package dev.two.project.Interface.Main.MainPatient;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;

public class PatientOptions extends JPanelRound {

    public JPanelRound showAppointments;
    public JPanelRound showHistory;
    public JPanelRound newAppointment;

    public JPanelRound SingOff;

    public PatientOptions(){
        this.setLayout(null);
        this.setBounds(30, 400, 250, 300);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setBackground(new Color(168, 192, 191));
        initComponents();

    }
    public void initComponents(){

        showAppointments = new JPanelRound();
        showAppointments.setBounds(35, 10, 180, 50);
        showAppointments.setRoundTopLeft(20);
        showAppointments.setRoundBottomLeft(20);
        showAppointments.setRoundBottomRight(20);
        showAppointments.setRoundTopRight(20);
        showAppointments.setBackground(new Color(21, 20, 20));
        this.add(showAppointments);

        showHistory = new JPanelRound();
        showHistory.setBounds(35, 75, 180, 50);
        showHistory.setRoundTopLeft(20);
        showHistory.setRoundBottomLeft(20);
        showHistory.setRoundBottomRight(20);
        showHistory.setRoundTopRight(20);
        showHistory.setBackground(new Color(21, 20, 20));
        this.add(showHistory);

        newAppointment = new JPanelRound();
        newAppointment.setBounds(35, 140, 180, 50);
        newAppointment.setRoundTopLeft(20);
        newAppointment.setRoundBottomLeft(20);
        newAppointment.setRoundBottomRight(20);
        newAppointment.setRoundTopRight(20);
        newAppointment.setBackground(new Color(21, 20, 20));
        this.add(newAppointment);

        SingOff = new JPanelRound();
        SingOff.setBounds(35, 205, 180, 50);
        SingOff.setRoundTopLeft(20);
        SingOff.setRoundBottomLeft(20);
        SingOff.setRoundBottomRight(20);
        SingOff.setRoundTopRight(20);
        SingOff.setBackground(new Color(21, 20, 20));
        this.add(SingOff);
    }
}
