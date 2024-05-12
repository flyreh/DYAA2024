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
    public JComboBox<String> tfGenero;
    public JComboBox<String> tfEstadoCivil;
    public JTextField tfTelefono;
    public JTextField tfCorreo;

    public JPasswordField pfContrasenia;
    private JSeparator sFirstName;
    private JSeparator sSecondName;
    private JSeparator sLastName;
    private JSeparator sContrasenia;
    private JSeparator sEdad;
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
        lbFirstName.setBounds(60, 100, 400, 30);
        lbFirstName.setForeground(Color.white);
        lbFirstName.setFont(custom);
        this.add(lbFirstName);

        tfFirstName = new JTextField();
        tfFirstName.setText("Primer Nombre");
        tfFirstName.setForeground(Color.GRAY);
        tfFirstName.setBounds(60, 130, 300, 40);
        tfFirstName.setFont(custom);
        tfFirstName.setBorder(new LineBorder(Color.BLACK, 2, false));

        tfFirstName.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                usuarioClickeado(evt);
            }
        });
        this.add(tfFirstName);

        sFirstName = new JSeparator();
        sFirstName.setBounds(60, 170, 300, 3);
        sFirstName.setBackground(Color.BLACK);
        sFirstName.setBorder(new LineBorder(Color.BLACK, 5, false));
        this.add(sFirstName);

        lbSecondName = new JLabel("Segundo Nombre:");
        lbSecondName.setBounds(60, 180, 400, 30);
        lbSecondName.setForeground(Color.white);
        lbSecondName.setFont(custom);
        this.add(lbSecondName);

        tfSecondName = new JTextField();
        tfSecondName.setText("Segundo Nombre");
        tfSecondName.setForeground(Color.GRAY);
        tfSecondName.setBounds(60, 210, 300, 40);
        tfSecondName.setFont(custom);
        tfSecondName.setBorder(new LineBorder(Color.BLACK, 2, false));
        tfSecondName.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                usuarioClickeado(evt);
            }
        });
        this.add(tfSecondName);

        sSecondName = new JSeparator();
        sSecondName.setBounds(60, 250, 300, 3);
        sSecondName.setBackground(Color.BLACK);
        sSecondName.setBorder(new LineBorder(Color.BLACK, 5, false));
        this.add(sSecondName);

        lbLastName = new JLabel("Apellido:");
        lbLastName.setBounds(60, 250, 400, 30);
        lbLastName.setForeground(Color.white);
        lbLastName.setFont(custom);
        this.add(lbLastName);

        tfLastName = new JTextField();
        tfLastName.setText("Apellido");
        tfLastName.setForeground(Color.GRAY);
        tfLastName.setBounds(60, 280, 300, 40);
        tfLastName.setFont(custom);
        tfLastName.setBorder(new LineBorder(Color.BLACK, 2, false));
        tfLastName.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                usuarioClickeado(evt);
            }
        });
        this.add(tfLastName);

        sLastName = new JSeparator();
        sLastName.setBounds(60, 320, 300, 3);
        sLastName.setBackground(Color.BLACK);
        sLastName.setBorder(new LineBorder(Color.BLACK, 5, false));
        this.add(sLastName);


        lbContrasenia = new JLabel("Contraseña:");
        lbContrasenia.setBounds(60, 320, 400, 30);
        lbContrasenia.setForeground(Color.WHITE);
        lbContrasenia.setFont(custom);
        this.add(lbContrasenia);

        pfContrasenia = new JPasswordField();
        pfContrasenia.setBounds(60, 350, 300, 40);
        pfContrasenia.setForeground(Color.GRAY);
        pfContrasenia.setBorder(new LineBorder(Color.BLACK, 2, false));
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
        sContrasenia.setBounds(60, 390, 300, 3);
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
        lbErrorLogin.setBounds(0, 640, 420, 10);
        lbErrorLogin.setForeground(Color.red);
        lbErrorLogin.setFont(custom.deriveFont(Font.PLAIN, 15));
        lbErrorLogin.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbErrorLogin);


        String[] opciones = {"primero", "segundo", "Tercero"};

        UIManager.put("ComboBox.selectionBackground", new Color(0, 129, 155));
        UIManager.put("ComboBox.selectionForeground", Color.WHITE);

        tfGenero = new JComboBox<>(opciones);
        tfGenero.setBounds(50, 400, 400, 30);
        tfGenero.setBackground(new Color(21, 20, 23));
        tfGenero.setBorder(new LineBorder(Color.BLACK, 1, false));
        tfGenero.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (isSelected) {
                    renderer.setBackground(new Color(0, 129, 155));
                    renderer.setForeground(Color.WHITE);
                } else {
                    renderer.setBackground(Color.BLACK);
                    renderer.setForeground(Color.WHITE);
                }
                return renderer;
            }
        });
        tfGenero.setForeground(Color.WHITE);
        this.add(tfGenero);

        tfEstadoCivil = new JComboBox<>(opciones);
        tfEstadoCivil.setBounds(50, 450, 400, 30);
        tfEstadoCivil.setBackground(new Color(21, 20, 23));
        tfEstadoCivil.setBorder(new LineBorder(Color.BLACK, 1, false));
        tfEstadoCivil.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (isSelected) {
                    renderer.setBackground(new Color(0, 129, 155));
                    renderer.setForeground(Color.WHITE);
                } else {
                    renderer.setBackground(Color.BLACK);
                    renderer.setForeground(Color.WHITE);
                }
                return renderer;
            }
        });
        tfEstadoCivil.setForeground(Color.WHITE);
        this.add(tfEstadoCivil);
    }

    public void usuarioClickeado(MouseEvent e) {
        JTextField source = (JTextField) e.getSource();
        lbErrorLogin.setText("");
        if(source == tfFirstName && tfFirstName.getText().equals("Primer Nombre")){
            tfFirstName.setText("");
            if(tfSecondName.getText().isEmpty()){
                tfSecondName.setText("Segundo Nombre");
                tfSecondName.setForeground(Color.GRAY);
            }
            if(tfLastName.getText().isEmpty()){
                tfLastName.setText("Apellido");
                tfLastName.setForeground(Color.GRAY);
            }
            tfFirstName.setForeground(Color.BLACK);
        }
        if(source == tfSecondName && tfSecondName.getText().equals("Segundo Nombre")){
            tfSecondName.setText("");
            if(tfFirstName.getText().isEmpty()){
                tfFirstName.setText("Primer Nombre");
                tfFirstName.setForeground(Color.GRAY);
            }
            if(tfLastName.getText().isEmpty()){
                tfLastName.setText("Apellido");
                tfLastName.setForeground(Color.GRAY);
            }
            tfSecondName.setForeground(Color.BLACK);
        }
        if(source == tfLastName && tfLastName.getText().equals("Apellido")){
            tfLastName.setText("");
            if(tfFirstName.getText().isEmpty()){
                tfFirstName.setText("Primer Nombre");
                tfFirstName.setForeground(Color.GRAY);
            }
            if(tfSecondName.getText().isEmpty()){
                tfSecondName.setText("Segundo Nombre");
                tfSecondName.setForeground(Color.GRAY);
            }
            tfLastName.setForeground(Color.BLACK);
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
        if (tfSecondName.getText().isEmpty()) {
            tfSecondName.setText("Segundo Nombre");
            tfSecondName.setForeground(Color.GRAY);
        }
        if (tfLastName.getText().isEmpty()) {
            tfLastName.setText("Apellido");
            tfLastName.setForeground(Color.GRAY);
        }

    }
}
