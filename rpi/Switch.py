# -*-coding: utf-8-*-

# GPIO 라이브러리 임포트
import RPi.GPIO as GPIO
import time
import requests

logging.basicConfig(level=logging.DEBUG, format="'%(asctime)s - %(message)s'")


def main():
    # 핀 번호 할당 방법을 커넥터 핀 번호로 설정
    GPIO.setmode(GPIO.BOARD)

    # 사용하는 핀 번호를 할당
    SW1 = 7
    LED1 = 11
    SW2 = 19
    LED2 = 23

    # LED1, 11번 핀을 출력 핀으로 설정, 초기 출력은 로우 레벨
    GPIO.setup(LED1, GPIO.OUT, initial=GPIO.LOW)
    # LED2, 23번 핀을 출력 핀으로 설정, 초기 출력은 로우 레벨
    GPIO.setup(LED2, GPIO.OUT, initial=GPIO.LOW)

    # SW1, 7번 핀을 입력 핀으로 설정
    GPIO.setup(SW1, GPIO.IN)
    # SW2, 19번 핀을 입력 핀으로 설정
    GPIO.setup(SW2, GPIO.IN)

    # 예외 처리
    try:
        isLedOn1 = False
        isLedOn2 = False
        # 무한 반복
        while 1:
            print('listening...')
            print('isLedOn1', isLedOn1)
            # 스위치 상태를 변수 key_in에 할당
            key_in1 = GPIO.input(SW1)
            # 변수 key_in 상태 판별
            if key_in1 == 0:  # 눌렀을 때
                if not isLedOn1:  # isLedOn1이 False 일때
                    GPIO.output(LED1, GPIO.HIGH)  # 하이 레벨 출력
                    isLedOn1 = True  # 하이레벨 출력 시 isLedOn1은 True
                    pass  # 아무것도 안 함
                else:
                    GPIO.output(LED1, GPIO.LOW)  # 로우 레벨 출력
                    isLedOn1 = False  # 로우 레벨 출력 시 isLedOn1은 False
                    pass  # 아무것도 안 함
            time.sleep(0.5)  # 0.5초 대기

            print('listening...')
            print('isLedOn2', isLedOn2)
            # 스위치 상태를 변수 key_in에 할당
            key_in2 = GPIO.input(SW2)
            # 변수 key_in 상태 판별
            if key_in2 == 0:  # 눌렀을 때
                if not isLedOn2:  # isLedOn1이 False 일때
                    GPIO.output(LED2, GPIO.HIGH)  # 하이 레벨 출력
                    isLedOn2 = True  # 하이레벨 출력 시 isLedOn1은 True
                    data = requests.get('http://localhost:8085/query')
                    resp = data.json()
                    num = resp[0]['num']  # num 여부
                    sw1 = resp[0]['sw1']  # sw1 여부
                    sw2 = resp[0]['sw2']  # sw2 여부
                    print(num)
                    print(sw1)
                    print(sw2)
                    if sw1 != 1:
                        requests.get('http://localhost:8085/onSw1?num={}&sw1={}&sw2={}'.format(num, sw1, sw2))
                    pass  # 아무것도 안 함
                else:
                    GPIO.output(LED2, GPIO.LOW)  # 로우 레벨 출력
                    isLedOn2 = False  # 로우 레벨 출력 시 isLedOn1은 False
                    if sw1 == 1:
                        requests.get('http://localhost:8085/offSw1?num={}&sw1={}&sw2={}'.format(num, sw1, sw2))
                    pass  # 아무것도 안 함
            time.sleep(0.5)  # 0.5초 대기

    # 키보드 예외 검출
    except KeyboardInterrupt:
        # 아무것도 하지 않음
        pass

    # GPIO 개방
    GPIO.cleanup()


if __name__ == "__main__":
    main()
