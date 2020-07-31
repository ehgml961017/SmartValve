# coding: utf-8

# GPIO 라이브러리 임포트
import RPi.GPIO as GPIO

def main():
    # 핀 번호 할당 방법을 커넥터 핀 번호로 설정
    GPIO.setmode(GPIO.BOARD)

    # 사용하는 핀 번호를 할당
    SW1 = 7
    LED1 = 11
    SW2 = 19
    LED2 = 23

    # 11번 핀을 출력 핀으로 설정, 초기 출력은 로우 레벨
    GPIO.setup(LED1, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED2, GPIO.OUT, initial=GPIO.LOW)

    # 7번 핀을 입력 핀으로 설정
    GPIO.setup(SW1, GPIO.IN)
    GPIO.setup(SW2, GPIO.IN)

    # 예외 처리
    try:

    # 무한 반복
        while 1:
            # 스위치 상태를 변수 key_in에 할당
            key_in1 = GPIO.input(SW1)
            # 변수 key_in 상태 판별
            if key_in1==0:
                # 하이 레벨 출력
                GPIO.output(LED1, GPIO.HIGH)
            else:
                # 로우 레벨 출력
                GPIO.output(LED1, GPIO.LOW)

            key_in2 = GPIO.input(SW2)
            # 변수 key_in 상태 판별
            if key_in2==0:
                # 하이 레벨 출력
                GPIO.output(LED2, GPIO.HIGH)
            else:
                # 로우 레벨 출력
                GPIO.output(LED2, GPIO.LOW)

    # 키보드 예외 검출
    except KeyboardInterrupt:
        # 아무것도 하지 않음
        pass


    # GPIO 개방
    GPIO.cleanup()

if __name__ == "__main__":
    main()

