package com.yllu.client.rest.client.response.ais;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Data
public class SaltedgeAccount {
    private String id;
    private String connection_id;
    private String name;
    private String nature;
    private Double balance;
    private String currency_code;
    private SaltedgeAccountExtra extra;

    private String created_at;
    private String updated_at;
}

