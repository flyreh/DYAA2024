package dev.two.project.Interface.Main.MainPatient;

import components.JPanelRound;
import dev.two.project.Interface.Main.MainPatient.newAppointment.newAppointment;

import java.awt.*;

public class MainPatientCard extends JPanelRound{

    public CardLayout cardLayout;
    public showAppointments showAppointments;
    public showHistory showHistory;
    public  newAppointment newAppointment;

    public MainPatientCard(){
        this.setBounds(300, 80, 850, 620);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setBackground(new Color(40, 40, 40,100));
        initComponents();
    }

    public void initComponents(){
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        showAppointments = new showAppointments();
        this.add(showAppointments, "showAppointments");

        showHistory = new showHistory();
        this.add(showHistory, "showHistory");

        newAppointment = new newAppointment();
        this.add(newAppointment, "newAppointment");
    }


}
