package com.yllu.vendor.saltedge.mapper;

import com.yllu.common.domain.entity.Aspsp;
import com.yllu.vendor.saltedge.rest.client.response.ais.SaltedgeProvider;
import io.vavr.collection.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SaltedgeAspspMapper implements Function<SaltedgeProvider, Aspsp> {

    public static final SaltedgeAspspMapper SALTEDGE_ASPSP_MAPPER = new SaltedgeAspspMapper();

    @Override
    public Aspsp apply(SaltedgeProvider saltedgeProvider) {
        return Aspsp.builder()
                .providerAspspId(saltedgeProvider.getId())
                .name(saltedgeProvider.getName())
                .icon(saltedgeProvider.getLogoUrl())
                .additionalInfoNeeded(List.of(saltedgeProvider.getRequiredFields(), saltedgeProvider.getInteractiveFields()).toString())
                .build();
    }
}
