package dev.two.project.controller.controllerDoctor;

import components.JPanelRound;
import dev.two.project.Interface.FrameDark.FrameDark;
import dev.two.project.Interface.Main.MainDoctor.AppointmentFormDoctor.DoctorForm;
import dev.two.project.Interface.Main.MainPatient.AppointmentForm.AppointmentForm;
import dev.two.project.Interface.Main.MainPatient.AppointmentForm.AppointmentForminputDesc;
import dev.two.project.Interface.MainWindow;
import dev.two.project.Interface.login.confirmation.confirmation;
import dev.two.project.controller.gestor.*;
import dev.two.project.model.Appointment;
import dev.two.project.model.Doctor;
import dev.two.project.model.MedicalAreas.Dermatology;
import dev.two.project.model.MedicalAreas.Oftalmologia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class controlDoctor {
    public MainWindow mainWindow;
    public FrameDark currentFrame;
    public DoctorForm docForm = new DoctorForm();

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
        MouseAdapter ListenerAppointments = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable source = (JTable) e.getSource();
                if (source == mainWindow.mainPanel.mainDoctor.mainDoctorCard.AppointmentsTable) {
                    int row = mainWindow.mainPanel.mainDoctor.mainDoctorCard.AppointmentsTable.getSelectedRow();
                    if (row != -1) {
                        int id = (int) mainWindow.mainPanel.mainDoctor.mainDoctorCard.AppointmentsTable.getValueAt(row, 0);
                        for (int i = 0; i < gestorDoctor.getSesion().getQueueAppointments().getSize(); i++) {
                            Appointment appointment = (Appointment) gestorDoctor.getSesion().getQueueAppointments().get(i);
                            if (appointment.getId() == id) {
                                mainWindow.mainPanel.mainDoctor.mainDoctorCard.PatientAppointmentInfo.setText(appointment.toString());
                            }
                        }
                    } else {
                        mainWindow.mainPanel.mainDoctor.mainDoctorCard.PatientAppointmentInfo.setText("Seleccione una Fila "+"\n"+ "\t"+"de la tabla");
                    }
                }
            }
        };
        MouseAdapter ListenerButtonAtention = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                if(source == mainWindow.mainPanel.mainDoctor.mainDoctorCard.AtentionApp){
                    mainWindow.mainPanel.mainDoctor.mainDoctorCard.AtentionApp.setBackground(new Color(35, 56, 41));
                }else if(source == mainWindow.mainPanel.mainDoctor.mainDoctorCard.PostponeApp){
                    mainWindow.mainPanel.mainDoctor.mainDoctorCard.PostponeApp.setBackground(new Color(56, 3, 3));
                }
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                if(source == mainWindow.mainPanel.mainDoctor.mainDoctorCard.AtentionApp){
                    mainWindow.mainPanel.mainDoctor.mainDoctorCard.AtentionApp.setBackground(new Color(63, 143, 69));
                }else if(source == mainWindow.mainPanel.mainDoctor.mainDoctorCard.PostponeApp){
                    mainWindow.mainPanel.mainDoctor.mainDoctorCard.PostponeApp.setBackground(new Color(126, 70, 88));
                }
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                //mostrar la ventana de confirmación de cita atendida -> insertar descripción del doctor de la cita.
                JPanelRound source = (JPanelRound) evt.getSource();
                if(source == mainWindow.mainPanel.mainDoctor.mainDoctorCard.AtentionApp){
                    currentFrame = new FrameDark();
                    currentFrame.setSize(845, 615);
                    currentFrame.paneldark.setSize(845, 615);

                    currentFrame.setLocationRelativeTo(mainWindow.mainPanel.mainDoctor.mainDoctorCard);
                    currentFrame.setVisible(true);
                    currentFrame.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            docForm.requestFocus();
                        }
                    });
                    docForm.setLocationRelativeTo(currentFrame);
                    docForm.setVisible(true);

                }else if(source == mainWindow.mainPanel.mainDoctor.mainDoctorCard.PostponeApp){
                    Appointment appointment = (Appointment) gestorDoctor.getSesion().getQueueAppointments().getFirst();
                    appointment.setStatus(Appointment.Status.POSTERGADA);
                    gestorDoctor.getSesion().getQueueAppointments().moveFirstToEnd();

                    ActTableAppointmentsDoctor(gestorDoctor.getSesion());

                    //mover la cita al ultimo de la cola del doctor y marcar como postergada.
                }
            }
        };
        MouseAdapter ListenerButtonsForm = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == docForm.doctorForminputDesc.Aceptar){

                    MoveAppointment(AppointmentForminputDesc.campo_direccionObra.getText());
                    AppointmentForminputDesc.LimpiarDatos();
                    docForm.setVisible(false);
                    currentFrame.setVisible(false);
                    //cita atendida con éxito
                    //añadir la cita al historial médico del paciente
                    //eliminar la cita de la cola de citas pendientes del doctor y del paciente.
                    //
                }else if(e.getSource() == docForm.doctorForminputDesc.Cancelar){
                    AppointmentForminputDesc.LimpiarDatos();
                    docForm.setVisible(false);
                    currentFrame.setVisible(false);
                }
            }
        };
        MouseAdapter ListenerSignOff = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                source.setBackground(new Color(182, 81, 81));
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                JPanelRound source = (JPanelRound) evt.getSource();
                source.setBackground(new Color(0, 0, 0));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SignOff();
            }
        };
        ListenerButtonsForm(ListenerButtonsForm);
        ListenerSignOff(ListenerSignOff);
        ListenerButtonsAtention(ListenerButtonAtention);
        ListenerTableAppointments(ListenerAppointments);
        ListenerInitSessionDoctor(initSessionDoctor);
        ListenerRegisterDoctor(DoctorRegistro);

    }
    public void ListenerButtonsForm(MouseAdapter listener) {
        docForm.doctorForminputDesc.Aceptar.addMouseListener(listener);
        docForm.doctorForminputDesc.Cancelar.addMouseListener(listener);
    }

    public void ListenerSignOff(MouseAdapter listener) {
        mainWindow.mainPanel.mainDoctor.SignOff.addMouseListener(listener);
    }
    public void ListenerButtonsAtention(MouseAdapter listener) {
        mainWindow.mainPanel.mainDoctor.mainDoctorCard.AtentionApp.addMouseListener(listener);
        mainWindow.mainPanel.mainDoctor.mainDoctorCard.PostponeApp.addMouseListener(listener);
    }

    public void ListenerTableAppointments(MouseAdapter listener) {
        mainWindow.mainPanel.mainDoctor.mainDoctorCard.AppointmentsTable.addMouseListener(listener);
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

    public void completeDoctorInfo() {
        //la sesion ya está seteada, mostrar la tabla con citas del doctor.
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
            mainWindow.mainPanel.mainLogin.loginDoctor.setVisible(false);

            mainWindow.mainPanel.mainDoctor.doctorInfo.Name.setText(gestorDoctor.getSesion().getFirstname());
            mainWindow.mainPanel.mainDoctor.doctorInfo.SecondName.setText(gestorDoctor.getSesion().getSecondName());
            mainWindow.mainPanel.mainDoctor.doctorInfo.mail.setText(gestorDoctor.getSesion().getCorreo());
            mainWindow.headerpanel.lbStatus.setText(">> Panel Principal Paciente");

            mainWindow.mainPanel.mainDoctor.setVisible(true);

            ActTableAppointmentsDoctor(gestorDoctor.getSesion());
        });
        timer.setRepeats(false);
        timer.start();

    }
    public void ActTableAppointmentsDoctor(Doctor doctor) {
        DefaultTableModel model = (DefaultTableModel) mainWindow.mainPanel.mainDoctor.mainDoctorCard.AppointmentsTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < doctor.getQueueAppointments().getSize(); i++) {
            Appointment appointment = (Appointment) doctor.getQueueAppointments().get(i);
            Object[] row = new Object[7];
            row[0] = appointment.getId();
            row[1] = appointment.getStatus();
            row[2] = appointment.getPatient().getFirstname();
            row[3] = appointment.getPatient().getLastName();
            row[4] = appointment.getCreationTimeDay();
            row[5] = appointment.getCreationTime();
            row[6] = appointment.getDoctor().getSpecialty().getClass().getSimpleName();
            model.addRow(row);
        }
        ActActuallyAppointment(gestorDoctor.getSesion());
    }
    public void ActActuallyAppointment(Doctor doctor) {
        Appointment appointment = (Appointment) doctor.getQueueAppointments().getFirst();
        if(appointment == null){
            mainWindow.mainPanel.mainDoctor.mainDoctorCard.PatientAppointmentInfo.setText("No Fila Seleccionada");
            mainWindow.mainPanel.mainDoctor.mainDoctorCard.ActuallyAppointmentInfo.setText("No hay citas pendientes");
            return;
        }else{
            mainWindow.mainPanel.mainDoctor.mainDoctorCard.PatientAppointmentInfo.setText("Seleccione una fila de la tabla");
            mainWindow.mainPanel.mainDoctor.mainDoctorCard.ActuallyAppointmentInfo.setText(appointment.toString());
        }
    }

    public void MoveAppointment(String description) {
        LocalTime nowAttention = LocalTime.now();
        LocalDate dateAttention = LocalDate.now();

        Appointment appointment = (Appointment) gestorDoctor.getSesion().getQueueAppointments().getFirst();

        appointment.setDoctordescription(description);

        appointment.setStatus(Appointment.Status.ATENDIDA);

        appointment.setCreationAttention(nowAttention);

        appointment.setCreationAttentionDay(dateAttention);

        //Quitamos la cita de la cola de citas del doctor
        gestorDoctor.getSesion().getQueueAppointments().remove();
        //Quitamos la cita de la cola de citas del paciente
        appointment.getPatient().getQueueAppointments().removeById(appointment.getId());
        //Añadimos la cita al historial médico del paciente
        appointment.getPatient().getMedicalHistory().InsertarInicio(appointment);

        ActTableAppointmentsDoctor(gestorDoctor.getSesion());
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
    public void SignOff() {
        gestorPatient.setSesion(null);
        mainWindow.mainPanel.mainDoctor.setVisible(false);
        mainWindow.mainPanel.mainPanelLogo.setVisible(true);
        mainWindow.mainPanel.mainPanelOptions.setVisible(true);
    }
}
