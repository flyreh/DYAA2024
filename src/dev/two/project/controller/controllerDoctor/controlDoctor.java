package dev.two.project.controller.controllerDoctor;

import components.JPanelRound;
import dev.two.project.Interface.MainWindow;
import dev.two.project.controller.gestor.*;
import dev.two.project.model.Doctor;
import dev.two.project.model.MedicalAreas.Dermatology;
import dev.two.project.model.MedicalAreas.Oftalmologia;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class controlDoctor {
    public MainWindow mainWindow;

    public controlDoctor(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        initComponents();
    }

    public void initComponents() {

        MouseAdapter DoctorRegistro = new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                if (source == mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.jprLogin) {
                    if (!ValidateRegisterData()) {
                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setForeground(new Color(255, 0, 0));
                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setText("Registro Incorrecto");
                    } else {
                        try {
                            if (Objects.equals(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.getSelectedArea(), "Dermatology")) {
                                AddPatientTreeDerma(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfFirstName.getText(),
                                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfSecondName.getText(),
                                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfLastName.getText(),
                                        String.valueOf(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.pfContrasenia.getPassword()),
                                        Integer.parseInt(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfEdad.getText()),
                                        Objects.requireNonNull(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfGenero.getSelectedItem()).toString(),
                                        Objects.requireNonNull(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfEstadoCivil.getSelectedItem()).toString(),
                                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfTelefono.getText(),
                                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfCorreo.getText());

                            } else if (Objects.equals(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.getSelectedArea(), "Ofthalmology")) {
                                AddPatientTreeOftal(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfFirstName.getText(),
                                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfSecondName.getText(),
                                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfLastName.getText(),
                                        String.valueOf(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.pfContrasenia.getPassword()),
                                        Integer.parseInt(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfEdad.getText()),
                                        Objects.requireNonNull(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfGenero.getSelectedItem()).toString(),
                                        Objects.requireNonNull(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfEstadoCivil.getSelectedItem()).toString(),
                                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfTelefono.getText(),
                                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfCorreo.getText());


                            } else if (Objects.equals(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorPanelOptions.getSelectedArea(), "Traumatology")) {
                                AddPatientTreeTrauma(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfFirstName.getText(),
                                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfSecondName.getText(),
                                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfLastName.getText(),
                                        String.valueOf(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.pfContrasenia.getPassword()),
                                        Integer.parseInt(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfEdad.getText()),
                                        Objects.requireNonNull(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfGenero.getSelectedItem()).toString(),
                                        Objects.requireNonNull(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfEstadoCivil.getSelectedItem()).toString(),
                                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfTelefono.getText(),
                                        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfCorreo.getText());

                            }

                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        };
        MouseAdapter initSessionDoctor = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                if (source == mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.jprLogin) {
                    System.out.println("login doctor presionado");
                    if (!ValidateLoginData()) {
                        mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.lbErrorLogin.setForeground(new Color(255, 0, 0));
                        mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.lbErrorLogin.setText("Datos incorrectos");
                    } else {
                        InitSessionDoctor(mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.tfUsuario.getText(),
                                String.valueOf(mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.pfContrasenia.getPassword()));

                    }

                }
            }
        };
        ListenerInitSessionDoctor(initSessionDoctor);
        ListenerRegisterDoctor(DoctorRegistro);

    }

    public void ListenerInitSessionDoctor(MouseAdapter listener) {
        mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.jprLogin.addMouseListener(listener);
    }
    public void ListenerRegisterDoctor(MouseAdapter listener) {
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.jprLogin.addMouseListener(listener);
    }

    public void InitSessionDoctor(String primerNombre, String password) {
        String specialty = verifyAuthDoctors(primerNombre, password);
        if (specialty == null) {
            mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.lbErrorLogin.setForeground(new Color(255, 0, 0));
            mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.lbErrorLogin.setText("Usuario no encontrado");
        } else {
            Doctor doctor = null;
            int id = 0;
            switch (specialty) {
                case "Dermatology":
                    id = gestorDerma.returnIdDoctorDerma(primerNombre, password);
                    doctor = gestorDerma.searchDoctorDermaTree(id);
                    break;
                case "Ofthalmology":
                    id = gestorOfta.returnIdDoctorOfta(primerNombre, password);
                    doctor = gestorOfta.searchDoctorOftaTree(id);
                    break;
                case "Traumatology":
                    id = gestorTrauma.returnIdDoctorTrauma(primerNombre, password);
                    doctor = gestorTrauma.searchDoctorTraumaTree(id);
                    break;
            }
            if (doctor != null) {
                gestorDoctor.setSesion(doctor);
                mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.lbErrorLogin.setForeground(new Color(3, 253, 53));
                mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.lbErrorLogin.setText(gestorDoctor.getSesion().getFirstname());
                completeDoctorInfo();
            }
        }
    }

    public void completeDoctorInfo(){


    }
    public String verifyAuthDoctors(String primerNombre, String password) {
        if (gestorDerma.SearchDoctorDermaFile(primerNombre, password)) {
            return "Dermatology";
        } else if (gestorOfta.SearchDoctorOftaFile(primerNombre, password)) {
            return "Ofthalmology";
        } else if (gestorTrauma.SearchDoctorTraumaFile(primerNombre, password)) {
            return "Traumatology";
        }
        return null;
    }

    public boolean ValidateLoginData() {
        if (mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.tfUsuario.getText().isEmpty() ||
                mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.tfUsuario.getText().equals("Usuario")) {
            return false;
        }
        if ((String.valueOf(mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.pfContrasenia.getPassword()).isEmpty() ||
                String.valueOf(mainWindow.mainPanel.mainLogin.loginDoctor.loginDoctorform.pfContrasenia.getPassword()).equals("********"))) {
            return false;
        }
        return true;
    }

    public void AddPatientTreeDerma(String primerNombre, String segundoNombre
            , String apellido, String password, int edad
            , String genero, String estadoCivil, String telefono, String correo) throws Exception {
        if (!verifyAuthDerma(primerNombre, password)) {
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setForeground(new Color(255, 0, 0));
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setText("Paciente existente con el mismo nombre y contraseña");
        } else {
            Doctor newdoctor = new Doctor(primerNombre, segundoNombre, apellido, password, edad, genero, estadoCivil, telefono, correo);
            newdoctor.setSpecialty(new Dermatology());
            gestorDerma.WriteDoctorDermaFile(newdoctor);
            gestorDerma.AddDoctorDermaTree(newdoctor);
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setForeground(new Color(3, 253, 53));
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setText("Paciente registrado");
            clearRegisterForm();
        }
    }

    public void AddPatientTreeOftal(String primerNombre, String segundoNombre
            , String apellido, String password, int edad
            , String genero, String estadoCivil, String telefono, String correo) throws Exception {
        if (!verifyAuthOfta(primerNombre, password)) {
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setForeground(new Color(255, 0, 0));
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setText("Paciente existente con el mismo nombre y contraseña");
        } else {
            Doctor newdoctor = new Doctor(primerNombre, segundoNombre, apellido, password, edad, genero, estadoCivil, telefono, correo);
            newdoctor.setSpecialty(new Oftalmologia());
            gestorOfta.WriteDoctorOftaFile(newdoctor);
            gestorOfta.AddDoctorOftaTree(newdoctor);
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setForeground(new Color(3, 253, 53));
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setText("Paciente registrado");
            clearRegisterForm();
        }
    }

    public void AddPatientTreeTrauma(String primerNombre, String segundoNombre
            , String apellido, String password, int edad
            , String genero, String estadoCivil, String telefono, String correo) throws Exception {
        if (!verifyAuthTrauma(primerNombre, password)) {
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setForeground(new Color(255, 0, 0));
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setText("Paciente existente con el mismo nombre y contraseña");
        } else {
            Doctor newdoctor = new Doctor(primerNombre, segundoNombre, apellido, password, edad, genero, estadoCivil, telefono, correo);
            newdoctor.setSpecialty(new Dermatology());
            gestorTrauma.WriteDoctorTraumaFile(newdoctor);
            gestorTrauma.AddDoctorOftaTree(newdoctor);
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setForeground(new Color(3, 253, 53));
            mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.lbErrorLogin.setText("Paciente registrado");
            clearRegisterForm();
        }
    }

    public boolean verifyAuthDerma(String primerNombre, String password) {
        return !gestorDerma.SearchDoctorDermaFile(primerNombre, password);
    }

    public boolean verifyAuthOfta(String primerNombre, String password) {
        return !gestorOfta.SearchDoctorOftaFile(primerNombre, password);
    }

    public boolean verifyAuthTrauma(String primerNombre, String password) {
        return !gestorTrauma.SearchDoctorTraumaFile(primerNombre, password);
    }


    public Boolean ValidateRegisterData() {
        if (mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfFirstName.getText().isEmpty() ||
                mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfFirstName.getText().equals("Primer Nombre")) {
            return false;
        }
        if (mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfLastName.getText().isEmpty() ||
                mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfLastName.getText().equals("Apellido")) {
            return false;
        }
        if (mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfSecondName.getText().isEmpty() ||
                mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfSecondName.getText().equals("Segundo Nombre")) {
            return false;
        }
        if ((String.valueOf(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.pfContrasenia.getPassword()).isEmpty() ||
                String.valueOf(mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.pfContrasenia.getPassword()).equals("********"))) {
            return false;
        }
        return true;
    }
    public void clearRegisterForm() {
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfFirstName.setText("Primer Nombre");
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfSecondName.setText("Segundo Nombre");
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfLastName.setText("Apellido");
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.pfContrasenia.setText("********");
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfEdad.setText("Edad");
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfGenero.setSelectedIndex(0);
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfEstadoCivil.setSelectedIndex(0);
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfTelefono.setText("Telefono");
        mainWindow.mainPanel.mainRegister.registerPanelDoctor.doctorRegisterForm.tfCorreo.setText("Correo");
    }
}
