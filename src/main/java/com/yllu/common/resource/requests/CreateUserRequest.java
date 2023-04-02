package com.yllu.common.resource.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
public class CreateUserRequest {
    @JsonProperty("identifier")
    String identifier;

}
