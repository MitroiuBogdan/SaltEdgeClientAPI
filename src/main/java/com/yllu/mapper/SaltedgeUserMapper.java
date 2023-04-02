package com.yllu.mapper;

import com.yllu.client.rest.client.response.ais.SaltEdgeCustomer;
import com.yllu.domain.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SaltedgeUserMapper implements Function<SaltEdgeCustomer, User> {

    public static final SaltedgeUserMapper SALTEDGE_USER_MAPPER = new SaltedgeUserMapper();

    @Override
    public User apply(SaltEdgeCustomer saltEdgeCustomerData) {
        return User.builder()
                .id(saltEdgeCustomerData.getId())
                .identifier(saltEdgeCustomerData.getIdentifier())
                .build();
    }
}
