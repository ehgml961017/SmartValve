package com.springboot.smartvalve.security;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/callback", "/login**", "/webjars/**",
                        "/main","/error**","/svList","/query","/logout","/onSw1**",
                        "/offSw1**","/onSw2**","/offSw2**","/insert","/time" +
                                "**","/send","/resources/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }


}

