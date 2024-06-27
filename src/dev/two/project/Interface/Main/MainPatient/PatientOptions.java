package dev.two.project.Interface.Main.MainPatient;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;

public class PatientOptions extends JPanelRound {

    public JPanelRound showAppointments;
    public JPanelRound showHistory;
    public JPanelRound newAppointment;
    public JPanelRound SingOff;

    public PatientOptions(){
        this.setLayout(new GridBagLayout());
        this.setBounds(30, 400, 250, 300);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setBackground(new Color(241, 233, 233, 220));
        initComponents();
    }

    public void initComponents(){

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        showAppointments = createPanelRound("VER CITAS");
        gbc.gridy = 0;
        this.add(showAppointments, gbc);

        showHistory = createPanelRound("VER HISTORIAL");
        gbc.gridy = 1;
        this.add(showHistory, gbc);

        newAppointment = createPanelRound("NUEVA CITA");
        gbc.gridy = 2;
        this.add(newAppointment, gbc);

        SingOff = createPanelRound("CERRAR SESIÓN");
        gbc.gridy = 3;
        this.add(SingOff, gbc);
    }

    private JPanelRound createPanelRound(String text) {
        JPanelRound panel = new JPanelRound();
        panel.setPreferredSize(new Dimension(180, 50));
        panel.setRoundTopLeft(20);
        panel.setRoundBottomLeft(20);
        panel.setRoundBottomRight(20);
        panel.setRoundTopRight(20);
        panel.setBackground(new Color(21, 20, 20));
        addLabelToPanel(panel, text);
        return panel;
    }

    private void addLabelToPanel(JPanelRound panel, String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        panel.setLayout(new GridBagLayout());
        panel.add(label);
    }
}