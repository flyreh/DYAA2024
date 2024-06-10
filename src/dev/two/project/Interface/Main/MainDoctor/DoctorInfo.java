package dev.two.project.Interface.Main.MainDoctor;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DoctorInfo extends JPanelRound {
    public JLabel Doctorphoto;
    public JLabel DoctorName;
    public JLabel DoctorSecondName;
    public JLabel Doctormail;

    public JLabel Name;
    public JLabel SecondName;
    public JLabel mail;

    public DoctorInfo(){

        this.setLayout(null);
        this.setBounds(30, 80, 250, 300);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setBackground(new Color(241, 233, 233));

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

        Doctorphoto = new JLabel("Doctor", scaledIcon, JLabel.CENTER);
        Doctorphoto.setVerticalTextPosition(JLabel.TOP);
        Doctorphoto.setHorizontalTextPosition(JLabel.CENTER);
        Doctorphoto.setBounds(22, 10, 200, 170);
        Doctorphoto.setForeground(Color.BLACK);
        this.add(Doctorphoto);

        DoctorName = new JLabel("Primer Nombre >> ");
        DoctorName.setBounds(15, 210, 150, 15);
        DoctorName.setFont(custom.deriveFont(Font.PLAIN, 15));
        DoctorName.setForeground(new Color(0, 0, 0));
        this.add(DoctorName);

        DoctorSecondName = new JLabel("Segundo Nombre >> ");
        DoctorSecondName.setBounds(15, 235, 150, 15);
        DoctorSecondName.setFont(custom.deriveFont(Font.PLAIN, 15));
        DoctorSecondName.setForeground(new Color(0, 0, 0));
        this.add(DoctorSecondName);

        Doctormail = new JLabel("Correo >> ");
        Doctormail.setBounds(15, 260, 80, 15);
        Doctormail.setFont(custom.deriveFont(Font.PLAIN, 15));
        Doctormail.setForeground(new Color(0, 0, 0));
        this.add(Doctormail);

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
