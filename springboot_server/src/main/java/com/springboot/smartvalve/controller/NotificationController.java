package com.springboot.smartvalve.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.springboot.smartvalve.dto.SvDTO;
import com.springboot.smartvalve.service.AndroidPushNotificationService;
import com.springboot.smartvalve.service.AndroidPushPeriodicNotifications;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;


<<<<<<< HEAD
=======
/*
* 프로젝트를 실행한 뒤 /send로 접속하여 동작이 실행되게 한다. firebase project의 server key를 가지고
* 디바이스 토큰으로 알림을 json 데이터 형식으로 firebase에게 요청한다.
* */
>>>>>>> 6578604edf9fc17fe7ff7eede1918f62479febfc
@RestController
public class NotificationController {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    AndroidPushNotificationService androidPushNotificationService;
<<<<<<< HEAD
    @Scheduled()
=======

    //@Scheduled(fixedRate = 10000) //10초 > 실제 서버 동작 시 1000*60*60*24 (23시간)
>>>>>>> 6578604edf9fc17fe7ff7eede1918f62479febfc
    @GetMapping(value = "/send")
    public @ResponseBody
    ResponseEntity<String> send() throws JSONException, InterruptedException {
        String notifications =
                AndroidPushPeriodicNotifications.PeriodicNotificationJson();
        HttpEntity<String> request = new HttpEntity<>(notifications);

        CompletableFuture<String> pushNotification =
                androidPushNotificationService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();
            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        } catch (InterruptedException e) {
            logger.debug("got interrupted!");
            throw new InterruptedException();
        } catch (ExecutionException e) {
            logger.debug("execution error!");
        }

        return new ResponseEntity<>("Push Notification ERROR!",
                HttpStatus.BAD_REQUEST);
    }
}
/*
* @Controller(Spring MVC Controller) 와 @RestController 의 차이점
*   [Controller - View]
*   전통적인 Spring MVC의 컨트롤러인 @Controller는 주로 View를 반환하기 위해 사용합니다.
*   아래와 같은 과정을 통해 Spring MVC Container는 Client의 요청으로부터 View를 반환합니다.
*   1. Client는 URI 형식으로 웹 서비스에 요청을 보낸다.
*   2. Mapping 되는 Handler 와 그 Type을 찾는 DispatcherServlet이 요청을 인터셉트한다.
*   3. Controller가 요청을 처리한 후에 응답을 DispatcherServlet으로 반환하고, DispatcherServlet은
*       View를 사용자에게 반환한다.
*
*   [Controller - Data]
*   하지만 Spring MVC 의 컨트롤러에서도 Data를 반환해야 하는 경우도 있습니다. Spring MVC의 컨트롤러에서는
*   데이터를 반환하기 위해 @ResponseBody 어노테이션을 활용해주어야 합니다. 이를 통해 Controller도
*   Json 형태로 데이터를 반환할 수 있습니다.
*   1. Client는 URI 형식으로 웹 서비스에  요청을 보낸다.
*   2. Mapping되는 Handler와 그 Type을 찾는 DispatcherServlet이 요청을 인터셉트한다.
*   3. @ResponseBody를 사용하여 Client에게 Json형태로 데이터를 반환한다.
*
* @RestController(Spring Restful Controller)
*   [RestController]
*   @RestController는 Spring MVC Controller에 @ResponseBody가 추가된 것입니다.
*   당연하게도 RestController의 주용도는 Json/Xml형태로 객체 데이터를 반환하는 것입니다.
*   개인적으로는 VueJS + Spring boot 프로젝트를 진행할 때 Spring boot를 API서버로 활용할 때
*   그리고 Android 앱 개발을 하면서 데이터를 반환할 때 사용하였습니다.
*   1. Client는 URI 형식으로 웹 서비스에 요청을 보낸다.
*   2. Mapping되는 Handler와 그 Type을 찾는 DispatcherServlet이 요청을 인터셉틑한다.
*   3. RestController는 해당 요청을 처리하고 데이터를 반환한다.
* */

/*
    로그개념
    1. 개발자 관점
    - 개발시 오류 처리 작업용(디버그용)
    - 실시간 개발 관점에서 무슨일이 일어났는지 확인 하고자 할 때(오류발생 시점 잡을 때)

    2. 서버 및 application 관리자 관점
    - client들의 개별 실행 정보
    - 가령 누가 로그인을 했느냐? 이 사람이 서핑한 page는 어디냐
*/

