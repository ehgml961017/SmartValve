package com.springboot.smartvalve.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
public class SvDTO {
    private int num;
    private int sw1;
    private int sw2;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T' HH:mm:ss")
    private Date on_sw1;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T' HH:mm:ss")
    private Date off_sw1;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T' HH:mm:ss")
    private Date on_sw2;
    @DateTimeFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private Date off_sw2;
}
