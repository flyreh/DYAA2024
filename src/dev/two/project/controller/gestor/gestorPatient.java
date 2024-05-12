package dev.two.project.controller.gestor;

import dev.two.project.model.AVLpatients;
import dev.two.project.model.Patient;

public class gestorPatient {
    public static Patient sesion;
    public static AVLpatients patients = new AVLpatients();

    public gestorPatient(AVLpatients patients, Patient sesion) {
        gestorPatient.patients = patients;
        gestorPatient.sesion = sesion;
    }

    public static void setSesion(Patient sesion) {
        gestorPatient.sesion = sesion;
    }
    public static Patient getSesion() {
        return sesion;
    }

    public static void WritePatientFile(Patient patient) {

    }
    public static boolean SearchPatientFile(String primerNombre, String segundoNombre, String apellido) {
        //regresa true si encuentra el paciente en el archivo de pacientes
        //regresa false si no encuentra el paciente en el archivo de pacientes
        return false;
    }
    public static void DeletePatientFile(Patient patient) {

    }
    public static void UpdatePatientFile(Patient patient) {

    }
    public static Patient searchPatientTree(Patient patient) {
        return null;
    }

    public static void AddPatientTree(Patient patient) {

    }
}