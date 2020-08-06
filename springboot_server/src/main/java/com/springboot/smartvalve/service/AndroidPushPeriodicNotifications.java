package com.springboot.smartvalve.service;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
<<<<<<< HEAD
 * 이 클래스의 용도는 밸브나 콕크의 특정시간(5분=300000ms)조건에 따라
 * send를 보내 푸쉬알림을 한다.
 * 클래스명이 Android Push Periodic Notification 이다.
=======
>>>>>>> e21e952baf4d7eee3afe412415e6aa779426e7b2
 * 현재 코드에서는 /send로 접속을 할 시에만 알림이 push된다.
 *
 * sampleData안에 device code를 넣어주면 된다.
 * 다중수신으로 구현이 되어 있다.
 * */
@Slf4j
public class AndroidPushPeriodicNotifications {

    public static String PeriodicNotificationJson() throws JSONException {
        LocalDate localDate = LocalDate.now();

        String sampleData[] = {"d2cORgcrRcaaUOsbM_F9wj" +
                ":APA91bGYN1QttYsst4lq6wMDYPUBnunEO8lFIilPg5ul0f2kLDQnfk0yvrOYDR-R0Gk1Efjq43BRnzI_FAJUqAsCoK0v_FsNcCVWgi_hMIYE-h_aa7403XpNcyN-k6STqoXbTZuK61wc",
                "cwELjuCQRDeiuiygc8oUQy" +
                        ":APA91bGdt8fB2_9bzcmHyabUxT_3PhXU6z2fB_qxI8epQcwS5vt9YcYCKE6B30m7BkIf72is5Va_jbOin35T2l1r8sh-4kYPrCoDqzya4KyDtNakwhwqIV95JhXuUG64OCV28gHTGbsc"};

        /*log테스트*/
        String name = "홍길동";
        log.debug(name);


        /*
        JsonObject는 객체(주로 String)를 Json객체로 바꿔주거나
        Json객체를 새로 만드는 역할을 합니다.
        */
       JSONObject body = new JSONObject(); //json 객체 생성

        List<String> tokenlist = new ArrayList<String>();  //<~>는 <String>값이 생략
        //tokenlist : 알림을 보낼 디바이스의 디바이스토큰을 넣는 list( registration_ids의 값으로 들어간다.)

        for (int i = 0; i < sampleData.length; i++) {
            tokenlist.add(sampleData[i]); /*tokenlist에 sampleData[]담기*/
        }

        JSONArray array = new JSONArray(); /*정보를 담은 Object, 이 오브젝트들이 array를 이루면
        Json array라고 부른다.*/

        for (int i = 0; i < tokenlist.size(); i++) {
            array.put(tokenlist.get(i)); /*JsonArray에 json추가*/
        }

        body.put("registration_ids", array); //{"key", "value"}

        JSONObject notification = new JSONObject();

        notification.put("title", "smartValve!"); //{"key", "value"}
        notification.put("body", "valve_5min over"); //{"key", "value"}


        body.put("notification", notification);
        System.out.println(body.toString());
        return body.toString();
    }
}
