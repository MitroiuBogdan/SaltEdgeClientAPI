package com.yllu.client.rest.client.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaltEdgeResponse<T> {
    private T data;
}
