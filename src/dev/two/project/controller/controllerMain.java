package dev.two.project.controller;

import components.JPanelRound;
import dev.two.project.Interface.MainWindow;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controllerMain {

    public MainWindow mainWindow;

    public controllerMain(MainWindow mainWindow){
        this.mainWindow = mainWindow;

        initComponents();
    }

    public void initComponents(){
        MouseAdapter mouseAdapterMain = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                source.setBackground(new Color(61, 61, 61));
                if(source == mainWindow.mainPanel.mainPanelOptions.IniciarPacientes){
                    mainWindow.mainPanel.mainPanelOptions.information.setText("El usuario tiene una cuenta en el sistema");
                }
                if(source == mainWindow.mainPanel.mainPanelOptions.IniciarDoctores){
                    mainWindow.mainPanel.mainPanelOptions.information.setText("El usuario es doctor y tiene una cuenta en el sistema");
                }
                if(source == mainWindow.mainPanel.mainPanelOptions.RegistrarPaciente){
                    mainWindow.mainPanel.mainPanelOptions.information.setText("El usuario es nuevo y quiere crear una cuenta en el sistema");
                }
                if(source == mainWindow.mainPanel.mainPanelOptions.RegistrarDoctor){
                    mainWindow.mainPanel.mainPanelOptions.information.setText("El administrador ingresa un nuevo doctor en el sistema");
                }
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                source.setBackground(new Color(0, 0, 0));
                mainWindow.mainPanel.mainPanelOptions.information.setText("");
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                if (source == mainWindow.mainPanel.mainPanelOptions.IniciarPacientes) {
                    mainWindow.mainPanel.mainPanelOptions.setVisible(false);
                    mainWindow.mainPanel.mainPanelLogo.setVisible(false);
                    mainWindow.mainPanel.mainLogin.setVisible(true);
                    mainWindow.mainPanel.mainLogin.loginPatient.setVisible(true);
                    mainWindow.headerpanel.lbStatus.setText(">>> Iniciar Sesión - Pacientes");
                } else if (source == mainWindow.mainPanel.mainPanelOptions.IniciarDoctores) {
                    mainWindow.mainPanel.mainPanelOptions.setVisible(false);
                    mainWindow.mainPanel.mainPanelLogo.setVisible(false);
                    mainWindow.mainPanel.mainLogin.setVisible(true);
                    mainWindow.mainPanel.mainLogin.loginDoctor.setVisible(true);
                    mainWindow.headerpanel.lbStatus.setText(">>> Iniciar Sesión - Doctores");
                } else if (source == mainWindow.mainPanel.mainPanelOptions.RegistrarPaciente) {
                    mainWindow.mainPanel.mainPanelOptions.setVisible(false);
                    mainWindow.mainPanel.mainPanelLogo.setVisible(false);
                    mainWindow.mainPanel.mainRegister.setVisible(true);
                    mainWindow.mainPanel.mainRegister.registerPanelPatient.setVisible(true);
                    mainWindow.headerpanel.lbStatus.setText(">>> Registrar Paciente Nuevo");

                } else if (source == mainWindow.mainPanel.mainPanelOptions.RegistrarDoctor) {

                }
            }
        };
        MouseAdapter mouseAdapterLoginPatient = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                source.setBackground(new Color(61, 61, 61));
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                source.setBackground(new Color(0, 0, 0));
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                if (source == mainWindow.mainPanel.mainLogin.loginPatient.clinicLogo.regresar) {
                    mainWindow.mainPanel.mainLogin.setVisible(false);
                   mainWindow.mainPanel.mainLogin.loginPatient.setVisible(false);
                   mainWindow.mainPanel.mainPanelLogo.setVisible(true);
                     mainWindow.mainPanel.mainPanelOptions.setVisible(true);
                     mainWindow.headerpanel.lbStatus.setText(">> Main Menu");
                } else if (source == mainWindow.mainPanel.mainLogin.loginPatient.loginForm.jprLogin) {
                    System.out.println("ingresar paciente presionado");
                }
            }
        };
        MouseAdapter mouseAdapterLoginDoctor = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                source.setBackground(new Color(61, 61, 61));
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                source.setBackground(new Color(0, 0, 0));
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                if (source == mainWindow.mainPanel.mainLogin.loginDoctor.clinicPanelDoctor.regresar) {
                    mainWindow.mainPanel.mainLogin.setVisible(false);
                    mainWindow.mainPanel.mainLogin.loginDoctor.setVisible(false);
                    mainWindow.mainPanel.mainPanelLogo.setVisible(true);
                    mainWindow.mainPanel.mainPanelOptions.setVisible(true);
                    mainWindow.headerpanel.lbStatus.setText(">> Main Menu");
                } else if (source == mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.jprLogin) {
                    System.out.println("ingresar doctor presionado");
                }
            }
        };
        MouseAdapter mouseAdapterRegisterPatient  = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                source.setBackground(new Color(61, 61, 61));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                source.setBackground(new Color(0, 0, 0));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                if (source == mainWindow.mainPanel.mainRegister.registerPanelPatient.registerLogoClinic.regresar) {
                    mainWindow.mainPanel.mainRegister.setVisible(false);
                    mainWindow.mainPanel.mainRegister.registerPanelPatient.setVisible(false);
                    mainWindow.mainPanel.mainPanelLogo.setVisible(true);
                    mainWindow.mainPanel.mainPanelOptions.setVisible(true);
                    mainWindow.headerpanel.lbStatus.setText(">> Main Menu");
                }
            }
        };
        ListenerRegisterPatient(mouseAdapterRegisterPatient);
        ListenerMainPanelOptions(mouseAdapterMain);
        ListenerLoginPatient(mouseAdapterLoginPatient);
        ListenerLoginDoctor(mouseAdapterLoginDoctor);
    }
    public void ListenerRegisterPatient(MouseAdapter mouseAdapterRegisterPatient){
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerLogoClinic.regresar.addMouseListener(mouseAdapterRegisterPatient);
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.jprLogin.addMouseListener(mouseAdapterRegisterPatient);
    }
    public void ListenerMainPanelOptions(MouseAdapter mouseAdapterMain){
        mainWindow.mainPanel.mainPanelOptions.IniciarPacientes.addMouseListener(mouseAdapterMain);
        mainWindow.mainPanel.mainPanelOptions.IniciarDoctores.addMouseListener(mouseAdapterMain);
        mainWindow.mainPanel.mainPanelOptions.RegistrarPaciente.addMouseListener(mouseAdapterMain);
        mainWindow.mainPanel.mainPanelOptions.RegistrarDoctor.addMouseListener(mouseAdapterMain);
    }
    public void ListenerLoginPatient(MouseAdapter mouseAdapterLoginPatient){
        mainWindow.mainPanel.mainLogin.loginPatient.clinicLogo.regresar.addMouseListener(mouseAdapterLoginPatient);
        mainWindow.mainPanel.mainLogin.loginPatient.loginForm.jprLogin.addMouseListener(mouseAdapterLoginPatient);
    }
    public void ListenerLoginDoctor(MouseAdapter mouseAdapterLoginDoctor){
        mainWindow.mainPanel.mainLogin.loginDoctor.clinicPanelDoctor.regresar.addMouseListener(mouseAdapterLoginDoctor);
        mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.jprLogin.addMouseListener(mouseAdapterLoginDoctor);
    }



}
