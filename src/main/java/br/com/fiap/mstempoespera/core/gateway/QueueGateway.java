package br.com.fiap.mstempoespera.core.gateway;

import br.com.fiap.mstempoespera.core.entity.QueuesDetails;
import reactor.core.publisher.Flux;

public interface QueueGateway {
    Flux<QueuesDetails> findAll(String upasId);
}
