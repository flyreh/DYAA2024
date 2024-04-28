package dev.two.project.Interface.login.loginPatient;

import components.JPanelGradient;
import components.JPanelRound;

import javax.swing.*;
import java.awt.*;

public class clinicPanelLogo extends JPanelRound {

    public JLabel ClinicName;
    public JLabel ClinicImage;

    public clinicPanelLogo(){
        this.setLayout(null);
        this.setBounds(0, 0, 1200, 800);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setBackground(new Color (68, 91, 81));


        initComponents();
    }

    public void initComponents(){

    }

}
