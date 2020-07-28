package com.springboot.smartvalve.service;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * 이 클래스의 용도는 하루에 한번 씩 보내는 주기적인 알림이므로
 * 클래스명이 Android Push Periodic Notification 이다.
 * 현재 코드에서는 /send로 접속을 할 시에만 알림이 push된다.
 * */
@Slf4j
public class AndroidPushPeriodicNotifications {

    public static String PeriodicNotificationJson() throws JSONException {
        LocalDate localDate = LocalDate.now();

        String sampleData[] = {"d2cORgcrRcaaUOsbM_F9wj" +
                ":APA91bGYN1QttYsst4lq6wMDYPUBnunEO8lFIilPg5ul0f2kLDQnfk0yvrOYDR-R0Gk1Efjq43BRnzI_FAJUqAsCoK0v_FsNcCVWgi_hMIYE-h_aa7403XpNcyN-k6STqoXbTZuK61wc",
        "cwELjuCQRDeiuiygc8oUQy:APA91bGdt8fB2_9bzcmHyabUxT_3PhXU6z2fB_qxI8epQcwS5vt9YcYCKE6B30m7BkIf72is5Va_jbOin35T2l1r8sh-4kYPrCoDqzya4KyDtNakwhwqIV95JhXuUG64OCV28gHTGbsc"};

        String name = "홍길동";
        log.debug(name);
        JSONObject body = new JSONObject();

        List<String> tokenlist = new ArrayList<String>();  //<~>는 <String>값이 생략

        for (int i = 0; i < sampleData.length; i++) {
            tokenlist.add(sampleData[i]);
        }

        JSONArray array = new JSONArray();

        for (int i = 0; i < tokenlist.size(); i++) {
            array.put(tokenlist.get(i));
        }

        body.put("registration_ids", array);

        JSONObject notification = new JSONObject();

        //title : 알림의 제목
        notification.put("title", "SmartValve!");
        //body : 알림의 내용
        notification.put("body", name);


        body.put("notification", notification);

        System.out.println(body.toString());

        return body.toString();
    }
}
/*
 * tokenlist : 알림을 보낼 디바이스의 디바이스토큰을 넣는 list( registration_ids의 값으로 들어간다.)
 *
 * */