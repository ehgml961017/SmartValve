package com.springboot.smartvalve.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class SvDTO {
    private int num;
    private int sw1;
    private int sw2;
    private Date on_sw1;
    private Date off_sw1;
    private Date on_sw2;
    private Date off_sw2;
}
