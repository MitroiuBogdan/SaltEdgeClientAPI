package com.yllu.common.resource.ais.requests;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class InitiateSessionRequest {

    @NotNull
    String customerId;
    String aspspCode;
    String returnBackUrl;
    Boolean dailyRefresh;

}
