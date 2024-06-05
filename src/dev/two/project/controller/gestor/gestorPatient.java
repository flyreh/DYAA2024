package dev.two.project.controller.gestor;

import dev.two.project.model.AVLpatients;
import dev.two.project.model.Patient;
import dev.two.project.tools.FileManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class gestorPatient {

    private static Patient sesion;
    public static AVLpatients patients = new AVLpatients();

    public gestorPatient(AVLpatients patients) {
        gestorPatient.patients = patients;
    }

    public static void setSesion(Patient sesion) {
        gestorPatient.sesion = sesion;
    }

    public static Patient getSesion() {
        return sesion;
    }

    public static AVLpatients getPatients() {
        return patients;
    }


    public static void WritePatientFile(Patient patient) {
        try {
            FileManager.escribirArchivo("patients.txt", String.valueOf(patient.getId()), true);
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
            System.out.println("archivo pacientes leido");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (almacen.size() < 4) {
            return false;
        }
        for (int i = 1; i < almacen.size(); i += 4) {
            if (i + 2 < almacen.size()) {
                if (almacen.get(i).equals(primerNombre)) {
                    if (almacen.get(i + 2).equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int returnIdpatient(String primerNombre, String password) {
        ArrayList<String> almacen = new ArrayList<>();
        try {
            FileManager.leerArchivo("patients.txt", almacen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < almacen.size(); i += 4) {
            if (almacen.get(i + 1).equals(primerNombre)) {
                if (almacen.get(i + 3).equals(password)) {
                    return Integer.parseInt(almacen.get(i));
                }
            }
        }
        return 0;
    }

    public static void DeletePatientFile(Patient patient) {

    }

    public static void UpdatePatientFile(Patient patient) {

    }

    public static Patient searchPatientTree(int id) {
        return patients.searchPatient(id);
    }

    public static void AddPatientTree(Patient patient) throws Exception {
        patients.insertar(patient);
        showPatients();
    }

    public static void showPatients() {
        patients.inorden(patients.getRaiz());
    }
}