package dev.two.project.Interface.login.confirmation.AppointmentForm;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AppointmentForm extends JFrame {
    public  AppointmentFormBack appointmentFormBack;
    public  AppointmentFormBorder appointmentFormBorder;
    public  AppointmentFormTitle appointmentFormTitle;
    public  AppointmentForminputDesc appointmentForminputDesc;

    public AppointmentForm() {
        this.setLayout(null);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setSize(785, 539);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Creación de Cita");
        this.setVisible(false);
        initComponents();
    }

    public void initComponents() {
        appointmentFormBack = new AppointmentFormBack();
        appointmentFormBack.setBounds(5, 5, 775, 529);
        this.add(appointmentFormBack);

        appointmentFormBorder = new AppointmentFormBorder();
        this.add(appointmentFormBorder);

        appointmentFormTitle = new AppointmentFormTitle();
        appointmentFormTitle.setBounds(60, 30, 700, 110);
        appointmentFormBack.add(appointmentFormTitle);

        Color color_estilo = new Color(0, 120, 145);
        JPanel panel_estilo = new JPanel();
        panel_estilo.setBackground(color_estilo);
        panel_estilo.setBounds(0, 190, 1500, 60);
        appointmentFormBack.add(panel_estilo);

        appointmentForminputDesc = new AppointmentForminputDesc();
        appointmentForminputDesc.setBounds(20, 270, 450, 275);
        appointmentFormBack.add(appointmentForminputDesc);
    }

}
