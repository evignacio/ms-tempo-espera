package br.com.fiap.mstempoespera.infrastructure.mapper;

import br.com.fiap.mstempoespera.core.entity.QueueDetail;
import br.com.fiap.mstempoespera.core.entity.QueuesDetails;
import br.com.fiap.mstempoespera.infrastructure.integration.to.queue.QueueDetailTo;
import br.com.fiap.mstempoespera.infrastructure.integration.to.queue.QueuesDetailsTo;

import java.util.stream.Collectors;

public abstract class QueueDetailMapper {
    private QueueDetailMapper() {

    }

    public static QueuesDetails toEntity(QueuesDetailsTo to) {
        var queuesDetails = to.queuesDetails()
                .stream()
                .map(QueueDetailMapper::toEntity)
                .collect(Collectors.toSet());

        return new QueuesDetails(
                to.upaId(),
                queuesDetails,
                to.totalPatientsAtUnit(),
                to.totalPatientsTreated()
        );
    }

    public static QueueDetail toEntity(QueueDetailTo to) {
        return new QueueDetail(
                to.title(),
                to.emergencyCategory(),
                to.size()
        );
    }
}
