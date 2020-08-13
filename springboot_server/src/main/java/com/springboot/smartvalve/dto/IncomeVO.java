package com.springboot.smartvalve.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class IncomeVO {
    private int num;
    private int valve_time;
    private int cork_time;
}
