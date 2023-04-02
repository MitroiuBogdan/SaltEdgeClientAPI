package com.yllu.resource.ais.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class InitiateSessionRequest {
    @JsonProperty("customerId")
    private String customerId;
    String connectionId;
    String aspspCode;
    Boolean dailyRefresh;

}
