package dev.two.project.Interface;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HeaderPanel extends JPanel {
    public JLabel lbStatus;

    public HeaderPanel() {
        this.setBounds(0, 0, 1160, 40);
        this.setLayout(null);
        this.setBackground(new Color(0,0,0,0));
        initComponents();
    }

    public void initComponents() {

        Font custom = new Font("Arial", Font.PLAIN, 15);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\utilities\\font\\JosefinSans\\JosefinSans-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        custom = custom.deriveFont(Font.PLAIN, 15);

        lbStatus = new JLabel(">> Main Menu");
        lbStatus.setForeground(Color.BLACK);
        lbStatus.setBounds(10, 10, 200, 15);
        lbStatus.setFont(custom);
        this.add(lbStatus);
    }
}
