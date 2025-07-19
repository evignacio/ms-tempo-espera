package br.com.fiap.mstempoespera.core.usecase;

import br.com.fiap.mstempoespera.core.entity.PatientAttendanceRecord;
import br.com.fiap.mstempoespera.core.entity.QueuesDetails;
import br.com.fiap.mstempoespera.core.entity.SaoPauloCity;
import br.com.fiap.mstempoespera.core.gateway.QueueGateway;
import br.com.fiap.mstempoespera.core.gateway.UpaGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Slf4j
@Service
public record CalculateEstimatedWaitingTimeUseCase(QueueGateway queueGateway, UpaGateway upaGateway) {

    private static final int HOURS_RANGE = 3;

    public Flux<QueuesDetails> execute(SaoPauloCity saoPauloCity) {
        var actualDate = LocalDateTime.now();
        var startDate = actualDate.minusHours(HOURS_RANGE);

        return upaGateway.findByCity(saoPauloCity)
                .flatMap(upa ->
                        upaGateway.findByUpaIdAndPeriod(upa.getId(), startDate, actualDate)
                                .map(PatientAttendanceRecord::calculateAverageWaitingTime)
                                .collectList()
                                .map(list -> list.stream()
                                        .mapToDouble(Double::doubleValue)
                                        .average()
                                        .orElse(0.0)
                                )
                                .flatMapMany(averageTimeTreatment ->
                                        queueGateway.findAll(upa.getId())
                                                .map(q -> {
                                                    q.calculateAverageWaitingTimes(averageTimeTreatment);
                                                    return q;
                                                })
                                )
                );
    }
}
