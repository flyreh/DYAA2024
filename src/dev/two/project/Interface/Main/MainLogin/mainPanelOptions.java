package dev.two.project.Interface.Main.MainLogin;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;

public class mainPanelOptions extends JPanelRound {


    public JPanelRound IniciarPacientes;
    public JLabel iniciarPacientes;

    public JPanelRound IniciarDoctores;
    public JLabel iniciarDoctores;

    public JPanelRound RegistrarPaciente;
    public JLabel registrarPaciente;

    public JPanelRound RegistrarDoctor;
    public JLabel registrarDoctor;

    public mainPanelOptions() {
        this.setLayout(null);
        this.setBounds(600, 0, 600, 800);
        this.setRoundTopRight(50);
        this.setRoundBottomRight(50);
        this.setBackground(new Color(88, 89, 96));
        initComponents();
    }
    public void initComponents(){
        IniciarPacientes = new JPanelRound();
        IniciarPacientes.setBounds(50, 150, 230, 180);
        IniciarPacientes.setBackground(new Color(0, 0, 0));
        IniciarPacientes.setRoundBottomLeft(50);
        IniciarPacientes.setRoundBottomRight(50);
        IniciarPacientes.setRoundTopLeft(50);
        IniciarPacientes.setRoundTopRight(50);
        this.add(IniciarPacientes);

        IniciarDoctores = new JPanelRound();
        IniciarDoctores.setBounds(320, 150, 230, 180);
        IniciarDoctores.setBackground(new Color(0, 0, 0));
        IniciarDoctores.setRoundBottomLeft(50);
        IniciarDoctores.setRoundBottomRight(50);
        IniciarDoctores.setRoundTopLeft(50);
        IniciarDoctores.setRoundTopRight(50);
        this.add(IniciarDoctores);

        RegistrarDoctor = new JPanelRound();
        RegistrarDoctor.setBounds(50, 400, 230, 180);
        RegistrarDoctor.setBackground(new Color(0, 0, 0));
        RegistrarDoctor.setRoundBottomLeft(50);
        RegistrarDoctor.setRoundBottomRight(50);
        RegistrarDoctor.setRoundTopLeft(50);
        RegistrarDoctor.setRoundTopRight(50);
        this.add(RegistrarDoctor);

        RegistrarPaciente = new JPanelRound();
        RegistrarPaciente.setBounds(320, 400, 230, 180);
        RegistrarPaciente.setBackground(new Color(0, 0, 0));
        RegistrarPaciente.setRoundBottomLeft(50);
        RegistrarPaciente.setRoundBottomRight(50);
        RegistrarPaciente.setRoundTopLeft(50);
        RegistrarPaciente.setRoundTopRight(50);
        this.add(RegistrarPaciente);

    }
}
