package com.yllu.service.user;

import com.yllu.domain.User;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {


    Mono<User> createUser(String identifier);

    Mono<ResponseEntity<Void>> deleteUserByCustomerId(String customerId);

    Flux<User> getUsers();

    Mono<User> getUserByCustomerId(String customerId);
}

