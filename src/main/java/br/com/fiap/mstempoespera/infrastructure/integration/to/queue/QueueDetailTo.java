package br.com.fiap.mstempoespera.infrastructure.integration.to.queue;

import br.com.fiap.mstempoespera.core.entity.EmergencyCategory;

public record QueueDetailTo(String title, int size, EmergencyCategory emergencyCategory) {
}
