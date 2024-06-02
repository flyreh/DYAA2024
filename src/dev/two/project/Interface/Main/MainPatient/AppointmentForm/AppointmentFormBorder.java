package dev.two.project.Interface.Main.MainPatient.AppointmentForm;

import components.JPanelRound;

import java.awt.*;

public class AppointmentFormBorder extends JPanelRound {

    public AppointmentFormBorder() {
        this.setBounds(0, 0, 453, 600);
        this.setBackground(Color.WHITE);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopLeft(50);
        this.setRoundTopRight(50);
    }
}
