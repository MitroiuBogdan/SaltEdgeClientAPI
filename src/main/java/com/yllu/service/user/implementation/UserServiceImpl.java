package com.yllu.service.user.implementation;

import com.yllu.common.domain.entity.User;
import com.yllu.vendor.saltedge.mapper.SaltedgeUserMapper;
import com.yllu.service.user.CustomerRemoteService;
import com.yllu.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final CustomerRemoteService customerRemoteService;


    @Override
    public Mono<User> createUser(String identifier) {
        return customerRemoteService.createCustomer(identifier)
                .map(SaltedgeUserMapper.SALTEDGE_USER_MAPPER);
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteUserByCustomerId(String customerId) {
        return customerRemoteService.deleteCustomer(customerId);
    }

    @Override
    public Flux<User> getUsers() {
        return customerRemoteService.getCustomers()
                .map(SaltedgeUserMapper.SALTEDGE_USER_MAPPER);
    }

    @Override
    public Mono<User> getUserByCustomerId(String customerId) {
        return customerRemoteService.getCustomerById(customerId)
                .map(SaltedgeUserMapper.SALTEDGE_USER_MAPPER);
    }
}
