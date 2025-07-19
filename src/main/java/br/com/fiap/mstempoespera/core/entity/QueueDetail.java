package br.com.fiap.mstempoespera.core.entity;

public class QueueDetail {
    private String title;
    private EmergencyCategory emergencyCategory;
    private Integer totalPatients;


    public QueueDetail(String title, EmergencyCategory emergencyCategory, Integer totalPatients) {
        setTitle(title);
        setEmergencyCategory(emergencyCategory);
        setTotalPatients(totalPatients);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public Integer getTotalPatients() {
        return totalPatients;
    }

    public void setTotalPatients(Integer totalPatients) {
        if (totalPatients < 0) {
            throw new IllegalArgumentException("Total patients cannot be negative");
        }
        this.totalPatients = totalPatients;
    }

    public EmergencyCategory getEmergencyCategory() {
        return emergencyCategory;
    }

    public void setEmergencyCategory(EmergencyCategory emergencyCategory) {
        this.emergencyCategory = emergencyCategory;
    }

    public boolean isTreage() {
        return emergencyCategory == null;
    }
}
