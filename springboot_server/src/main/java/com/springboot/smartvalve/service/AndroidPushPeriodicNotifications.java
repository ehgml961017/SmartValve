package com.springboot.smartvalve.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AndroidPushPeriodicNotifications {

    public static String PeriodicNotificationJson() throws JSONException {
        LocalDate localDate = LocalDate.now();

        String sampleData[] = {"de-vEfbfQCOETuZcDsG8Xf:APA91bFJOgVuEaW1nJ14oDtsRsqDCub7q6-msDatpFBN1tXdzf3kuWGvLrAf9Uu73KFy4x_RMV3tLRRGNTIaCRU9pgFrgfKALUdOXLfgPo6rfy_PmWahLNTMpIUfNF1UWgQ-XibYfImE"};

        JSONObject body = new JSONObject();

        List<String> tokenlist = new ArrayList<String>();

        for(int i=0; i<sampleData.length; i++){
            tokenlist.add(sampleData[i]);
        }

        JSONArray array = new JSONArray();

        for(int i=0; i<tokenlist.size(); i++) {
            array.put(tokenlist.get(i));
        }

        body.put("registration_ids", array);

        JSONObject notification = new JSONObject();
        notification.put("title","hello!");
        notification.put("body","Today is "+localDate.getDayOfWeek().name()+
                "!");

        body.put("notification", notification);

        System.out.println(body.toString());

        return body.toString();
    }
}