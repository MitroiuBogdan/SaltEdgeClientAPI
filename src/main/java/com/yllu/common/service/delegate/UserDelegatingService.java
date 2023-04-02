package com.yllu.common.service.delegate;

import com.yllu.common.domain.Vendor;
import com.yllu.common.domain.entity.User;
import com.yllu.common.service.UserVendorService;
import com.yllu.common.service.VendorServiceSelector;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
@Service
public class UserDelegatingService {

    private final List<UserVendorService> userVendorServices;

    public Mono<User> createUser(Vendor vendor, String identifier) {
        return VendorServiceSelector.selectVendorService(userVendorServices, vendor)
                .createUser(identifier);
    }

    public Mono<ResponseEntity<Void>> deleteUser(Vendor vendor, String userId) {
        return VendorServiceSelector.selectVendorService(userVendorServices, vendor)
                .deleteUser(userId);
    }

    public Flux<User> getUsers(Vendor vendor) {
        return VendorServiceSelector.selectVendorService(userVendorServices, vendor)
                .getUsers();
    }

    public Mono<User> getUserById(Vendor vendor, String userId) {
        return VendorServiceSelector.selectVendorService(userVendorServices, vendor)
                .getUserById(userId);
    }

}
