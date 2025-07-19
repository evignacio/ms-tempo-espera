package br.com.fiap.mstempoespera.core.entity;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class QueuesDetails implements Iterable<QueueDetail> {
    private String upaId;
    private Set<QueueDetail> queuesDetails;
    private Integer totalPatientsAtUnit;
    private Integer totalPatientsTreated;
    private Double averageWaitingTime;

    public QueuesDetails(String upaId, Set<QueueDetail> queuesDetails, Integer totalPatientsAtUnit, Integer totalPatientsTreated) {
        setUpaId(upaId);
        setQueuesDetails(queuesDetails);
        setTotalPatientsAtUnit(totalPatientsAtUnit);
        setTotalPatientsTreated(totalPatientsTreated);
    }

    public String getUpaId() {
        return upaId;
    }

    private void setUpaId(String upaId) {
        if (upaId == null || upaId.isEmpty()) {
            throw new IllegalArgumentException("UPA ID cannot be null or empty");
        }
        this.upaId = upaId;
    }

    private void setQueuesDetails(Set<QueueDetail> queuesDetails) {
        if (queuesDetails == null || queuesDetails.isEmpty()) {
            throw new IllegalArgumentException("Queue details cannot be null or empty");
        }
        this.queuesDetails = queuesDetails;
    }

    public Integer getTotalPatientsAtUnit() {
        return totalPatientsAtUnit;
    }

    public void setTotalPatientsAtUnit(Integer totalPatientsAtUnit) {
        if (totalPatientsAtUnit < 0) {
            throw new IllegalArgumentException("Total patients at unit cannot be negative");
        }
        this.totalPatientsAtUnit = totalPatientsAtUnit;
    }


    public Integer getTotalPatientsTreated() {
        return totalPatientsTreated;
    }

    public void setTotalPatientsTreated(Integer totalPatientsTreated) {
        if (totalPatientsTreated < 0) {
            throw new IllegalArgumentException("Total patients treated cannot be negative");
        }
        this.totalPatientsTreated = totalPatientsTreated;
    }

    public Double getAverageWaitingTime() {
        return averageWaitingTime;
    }

    public void calculateAverageWaitingTimes(Double averageTimeTreatment) {
        var amountPatientTriageQueue = queuesDetails.stream()
                .filter(QueueDetail::isTreage)
                .map(QueueDetail::getTotalPatients).
                reduce(Integer::sum)
                .orElse(0);

        averageWaitingTime = averageTimeTreatment * amountPatientTriageQueue;
    }

    @Override
    public Iterator<QueueDetail> iterator() {
        return queuesDetails == null ? Collections.emptyIterator() : queuesDetails.iterator();
    }
}
