package com.springboot.smartvalve.dto;

import lombok.Data;

@Data //@Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode를 한번에 설정해주는 어노테이션
public class IncomeVO { //1.
    private int num;
    private int valve_time;
    private int cork_time;
}
