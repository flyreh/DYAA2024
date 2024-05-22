package dev.two.project.controller.gestor;

import dev.two.project.model.AVLpatients;
import dev.two.project.model.Patient;
import dev.two.project.tools.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class gestorPatient {
    private static Patient sesion;
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
        try {
            FileManager.escribirArchivo("patients.txt", patient.getFirstname(), true);
            FileManager.escribirArchivo("patients.txt", patient.getSecondName(), true);
            FileManager.escribirArchivo("patients.txt", patient.getPassword(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static boolean SearchPatientFile(String primerNombre, String password) {
        ArrayList<String> almacen = new ArrayList<>();
        try {
            FileManager.leerArchivo("patients.txt", almacen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < almacen.size(); i += 3) {
            if (almacen.get(i).equals(primerNombre)) {
                if (almacen.get(i + 2).equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void DeletePatientFile(Patient patient) {

    }
    public static void UpdatePatientFile(Patient patient) {

    }
    public static Patient searchPatientTree(Patient patient) {
        return patients.searchPatient(patient);
    }

    public static void AddPatientTree(Patient patient) throws Exception {
            patients.insertar(patient);
            showPatients();
    }
    public static void showPatients() {
        patients.inorden(patients.getRaiz());
    }
}