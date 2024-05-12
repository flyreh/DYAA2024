package dev.two.project.controller;

import components.JPanelRound;
import dev.two.project.Interface.MainWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import dev.two.project.controller.gestor.*;
import dev.two.project.model.Patient;

public class controlPatient {

    public MainWindow mainWindow;

    public controlPatient(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        initComponents();
    }
    public void initComponents(){
        MouseAdapter paciente = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                if (source == mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.jprLogin) {
                    if (!ValidateRegisterData()) {
                        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setText("Registro Incorrecto");
                    }else{
                                AddPatientTree(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfFirstName.getText(),
                                mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfSecondName.getText(),
                                mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfLastName.getText(),
                                String.valueOf(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.pfContrasenia.getPassword()),
                                Integer.parseInt(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfEdad.getText()),
                                Objects.requireNonNull(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfGenero.getSelectedItem()).toString(),
                                Objects.requireNonNull(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfEstadoCivil.getSelectedItem()).toString(),
                                mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfTelefono.getText(),
                                mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfCorreo.getText());
                        mainWindow.mainPanel.mainRegister.setVisible(false);
                        mainWindow.mainPanel.mainLogin.setVisible(true);
                    }
                }
            }
        };
        ListenerPaciente(paciente);

    }
   public void ListenerPaciente(MouseAdapter evt){
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerLogoClinic.regresar.addMouseListener(evt);
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.jprLogin.addMouseListener(evt);
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
        return !gestorPatient.SearchPatientFile(primerNombre, SecondName, password);
    }
    public void AddPatientTree(String primerNombre, String segundoNombre
            ,String apellido, String password,int edad
            , String genero, String estadoCivil, String telefono, String correo){
        if(!verifyAuth(primerNombre, segundoNombre, password)){
            mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setText("Paciente existente");
        }else{
            Patient newpatient = new Patient(primerNombre, segundoNombre, apellido, password, edad, genero, estadoCivil, telefono, correo);
            gestorPatient.WritePatientFile(newpatient);
            gestorPatient.AddPatientTree(newpatient);
        }

        }

    }