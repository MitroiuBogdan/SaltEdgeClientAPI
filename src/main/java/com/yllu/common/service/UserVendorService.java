package com.yllu.common.service;

import com.yllu.common.domain.entity.User;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserVendorService extends VendorService {

    Mono<User> createUser(String identifier);

    Mono<ResponseEntity<Void>> deleteUser(String userId);

    Flux<User> getUsers();

    Mono<User> getUserById(String userId);
}
