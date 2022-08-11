package com.ing.casyadapterpoc.vendor.saltedge.rest.client.request.enrichment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MerchantsInfoRequest {

    @JsonProperty("data")
    List<String> data;
}