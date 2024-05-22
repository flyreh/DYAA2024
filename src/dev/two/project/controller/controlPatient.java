package dev.two.project.controller;

import components.JPanelRound;
import dev.two.project.Interface.MainWindow;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import dev.two.project.controller.gestor.*;
import dev.two.project.model.Patient;

import javax.crypto.CipherInputStream;

public class controlPatient {

    public MainWindow mainWindow;

    public controlPatient(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        initComponents();
    }
    public void initComponents(){
        MouseAdapter pacienteregistro = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                if (source == mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.jprLogin) {
                    if (!ValidateRegisterData()) {
                        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setForeground(new Color(255, 0, 0));
                        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setText("Registro Incorrecto");
                    }else{
                        try {
                            AddPatientTree(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfFirstName.getText(),
                            mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfSecondName.getText(),
                            mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfLastName.getText(),
                            String.valueOf(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.pfContrasenia.getPassword()),
                            Integer.parseInt(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfEdad.getText()),
                            Objects.requireNonNull(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfGenero.getSelectedItem()).toString(),
                            Objects.requireNonNull(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfEstadoCivil.getSelectedItem()).toString(),
                            mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfTelefono.getText(),
                            mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfCorreo.getText());
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        };
        MouseAdapter initSessionPatient = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                if (source == mainWindow.mainPanel.mainLogin.loginPatient.loginForm.jprLogin) {
                    if(!ValidateLoginData()){

                    }else{

                    }

                }
            }
        };
        ListenerInitSessionPatient(initSessionPatient);
        ListenerRegistroPaciente(pacienteregistro);
    }
    public void ListenerInitSessionPatient(MouseAdapter evt){
        mainWindow.mainPanel.mainLogin.loginPatient.loginForm.jprLogin.addMouseListener(evt);
    }
   public void ListenerRegistroPaciente(MouseAdapter evt){
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.jprLogin.addMouseListener(evt);
    }
    public boolean ValidateLoginData(){
        return false;
    }

    public boolean ValidateRegisterData(){
        if(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfFirstName.getText().isEmpty() ||
                mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfFirstName.getText().equals("Primer Nombre")){
            return false;
        }
        if(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfLastName.getText().isEmpty() ||
                mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfLastName.getText().equals("Apellido")){
            return false;
        }
        if(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfSecondName.getText().isEmpty() ||
                mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfSecondName.getText().equals("Segundo Nombre")){
            return false;
        }
        if((String.valueOf(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.pfContrasenia.getPassword()).isEmpty()||
                String.valueOf(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.pfContrasenia.getPassword()).equals("********"))){
            return false;
        }
        return true;
    }
    public boolean verifyAuth(String primerNombre, String SecondName, String password){
        return !gestorPatient.SearchPatientFile(primerNombre, password);
    }
    public void AddPatientTree(String primerNombre, String segundoNombre
            ,String apellido, String password,int edad
            , String genero, String estadoCivil, String telefono, String correo) throws Exception {
        if(!verifyAuth(primerNombre, segundoNombre, password)){
            mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setForeground(new Color(255, 0, 0));
            mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setText("Paciente existente con el mismo nombre y contraseña");
        }else{
            Patient newpatient = new Patient(primerNombre, segundoNombre, apellido, password, edad, genero, estadoCivil, telefono, correo);
            gestorPatient.WritePatientFile(newpatient);
            gestorPatient.AddPatientTree(newpatient);
            mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setForeground(new Color(3, 253, 53));
            mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setText("Paciente registrado");
            clearRegisterForm();
        }
    }
    public void InitSessionPatient(String primerNombre, String segundoNombre, String password){
        if(verifyAuth(primerNombre, segundoNombre, password)){
            mainWindow.mainPanel.mainLogin.loginPatient.loginForm.lbErrorLogin.setForeground(new Color(255, 0, 0));
            mainWindow.mainPanel.mainLogin.loginPatient.loginForm.lbErrorLogin.setText("Usuario no encontrado");
        }else{
            mainWindow.mainPanel.mainLogin.loginPatient.loginForm.lbErrorLogin.setForeground(new Color(3, 253, 53));
            mainWindow.mainPanel.mainLogin.loginPatient.loginForm.lbErrorLogin.setText("Usuario encontrado");
        }
    }
    public void clearRegisterForm() {
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfFirstName.setText("");
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfSecondName.setText("");
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfLastName.setText("");
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.pfContrasenia.setText("");
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfEdad.setText("");
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfGenero.setSelectedIndex(0);
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfEstadoCivil.setSelectedIndex(0);
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfTelefono.setText("");
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfCorreo.setText("");
    }

    }