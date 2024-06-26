package dev.two.project.Interface.Main.MainInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import dev.two.project.Interface.Main.MainDoctor.MainDoctor;
import dev.two.project.Interface.Main.MainPatient.MainPatient;
import dev.two.project.Interface.Register.RegisterPatient.RegisterLogoClinic;
import dev.two.project.Interface.Register.RegisterPatient.RegisterPanelPatient;
import dev.two.project.Interface.login.loginPatient.*;
import dev.two.project.Interface.login.loginDoctor.*;


public class mainPanel extends JPanel{

    public mainPanelLogo mainPanelLogo;
    public mainPanelOptions mainPanelOptions;
    public mainLogin mainLogin;
    public MainPatient mainPatient;
    public MainDoctor mainDoctor;

    public mainRegister mainRegister;

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

        mainLogin = new mainLogin();
        this.add(mainLogin);
        mainLogin.setVisible(false);

        mainRegister = new mainRegister();
        this.add(mainRegister);
        mainRegister.setVisible(false);

        mainPatient = new MainPatient(){
            private Image backgroundImage;
            {
                try {
                    backgroundImage = ImageIO.read(new File("src\\dev\\two\\project\\resources\\media\\img\\fondoClinica.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 30, this.getWidth(), 740, this);
            }
        };
        this.add(mainPatient);
        mainPatient.setVisible(false);


        mainDoctor = new MainDoctor(){
            private Image backgroundImage;
            {
                try {
                    backgroundImage = ImageIO.read(new File("src/dev/two/project/resources/media/img/directorio-de-doctores.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 30, this.getWidth(), 740, this);
            }

        };
        this.add(mainDoctor);
        mainDoctor.setVisible(false);
    }
}
