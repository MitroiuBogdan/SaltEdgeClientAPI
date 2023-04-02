package com.yllu.vendor.saltedge.service;

import com.yllu.common.domain.entity.User;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {


    Mono<User> createUser(String identifier);

    Mono<ResponseEntity<Void>> deleteUserByCustomerId(String customerId);

    Flux<User> getUsers();

    Mono<User> getUserByCustomerId(String customerId);
}

