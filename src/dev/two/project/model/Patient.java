package dev.two.project.model;

public class Patient extends NodoAVL {

    private final int id;
    private static int idCounter = 10;
    private String firstname;
    private String secondName;
    private String lastName;
    private String password;
    private int edad;
    private String genero;
    private String estadoCivil;
    private String telefono;
    private String correo;
    private medicalH medicalHistory = new medicalH();
    private Queue queueAppointments = new Queue();

    public Patient(String firstname, String secondName, String lastName
            , String password, int edad, String genero
            , String estadoCivil, String telefono, String correo) {
        super();
        this.id = ++idCounter;
        this.firstname = firstname;
        this.secondName = secondName;
        this.lastName = lastName;
        this.password = password;
        this.edad = edad;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.telefono = telefono;
        this.correo = correo;
    }
    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
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

    public medicalH getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(medicalH medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Queue getQueueAppointments() {
        return queueAppointments;
    }

    public void setQueueAppointments(Queue queueAppointments) {
        this.queueAppointments = queueAppointments;
    }
}
