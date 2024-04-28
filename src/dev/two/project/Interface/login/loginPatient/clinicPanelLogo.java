package dev.two.project.Interface.login.loginPatient;

import components.JPanelGradient;
import components.JPanelRound;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class clinicPanelLogo extends JPanelRound {

    public JLabel welcomeLabel;
    public JLabel ClinicImage;
    public JLabel doctorimage;

    public clinicPanelLogo(){
        this.setLayout(null);
        this.setBounds(0, 0, 1200, 800);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setBackground(new Color (232, 236, 235));
        initComponents();
    }

    public void initComponents(){
        Font fuenteCustom = new Font("Arial", Font.PLAIN, 100);
        try {
            fuenteCustom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\utilities\\font\\JosefinSans\\JosefinSans-Bold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        fuenteCustom = fuenteCustom.deriveFont(Font.PLAIN, 60);

        welcomeLabel = new JLabel(">Bienvenido<");
        welcomeLabel.setBounds(10, 150, 600, 100);
        welcomeLabel.setFont(fuenteCustom);
        welcomeLabel.setForeground(new Color(7, 83, 112));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setForeground(Color.WHITE);
        this.add(welcomeLabel);

        ImageIcon originalIcon = new ImageIcon("src/dev/two/project/utilities/media/img/clinicLogo.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(550, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        ClinicImage = new JLabel();
        ClinicImage.setBounds(0, 250, 600, 220);
        ClinicImage.setIcon(scaledIcon);
        ClinicImage.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(ClinicImage);

        ImageIcon originalIcon2 = new ImageIcon("src/dev/two/project/utilities/media/img/doctor.png");
        Image originalImage2 = originalIcon2.getImage();
        Image scaledImage2 = originalImage2.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);

        doctorimage = new JLabel();
        doctorimage.setBounds(170, 450, 250, 300);
        doctorimage.setIcon(scaledIcon2);
        doctorimage.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(doctorimage);
    }


}
