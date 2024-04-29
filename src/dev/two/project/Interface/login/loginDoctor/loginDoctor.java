package dev.two.project.Interface.login.loginDoctor;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;

public class loginDoctor extends JPanel {

    public clinicPanelDoctor clinicPanelDoctor;
    public loginDoctorform loginDoctorform;

    public loginDoctor() {
        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setBackground(new Color(0, 0, 0,0));
        initComponents();
    }

    public void initComponents(){

        loginDoctorform = new loginDoctorform();
        this.add(loginDoctorform);

        clinicPanelDoctor = new clinicPanelDoctor();
        this.add(clinicPanelDoctor);


    }


}
