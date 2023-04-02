package com.yllu.common.domain.entity;

import lombok.*;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExchangeRate {

    private String currencyFrom;
    private String currencyTo;
    private Double rate;
}
