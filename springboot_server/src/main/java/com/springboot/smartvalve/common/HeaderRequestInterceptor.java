package com.springboot.smartvalve.common;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

// header request Interceptor = header request를 가로챈다.
/*
interceptor : controller에 들어오는 요청 HttpRequest와 컨트롤러가 응답하는
HttpResponse를 가로채는 역할
*/
public class HeaderRequestInterceptor implements ClientHttpRequestInterceptor {
    private final String headerName;
    private final String headerValue;

    //가로채서 interceptor constructor 넣어준다.
    public HeaderRequestInterceptor(String headerName, String headerValue) {
        this.headerName = headerName;
        this.headerValue = headerValue;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        HttpRequest wrapper = new HttpRequestWrapper(request);
        //interceptor한 것을 setting (headerName, headerValue)해주고 그것을 get한다.
        wrapper.getHeaders().set(headerName, headerValue);
        // header(를 wrapper로 감싼 것) and body를 실행하게 한다.
        return execution.execute(wrapper, body);
    }
}