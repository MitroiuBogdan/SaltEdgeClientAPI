package com.yllu.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Connection {

    private String connectionId;

    private String status;

    private String reason;
}
