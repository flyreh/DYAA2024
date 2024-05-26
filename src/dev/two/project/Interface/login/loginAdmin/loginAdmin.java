package dev.two.project.Interface.login.loginAdmin;

import dev.two.project.Interface.login.loginPatient.clinicPanelPatient;
import dev.two.project.Interface.login.loginPatient.loginPatientForm;

import javax.swing.*;
import java.awt.*;

public class loginAdmin extends JPanel {
    public clinicPanelAdmin clinicLogo;
    public loginAdminForm adminForm;

    public loginAdmin() {
        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        initComponents();
    }
    public void initComponents() {
        adminForm = new loginAdminForm();
        this.add(adminForm);
        clinicLogo = new clinicPanelAdmin();
        this.add(clinicLogo);
    }


}
