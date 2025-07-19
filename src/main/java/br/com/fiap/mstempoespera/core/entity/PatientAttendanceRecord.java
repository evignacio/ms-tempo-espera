package br.com.fiap.mstempoespera.core.entity;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class PatientAttendanceRecord {
    private String upasId;
    private String patientName;
    private EmergencyCategory emergencyCategory;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public PatientAttendanceRecord(String upasId, String patientName, EmergencyCategory emergencyCategory, LocalDateTime startTime, LocalDateTime endTime) {
        setUpasId(upasId);
        setPatientName(patientName);
        setEmergencyCategory(emergencyCategory);
        setStartTime(startTime);
        setEndTime(endTime);
    }

    public String getUpasId() {
        return upasId;
    }

    public void setUpasId(String upasId) {
        if (upasId == null || upasId.isEmpty()) {
            throw new IllegalArgumentException("UPS ID cannot be null or empty");
        }
        this.upasId = upasId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        if (patientName == null || patientName.isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be null or empty");
        }
        this.patientName = patientName;
    }

    public EmergencyCategory getEmergencyCategory() {
        return emergencyCategory;
    }

    public void setEmergencyCategory(EmergencyCategory emergencyCategory) {
        if (emergencyCategory == null) {
            throw new IllegalArgumentException("Emergency category cannot be null");
        }
        this.emergencyCategory = emergencyCategory;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        if (startTime == null) {
            throw new IllegalArgumentException("Start time cannot be null");
        }
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        if (endTime == null) {
            throw new IllegalArgumentException("End time cannot be null");
        }
        this.endTime = endTime;
    }

    public Double calculateAverageWaitingTime() {
        return Duration.between(startTime, endTime).toMillis() / 1000.0 / 60.0;
    }
}

