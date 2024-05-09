package dev.two.project.Interface.Main.MainInterface;

import javax.swing.*;
import java.awt.*;

import dev.two.project.Interface.Register.RegisterPatient.RegisterLogoClinic;
import dev.two.project.Interface.Register.RegisterPatient.RegisterPanelPatient;
import dev.two.project.Interface.login.loginPatient.*;
import dev.two.project.Interface.login.loginDoctor.*;


public class mainPanel extends JPanel{

    public mainPanelLogo mainPanelLogo;
    public mainPanelOptions mainPanelOptions;

    public loginPatient loginPatient;
    public loginDoctor loginDoctor;

    public RegisterPanelPatient registerPanelPatient;

    public mainPanel(){
        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        initComponents();
    }

    public void initComponents(){
        mainPanelLogo = new mainPanelLogo();
        this.add(mainPanelLogo);

        mainPanelOptions = new mainPanelOptions();
        this.add(mainPanelOptions);

        loginPatient = new loginPatient();
        this.add(loginPatient);
        loginPatient.setVisible(false);

        loginDoctor = new loginDoctor();
        this.add(loginDoctor);
        loginDoctor.setVisible(false);

        registerPanelPatient = new RegisterPanelPatient();
        this.add(registerPanelPatient);
        registerPanelPatient.setVisible(false);

    }
}
