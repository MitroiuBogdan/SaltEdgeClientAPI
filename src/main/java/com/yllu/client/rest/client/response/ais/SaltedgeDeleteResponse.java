package com.yllu.client.rest.client.response.ais;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SaltedgeDeleteResponse {

    private boolean removed;
    @JsonProperty("id")
    private String connectionId;
}
