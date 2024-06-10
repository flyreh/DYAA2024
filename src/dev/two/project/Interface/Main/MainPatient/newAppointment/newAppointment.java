package dev.two.project.Interface.Main.MainPatient.newAppointment;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;

public class newAppointment extends JPanelRound {
    public CardLayout cardLayout;
    public newAppointmentOptions newAppointmentOptions;
    public ViewCreateAppointment viewCreateAppointment;

    JLabel message;

    public newAppointment(){
        this.setBounds(0, 0, 850, 620);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setBackground(new java.awt.Color(105, 102, 102));
        initComponents();
    }
    public void initComponents(){
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        message = new JLabel("sacando nueva cita");
        message.setBounds(400, 200, 100, 100);
        this.add(message);

        viewCreateAppointment = new ViewCreateAppointment();
        this.add(viewCreateAppointment, "viewCreateAppointment");
        //cardLayout.show(this, "viewCreateAppointment");

        newAppointmentOptions = new newAppointmentOptions();
        this.add(newAppointmentOptions, "newAppointmentOptions");
        cardLayout.show(this, "newAppointmentOptions");

    }
}
