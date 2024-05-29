package dev.two.project.Interface.Register.RegisterDoctor;

import components.JPanelRound;
import dev.two.project.Interface.Register.RegisterPatient.RegisterLogoClinic;
import dev.two.project.Interface.Register.RegisterPatient.registerPatientForm;

import javax.swing.*;
import java.awt.*;

public class RegisterPanelDoctor extends JPanel {
    public DoctorRegisterForm doctorRegisterForm;
    public DoctorPanelOptions doctorPanelOptions;

    public RegisterPanelDoctor() {
        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        initComponents();
    }
    public void initComponents() {
        doctorRegisterForm = new DoctorRegisterForm();
        this.add(doctorRegisterForm);

        doctorPanelOptions = new DoctorPanelOptions();
        this.add(doctorPanelOptions);
    }
}
