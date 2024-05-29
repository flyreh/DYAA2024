package dev.two.project.model;

import dev.two.project.model.MedicalAreas.Area;
import dev.two.project.model.MedicalAreas.Dermatology;

public class Doctor extends NodoAVL {
    private static int idCounter = 50;
    private int id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String password;
    private int edad;
    private String genero;
    private String estadoCivil;
    private String telefono;
    private String correo;
    private Area specialty;
    private Queue queueAppointments = new Queue();

    public Doctor(String firstName, String secondName, String lastName, String password, int edad, String genero, String estadoCivil, String telefono, String correo) {
        super();
        this.id = idCounter++;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.password = password;
        this.edad = edad;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId(){
        return id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Area getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Area specialty) {
        this.specialty = specialty;
    }

    public Queue getQueueAppointments() {
        return queueAppointments;
    }

    public void setQueueAppointments(Queue queueAppointments) {
        this.queueAppointments = queueAppointments;
    }
}
