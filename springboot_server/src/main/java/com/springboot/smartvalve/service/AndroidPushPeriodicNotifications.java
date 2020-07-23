package com.springboot.smartvalve.service;

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
public class AndroidPushPeriodicNotifications {

    public static String PeriodicNotificationJson() throws JSONException {
        LocalDate localDate = LocalDate.now();

        String sampleData[] = {"de-vEfbfQCOETuZcDsG8Xf:APA91bFJOgVuEaW1nJ14oDtsRsqDCub7q6-msDatpFBN1tXdzf3kuWGvLrAf9Uu73KFy4x_RMV3tLRRGNTIaCRU9pgFrgfKALUdOXLfgPo6rfy_PmWahLNTMpIUfNF1UWgQ-XibYfImE"};

        JSONObject body = new JSONObject();

        List<String> tokenlist = new ArrayList<String>();  //<~>는 <String>값이 생략

        for(int i=0; i<sampleData.length; i++){
            tokenlist.add(sampleData[i]);
        }

        JSONArray array = new JSONArray();

        for(int i=0; i<tokenlist.size(); i++) {
            array.put(tokenlist.get(i));
        }

        body.put("registration_ids", array);

        JSONObject notification = new JSONObject();

        //title : 알림의 제목
        notification.put("title","hello!");
        //body : 알림의 내용
        notification.put("body","Today is "+localDate.getDayOfWeek().name()+
                "!");

        body.put("notification", notification);

        System.out.println(body.toString());

        return body.toString();
    }
}
/*
* tokenlist : 알림을 보낼 디바이스의 디바이스토큰을 넣는 list( registration_ids의 값으로 들어간다.)
*
* */