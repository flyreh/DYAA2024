package dev.two.project.Interface.Main.MainDoctor.AppointmentFormDoctor;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;

public class DoctorFormBack extends JPanelRound {
    private ImageIcon imagen;

    public DoctorFormBack() {
        this.setBounds(2, 5, 445, 590);
        this.setLayout(null);
        this.setBackground(new Color(0, 0, 0));
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopLeft(50);
        this.setRoundTopRight(50);
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setAlignmentY(CENTER_ALIGNMENT);
        initComponents();
    }

    public void initComponents() {
        imagen = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\gif\\edificio.gif");
        Image scaled = imagen.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        JLabel panel_imagen = new JLabel();
        panel_imagen.setIcon(imagen);
        panel_imagen.setBounds(500, 250, 300, 300);
        this.add(panel_imagen);
    }
}
