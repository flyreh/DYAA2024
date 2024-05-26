package dev.two.project.Interface.Main.MainPatient;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainPatient extends JPanelRound {
    public PatientInfo patientInfo;
    public PatientOptions patientOptions;
    public MainPatientCard mainPatientCard;

    public MainPatient(){
        this.setLayout(null);
        this.setBounds(0, 0, 1200, 800);
        this.setBackground(new Color(104, 103, 103));
        this.setRoundBottomLeft(50);
        this.setRoundTopLeft(50);
        this.setRoundTopRight(50);
        this.setRoundBottomRight(50);
        this.setVisible(false);
        initComponents();
    }
    public void initComponents(){

        patientInfo = new PatientInfo();
        this.add(patientInfo);

        patientOptions = new PatientOptions();
        this.add(patientOptions);

        mainPatientCard = new MainPatientCard();
        this.add(mainPatientCard);
    }
}
