package com.springboot.smartvalve.security;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso  /*OAuth2의 초기화와 자동설정을 지원한다.*/
/**
 * 스프링 시큐리티 설정 클래스
 */
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/callback", "/login**", "/webjars/**",
                        "/main", "/error**", "/svList", "/query", "/logout",
                        "/onSw1**", "/incomeList",
                        "/offSw1**", "/onSw2**", "/offSw2**", "/insert",
                        "/send", "/resources/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }


}
/*애플리케이션 전체에 대한 보안 설정이 필요하다면,
antMatchers(), regexMatchers(), anyRequest()를 원하는 만큼 연결해서 사용할 수 있다.
하지만, 주어진 순서에 따라 적용이 되는 것을 알고 있어야 한다.
그러므로 가장 세분화된 요청 패스 패턴을 먼저 적용하고 anyRequest()같이 세부적이지 않은 것은 나중에 적용해야한다.
그렇지 않다면 상대적으로 세부적인 내용들이 적용되지 않는다.*/
/*
@Configuration :
    클래스가 하나 이상의 @Bean 메소드를 제공하고
    스프링 컨테이너가 Bean정의를 생성하고
    런타임시 그 Bean들이 요청들을 처리할 것을 선언하게 된다.

.anyRequest().authenticated() :
    어떠한 요청이든 인증된 사용자만 접근할 수 있습니다.
.authorizeRequests():
    요청에 대한 권한을 지정할 수 있다.
.permitAll() :
    접근을 전부 허용한다.

번외
.anonymous():
    인증되지 않은 사용자도 접근할 수 있다.
.fullyAuthenticated():
    완전히 인증된 사용자만 접글할 수 있다.
.hasRole() or hasAnyRole():
    특정 권한을 가지는 사용자만 접근할 수 있다.
.hasAuthority() or hasAnyAuthority() :
    특정 권한을 가지는 사용자만 접근할 수 있다.
.hasIpAddress() :
    특정 아이피 주소를 가지는 사용자만 접근할 수 있다.
.not():
    접근 제한 기능을 해제
.permitAll() or denyAll() :
    접근을 전부 허용하거나 제한한다.
.rememberMe() :
    로그인한 사용자만 접근할 수 있다.
*/
