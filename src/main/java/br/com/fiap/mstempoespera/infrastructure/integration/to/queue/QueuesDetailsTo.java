package br.com.fiap.mstempoespera.infrastructure.integration.to.queue;

import java.util.Set;

public record QueuesDetailsTo(
        String upaId,
        Set<QueueDetailTo> queuesDetails,
        int totalPatientsAtUnit,
        int totalPatientsTreated) {
}
