package br.com.fiap.mstempoespera.infrastructure.integration.rest;

import br.com.fiap.mstempoespera.core.entity.SaoPauloCity;
import br.com.fiap.mstempoespera.infrastructure.integration.to.upa.PatientAttendanceRecordTo;
import br.com.fiap.mstempoespera.infrastructure.integration.to.upa.UpaTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Slf4j
@Component
public class UpaRestClient {
    private final WebClient webClient;

    public UpaRestClient(@Value("${rest-service.ms-gestao-upa.url}") String url) {
        this.webClient = WebClient.create(url);
    }

    public Flux<UpaTo> requestUpasByCity(SaoPauloCity saoPauloCity) {
        return webClient.get()
                .uri("/api/v1/upas/cidades/{city}", saoPauloCity)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(UpaTo.class)
                .doOnError(error -> log.error("Error fetching UPA data: {}", error.getMessage()))
                .doOnComplete(() -> log.info("UPA data fetched successfully for city: {}", saoPauloCity));
    }

    public Flux<PatientAttendanceRecordTo> requestPatientAttendancePeriod(String upaId, LocalDateTime startDate, LocalDateTime endDate) {
        return webClient.get()
                .uri("/api/v1/upas/{upaId}/atendimentos/periodo?inicio=" + startDate + "&fim=" + endDate, upaId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(PatientAttendanceRecordTo.class)
                .doOnError(error -> log.error("Error fetching patient attendance records: {}", error.getMessage()))
                .doOnComplete(() -> log.info("Patient attendance records fetched successfully for UPA ID: {}", upaId));
    }
}
