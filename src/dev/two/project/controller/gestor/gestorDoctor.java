package dev.two.project.controller.gestor;

import dev.two.project.model.Doctor;
import dev.two.project.model.Patient;
import dev.two.project.tools.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class gestorDoctor {
    public static Doctor sesiondoctor;

    public gestorDoctor(Doctor sesiondoctor) {
        gestorDoctor.sesiondoctor = sesiondoctor;
    }

    public static void setSesion(Doctor sesion) {
        gestorDoctor.sesiondoctor = sesion;
    }

    public static Doctor getSesion() {
        return sesiondoctor;
    }


}
