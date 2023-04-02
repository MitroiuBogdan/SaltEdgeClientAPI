package com.yllu.vendor.saltedge.rest.controllers;

import com.yllu.common.domain.entity.Grant;
import com.yllu.vendor.saltedge.rest.client.response.ais.SaltedgeDeleteResponse;
import com.yllu.vendor.saltedge.service.SaltedgeConnectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/SALTEDGE/connections")
@AllArgsConstructor
public class ConnectionController {

    private final SaltedgeConnectionService saltedgeConnectionService;

    @PutMapping("/{connectionId}/refresh")
    public Mono<Grant> refreshConnection(@PathVariable String connectionId) {
        log.info("refreshConnection - refreshing grant with id {}", connectionId);
        return saltedgeConnectionService.refreshById(connectionId);
    }

    @DeleteMapping("/{connectionId}")
    public Mono<SaltedgeDeleteResponse> deleteConnection(@PathVariable String connectionId) {
        log.info("deleteConnection - deleting grant by id {}", connectionId);
        return saltedgeConnectionService.deleteById(connectionId);
    }

    @GetMapping("/{connectionId}")
    public Mono<Grant> getById(@PathVariable String connectionId) {
        log.info("getById - getting grant by connection id {}", connectionId);
        return saltedgeConnectionService.getById(connectionId);
    }
}
