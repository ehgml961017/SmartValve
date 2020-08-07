# -*-coding: utf-8-*-

# GPIO 라이브러리 임포트
# import RPi.GPIO as GPIO
# import time
import requests
import logging
# GPIO 라이브러리 임포트
import RPi.GPIO as GPIO

logging.basicConfig(level=logging.DEBUG, format="'%(asctime)s - %(message)s'")


def main():
    GPIO.setmode(GPIO.BOARD)
    LED1 = 11
    LED2 = 23
    # LED1, 11번핀을 출력 핀으로 설정
    GPIO.setup(LED1, GPIO.OUT)
    # LED2, 23번 핀을 출력 핀으로 설정
    GPIO.setup(LED2, GPIO.OUT)
    while True:
        data = requests.get('http://192.168.0.90:8085/query')
        resp = data.json()
        num = resp[0]['num']  # num 여부
        sw1 = resp[0]['sw1']  # sw1 여부
        sw2 = resp[0]['sw2']  # sw2 여부

        if sw1 == 0:
            logging.info(sw1)
            logging.info('led1 off')
            GPIO.output(LED1, GPIO.LOW)
            logging.info('query repeat check')
            data = requests.get('http://192.168.0.90:8085/query')
            resp = data.json()
            sw1 = resp[0]['sw1']  # sw1 여부
            if sw1 == 1:
                logging.info('switch1 status change detection')
                logging.info('led1 on')
                GPIO.output(LED1, GPIO.HIGH)

        else:
            logging.info(sw1)
            logging.info('led1 off')
            GPIO.output(LED1, GPIO.HIGH)
            logging.info('query repeat check')
            data = requests.get('http://192.168.0.90:8085/query')
            resp = data.json()
            sw1 = resp[0]['sw1']  # sw1 여부
            if sw1 == 0:
                logging.info('switch1 status change detection')
                logging.info('led1 off')
                GPIO.output(LED1, GPIO.LOW)
                
        if sw2 == 0:
            logging.info(sw2)
            logging.info('led2 off')
            GPIO.output(LED2, GPIO.LOW)
            logging.info('query repeat check')
            data = requests.get('http://192.168.0.90:8085/query')
            resp = data.json()
            sw2 = resp[0]['sw2']  # sw2 여부
            if sw2 == 1:
                logging.info('switch2 status change detection')
                logging.info('led2 off')
                GPIO.output(LED2, GPIO.HIGH)
        else:
            logging.info(sw2)
            logging.info('led2 on')
            GPIO.output(LED2, GPIO.HIGH)
            logging.info('query repeat check')
            data = requests.get('http://192.168.0.90:8085/query')
            resp = data.json()
            sw2 = resp[0]['sw2']  # sw2 여부
            if sw2 == 0:
                logging.info('switch2 status change detection')
                logging.info('led2 off')
                GPIO.output(LED2, GPIO.LOW)


GPIO.cleanup()

if __name__ == '__main__':
    main()