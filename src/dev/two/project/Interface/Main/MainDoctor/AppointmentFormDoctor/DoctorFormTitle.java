package dev.two.project.Interface.Main.MainDoctor.AppointmentFormDoctor;

import javax.swing.*;
import java.awt.*;

public class DoctorFormTitle extends JPanel {
    protected JLabel etiqueta_bienvenida;

    public DoctorFormTitle () {
        Font mifuenteAesthetic = new Font("Sarala", Font.BOLD, 30);
        this.setAlignmentX(CENTER_ALIGNMENT);
        etiqueta_bienvenida = new JLabel("ATENCION DE CITA");
        etiqueta_bienvenida.setBounds(8, 70, 100, 40);
        etiqueta_bienvenida.setForeground(Color.WHITE);
        etiqueta_bienvenida.setFont(mifuenteAesthetic);
        setOpaque(false);
        this.add(etiqueta_bienvenida);
    }
}
