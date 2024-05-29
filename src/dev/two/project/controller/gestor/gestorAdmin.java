package dev.two.project.controller.gestor;

import dev.two.project.model.Doctor;
import dev.two.project.tools.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class gestorAdmin {
    private static String sesion;

    public gestorAdmin(String sesion) {
        gestorAdmin.sesion = sesion;
    }

    public static void setSesion(String sesion) {
        gestorAdmin.sesion = sesion;
    }

    public static String getSesion() {
        return sesion;
    }

    public static boolean SearchAdminFile(String primerNombre, String password) {
        ArrayList<String> almacen = new ArrayList<>();
        try {
            FileManager.leerArchivo("admin.txt", almacen);
            System.out.println("archivo administradores leido");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (almacen.size() < 2) {
            return false;
        } else if (almacen.get(0).equals(primerNombre)) {
            if (almacen.get(1).equals(password)) {
                return true;
            }
        }
        return false;
    }
}
