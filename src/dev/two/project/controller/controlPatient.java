package dev.two.project.controller;

import components.JPanelRound;
import dev.two.project.Interface.MainWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
                        AddPatientTree();
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
    public void AddPatientTree(){
        System.out.println("Agregando paciente");

    }
}
