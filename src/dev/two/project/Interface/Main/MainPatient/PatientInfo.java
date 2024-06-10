package dev.two.project.Interface.Main.MainPatient;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PatientInfo extends JPanelRound {

    public JLabel patientphoto;
    public JLabel patientName;
    public JLabel patientSecondName;
    public JLabel patientmail;

    public JLabel Name;
    public JLabel SecondName;
    public JLabel mail;

    public PatientInfo(){

        this.setLayout(null);
        this.setBounds(30, 80, 250, 300);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setBackground(new Color(241, 233, 233, 220));

        initComponents();
    }

    public void initComponents(){
        Font custom = new Font("Arial", Font.PLAIN, 15);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\resources\\font\\JosefinSans\\JosefinSans-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        ImageIcon originalIcon = new ImageIcon("src/dev/two/project/resources/media/img/usermain.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        patientphoto = new JLabel("Paciente", scaledIcon, JLabel.CENTER);
        patientphoto.setVerticalTextPosition(JLabel.TOP);
        patientphoto.setHorizontalTextPosition(JLabel.CENTER);
        patientphoto.setBounds(22, 10, 200, 170);
        patientphoto.setForeground(Color.BLACK);
        this.add(patientphoto);

        patientName = new JLabel("Primer Nombre >> ");
        patientName.setBounds(15, 210, 150, 15);
        patientName.setFont(custom.deriveFont(Font.PLAIN, 15));
        patientName.setForeground(new Color(0, 0, 0));
        this.add(patientName);

        patientSecondName = new JLabel("Segundo Nombre >> ");
        patientSecondName.setBounds(15, 235, 150, 15);
        patientSecondName.setFont(custom.deriveFont(Font.PLAIN, 15));
        patientSecondName.setForeground(new Color(0, 0, 0));
        this.add(patientSecondName);

        patientmail = new JLabel("Correo >> ");
        patientmail.setBounds(15, 260, 80, 15);
        patientmail.setFont(custom.deriveFont(Font.PLAIN, 15));
        patientmail.setForeground(new Color(0, 0, 0));
        this.add(patientmail);

        Name = new JLabel();
        Name.setBounds(170, 210, 80, 15);
        Name.setFont(custom.deriveFont(Font.PLAIN, 15));
        Name.setForeground(new Color(0, 0, 0));
        this.add(Name);

        SecondName = new JLabel();
        SecondName.setBounds(170, 235, 80, 15);
        SecondName.setFont(custom.deriveFont(Font.PLAIN, 15));
        SecondName.setForeground(new Color(0, 0, 0));
        this.add(SecondName);

        mail = new JLabel();
        mail.setBounds( 100, 260, 180, 15);
        mail.setFont(custom.deriveFont(Font.PLAIN, 15));
        mail.setForeground(new Color(0, 0, 0));
        this.add(mail);

    }
}
