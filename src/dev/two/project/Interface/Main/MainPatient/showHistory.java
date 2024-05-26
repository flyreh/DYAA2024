package dev.two.project.Interface.Main.MainPatient;

import components.JPanelRound;

import javax.swing.*;

public class showHistory extends JPanelRound {
    JLabel message;

    public showHistory(){
        this.setBounds(0, 0, 850, 680);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setBackground(new java.awt.Color(255, 255, 0));
        initComponents();
    }
    public void initComponents(){
        message = new JLabel("mostrando historial");
        message.setBounds(400, 200, 100, 100);
        this.add(message);
    }
}
