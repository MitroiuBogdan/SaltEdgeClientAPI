package com.yllu.mapper;

import com.yllu.client.rest.client.response.ais.SaltedgeProvider;
import com.yllu.domain.Aspsp;
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
