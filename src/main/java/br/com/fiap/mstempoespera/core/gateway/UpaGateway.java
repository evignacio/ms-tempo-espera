package br.com.fiap.mstempoespera.core.gateway;

import br.com.fiap.mstempoespera.core.entity.PatientAttendanceRecord;
import br.com.fiap.mstempoespera.core.entity.SaoPauloCity;
import br.com.fiap.mstempoespera.core.entity.Upa;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface UpaGateway {
    Flux<Upa> findByCity(SaoPauloCity saoPauloCity);

    Flux<PatientAttendanceRecord> findByUpaIdAndPeriod(String upaId, LocalDateTime startDate, LocalDateTime endDate);
}
