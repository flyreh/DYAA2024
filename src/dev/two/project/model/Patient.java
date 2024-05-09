package dev.two.project.model;

public class Patient extends NodoAVL {

    private String id;
    private String firstname;
    private String secondName;
    private String lastName;
    private String password;
    private int edad;
    private String genero;
    private String estadoCivil;
    private String telefono;
    private String correo;
    private medicalH medicalHistory;
    private Queue queueAppointments = new Queue();



}
