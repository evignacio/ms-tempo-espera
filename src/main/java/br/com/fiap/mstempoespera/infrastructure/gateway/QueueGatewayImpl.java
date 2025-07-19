package br.com.fiap.mstempoespera.infrastructure.gateway;

import br.com.fiap.mstempoespera.core.entity.QueuesDetails;
import br.com.fiap.mstempoespera.core.gateway.QueueGateway;
import br.com.fiap.mstempoespera.infrastructure.integration.rest.QueueRestClient;
import br.com.fiap.mstempoespera.infrastructure.mapper.QueueDetailMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public record QueueGatewayImpl(QueueRestClient queueRestClient) implements QueueGateway {

    @Override
    public Mono<QueuesDetails> findAll(String upasId) {
        return queueRestClient.requestQueuesDetails(upasId) .map(QueueDetailMapper::toEntity);
    }
}
