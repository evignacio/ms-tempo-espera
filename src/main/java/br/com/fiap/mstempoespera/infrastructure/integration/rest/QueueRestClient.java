package br.com.fiap.mstempoespera.infrastructure.integration.rest;

import br.com.fiap.mstempoespera.infrastructure.integration.to.queue.QueuesDetailsTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class QueueRestClient {
    private final WebClient webClient;

    public QueueRestClient(@Value("${rest-service.ms-fila-atendimento.url}") String url) {
        this.webClient = WebClient.create(url);
    }

    public Mono<QueuesDetailsTo> requestQueuesDetails(String upasId) {
        return webClient.get()
                .uri("/queues/upas/{upasId}", upasId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(QueuesDetailsTo.class)
                .doOnError(error -> log.error("Error fetching queue details: {}", error.getMessage()))
                .doOnSuccess(success -> log.info("Queue details fetched successfully"));
    }
}
