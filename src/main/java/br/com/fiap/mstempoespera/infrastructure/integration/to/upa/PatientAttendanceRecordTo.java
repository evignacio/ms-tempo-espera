package br.com.fiap.mstempoespera.infrastructure.integration.to.upa;

import java.time.LocalDateTime;

public record PatientAttendanceRecordTo(
        UpaTo upa,
        String patientName,
        Urgency urgencyLevel,
        LocalDateTime creationDate,
        LocalDateTime endDate) {
}

