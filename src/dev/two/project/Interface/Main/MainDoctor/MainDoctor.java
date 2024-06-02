package dev.two.project.Interface.Main.MainDoctor;

import components.JPanelRound;

import java.awt.*;

public class MainDoctor extends JPanelRound {

    public DoctorInfo doctorInfo;
    public MainDoctorCard mainDoctorCard;

    public JPanelRound SignOff;

    public MainDoctor(){
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
        SignOff = new JPanelRound();
        SignOff.setBounds(35, 390, 180, 50);
        SignOff.setRoundTopLeft(20);
        SignOff.setRoundBottomLeft(20);
        SignOff.setRoundBottomRight(20);
        SignOff.setRoundTopRight(20);
        SignOff.setBackground(new Color(21, 20, 20));
        this.add(SignOff);

        doctorInfo = new DoctorInfo();
        this.add(doctorInfo);

        mainDoctorCard = new MainDoctorCard();
        this.add(mainDoctorCard);
    }
}
