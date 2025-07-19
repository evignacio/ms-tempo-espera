package br.com.fiap.mstempoespera.infrastructure.integration.to.upa;

import br.com.fiap.mstempoespera.core.entity.EmergencyCategory;

public enum Urgency {
    NAO_URGENTE(EmergencyCategory.NOT_URGENT),
    POUCO_URGENTE(EmergencyCategory.LITTLE_URGENT),
    URGENTE(EmergencyCategory.URGENT),
    MUITO_URGENTE(EmergencyCategory.VERY_URGENT),
    EMERGENCIA(EmergencyCategory.EMERGENCY);

    private final EmergencyCategory emergencyCategory;

    Urgency(EmergencyCategory emergencyCategory) {
        this.emergencyCategory = emergencyCategory;
    }

    public EmergencyCategory getEmergencyCategory() {
        return emergencyCategory;
    }
}
