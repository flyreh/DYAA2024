package dev.two.project.model;

import java.util.Date;

public class Appointment extends Nodo {

    public enum Status {
        POR_ATENDER,
        ATENDIDA
    }

    private Status status;
    private String description;
    private Doctor doctor;
    private Patient patient;
    private Date CreationTime;
    private Date CreationAttention;

    public Appointment(String description){
        this.description = description;
        this.status = Status.POR_ATENDER;
    }

    public Date getCreationTime() {
        return CreationTime;
    }

    public void setCreationTime(Date CreationTime) {
        this.CreationTime = CreationTime;
    }

    public Date getCreationAttention() {
        return CreationAttention;
    }

    public void setCreationAttention(Date CreationAttention) {
        this.CreationAttention = CreationAttention;
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