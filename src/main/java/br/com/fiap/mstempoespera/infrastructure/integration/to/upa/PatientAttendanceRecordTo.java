package br.com.fiap.mstempoespera.infrastructure.integration.to.upa;

import br.com.fiap.mstempoespera.core.entity.EmergencyCategory;

import java.time.LocalDateTime;

public record PatientAttendanceRecordTo(
        UpaTo upa,
        String patientName,
        EmergencyCategory urgencyLevel,
        LocalDateTime creationDate,
        LocalDateTime endDate) {
}

