package br.com.fiap.mstempoespera.core.gateway;

import br.com.fiap.mstempoespera.core.entity.QueuesDetails;
import reactor.core.publisher.Mono;

public interface QueueGateway {
    Mono<QueuesDetails> findAll(String upasId);
}
