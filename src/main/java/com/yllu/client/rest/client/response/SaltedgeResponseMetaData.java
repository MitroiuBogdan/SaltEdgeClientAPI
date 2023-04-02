package com.yllu.client.rest.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaltedgeResponseMetaData {
    @JsonProperty("next_id")
    private String nextId;
    @JsonProperty("next_page")
    private String nextPage;
}
