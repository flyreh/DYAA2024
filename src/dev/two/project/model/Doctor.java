package dev.two.project.model;

import dev.two.project.controller.gestor.gestorDoctor;
import dev.two.project.model.MedicalAreas.Area;
import dev.two.project.model.MedicalAreas.Dermatology;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class Doctor extends NodoAVL implements Serializable {
    private int id;
    private static int idCounter = 50;
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
        this.id = ++idCounter;
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

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Doctor.idCounter = idCounter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
    @Override
    public String toString() {
        String Doctor = "";
        Doctor += "Estado:  " +"Activo ✓ "+ "\n";
        Doctor += "Primer Nombre: " + this.firstName + "\n";
        Doctor += "Segundo Nombre: " + this.secondName + "\n";
        Doctor += "Apellido: " + this.lastName + "\n";
        Doctor += "Género:    " + this.genero + "\n";
        Doctor += "Teléfono:  " + this.telefono + "\n";
        Doctor += "Correo Dr: " + this.correo + "\n";
        Doctor += "Especialidad: " + this.specialty.getClass().getSimpleName() + "\n";

        return Doctor;
    }
}
