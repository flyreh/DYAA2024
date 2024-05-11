package dev.two.project.Interface.Register.RegisterPatient;

import components.JPanelGradient;
import components.JPanelRound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class registerPatientForm extends JPanelGradient {

    private JLabel lbFirstName;
    private JLabel lbSecondName;
    private JLabel lbLastName;
    private JLabel lbContrasenia;
    private JLabel lbEdad;
    private JLabel lbgenero;
    private JLabel estadoCivil;
    private JLabel lbTelefono;
    private JLabel lbCorreo;

    public JTextField tfFirstName;
    public JTextField tfSecondName;
    public JTextField tfLastName;
    public JTextField tfEdad;
    public JTextField tfGenero;
    public JTextField tfEstadoCivil;
    public JTextField tfTelefono;
    public JTextField tfCorreo;

    public JPasswordField pfContrasenia;
    private JSeparator sFirstName;
    private JSeparator sSecondName;
    private JSeparator sLastName;
    private JSeparator sContrasenia;
    private JSeparator sEdad;
    private JSeparator sGenero;
    private JSeparator sEstadoCivil;
    private JSeparator sTelefono;
    private JSeparator sCorreo;

    public JLabel btnLogin;
    public JPanelRound jprLogin;
    public JLabel lbErrorLogin;
    public JLabel title;

    public registerPatientForm() {
        this.setBounds(650, 80, 450, 660);
        this.setGradientStart(new Color(29, 56, 110, 131));
        this.setGradientEnd(new Color(64, 131, 127, 68));
        this.setLayout(null);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setRoundBottomLeft(50);
        this.setRoundTopLeft(50);
        initComponents();
    }
    public void initComponents() {
        Font custom = new Font("Arial", Font.PLAIN, 15);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\resources\\font\\Sarala\\Sarala-Regular.ttf"));
            custom = custom.deriveFont(Font.PLAIN, 15);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        Font font = new Font("Arial", Font.PLAIN, 10);
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\resources\\font\\JosefinSans\\JosefinSans-Bold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        font = font.deriveFont(Font.PLAIN, 30);

        title = new JLabel("REGISTRO DE PACIENTES");
        title.setBounds(20, 50, 400, 40);
        title.setFont(font);
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title);

        lbFirstName = new JLabel("Primer Nombre:");
        lbFirstName.setBounds(50, 100, 400, 50);
        lbFirstName.setForeground(Color.white);
        lbFirstName.setFont(custom);
        this.add(lbFirstName);

        tfFirstName = new JTextField();
        tfFirstName.setText("Primer Nombre");
        tfFirstName.setForeground(Color.GRAY);
        tfFirstName.setBounds(50, 150, 300, 40);
        tfFirstName.setFont(custom);
        tfFirstName.setBorder(new LineBorder(Color.WHITE, 5, false));
        tfFirstName.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                usuarioClickeado();
            }
        });
        this.add(tfFirstName);

        sFirstName = new JSeparator();
        sFirstName.setBounds(50, 190, 300, 3);
        sFirstName.setBackground(Color.BLACK);
        sFirstName.setBorder(new LineBorder(Color.BLACK, 5, false));
        this.add(sFirstName);

        lbSecondName = new JLabel("Segundo Nombre:");
        lbSecondName.setBounds(50, 200, 400, 50);
        lbSecondName.setForeground(Color.white);
        lbSecondName.setFont(custom);
        this.add(lbSecondName);

        tfSecondName = new JTextField();
        tfSecondName.setText("Segundo Nombre");
        tfSecondName.setForeground(Color.GRAY);
        tfSecondName.setBounds(50, 250, 300, 40);
        tfSecondName.setFont(custom);
        tfSecondName.setBorder(new LineBorder(Color.WHITE, 5, false));
        tfSecondName.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                usuarioClickeado();
            }
        });
        this.add(tfSecondName);

        sSecondName = new JSeparator();
        sSecondName.setBounds(50, 290, 300, 3);
        sSecondName.setBackground(Color.BLACK);
        sSecondName.setBorder(new LineBorder(Color.BLACK, 5, false));
        this.add(sSecondName);

        lbLastName = new JLabel("Apellido:");
        lbLastName.setBounds(50, 300, 400, 50);
        lbLastName.setForeground(Color.white);
        lbLastName.setFont(custom);
        this.add(lbLastName);

        tfLastName = new JTextField();
        tfLastName.setText("Apellido");
        tfLastName.setForeground(Color.GRAY);
        tfLastName.setBounds(50, 350, 300, 40);
        tfLastName.setFont(custom);
        tfLastName.setBorder(new LineBorder(Color.WHITE, 5, false));
        tfLastName.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                usuarioClickeado();
            }
        });
        this.add(tfLastName);

        sLastName = new JSeparator();
        sLastName.setBounds(50, 390, 300, 3);
        sLastName.setBackground(Color.BLACK);
        sLastName.setBorder(new LineBorder(Color.BLACK, 5, false));
        this.add(sLastName);


        lbContrasenia = new JLabel("Contraseña:");
        lbContrasenia.setBounds(50, 390, 400, 40);
        lbContrasenia.setForeground(Color.WHITE);
        lbContrasenia.setFont(custom);
        this.add(lbContrasenia);

        pfContrasenia = new JPasswordField();
        pfContrasenia.setBounds(50, 430, 300, 40);
        pfContrasenia.setForeground(Color.GRAY);
        pfContrasenia.setBorder(new LineBorder(Color.WHITE, 5, false));
        pfContrasenia.setText("********");
        pfContrasenia.setFont(custom);
        pfContrasenia.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                passwordClickeado();
            }
        });
        this.add(pfContrasenia);

        sContrasenia = new JSeparator();
        sContrasenia.setBounds(50, 470, 300, 3);
        sContrasenia.setBackground(Color.BLACK);
        sContrasenia.setBorder(new LineBorder(Color.BLACK, 5, false));
        this.add(sContrasenia);

        int round = 25;
        jprLogin = new JPanelRound();
        jprLogin.setBounds(160, 600, 100, 40);
        jprLogin.setRoundBottomLeft(round);
        jprLogin.setRoundBottomRight(round);
        jprLogin.setRoundTopLeft(round);
        jprLogin.setRoundTopRight(round);
        jprLogin.setBackground(new Color(37, 35, 39));

        btnLogin = new JLabel("Sign Un");
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(custom.deriveFont(20.0f));
        jprLogin.add(btnLogin);
        this.add(jprLogin);

        lbErrorLogin = new JLabel();
        lbErrorLogin.setBounds(0, 650, 420, 10);
        lbErrorLogin.setForeground(Color.red);
        lbErrorLogin.setFont(custom.deriveFont(Font.PLAIN, 15));
        lbErrorLogin.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbErrorLogin);
    }

    public void usuarioClickeado() {
        lbErrorLogin.setText("");
        if (tfFirstName.getText().equals("Primer Nombre")) {
            tfFirstName.setText("");
            tfFirstName.setForeground(Color.BLACK);
        }
        if (String.valueOf(pfContrasenia.getPassword()).isEmpty()) {
            pfContrasenia.setText("********");
            pfContrasenia.setForeground(Color.GRAY);
        }
    }

    public void passwordClickeado() {
        lbErrorLogin.setText("");
        if (String.valueOf(pfContrasenia.getPassword()).equals("********")) {
            pfContrasenia.setText("");
            pfContrasenia.setForeground(Color.BLACK);
        }
        if (tfFirstName.getText().isEmpty()) {
            tfFirstName.setText("Primer Nombre");
            tfFirstName.setForeground(Color.GRAY);
        }
    }
}
