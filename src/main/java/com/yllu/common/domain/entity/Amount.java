package com.yllu.common.domain.entity;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class Amount {

    private String currency;
    private Double content;
}
