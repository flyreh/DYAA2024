package dev.two.project.controller.gestor;

import dev.two.project.model.AVLOfta;
import dev.two.project.model.Doctor;
import dev.two.project.model.Patient;
import dev.two.project.tools.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class gestorOfta {

        public static AVLOfta DoctorsOfta = new AVLOfta();

        public gestorOfta(AVLOfta DoctorsOfta) {
                gestorOfta.DoctorsOfta = DoctorsOfta;
        }
        public static AVLOfta getDoctorsOfta() {
                return DoctorsOfta;
        }

        public static void WriteDoctorOftaFile(Doctor doctor) {
                try {
                        FileManager.escribirArchivo("doctorsOfta.txt", String.valueOf(doctor.getId()), true);
                        FileManager.escribirArchivo("doctorsOfta.txt", doctor.getFirstname(), true);
                        FileManager.escribirArchivo("doctorsOfta.txt", doctor.getSecondName(), true);
                        FileManager.escribirArchivo("doctorsOfta.txt", doctor.getPassword(), true);
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        public static boolean SearchDoctorOftaFile(String primerNombre, String password) {
                ArrayList<String> almacen = new ArrayList<>();
                try {
                        FileManager.leerArchivo("doctorsOfta.txt", almacen);
                        System.out.println("archivo Ofta leido");
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
        public static int returnIdDoctorOfta(String primerNombre, String password) {
                ArrayList<String> almacen = new ArrayList<>();
                try {
                        FileManager.leerArchivo("doctorsOfta.txt", almacen);
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
        public static Doctor searchDoctorOftaTree(int id) {
                return DoctorsOfta.searchDoctorOftaId(id);
        }

        public static void AddDoctorOftaTree(Doctor doctor) throws Exception {
                DoctorsOfta.insertar(doctor);
                showPatients();
        }

        public static void showPatients() {
                DoctorsOfta.inorden(DoctorsOfta.getRaiz());
        }
}
