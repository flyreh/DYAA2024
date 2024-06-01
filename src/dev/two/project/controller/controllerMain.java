package dev.two.project.controller;

import components.JPanelRound;
import dev.two.project.Interface.FrameDark.FrameDark;
import dev.two.project.Interface.MainWindow;
import dev.two.project.Interface.login.confirmationLogin.confirmation;
import dev.two.project.controller.gestor.gestorPatient;
import dev.two.project.controller.gestor.gestorAdmin;

import javax.swing.*;
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
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.setVisible(false);
                    mainWindow.mainPanel.mainRegister.registerPanelPatient.setVisible(true);
                    mainWindow.headerpanel.lbStatus.setText(">>> Registrar Paciente Nuevo");

                } else if (source == mainWindow.mainPanel.mainPanelOptions.RegistrarDoctor) {
                    mainWindow.mainPanel.mainPanelOptions.setVisible(false);
                    mainWindow.mainPanel.mainPanelLogo.setVisible(false);
                    mainWindow.mainPanel.mainLogin.setVisible(true);
                    mainWindow.mainPanel.mainLogin.loginAdmin.setVisible(true);
                    mainWindow.headerpanel.lbStatus.setText(">>> Registrar Doctor Nuevo");
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
        MouseAdapter mouseAdapterLoginAdmin = new MouseAdapter() {
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
                if (source == mainWindow.mainPanel.mainLogin.loginAdmin.clinicLogo.regresar) {
                    mainWindow.mainPanel.mainLogin.setVisible(false);
                    mainWindow.mainPanel.mainLogin.loginAdmin.setVisible(false);
                    mainWindow.mainPanel.mainPanelLogo.setVisible(true);
                    mainWindow.mainPanel.mainPanelOptions.setVisible(true);
                    mainWindow.headerpanel.lbStatus.setText(">> Main Menu");
                } else if (source == mainWindow.mainPanel.mainLogin.loginAdmin.adminForm.jprLogin) {
                    if (!ValidateLoginDataAdmin()) {
                        mainWindow.mainPanel.mainLogin.loginAdmin.adminForm.lbErrorLogin.setForeground(new Color(255, 0, 0));
                        mainWindow.mainPanel.mainLogin.loginAdmin.adminForm.lbErrorLogin.setText("Datos incorrectos");
                    } else {
                        InitSessionAdmin(mainWindow.mainPanel.mainLogin.loginAdmin.adminForm.tfUsuario.getText(),
                                String.valueOf(mainWindow.mainPanel.mainLogin.loginAdmin.adminForm.pfContrasenia.getPassword()));

                    }
                }
            }
        };
        MouseAdapter mouseAdapterOptionsAdmin = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                if (source == mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Dermatology) {
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Dermatology.setBackground(new Color(61, 61, 61));
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Ofthalmology.setBackground(new Color(0, 0, 0));
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Traumatology.setBackground(new Color(0, 0, 0));
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.setSelectArea("Dermatology");
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.information.setText("Registrar un Doctor en el área de Dermatología");
                    System.out.println(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.getSelectedArea());
                }
                if (source == mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Ofthalmology) {
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Dermatology.setBackground(new Color(0, 0, 0));
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Ofthalmology.setBackground(new Color(61, 61, 61));
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Traumatology.setBackground(new Color(0, 0, 0));
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.setSelectArea("Ofthalmology");
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.information.setText("Registrar un Doctor en el área de Ofthalmología");
                    System.out.println(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.getSelectedArea());
                }
                if (source == mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Traumatology) {
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Dermatology.setBackground(new Color(0, 0, 0));
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Ofthalmology.setBackground(new Color(0, 0, 0));
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Traumatology.setBackground(new Color(61, 61, 61));
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.setSelectArea("Traumatology");
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.information.setText("Registrar un Doctor en el área de Traumatología");
                    System.out.println(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.getSelectedArea());
                }
                if (source == mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.singOffAdmin) {
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.setSelectArea("");
                    mainWindow.mainPanel.mainRegister.setVisible(false);
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.setVisible(false);
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.setVisible(false);
                    mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.setVisible(false);
                    mainWindow.mainPanel.mainLogin.loginAdmin.setVisible(false);
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
        ListenerLoginAdmin(mouseAdapterLoginAdmin);
        ListenerOptionsAdmin(mouseAdapterOptionsAdmin);
    }
    public boolean ValidateLoginDataAdmin() {
        if (mainWindow.mainPanel.mainLogin.loginAdmin.adminForm.tfUsuario.getText().isEmpty() ||
                mainWindow.mainPanel.mainLogin.loginAdmin.adminForm.tfUsuario.getText().equals("Usuario")) {
            return false;
        }
        if ((String.valueOf(mainWindow.mainPanel.mainLogin.loginAdmin.adminForm.pfContrasenia.getPassword()).isEmpty() ||
                String.valueOf(mainWindow.mainPanel.mainLogin.loginAdmin.adminForm.pfContrasenia.getPassword()).equals("********"))) {
            return false;
        }
        return true;
    }
    public boolean verifyAuth(String primerNombre, String password) {
        return !gestorAdmin.SearchAdminFile(primerNombre, password);
    }

    public void InitSessionAdmin(String user, String password) {
        if (verifyAuth(user, password)) {
            mainWindow.mainPanel.mainLogin.loginPatient.loginForm.lbErrorLogin.setForeground(new Color(255, 0, 0));
            mainWindow.mainPanel.mainLogin.loginPatient.loginForm.lbErrorLogin.setText("Usuario no encontrado");
        } else {
                completeAdminPanel();
        }
    }
    public void completeAdminPanel() {
        FrameDark fo = new FrameDark();
        confirmation confirmation = new confirmation();
        fo.setLocationRelativeTo(mainWindow);
        fo.setVisible(true);
        fo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                confirmation.requestFocus();
            }
        });
        confirmation.setLocationRelativeTo(fo);
        confirmation.setVisible(true);
        Timer timer = new Timer(2500, actionEvent -> {
            fo.dispose();
            confirmation.dispose();
            mainWindow.mainPanel.mainLogin.loginAdmin.setVisible(false);
            mainWindow.mainPanel.mainLogin.setVisible(false);
            mainWindow.mainPanel.mainRegister.setVisible(true);
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.setVisible(true);
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.setVisible(true);
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.setVisible(true);
            mainWindow.headerpanel.lbStatus.setText(">> Registro de Doctor");
        });
        timer.setRepeats(false);
        timer.start();
    }
    public void ListenerOptionsAdmin(MouseAdapter mouseAdapterOptionsAdmin){
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Dermatology.addMouseListener(mouseAdapterOptionsAdmin);
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Ofthalmology.addMouseListener(mouseAdapterOptionsAdmin);
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.Traumatology.addMouseListener(mouseAdapterOptionsAdmin);
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.singOffAdmin.addMouseListener(mouseAdapterOptionsAdmin);
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
    public void ListenerLoginAdmin(MouseAdapter mouseAdapterLoginAdmin){
        mainWindow.mainPanel.mainLogin.loginAdmin.clinicLogo.regresar.addMouseListener(mouseAdapterLoginAdmin);
        mainWindow.mainPanel.mainLogin.loginAdmin.adminForm.jprLogin.addMouseListener(mouseAdapterLoginAdmin);

    }

}
