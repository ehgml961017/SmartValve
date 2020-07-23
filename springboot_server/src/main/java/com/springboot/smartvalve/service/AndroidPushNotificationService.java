package com.springboot.smartvalve.service;

import com.springboot.smartvalve.common.HeaderRequestInterceptor;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
@Service
public class AndroidPushNotificationService {
    private static final String firebase_server_key="AAAAnwv2hvE:APA91bGPoq-ZsvBGdpyXGTrhSFrnHnX57uU8_s9BwrLki8nJ84_TMd_DJ3gRkOH-0pdlmRuDjxWOI7zhQPeBSZBIYk6adxWWGbRrH4GUwGqJkF9RdyWFaEKdREot0KhqshMEkWarMMnI";
    private static final String firebase_api_url="https://fcm.googleapis.com/fcm/send";

    @Async
    public CompletableFuture<String> send(HttpEntity<String> entity) {

        RestTemplate restTemplate = new RestTemplate();

        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        interceptors.add(new HeaderRequestInterceptor("Authorization",  "key=" + firebase_server_key));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json; UTF-8 "));
        restTemplate.setInterceptors(interceptors);

        String firebaseResponse = restTemplate.postForObject(firebase_api_url, entity, String.class);

        return CompletableFuture.completedFuture(firebaseResponse);
    }
}
