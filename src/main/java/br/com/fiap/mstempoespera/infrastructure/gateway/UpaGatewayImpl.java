package br.com.fiap.mstempoespera.infrastructure.gateway;

import br.com.fiap.mstempoespera.core.entity.PatientAttendanceRecord;
import br.com.fiap.mstempoespera.core.entity.SaoPauloCity;
import br.com.fiap.mstempoespera.core.entity.Upa;
import br.com.fiap.mstempoespera.core.gateway.UpaGateway;
import br.com.fiap.mstempoespera.infrastructure.integration.rest.UpaRestClient;
import br.com.fiap.mstempoespera.infrastructure.mapper.UpaMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Slf4j
@Component
public record UpaGatewayImpl(UpaRestClient upaRestClient) implements UpaGateway {

    @Override
    public Flux<Upa> findByCity(SaoPauloCity saoPauloCity) {
        return upaRestClient.requestUpasByCity(saoPauloCity)
                .map(UpaMapper::toEntity);
    }

    @Override
    public Flux<PatientAttendanceRecord> findByUpaIdAndPeriod(String upaId, LocalDateTime startDate, LocalDateTime endDate) {
        return upaRestClient.requestPatientAttendancePeriod(upaId, startDate, endDate)
                .map(UpaMapper::toEntity);
    }
}
