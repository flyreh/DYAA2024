package dev.two.project.Interface.login.loginPatient;

import javax.swing.*;
import java.awt.*;

public class loginPatient extends JPanel {
    public loginPatientForm loginForm;
    public clinicPanelLogo clinicLogo;

    public loginPatient() {
        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        initComponents();
    }
    public void initComponents() {
        loginForm = new loginPatientForm();
        this.add(loginForm);
        clinicLogo = new clinicPanelLogo();
        this.add(clinicLogo);
    }

}
