package br.com.fiap.mstempoespera.infrastructure.mapper;

import br.com.fiap.mstempoespera.core.entity.PatientAttendanceRecord;
import br.com.fiap.mstempoespera.core.entity.Upa;
import br.com.fiap.mstempoespera.infrastructure.integration.to.upa.PatientAttendanceRecordTo;
import br.com.fiap.mstempoespera.infrastructure.integration.to.upa.UpaTo;

public abstract class UpaMapper {
    private UpaMapper() {
        // Private constructor to prevent instantiation
    }

    public static Upa toEntity(UpaTo to) {
        return new Upa(to.id(), to.nickName());
    }

    public static PatientAttendanceRecord toEntity(PatientAttendanceRecordTo to) {
        return new PatientAttendanceRecord(
                to.upa().id(),
                to.patientName(),
                to.urgencyLevel().getEmergencyCategory(),
                to.creationDate(),
                to.endDate()
        );
    }
}
