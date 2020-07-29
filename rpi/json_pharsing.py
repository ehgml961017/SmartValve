import requests

data = requests.get('http://localhost:8085/query')
# json을 바로 리턴
resp = data.json()
num = resp[0]['num']  # num여부
sw1 = resp[0]['sw1']  # 밸브 온오프여부
sw2 = resp[0]['sw1']  # 콕크 온오프여부
print(type(num))
# num번째 스위치 몇번 온오프 요청 가능
if sw1 == 0 and sw2 == 0:
    requests

requests.get('http://localhost:8085/onSw1?num={}'.format(num))
