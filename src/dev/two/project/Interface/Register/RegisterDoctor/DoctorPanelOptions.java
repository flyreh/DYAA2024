package dev.two.project.Interface.Register.RegisterDoctor;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DoctorPanelOptions extends JPanelRound {
    public JLabel information;

    public JPanelRound Dermatology;
    public JLabel iniciarPacientes;

    public JPanelRound Ofthalmology;
    public JLabel iniciarDoctores;

    public JPanelRound Traumatology;
    public JLabel registrarPaciente;

    public static String selectedArea;

    public JPanelRound singOffAdmin;

    public DoctorPanelOptions() {
        this.setLayout(null);
        this.setBounds(0, 0, 1200, 800);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundTopRight(50);
        this.setRoundBottomRight(50);
        this.setBackground(new Color(88, 89, 96));
        initComponents();
    }
    public void setSelectArea(String area){
        selectedArea = area;
    }
    public String getSelectedArea(){
        return selectedArea;
    }

    public void initComponents() {
        Font custom = new Font("Arial", Font.PLAIN, 15);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\resources\\font\\JosefinSans\\JosefinSans-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }

        information = new JLabel();
        information.setBounds(50, 650, 550, 20);
        information.setFont(custom.deriveFont(Font.PLAIN, 20));
        information.setForeground(new Color(246, 244, 244));
        this.add(information);

        Dermatology = new JPanelRound();
        Dermatology.setBounds(50, 150, 230, 180);
        Dermatology.setBackground(new Color(0, 0, 0));
        Dermatology.setRoundBottomLeft(50);
        Dermatology.setRoundBottomRight(50);
        Dermatology.setRoundTopLeft(50);
        Dermatology.setRoundTopRight(50);

        ImageIcon originalIcon = new ImageIcon("src/dev/two/project/resources/media/img/cliente.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        iniciarPacientes = new JLabel("Dermatología", scaledIcon, JLabel.CENTER);
        iniciarPacientes.setVerticalTextPosition(JLabel.TOP);
        iniciarPacientes.setHorizontalTextPosition(JLabel.CENTER);
        iniciarPacientes.setForeground(Color.WHITE);
        iniciarPacientes.setFont(custom.deriveFont(Font.BOLD, 20));
        Dermatology.add(iniciarPacientes);
        this.add(Dermatology);

        Ofthalmology = new JPanelRound();
        Ofthalmology.setBounds(320, 150, 230, 180);
        Ofthalmology.setBackground(new Color(0, 0, 0));
        Ofthalmology.setRoundBottomLeft(50);
        Ofthalmology.setRoundBottomRight(50);
        Ofthalmology.setRoundTopLeft(50);
        Ofthalmology.setRoundTopRight(50);

        ImageIcon originalIconDoctor = new ImageIcon("src/dev/two/project/resources/media/img/doctoroption.png");
        Image originalImageDoctor = originalIconDoctor.getImage();
        Image scaledImageDoctor = originalImageDoctor.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDoctor = new ImageIcon(scaledImageDoctor);

        iniciarDoctores = new JLabel("Oftalmología", scaledIconDoctor, JLabel.CENTER);
        iniciarDoctores.setVerticalTextPosition(JLabel.TOP);
        iniciarDoctores.setHorizontalTextPosition(JLabel.CENTER);
        iniciarDoctores.setForeground(Color.WHITE);
        iniciarDoctores.setFont(custom.deriveFont(Font.BOLD, 20));
        Ofthalmology.add(iniciarDoctores);
        this.add(Ofthalmology);

        Traumatology = new JPanelRound();
        Traumatology.setBounds(185, 400, 230, 180);
        Traumatology.setBackground(new Color(0, 0, 0));
        Traumatology.setRoundBottomLeft(50);
        Traumatology.setRoundBottomRight(50);
        Traumatology.setRoundTopLeft(50);
        Traumatology.setRoundTopRight(50);

        ImageIcon originalIconRegPaciente = new ImageIcon("src/dev/two/project/resources/media/img/agregar-usuario.png");
        Image originalImageRegPaciente = originalIconRegPaciente.getImage();
        Image scaledImageRegPaciente = originalImageRegPaciente.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIconRegPaciente = new ImageIcon(scaledImageRegPaciente);

        registrarPaciente = new JLabel("Traumatología", scaledIconRegPaciente, JLabel.CENTER);
        registrarPaciente.setVerticalTextPosition(JLabel.TOP);
        registrarPaciente.setHorizontalTextPosition(JLabel.CENTER);
        registrarPaciente.setForeground(Color.WHITE);
        registrarPaciente.setFont(custom.deriveFont(Font.BOLD, 20));
        Traumatology.add(registrarPaciente);
        this.add(Traumatology);

        singOffAdmin = new JPanelRound();
        singOffAdmin.setBounds(185, 600, 230, 50);
        singOffAdmin.setBackground(new Color(0, 0, 0));
        singOffAdmin.setRoundBottomLeft(20);
        singOffAdmin.setRoundBottomRight(20);
        singOffAdmin.setRoundTopLeft(20);
        singOffAdmin.setRoundTopRight(20);
        this.add(singOffAdmin);

        JLabel singOff = new JLabel("Cerrar Sesión", JLabel.CENTER);
        singOff.setForeground(Color.WHITE);
        singOff.setFont(custom.deriveFont(Font.BOLD, 20));
        singOffAdmin.add(singOff);

    }
}
