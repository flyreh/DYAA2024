package dev.two.project.Interface.Main.MainInterface;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class mainPanelOptions extends JPanelRound {

    public JLabel information;

    public JPanelRound IniciarPacientes;
    public JLabel iniciarPacientes;

    public JPanelRound IniciarDoctores;
    public JLabel iniciarDoctores;

    public JPanelRound RegistrarPaciente;
    public JLabel registrarPaciente;

    public JPanelRound RegistrarDoctor;
    public JLabel registrarDoctor;

    public mainPanelOptions() {
        this.setLayout(null);
        this.setBounds(600, 0, 600, 800);
        this.setRoundTopRight(50);
        this.setRoundBottomRight(50);
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

        information = new JLabel();
        information.setBounds(50,650,550,20);
        information.setFont(custom.deriveFont(Font.PLAIN, 20));
        information.setForeground(new Color(246, 244, 244));
        this.add(information);

        IniciarPacientes = new JPanelRound();
        IniciarPacientes.setBounds(50, 150, 230, 180);
        IniciarPacientes.setBackground(new Color(0, 0, 0));
        IniciarPacientes.setRoundBottomLeft(50);
        IniciarPacientes.setRoundBottomRight(50);
        IniciarPacientes.setRoundTopLeft(50);
        IniciarPacientes.setRoundTopRight(50);

        ImageIcon originalIcon = new ImageIcon("src/dev/two/project/resources/media/img/cliente.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);

        //icono con la imagen ya reescalada
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        iniciarPacientes = new JLabel("Paciente", scaledIcon, JLabel.CENTER);
        iniciarPacientes.setVerticalTextPosition(JLabel.TOP);
        iniciarPacientes.setHorizontalTextPosition(JLabel.CENTER);
        iniciarPacientes.setForeground(Color.WHITE);
        iniciarPacientes.setFont(custom.deriveFont(Font.BOLD, 20));
        IniciarPacientes.add(iniciarPacientes);
        this.add(IniciarPacientes);

        IniciarDoctores = new JPanelRound();
        IniciarDoctores.setBounds(320, 150, 230, 180);
        IniciarDoctores.setBackground(new Color(0, 0, 0));
        IniciarDoctores.setRoundBottomLeft(50);
        IniciarDoctores.setRoundBottomRight(50);
        IniciarDoctores.setRoundTopLeft(50);
        IniciarDoctores.setRoundTopRight(50);

        ImageIcon originalIconDoctor = new ImageIcon("src/dev/two/project/resources/media/img/doctoroption.png");
        Image originalImageDoctor = originalIconDoctor.getImage();
        Image scaledImageDoctor = originalImageDoctor.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDoctor = new ImageIcon(scaledImageDoctor);

        iniciarDoctores = new JLabel("Doctor", scaledIconDoctor, JLabel.CENTER);
        iniciarDoctores.setVerticalTextPosition(JLabel.TOP);
        iniciarDoctores.setHorizontalTextPosition(JLabel.CENTER);
        iniciarDoctores.setForeground(Color.WHITE);
        iniciarDoctores.setFont(custom.deriveFont(Font.BOLD, 20));
        IniciarDoctores.add(iniciarDoctores);
        this.add(IniciarDoctores);

        RegistrarDoctor = new JPanelRound();
        RegistrarDoctor.setBounds(50, 400, 230, 180);
        RegistrarDoctor.setBackground(new Color(0, 0, 0));
        RegistrarDoctor.setRoundBottomLeft(50);
        RegistrarDoctor.setRoundBottomRight(50);
        RegistrarDoctor.setRoundTopLeft(50);
        RegistrarDoctor.setRoundTopRight(50);

        ImageIcon originalIconRegDoctor = new ImageIcon("src/dev/two/project/resources/media/img/agregar-doctor.png");
        Image originalImageRegDoctor = originalIconRegDoctor.getImage();
        Image scaledImageRegDoctor = originalImageRegDoctor.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIconRegDoctor = new ImageIcon(scaledImageRegDoctor);

        registrarDoctor = new JLabel("Registrar Doctor", scaledIconRegDoctor, JLabel.CENTER);
        registrarDoctor.setVerticalTextPosition(JLabel.TOP);
        registrarDoctor.setHorizontalTextPosition(JLabel.CENTER);
        registrarDoctor.setForeground(Color.WHITE);
        registrarDoctor.setFont(custom.deriveFont(Font.BOLD, 20));
        RegistrarDoctor.add(registrarDoctor);
        this.add(RegistrarDoctor);

        RegistrarPaciente = new JPanelRound();
        RegistrarPaciente.setBounds(320, 400, 230, 180);
        RegistrarPaciente.setBackground(new Color(0, 0, 0));
        RegistrarPaciente.setRoundBottomLeft(50);
        RegistrarPaciente.setRoundBottomRight(50);
        RegistrarPaciente.setRoundTopLeft(50);
        RegistrarPaciente.setRoundTopRight(50);

        ImageIcon originalIconRegPaciente = new ImageIcon("src/dev/two/project/resources/media/img/agregar-usuario.png");
        Image originalImageRegPaciente = originalIconRegPaciente.getImage();
        Image scaledImageRegPaciente = originalImageRegPaciente.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIconRegPaciente = new ImageIcon(scaledImageRegPaciente);

        registrarPaciente = new JLabel("Registrar Paciente", scaledIconRegPaciente, JLabel.CENTER);
        registrarPaciente.setVerticalTextPosition(JLabel.TOP);
        registrarPaciente.setHorizontalTextPosition(JLabel.CENTER);
        registrarPaciente.setForeground(Color.WHITE);
        registrarPaciente.setFont(custom.deriveFont(Font.BOLD, 20));
        RegistrarPaciente.add(registrarPaciente);
        this.add(RegistrarPaciente);

    }
}
