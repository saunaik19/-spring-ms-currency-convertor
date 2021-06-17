package com.saurabh.example.limitsservice.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LimitConfiguration {
    private Integer minimum;
    private Integer maximum;
}
