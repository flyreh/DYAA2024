package dev.two.project.Interface.Main.MainInterface;

import dev.two.project.Interface.Register.RegisterPatient.RegisterPanelPatient;
import dev.two.project.Interface.login.loginDoctor.loginDoctor;
import dev.two.project.Interface.login.loginPatient.loginPatient;

import javax.swing.*;
import java.awt.*;

public class mainLogin extends JPanel {
    public loginPatient loginPatient;
    public loginDoctor loginDoctor;

    public mainLogin(){
        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        initComponents();
    }

    public void initComponents(){

        loginPatient = new loginPatient();
        this.add(loginPatient);
        loginPatient.setVisible(false);

        loginDoctor = new loginDoctor();
        this.add(loginDoctor);
        loginDoctor.setVisible(false);



    }
}
