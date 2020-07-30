# Smart Valve  
뉴딜 일자리 팀프로젝트 3조 - Smart Valve android  
android api version 24부터 정상작동하는것 확인 

## Project 소개  
	가스레인지 사용 후 잠그는 것을 잊게되는 가스밸브의 상태를 실시간으로 확인하고, 가스밸브가 장시간 열려있는 경우 경고메세지를 보내주는 모바일 애플리케이션을 개발하는 프로젝트입니다.  
  
## EndUser 입장에서 보는 핵심기능  
	#휴대폰으로 가스밸브 제어가능
	#가스밸브 상태 실시간 푸쉬알림 기능.
	#최근에 사용한 10건의 가스밸브 ,콕크의 현황 확인가능
  1. 가스레인지가 사용되지 않는데 가스밸브가 열려있는 경우 핸드폰 push기능으로 알림  
  2. 마지막으로 사용된 가스레인지의 시간 확인 가능  
  3. 최근 10건의 가스레인지 사용기록을 확인 가능  
  4. 이미지를 통해 직관적인 가스레인지 현황 확인 가능
    
## 사용한 기술셋 
  - Android  
    1. FCM  
    2. base adapter  
    3. thread, timer, json  
      
  - Springboot  
    1. AWS EC2 서버RDS MariaDB 연동  
    2. mybatis , JSP, JSON , spring scheduling,
    3. 안드로이드  푸쉬알림(firebase)
    4. slf4j,tomcat,lombok,jstl  
      
  - WEB FrontEnd  
    1. html, css, java script  
      
  - Raspberry Pi  
    1. DB Data Response  
      구글에서 "Python Json 연결" 검색  
    2. SW1, SW2 On/Off시 LED On/Off  
      교재 실습 예제파일 응용중  
        
## Local에서 돌려보는 매뉴얼  
  - Android  
  - Springboot + DB 실행  
  - WEB Front  
  - Raspberry Pi  
