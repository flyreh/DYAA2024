package dev.two.project.controller.controllerPatient;

import components.JPanelRound;
import dev.two.project.Interface.FrameDark.FrameDark;
import dev.two.project.Interface.MainWindow;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import dev.two.project.Interface.Main.MainPatient.AppointmentForm.AppointmentForm;
import dev.two.project.Interface.Main.MainPatient.AppointmentForm.AppointmentForminputDesc;
import dev.two.project.Interface.login.confirmation.confirmation;
import dev.two.project.controller.gestor.*;
import dev.two.project.model.Appointment;
import dev.two.project.model.Doctor;
import dev.two.project.model.Patient;
import dev.two.project.model.medicalH;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class controlPatient {

    public MainWindow mainWindow;
    public FrameDark currentFrame;
    public AppointmentForm appForm = new AppointmentForm();

    public controlPatient(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        initComponents();
    }

    public void initComponents() {
        MouseAdapter pacienteregistro = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                if (source == mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.jprLogin) {
                    if (!ValidateRegisterData()) {
                        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setForeground(new Color(255, 0, 0));
                        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setText("Registro Incorrecto");
                    } else {
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
                    if (!ValidateLoginData()) {
                        mainWindow.mainPanel.mainLogin.loginPatient.loginForm.lbErrorLogin.setForeground(new Color(255, 0, 0));
                        mainWindow.mainPanel.mainLogin.loginPatient.loginForm.lbErrorLogin.setText("Datos incorrectos");
                    } else {
                        InitSessionPatient(mainWindow.mainPanel.mainLogin.loginPatient.loginForm.tfUsuario.getText(),
                                String.valueOf(mainWindow.mainPanel.mainLogin.loginPatient.loginForm.pfContrasenia.getPassword()));

                    }

                }
            }
        };
        MouseAdapter MainPatientOptions = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                if (source == mainWindow.mainPanel.mainPatient.patientOptions.showAppointments) {
                    mainWindow.mainPanel.mainPatient.patientOptions.showAppointments.setBackground(new Color(96, 96, 96));
                    mainWindow.mainPanel.mainPatient.patientOptions.newAppointment.setBackground(new Color(0, 0, 0));
                    mainWindow.mainPanel.mainPatient.patientOptions.showHistory.setBackground(new Color(0, 0, 0));
                    ActTableAppointments(gestorPatient.getSesion());
                    mainWindow.mainPanel.mainPatient.mainPatientCard.showAppointments.doctorsInfo.setText("");
                    mainWindow.mainPanel.mainPatient.mainPatientCard.cardLayout.show(mainWindow.mainPanel.mainPatient.mainPatientCard, "showAppointments");
                }
                if (source == mainWindow.mainPanel.mainPatient.patientOptions.newAppointment) {
                    mainWindow.mainPanel.mainPatient.patientOptions.showAppointments.setBackground(new Color(0, 0, 0));
                    mainWindow.mainPanel.mainPatient.patientOptions.newAppointment.setBackground(new Color(96, 96, 96));
                    mainWindow.mainPanel.mainPatient.patientOptions.showHistory.setBackground(new Color(0, 0, 0));
                    mainWindow.mainPanel.mainPatient.mainPatientCard.cardLayout.show(mainWindow.mainPanel.mainPatient.mainPatientCard, "newAppointment");
                    mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.cardLayout.show(mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment, "newAppointmentOptions");
                }
                if (source == mainWindow.mainPanel.mainPatient.patientOptions.showHistory) {
                    mainWindow.mainPanel.mainPatient.patientOptions.showAppointments.setBackground(new Color(0, 0, 0));
                    mainWindow.mainPanel.mainPatient.patientOptions.newAppointment.setBackground(new Color(0, 0, 0));
                    mainWindow.mainPanel.mainPatient.patientOptions.showHistory.setBackground(new Color(96, 96, 96));
                    ActTableHistorial(gestorPatient.getSesion());
                    mainWindow.mainPanel.mainPatient.mainPatientCard.cardLayout.show(mainWindow.mainPanel.mainPatient.mainPatientCard, "showHistory");
                }
                if (source == mainWindow.mainPanel.mainPatient.patientOptions.SingOff) {
                    SignOff();
                }
            }
        };
        MouseAdapter newAppointmentAreas = new MouseAdapter() {
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
                mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.viewCreateAppointment.doctorsInfo.setText("Seleccione una Fila");

                JPanelRound source = (JPanelRound) evt.getSource();
                if (source == mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.newAppointmentOptions.jprCreateDerma) {
                    FillTableDoctorsDerma();
                    mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.cardLayout.show(mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment, "viewCreateAppointment");
                } else if (source == mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.newAppointmentOptions.jprcreateOfta) {
                    FillTableDoctorsOfta();
                    mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.cardLayout.show(mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment, "viewCreateAppointment");

                } else if (source == mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.newAppointmentOptions.jprCreateTrauma) {
                    mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.cardLayout.show(mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment, "viewCreateAppointment");
                    FillTableDoctorsTrauma();
                }
            }
        };

        MouseAdapter showAppointmentForm = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                source.setBackground(new Color(105, 103, 103));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                source.setBackground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                if (source == mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.viewCreateAppointment.createAppointment) {
                    currentFrame = new FrameDark();
                    currentFrame.setSize(845, 615);
                    currentFrame.paneldark.setSize(845, 615);

                    currentFrame.setLocationRelativeTo(mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment);
                    currentFrame.setVisible(true);
                    currentFrame.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                           appForm.requestFocus();
                        }
                    });
                    appForm.setLocationRelativeTo(currentFrame);
                    appForm.setVisible(true);
                }
            }
        };
        MouseAdapter CreateAppointment = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == appForm.appointmentForminputDesc.Aceptar){
                    AceptarCita(AppointmentForminputDesc.campo_direccionObra.getText());
                    AppointmentForminputDesc.LimpiarDatos();
                    appForm.setVisible(false);
                    currentFrame.setVisible(false);
                }else if(e.getSource() == appForm.appointmentForminputDesc.Cancelar){
                    AppointmentForminputDesc.LimpiarDatos();
                    appForm.setVisible(false);
                    currentFrame.setVisible(false);
                }
            }
        };
        MouseAdapter tableAppointmentsListener =  new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable source = (JTable) e.getSource();
                if (source == mainWindow.mainPanel.mainPatient.mainPatientCard.showAppointments.AppointmentTable) {
                    int row = mainWindow.mainPanel.mainPatient.mainPatientCard.showAppointments.AppointmentTable.getSelectedRow();
                    if (row != -1) {
                        int id = (int) mainWindow.mainPanel.mainPatient.mainPatientCard.showAppointments.AppointmentTable.getValueAt(row, 2);
                        Doctor doctor;
                        if(gestorDerma.DoctorsDerma.searchDoctorDermaId(id) != null) {
                            doctor = gestorDerma.DoctorsDerma.searchDoctorDermaId(id);
                        } else if(gestorOfta.DoctorsOfta.searchDoctorOftaId(id) != null) {
                            doctor = gestorOfta.DoctorsOfta.searchDoctorOftaId(id);
                        } else {
                            doctor = gestorTrauma.DoctorsTrauma.searchDoctorTraumaId(id);
                        }
                        mainWindow.mainPanel.mainPatient.mainPatientCard.showAppointments.doctorsInfo.setText(doctor.toString());
                    }
                }
            }
        };
        MouseAdapter tableHistory = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable source = (JTable) e.getSource();
                if (source == mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.TableHistory) {
                    int row = mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.TableHistory.getSelectedRow();
                    if (row != -1) {
                        //id de la cita
                        int id = (int) mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.TableHistory.getValueAt(row, 0);
                        for( Appointment appointment = gestorPatient.getSesion().getMedicalHistory().getCabeza();
                             appointment != null;
                             appointment = (Appointment) appointment.next){
                            if(appointment.getId() == id){
                                mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.appointmentInfo.setText(appointment.toString2());
                            }
                        }

                    }
                }
            }
        };

        MouseAdapter SorterTableHistory = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                if (source == mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.SorterHistory) {
                    mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.SorterHistory.setBackground(new Color(105, 103, 103));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                if (source == mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.SorterHistory) {
                    mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.SorterHistory.setBackground(Color.WHITE);
                }
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                if (source == mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.SorterHistory) {
                    SorterHistory(gestorPatient.getSesion());
                }
            }
        };
        MouseAdapter BackOrderTable = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                if (source == mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.BackSorterTable) {
                    mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.BackSorterTable.setBackground(new Color(105, 103, 103));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                if (source == mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.BackSorterTable) {
                    mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.BackSorterTable.setBackground(Color.WHITE);
                }
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanelRound source = (JPanelRound) e.getSource();
                if (source == mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.BackSorterTable) {
                    ActTableHistorial(gestorPatient.getSesion());
                }
            }
        };

        MouseAdapter TableDoctorsListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.viewCreateAppointment.doctorsTable) {
                    int row = mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.viewCreateAppointment.doctorsTable.getSelectedRow();
                    if (row != -1) {
                        int id = (int) mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.viewCreateAppointment.doctorsTable.getValueAt(row, 0);
                        Doctor doctor;
                        if(gestorDerma.DoctorsDerma.searchDoctorDermaId(id) != null) {
                            doctor = gestorDerma.DoctorsDerma.searchDoctorDermaId(id);
                        } else if(gestorOfta.DoctorsOfta.searchDoctorOftaId(id) != null) {
                            doctor = gestorOfta.DoctorsOfta.searchDoctorOftaId(id);
                        } else {
                            doctor = gestorTrauma.DoctorsTrauma.searchDoctorTraumaId(id);
                        }
                        mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.viewCreateAppointment.doctorsInfo.setText(doctor.toString());
                    }
                }
            }
        };
        ListenerTableDoctors(TableDoctorsListener);
        ListenerBackOrderTable(BackOrderTable);
        ListenerSorterTableHistory(SorterTableHistory);
        ListenerTableHistory(tableHistory);
        ListenerTableAppointments(tableAppointmentsListener);
        ListenerAppointmentForm(CreateAppointment);
        ListenerCreateAppointment(showAppointmentForm);
        ListenerNewAppointmentAreas(newAppointmentAreas);
        ListenerMainPatientOptions(MainPatientOptions);
        ListenerInitSessionPatient(initSessionPatient);
        ListenerRegistroPaciente(pacienteregistro);
    }
    public void ListenerBackOrderTable(MouseAdapter evt){
        mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.BackSorterTable.addMouseListener(evt);
    }
    public void ListenerSorterTableHistory(MouseAdapter evt){
        mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.SorterHistory.addMouseListener(evt);
    }
    public void ListenerTableHistory(MouseAdapter evt){
        mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.TableHistory.addMouseListener(evt);
    }
    public void ListenerTableDoctors(MouseAdapter evt){
        mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.viewCreateAppointment.doctorsTable.addMouseListener(evt);
    }

    public void ListenerTableAppointments(MouseAdapter evt) {
        mainWindow.mainPanel.mainPatient.mainPatientCard.showAppointments.AppointmentTable.addMouseListener(evt);
    }

    public void ListenerAppointmentForm(MouseAdapter evt) {
        appForm.appointmentForminputDesc.Aceptar.addMouseListener(evt);
        appForm.appointmentForminputDesc.Cancelar.addMouseListener(evt);
    }

    public void ListenerCreateAppointment(MouseAdapter evt) {
        mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.viewCreateAppointment.createAppointment.addMouseListener(evt);
    }

    public void ListenerNewAppointmentAreas(MouseAdapter evt) {
        mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.newAppointmentOptions.jprCreateDerma.addMouseListener(evt);
        mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.newAppointmentOptions.jprcreateOfta.addMouseListener(evt);
        mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.newAppointmentOptions.jprCreateTrauma.addMouseListener(evt);
    }

    public void ListenerMainPatientOptions(MouseAdapter evt) {
        mainWindow.mainPanel.mainPatient.patientOptions.showAppointments.addMouseListener(evt);
        mainWindow.mainPanel.mainPatient.patientOptions.newAppointment.addMouseListener(evt);
        mainWindow.mainPanel.mainPatient.patientOptions.showHistory.addMouseListener(evt);
        mainWindow.mainPanel.mainPatient.patientOptions.SingOff.addMouseListener(evt);
    }

    public void ListenerInitSessionPatient(MouseAdapter evt) {
        mainWindow.mainPanel.mainLogin.loginPatient.loginForm.jprLogin.addMouseListener(evt);
    }

    public void ListenerRegistroPaciente(MouseAdapter evt) {
        mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.jprLogin.addMouseListener(evt);
    }

    public boolean ValidateLoginData() {
        if (mainWindow.mainPanel.mainLogin.loginPatient.loginForm.tfUsuario.getText().isEmpty() ||
                mainWindow.mainPanel.mainLogin.loginPatient.loginForm.tfUsuario.getText().equals("Usuario")) {
            return false;
        }
        if ((String.valueOf(mainWindow.mainPanel.mainLogin.loginPatient.loginForm.pfContrasenia.getPassword()).isEmpty() ||
                String.valueOf(mainWindow.mainPanel.mainLogin.loginPatient.loginForm.pfContrasenia.getPassword()).equals("********"))) {
            return false;
        }
        return true;
    }

    public boolean ValidateRegisterData() {
        if (mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfFirstName.getText().isEmpty() ||
                mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfFirstName.getText().equals("Primer Nombre")) {
            return false;
        }
        if (mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfLastName.getText().isEmpty() ||
                mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfLastName.getText().equals("Apellido")) {
            return false;
        }
        if (mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfSecondName.getText().isEmpty() ||
                mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.tfSecondName.getText().equals("Segundo Nombre")) {
            return false;
        }
        if ((String.valueOf(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.pfContrasenia.getPassword()).isEmpty() ||
                String.valueOf(mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.pfContrasenia.getPassword()).equals("********"))) {
            return false;
        }
        return true;
    }
    // Revisa en el archivo de doctores si el usuario existe o no para su autenticación

    public boolean verifyAuth(String primerNombre, String password) {
        return !gestorPatient.SearchPatientFile(primerNombre, password);
    }

    public void AddPatientTree(String primerNombre, String segundoNombre
            , String apellido, String password, int edad
            , String genero, String estadoCivil, String telefono, String correo) throws Exception {
        if (!verifyAuth(primerNombre, password)) {
            mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setForeground(new Color(255, 0, 0));
            mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setText("Paciente existente con el mismo nombre y contraseña");
        } else {
            Patient newpatient = new Patient(primerNombre, segundoNombre, apellido, password, edad, genero, estadoCivil, telefono, correo);
            gestorPatient.WritePatientFile(newpatient);
            gestorPatient.AddPatientTree(newpatient);
            mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setForeground(new Color(3, 253, 53));
            mainWindow.mainPanel.mainRegister.registerPanelPatient.registerPatientForm.lbErrorLogin.setText("Paciente registrado");
            clearRegisterForm();
        }
    }

    public void InitSessionPatient(String primerNombre, String password) {
        if (verifyAuth(primerNombre, password)) {
            mainWindow.mainPanel.mainLogin.loginPatient.loginForm.lbErrorLogin.setForeground(new Color(255, 0, 0));
            mainWindow.mainPanel.mainLogin.loginPatient.loginForm.lbErrorLogin.setText("Usuario no encontrado");
        } else {
            if (gestorPatient.searchPatientTree(gestorPatient.returnIdpatient(primerNombre, password)) != null) {
                gestorPatient.setSesion(gestorPatient.searchPatientTree(gestorPatient.returnIdpatient(primerNombre, password)));
                completePatientInfo();
            }
        }
    }

    public void completePatientInfo() {
        FrameDark fo = new FrameDark();
        fo.setSize(1200, 800);
        fo.paneldark.setSize(1200, 800);
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
            mainWindow.mainPanel.mainLogin.setVisible(false);
            mainWindow.mainPanel.mainLogin.loginPatient.setVisible(false);

            mainWindow.mainPanel.mainPatient.patientInfo.Name.setText(gestorPatient.getSesion().getFirstname());
            mainWindow.mainPanel.mainPatient.patientInfo.SecondName.setText(gestorPatient.getSesion().getSecondName());
            mainWindow.mainPanel.mainPatient.patientInfo.mail.setText(gestorPatient.getSesion().getCorreo());
            mainWindow.headerpanel.lbStatus.setText(">> Panel Principal Paciente");
            mainWindow.mainPanel.mainPatient.setVisible(true);
            mainWindow.mainPanel.mainPatient.mainPatientCard.cardLayout.show(mainWindow.mainPanel.mainPatient.mainPatientCard, "showAppointments");

            ActTableAppointments(gestorPatient.getSesion());
            ActTableHistorial(gestorPatient.getSesion());
        });
        timer.setRepeats(false);
        timer.start();
    }
    //Agrega una cita a la cola de citas del doctor y del paciente una vez ingresada la descripción por parte del paciente
    public void AceptarCita(String initDesc){
        int row = mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.viewCreateAppointment.doctorsTable.getSelectedRow();
        if (row != -1) {
            int id = (int) mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.viewCreateAppointment.doctorsTable.getValueAt(row, 0);
            Doctor doctor;
            if(gestorDerma.DoctorsDerma.searchDoctorDermaId(id) != null) {
                doctor = gestorDerma.DoctorsDerma.searchDoctorDermaId(id);
            } else if(gestorOfta.DoctorsOfta.searchDoctorOftaId(id) != null) {
                doctor = gestorOfta.DoctorsOfta.searchDoctorOftaId(id);
            } else {
                doctor = gestorTrauma.DoctorsTrauma.searchDoctorTraumaId(id);
            }
            LocalTime now = LocalTime.now();
            LocalDate date = LocalDate.now();

            // Agrego la cita a la cola de citas del doctor y a la cola de citas del paciente
            Appointment appointment = new Appointment(initDesc, date, now, doctor, gestorPatient.getSesion());
            doctor.getQueueAppointments().add(appointment);
            gestorPatient.getSesion().getQueueAppointments().add(appointment);

            ActTableAppointments(gestorPatient.getSesion());
        }else{
            System.out.println("Seleccione un doctor en la tabla");
        }
    }

    public void ActTableAppointments(Patient patient) {
        DefaultTableModel model = (DefaultTableModel) mainWindow.mainPanel.mainPatient.mainPatientCard.showAppointments.AppointmentTable.getModel();
        model.setRowCount(0);

        mainWindow.mainPanel.mainPatient.mainPatientCard.showAppointments.ActuallyAppointmentInfo.setText("Seleccione una Fila");

        for (int i = 0; i < patient.getQueueAppointments().getSize(); i++) {
            Appointment appointment = (Appointment) patient.getQueueAppointments().get(i);
            Object[] row = new Object[7];
            row[0] = appointment.getId();
            row[1] = appointment.getStatus();
            row[2] = appointment.getDoctor().getId();
            row[3] = appointment.getDoctor().getLastName();
            row[4] = appointment.getCreationTimeDay();
            row[5] = appointment.getCreationTime();
            row[6] = appointment.getDoctor().getSpecialty().getClass().getSimpleName();
            model.addRow(row);
        }
        //Notifica si el usuario tiene una cita a la cual asistir

        for (int i = 0; i < patient.getQueueAppointments().getSize(); i++) {
            Appointment appointment = (Appointment) patient.getQueueAppointments().get(i);
            if(appointment.getDoctor().getQueueAppointments().getFirst() == appointment){
                mainWindow.mainPanel.mainPatient.mainPatientCard.showAppointments.ActuallyAppointmentInfo.setText(appointment.toString());
            }
        }
    }

    public void ActTableHistorial(Patient patient) {
        DefaultTableModel model = (DefaultTableModel) mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.TableHistory.getModel();
        model.setRowCount(0);

        mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.appointmentInfo.setText("Seleccione una Fila");

        Appointment appointment = patient.getMedicalHistory().getCabeza();
        while (appointment != null) {
            Object[] row = new Object[5];
            row[0] = appointment.getId();
            row[1] = appointment.getStatus();
            row[2] = appointment.getDoctor().getLastName();
            row[3] = appointment.getCreationTime();
            row[4] = appointment.getCreationAttention();
            model.addRow(row);
            appointment = (Appointment) appointment.next;
        }
    }

    public void SorterHistory(Patient patient) {

        DefaultTableModel model = (DefaultTableModel) mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.TableHistory.getModel();
        model.setRowCount(0);

        mainWindow.mainPanel.mainPatient.mainPatientCard.showHistory.appointmentInfo.setText("Seleccione una Fila");
        // Crea una copia de la lista de citas
        medicalH original = patient.getMedicalHistory();
        medicalH copy = original.copy();
        // Ordena la copia
        Appointment sortedHead = copy.mergeSort(copy.getCabeza());

        // Usa la lista ordenada para llenar la tabla
        Appointment appointment = sortedHead;
        while (appointment != null) {
            Object[] row = new Object[5];
            row[0] = appointment.getId();
            row[1] = appointment.getStatus();
            row[2] = appointment.getDoctor().getLastName();
            row[3] = appointment.getCreationTime();
            row[4] = appointment.getCreationAttention();
            model.addRow(row);
            appointment = (Appointment) appointment.next;
        }
    }

    public void FillTableDoctorsDerma() {
        DefaultTableModel model = (DefaultTableModel) mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.viewCreateAppointment.doctorsTable.getModel();
        model.setRowCount(0);
        fillTableWithDoctors(gestorDerma.DoctorsDerma.getRaiz(), model);
    }

    public void FillTableDoctorsOfta() {
        DefaultTableModel model = (DefaultTableModel) mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.viewCreateAppointment.doctorsTable.getModel();
        model.setRowCount(0);
        fillTableWithDoctors(gestorOfta.DoctorsOfta.getRaiz(), model);
    }

    public void FillTableDoctorsTrauma() {
        DefaultTableModel model = (DefaultTableModel) mainWindow.mainPanel.mainPatient.mainPatientCard.newAppointment.viewCreateAppointment.doctorsTable.getModel();
        model.setRowCount(0);
        fillTableWithDoctors(gestorTrauma.DoctorsTrauma.getRaiz(), model);
    }

    //Para llenar las tablas con los doctores se usa recorrido Inorden

    private void fillTableWithDoctors(Doctor doctor, DefaultTableModel model) {
        if (doctor != null) {
            fillTableWithDoctors((Doctor) doctor.getIzdo(), model);
            Object[] row = new Object[4];
            row[0] = doctor.getId();
            row[1] = doctor.getFirstname();
            row[2] = doctor.getLastName();
            row[3] = doctor.getTelefono();
            model.addRow(row);
            fillTableWithDoctors((Doctor) doctor.getDcho(), model);
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

    public void SignOff() {
        gestorPatient.setSesion(null);
        mainWindow.mainPanel.mainPatient.setVisible(false);
        mainWindow.mainPanel.mainPanelLogo.setVisible(true);
        mainWindow.mainPanel.mainPanelOptions.setVisible(true);
    }

}