# -*-coding: utf-8-*-

import RPi.GPIO as GPIO
import logging
import requests
import time
from datetime import datetime, timedelta
import threading

logging.basicConfig(level=logging.DEBUG, format="'%(asctime)s - %(message)s'")          

global time_init                        # 타임초기화 전역변수
time_init = True                        # True 초기값 설정 

def sw_function():
    # 사용하는 핀 번호를 할당
    led1 = 11
    led2 = 23
    switch1 = 7
    switch2 = 19
    state1 = 1
    state2 = 1
    
    GPIO.setmode(GPIO.BOARD)            # 핀 번호 할당 방법을 커넥터 핀 번호로 설정
    GPIO.setwarnings(False)
    
    GPIO.setup(led1, GPIO.OUT)          # led1, 11번 핀을 출력 핀으로 설정
    GPIO.setup(led2, GPIO.OUT)          # led2, 23번 핀을 출력 핀으로 설정
    
    GPIO.setup(switch1, GPIO.IN, GPIO.PUD_UP)       # switch1, 7번 핀을 입력 핀으로 설정
    GPIO.setup(switch2, GPIO.IN, GPIO.PUD_UP)       # switch2, 19번 핀을 입력 핀으로 설정
    
    while True:
        data = requests.get('http://192.168.0.90:8085/query')
        resp = data.json()
        num = resp[0]['num']  # num 여부
        sw1 = resp[0]['sw1']  # sw1 여부
        sw2 = resp[0]['sw2']  # sw2 여부
        if GPIO.input(switch1) == 0:
            while True:
                if GPIO.input(switch1) == 1:
                    state1 = not state1
                    GPIO.output(led1, state1)
                    if state1 == 0:
                        requests.get('http://192.168.0.90:8085/offSw1?num={}&sw1={}&sw2={}'.format(num, sw1, sw2))
                    elif state1 == 1:
                        requests.get('http://192.168.0.90:8085/onSw1?num={}&sw1={}&sw2={}'.format(num, sw1, sw2))
                    time.sleep(0.2)
                    break
                    
        if GPIO.input(switch2) == 0:           
            while True:
                if GPIO.input(switch2) == 1:
                    state2 = not state2
                    GPIO.output(led2, state2)
                    if state2 == 0:
                        requests.get('http://192.168.0.90:8085/offSw2?num={}&sw1={}&sw2={}'.format(num, sw1, sw2))
                    elif state2 == 1:
                        requests.get('http://192.168.0.90:8085/onSw2?num={}&sw1={}&sw2={}'.format(num, sw1, sw2))
                    time.sleep(0.2)
                    break

def sw1_time_check():                   # sw1_time_check 함수 설정
    global time_init                    # 전역변수 
    current_time = datetime.now()       # 현재타임 스탬프 찍음
    logging.info(current_time)          
    while True:
        now = datetime.now()                                        # 비교할 현재타임스탬프 찍음
        measure_time = now - current_time                           # 측정시간 (설정시간 이상이면 push)
        data = requests.get('http://192.168.0.90:8085/query')                
        resp = data.json()                                          
        sw1_onLimit = resp[0]['sw1_onLimit']                        # sw1_onLimit 스위치 1 켜져있으면 찍히는 한계점 시간 
        logging.info(sw1_onLimit)                                   
        logging.info(measure_time)                                  
        if (measure_time.seconds > 60) and (sw1_onLimit is not None):       # 60초 이상이고  sw1이 on이고 sw1_onLimit is not None : null이 아니면 push요청한다. 
            logging.info('send push')                                       
            requests.get('http://192.168.0.90:8085/send')                   
            time_init = True                                                # send 하면 측정시간을 초기화
            break                                                           
        elif sw1_onLimit is None:                                           
            logging.info('Gas Valve Timeout')                               
            time_init = True                                                
            break
        


def main():
    GPIO.setmode(GPIO.BOARD)

    LED1 = 11
    LED2 = 23
   
    GPIO.setup(LED1, GPIO.OUT)                                           # LED1, 11번핀을 출력 핀으로 설정
    GPIO.setup(LED2, GPIO.OUT)                                           # LED2, 23번핀을 출력 핀으로 설정

    global time_init
    time_init = True
    while True:
        data = requests.get('http://192.168.0.90:8085/query')           
        resp = data.json()                                              
        sw1 = resp[0]['sw1']                    # sw1 여부                                
        sw2 = resp[0]['sw2']                    # sw2 여부
        sw1_onLimit = resp[0]['sw1_onLimit']                            
        
        logging.info(sw1)
        logging.info(sw2)
        logging.info(sw1_onLimit)

        if sw1 == 1:
            logging.info('led1 On')
            GPIO.output(LED1, GPIO.HIGH)    # 하이 레벨 출력
            if time_init:                   
                time_init = False           
                t2 = threading.Thread(target=sw1_time_check)            
                t2.start()                                              

        else:
            logging.info('led1 Off')
            GPIO.output(LED1, GPIO.LOW)     # 로우 레벨 출력

        if sw2 == 1:
            logging.info('led2 On')
            GPIO.output(LED2, GPIO.HIGH)    # 하이 레벨 출력
        else:
            logging.info('led2 Off')
            GPIO.output(LED2, GPIO.LOW)     # 로우 레벨 출력

        
GPIO.cleanup()

if __name__ == "__main__":
    t1 = threading.Thread(target=main)                              
    t1.start()                                                      
    
    t3= threading.Thread(target=sw_function)
    t3.start()