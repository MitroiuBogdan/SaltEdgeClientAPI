package com.yllu.client.rest.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaltEdgeConsent {

    @NotNull
    @JsonProperty("scopes")
    List<String> scopes;

//TODO to be changed to ZoneDateTime -> jackson error
    @JsonProperty("from_date")
    String activationDate;

    @JsonProperty("to_date")
    String expirationDate;

    @JsonProperty("period_day")
    Double consentValidityDays;

}
