import requests
import logging

# -*- coding: utf-8 -*-
if __name__ == '__main__':
    logging.basicConfig(filename='file_name.txt', level=logging.DEBUG,
                        format='%(asctime)s-%(levelname)s-%(message)s')
    data = requests.get('http://localhost:8085/query')
    # json을 바로 리턴
    resp = data.json()
    num = resp[0]['num']  # num여부
    sw1 = resp[0]['sw1']  # 밸브 온오프여부
    sw2 = resp[0]['sw2']  # 콕크 온오프여부
    sw1_power = 0
    sw2_power = 0
    # num번째 스위치 몇번 온오프 요청 가능
    # 무한반복 >> 1번스위치 눌럿는지 안눌럿는지 판별  and 2번스위치 눌럿는지 안눌럿느지 판별>>  1,2번 스위치중 누른거 판별
    # 1번이 눌렷으면 스위치의 상태값을 바꿔준다  >> 그다음에 on request를 날린다. >> json값을 다시 확인해서 제대로 들어 갔는지 확인 >>
    # 제대로 안들어갔으면 다시 실행(이거는 일단 보류) (씹히는거니까) >> 다시 누른걸 감지하면 상태값 다시 바꿔주고(바뀌면) off req
    # if sw1_power == 1:
    if sw1 == 0:
        sw1 = sw1 + 1
        requests.get('http://localhost:8085/onSw1?num={}&sw1={}&sw2={}'.format(num, sw1, sw2))
        print("1번스위치 시작")


    elif sw1 == 1:
        sw1 = sw1 - 1
        requests.get('http://localhost:8085/offSw1?num={}&sw1={}&sw2={}'.format(num, sw1, sw2))

    # # if sw1_power == 0:
    #     if sw1 == 1:
    #         requests.get('http://localhost:8085/offSw1?num={}&sw1={}&sw2={}'.format(num, sw1, sw2))
    #         logging.DEBUG('num: ' + str(num))
    #         logging.DEBUG('sw1: ' + str(sw1))
    #         logging.DEBUG('sw2: ' + str(sw2))
    #     else:
    #         logging.DEBUG('이미 가스밸브가 꺼져 있습니다.')
    # # if sw2_power == 1:
    #     if sw2 == 0:
    #         requests.get('http://localhost:8085/onSw2?num={}&sw1={}&sw2={}'.format(num, sw1, sw2))
    #         logging.DEBUG('num: ' + str(num))
    #         logging.DEBUG('sw1: ' + str(sw1))
    #         logging.DEBUG('sw2: ' + str(sw2))
    #     else:
    #         logging.DEBUG('이미 가스콕크가 켜져있습니다.')
    # # if sw2_power == 0:
    #     if sw2 == 1:
    #         requests.get('http://localhost:8085/offSw2?num={}&sw1={}&sw2={}'.format(num, sw1, sw2))
    #         logging.DEBUG('num: ' + str(num))
    #         logging.DEBUG('sw1: ' + str(sw1))
    #         logging.DEBUG('sw2: ' + str(sw2))
    #     else:
    #         logging.DEBUG('이미 가스콕크가 꺼져있습니다.')
