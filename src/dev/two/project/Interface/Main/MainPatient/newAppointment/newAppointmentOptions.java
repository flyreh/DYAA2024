package dev.two.project.Interface.Main.MainPatient.newAppointment;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class newAppointmentOptions extends JPanelRound {

    public JPanelRound jprCreateDerma;
    public JLabel creteDerma;

    public JPanelRound jprcreateOfta;
    public JLabel createOfta;

    public JPanelRound jprCreateTrauma;
    public JLabel createTrauma;

    public newAppointmentOptions(){
        this.setLayout(null);
        this.setBounds(0, 0, 850, 620);
        this.setRoundTopRight(50);
        this.setRoundBottomRight(50);
        this.setRoundBottomLeft(50);
        this.setRoundTopLeft(50);
        this.setBackground(new Color(88, 89, 96));
        initComponents();
    }
    public void initComponents(){
        Font custom = new Font("Arial", Font.PLAIN, 15);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\resources\\font\\JosefinSans\\JosefinSans-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        jprCreateDerma = new JPanelRound();
        jprCreateDerma.setBounds(50, 150, 230, 180);
        jprCreateDerma.setBackground(new Color(0, 0, 0));
        jprCreateDerma.setRoundBottomLeft(50);
        jprCreateDerma.setRoundBottomRight(50);
        jprCreateDerma.setRoundTopLeft(50);
        jprCreateDerma.setRoundTopRight(50);

        ImageIcon originalIcon = new ImageIcon("src/dev/two/project/resources/media/img/cliente.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        creteDerma = new JLabel("Dermatologia", scaledIcon, JLabel.CENTER);
        creteDerma.setVerticalTextPosition(JLabel.TOP);
        creteDerma.setHorizontalTextPosition(JLabel.CENTER);
        creteDerma.setForeground(Color.WHITE);
        creteDerma.setFont(custom.deriveFont(Font.BOLD, 20));
        jprCreateDerma.add(creteDerma);
        this.add(jprCreateDerma);

        jprcreateOfta = new JPanelRound();
        jprcreateOfta.setBounds(320, 150, 230, 180);
        jprcreateOfta.setBackground(new Color(0, 0, 0));
        jprcreateOfta.setRoundBottomLeft(50);
        jprcreateOfta.setRoundBottomRight(50);
        jprcreateOfta.setRoundTopLeft(50);
        jprcreateOfta.setRoundTopRight(50);

        ImageIcon originalIconDoctor = new ImageIcon("src/dev/two/project/resources/media/img/doctoroption.png");
        Image originalImageDoctor = originalIconDoctor.getImage();
        Image scaledImageDoctor = originalImageDoctor.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDoctor = new ImageIcon(scaledImageDoctor);

        createOfta = new JLabel("Oftamologia", scaledIconDoctor, JLabel.CENTER);
        createOfta.setVerticalTextPosition(JLabel.TOP);
        createOfta.setHorizontalTextPosition(JLabel.CENTER);
        createOfta.setForeground(Color.WHITE);
        createOfta.setFont(custom.deriveFont(Font.BOLD, 20));
        jprcreateOfta.add(createOfta);
        this.add(jprcreateOfta);

        jprCreateTrauma = new JPanelRound();
        jprCreateTrauma.setBounds(180, 400, 230, 180);
        jprCreateTrauma.setBackground(new Color(0, 0, 0));
        jprCreateTrauma.setRoundBottomLeft(50);
        jprCreateTrauma.setRoundBottomRight(50);
        jprCreateTrauma.setRoundTopLeft(50);
        jprCreateTrauma.setRoundTopRight(50);

        ImageIcon originalIconRegDoctor = new ImageIcon("src/dev/two/project/resources/media/img/agregar-doctor.png");
        Image originalImageRegDoctor = originalIconRegDoctor.getImage();
        Image scaledImageRegDoctor = originalImageRegDoctor.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIconRegDoctor = new ImageIcon(scaledImageRegDoctor);

        createTrauma = new JLabel("Traumatologia", scaledIconRegDoctor, JLabel.CENTER);
        createTrauma.setVerticalTextPosition(JLabel.TOP);
        createTrauma.setHorizontalTextPosition(JLabel.CENTER);
        createTrauma.setForeground(Color.WHITE);
        createTrauma.setFont(custom.deriveFont(Font.BOLD, 20));
        jprCreateTrauma.add(createTrauma);
        this.add(jprCreateTrauma);

    }
}