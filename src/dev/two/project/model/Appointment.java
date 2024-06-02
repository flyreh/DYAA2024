package dev.two.project.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Appointment extends Nodo {

    public enum Status {
        POR_ATENDER,
        ATENDIDA
    }
    private final int id;
    private static int idCounter = 10;
    private Status status;
    private String Initialdescription;
    private String Doctordescription;
    private Doctor doctor;
    private Patient patient;
    private LocalDate CreationTimeDay;
    private LocalTime CreationTime;
    private LocalDate CreationAttentionDay;
    private LocalTime CreationAttentionTime;

    public Appointment(String description, LocalDate CreationTimeDay,LocalTime CreationTime, Doctor doctor, Patient patient){
        this.id = ++idCounter;
        this.doctor = doctor;
        this.patient = patient;
        this.CreationTimeDay = CreationTimeDay;
        this.CreationTime = CreationTime;
        this.Initialdescription = description;
        this.status = Status.POR_ATENDER;
    }

    public int getId() {
        return id;
    }

    public LocalTime getCreationTime() {
        return CreationTime;
    }

    public void setCreationTime(LocalTime CreationTime) {
        this.CreationTime = CreationTime;
    }

    public LocalDate getCreationTimeDay() {
        return CreationTimeDay;
    }

    public void setCreationTimeDay(LocalDate CreationTimeDay) {
        this.CreationTimeDay = CreationTimeDay;
    }

    public LocalTime getCreationAttention() {
        return CreationAttentionTime;
    }

    public void setCreationAttention(LocalTime CreationAttention) {
        this.CreationAttentionTime = CreationAttention;
    }

    public LocalDate getCreationAttentionDay() {
        return CreationAttentionDay;
    }

    public void setCreationAttentionDay(LocalDate CreationAttentionDay) {
        this.CreationAttentionDay = CreationAttentionDay;
    }

    public String getDoctordescription() {
        return Doctordescription;
    }

    public void setDoctordescription(String description) {
        this.Doctordescription = description;
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