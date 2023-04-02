package com.yllu.common.service.delegate;

import com.yllu.common.domain.Vendor;
import com.yllu.common.service.GrantActivationVendorService;
import com.yllu.common.service.VendorServiceSelector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
@Service
public class GrantActivationDelegatingService {

    private final List<GrantActivationVendorService> grantActivationVendorServices;

    public Mono<String> getLoginUrl(Vendor vendor){
        return VendorServiceSelector.selectVendorService(grantActivationVendorServices,vendor)
                .getLoginUrl();
    }
}
