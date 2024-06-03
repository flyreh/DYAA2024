package dev.two.project.controller.gestor;

import dev.two.project.model.AVLDerma;
import dev.two.project.model.Doctor;
import dev.two.project.model.Patient;
import dev.two.project.tools.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class gestorDerma {
    
    public static AVLDerma DoctorsDerma = new AVLDerma();

    public gestorDerma(AVLDerma DoctorsDerma) {
        gestorDerma.DoctorsDerma = DoctorsDerma;
    }
    public static AVLDerma getDoctorsDerma() {
        return DoctorsDerma;
    }

    public static void WriteDoctorDermaFile(Doctor doctor) {
        try {
            FileManager.escribirArchivo("doctorsDerma.txt", String.valueOf(doctor.getId()), true);
            FileManager.escribirArchivo("doctorsDerma.txt", doctor.getFirstname(), true);
            FileManager.escribirArchivo("doctorsDerma.txt", doctor.getSecondName(), true);
            FileManager.escribirArchivo("doctorsDerma.txt", doctor.getPassword(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean SearchDoctorDermaFile(String primerNombre, String password) {
        ArrayList<String> almacen = new ArrayList<>();
        try {
            FileManager.leerArchivo("doctorsDerma.txt", almacen);
            System.out.println("archivo Derma leido");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(almacen.size()<4){
            return false;
        }
        for (int i = 1; i < almacen.size(); i += 4) {
            if(i+2 < almacen.size()) {
                if (almacen.get(i).equals(primerNombre)) {
                    if (almacen.get(i + 2).equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static int returnIdDoctorDerma(String primerNombre, String password) {
        ArrayList<String> almacen = new ArrayList<>();
        try {
            FileManager.leerArchivo("doctorsDerma.txt", almacen);
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

    public static Doctor searchDoctorDermaTree(int id) {
        return DoctorsDerma.searchDoctorDermaId(id);
    }

    public static void AddDoctorDermaTree(Doctor doctor) throws Exception {
        DoctorsDerma.insertar(doctor);
        showPatients();
    }

    public static void showPatients() {
        DoctorsDerma.inorden(DoctorsDerma.getRaiz());
    }
}
