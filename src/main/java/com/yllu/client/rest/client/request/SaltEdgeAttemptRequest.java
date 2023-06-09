package com.yllu.client.rest.client.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaltEdgeAttemptRequest {

    @JsonProperty("return_to")
    String returnTo;

    @JsonProperty("fetch_scopes")
    List<String> fetchScopes;
}
