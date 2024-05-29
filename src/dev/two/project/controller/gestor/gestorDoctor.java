package dev.two.project.controller.gestor;

import dev.two.project.model.Doctor;
import dev.two.project.model.Patient;

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
