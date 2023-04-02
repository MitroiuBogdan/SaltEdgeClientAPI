package com.yllu.common.resource;

import com.yllu.common.domain.entity.User;
import com.yllu.common.resource.requests.CreateUserRequest;
import com.yllu.vendor.saltedge.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.yllu.common.logging.LoggingHelper.buildLogMessage;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping()
public class UserController {

    private final UserService userService;

    @PostMapping({"users/create"})
    public Mono<User> createUser(@RequestBody CreateUserRequest createUserRequest) {
        log.info("Creating user with :{}", createUserRequest.toString());

        return userService.createUser(createUserRequest.getIdentifier())
                .doOnNext(user -> log.info(buildLogMessage(user)));
    }

    @DeleteMapping({"users/{userId}"})
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable String userId) {
        log.info("Delete user for userId: {}", userId);
        return userService.deleteUserByCustomerId(userId)
                .doOnNext(user -> log.info(buildLogMessage(user)));
    }

    @GetMapping({"users"})
    public Flux<User> getUsers() {
        log.info("Get all users");
        return userService.getUsers()
                .doOnNext(user -> log.info(buildLogMessage(user)));
    }

    @GetMapping({"users/{userId}"})
    public Mono<User> getUserById(@PathVariable String userId) {
        log.info("Get  users for  userId: {}", userId);
        return userService.getUserByCustomerId(userId)
                .doOnNext(user -> log.info(buildLogMessage(user)));
    }

}
