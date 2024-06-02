package dev.two.project.Interface.login.confirmation.AppointmentForm;

import javax.swing.*;
import java.awt.*;

public class AppointmentFormTitle extends JPanel {
    protected JLabel etiqueta_bienvenida;

    public AppointmentFormTitle () {
        Font mifuenteAesthetic = new Font("Sarala", Font.BOLD, 80);

        etiqueta_bienvenida = new JLabel("NUEVA CITA");
        etiqueta_bienvenida.setBounds(8, 70, 400, 70);
        etiqueta_bienvenida.setForeground(Color.WHITE);
        etiqueta_bienvenida.setFont(mifuenteAesthetic);

        setOpaque(false);
        this.add(etiqueta_bienvenida);
    }
}