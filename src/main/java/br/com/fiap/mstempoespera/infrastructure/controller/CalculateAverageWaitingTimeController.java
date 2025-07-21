package br.com.fiap.mstempoespera.infrastructure.controller;

import br.com.fiap.mstempoespera.core.entity.QueuesDetails;
import br.com.fiap.mstempoespera.core.entity.SaoPauloCity;
import br.com.fiap.mstempoespera.core.usecase.CalculateEstimatedWaitingTimeUseCase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/ups/calculate-average-waiting-time")
public record CalculateAverageWaitingTimeController(CalculateEstimatedWaitingTimeUseCase calculateEstimatedWaitingTimeUseCase) {

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, QueuesDetails>> calculate(@RequestParam SaoPauloCity city) {
        var interval = Flux.interval(Duration.ofSeconds(5));
        var queuesDetails = calculateEstimatedWaitingTimeUseCase.execute(city);
        return Flux.zip(interval, queuesDetails);
    }

}
