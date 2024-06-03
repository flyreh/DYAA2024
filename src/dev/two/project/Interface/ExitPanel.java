package dev.two.project.Interface;

import javax.swing.*;
import java.awt.*;

public class ExitPanel extends JPanel {
    public JLabel lbExitButton;
    public ImageIcon exitOFF;
    public ImageIcon exitON;

    public ExitPanel() {
        this.setBounds(1160, 0, 40, 40);
        this.setLayout(null);
        this.setBackground(new Color(0, 0, 0, 0));
        initComponents();
    }

    public void initComponents() {

        exitOFF = new ImageIcon("src\\dev\\two\\project\\resources\\media\\img\\xnegro.png");
        Image scaled1 = exitOFF.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        exitOFF = new ImageIcon(scaled1);

        exitON = new ImageIcon("src\\dev\\two\\project\\resources\\media\\img\\xrojo.png");
        Image scaled2 = exitON.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        exitON = new ImageIcon(scaled2);

        lbExitButton = new JLabel();
        lbExitButton.setBounds(0, 0, 40, 40);
        lbExitButton.setIcon(exitOFF);
        this.add(lbExitButton);
    }
}
