package dev.two.project.Interface.Main.MainDoctor.AppointmentFormDoctor;

import dev.two.project.Interface.Main.MainPatient.AppointmentForm.AppointmentFormBack;
import dev.two.project.Interface.Main.MainPatient.AppointmentForm.AppointmentFormBorder;
import dev.two.project.Interface.Main.MainPatient.AppointmentForm.AppointmentFormTitle;
import dev.two.project.Interface.Main.MainPatient.AppointmentForm.AppointmentForminputDesc;

import javax.swing.*;
import java.awt.*;

public class DoctorForm  extends JFrame {
    public DoctorFormBack doctorFormBack;
    public DoctorFormBorder doctorFormBorder;
    public DoctorFormTitle doctorFormTitle;
    public DoctorForminputDesc doctorForminputDesc;

    public DoctorForm() {
        this.setLayout(null);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setSize(450, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Creación de Cita");
        this.setVisible(false);
        initComponents();
    }

    public void initComponents() {
        doctorFormBack = new DoctorFormBack();
        this.add(doctorFormBack);

        doctorFormBorder = new DoctorFormBorder();
        this.add(doctorFormBorder);

        doctorFormTitle = new DoctorFormTitle();
        doctorFormTitle.setBounds(8, 30, 445, 40);
        doctorFormBack.add(doctorFormTitle);

        Color color_estilo = new Color(0, 120, 145);
        JPanel panel_estilo = new JPanel();
        panel_estilo.setBackground(color_estilo);
        panel_estilo.setBounds(0, 190, 445, 60);
        doctorFormBack.add(panel_estilo);

        doctorForminputDesc = new DoctorForminputDesc();
        doctorForminputDesc.setBounds(20, 270, 410, 275);
        doctorFormBack.add(doctorForminputDesc);
    }

}
