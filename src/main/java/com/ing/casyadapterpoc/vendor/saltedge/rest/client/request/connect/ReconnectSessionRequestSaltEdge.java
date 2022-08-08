package com.ing.casyadapterpoc.vendor.saltedge.rest.client.request.connect;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ing.casyadapterpoc.vendor.saltedge.rest.client.request.SaltEdgeAttemptRequest;
import com.ing.casyadapterpoc.vendor.saltedge.rest.client.request.SaltEdgeConsent;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReconnectSessionRequestSaltEdge {

    @NotNull
    @JsonProperty("connection_id")
    String connectionId;

    @NotNull
    @JsonProperty("customer_id")
    String customerId;

    @NotNull
    @JsonProperty("consent")
    SaltEdgeConsent consent;

    @JsonProperty("attempt")
    SaltEdgeAttemptRequest attempt;

    @JsonProperty("provider_code")
    String providerCode;

    @JsonProperty("daily_refresh")
    boolean dailyRefresh;

}
