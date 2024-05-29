package dev.two.project.Interface.Main.MainInterface;

import dev.two.project.Interface.Register.RegisterDoctor.RegisterPanelDoctor;
import dev.two.project.Interface.Register.RegisterPatient.RegisterPanelPatient;
import dev.two.project.Interface.login.loginDoctor.loginDoctor;
import dev.two.project.Interface.login.loginPatient.loginPatient;

import javax.swing.*;
import java.awt.*;

public class mainRegister extends JPanel {
    public RegisterPanelPatient registerPanelPatient;
    public RegisterPanelDoctor registerPanelDoctor;


    public mainRegister(){
        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        initComponents();
    }

    public void initComponents(){
        registerPanelPatient = new RegisterPanelPatient();
        this.add(registerPanelPatient);
        registerPanelPatient.setVisible(false);

        registerPanelDoctor = new RegisterPanelDoctor();
        this.add(registerPanelDoctor);
        registerPanelDoctor.setVisible(false);
    
    }
}
