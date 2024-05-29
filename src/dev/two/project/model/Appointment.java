package dev.two.project.model;

public class Appointment extends Nodo {

    public enum Status {
        POR_ATENDER,
        ATENDIDA
    }

    private Status status;
    private String description;
    private Doctor doctor;
    private Patient patient;

    public Appointment(String description){
        this.description = description;
        this.status = Status.POR_ATENDER;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}