package dev.two.project.Interface.Register.RegisterPatient;

import dev.two.project.Interface.login.loginPatient.clinicPanelPatient;
import dev.two.project.Interface.login.loginPatient.loginPatientForm;

import javax.swing.*;
import java.awt.*;

public class RegisterPanelPatient extends JPanel {
    public RegisterLogoClinic registerLogoClinic;
    public registerPatientForm registerPatientForm;

    public RegisterPanelPatient() {
        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        initComponents();
    }
    public void initComponents() {
        registerPatientForm = new registerPatientForm();
        this.add(registerPatientForm);

       registerLogoClinic = new RegisterLogoClinic();
        this.add(registerLogoClinic);

    }
}
