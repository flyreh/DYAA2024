package dev.two.project.controller.gestor;

import dev.two.project.model.AVLTrauma;
import dev.two.project.model.Doctor;
import dev.two.project.model.Patient;
import dev.two.project.tools.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class gestorTrauma {

        public static AVLTrauma DoctorsTrauma = new AVLTrauma();



        public static void WriteDoctorTraumaFile(Doctor doctor) {
                try {
                        FileManager.escribirArchivo("doctorsTrauma.txt", String.valueOf(doctor.getId()), true);
                        FileManager.escribirArchivo("doctorsTrauma.txt", doctor.getFirstname(), true);
                        FileManager.escribirArchivo("doctorsTrauma.txt", doctor.getSecondName(), true);
                        FileManager.escribirArchivo("doctorsTrauma.txt", doctor.getPassword(), true);
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        public static boolean SearchDoctorTraumaFile(String primerNombre, String password) {
                ArrayList<String> almacen = new ArrayList<>();
                try {
                        FileManager.leerArchivo("doctorsTrauma.txt", almacen);
                        System.out.println("archivo Trauma leido");
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
        public static int returnIdDoctorTrauma(String primerNombre, String password) {
                ArrayList<String> almacen = new ArrayList<>();
                try {
                        FileManager.leerArchivo("doctorsTrauma.txt", almacen);
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
        public static Doctor searchDoctorTraumaTree(int id) {
                return DoctorsTrauma.searchDoctorTraumaId(id);
        }

        public static void AddDoctorOftaTree(Doctor doctor) throws Exception {
                DoctorsTrauma.insertar(doctor);
                showPatients();
        }

        public static void showPatients() {
                DoctorsTrauma.inorden(DoctorsTrauma.getRaiz());
        }
}
