package dev.two.project.Interface.login.loginPatient;

import components.JPanelGradient;
import components.JPanelRound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class loginForm  extends JPanelGradient {

    private JLabel lbUsuario;
    private JLabel lbContrasenia;
    public JTextField tfUsuario;
    public JPasswordField pfContrasenia;
    private JSeparator sUsuario;
    private JSeparator sContrasenia;
    private JLabel lbImagenUsuario;
    public JLabel btnLogin;
    public JPanelRound jprLogin;
    public JLabel lbErrorLogin;
    public JLabel title;

    public loginForm() {
        this.setBounds(780, 0, 420, 800);
        this.setGradientStart(new Color(0, 129, 230));
        this.setGradientEnd(new Color(10, 100, 110));
        this.setLayout(null);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        initComponents();
    }

    public void initComponents() {
        Font custom = new Font("Arial", Font.PLAIN, 15);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\utilities\\font\\Sarala\\Sarala-Regular.ttf"));
            custom = custom.deriveFont(Font.PLAIN, 15);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        Font font = new Font("Arial", Font.PLAIN, 10);
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\utilities\\font\\JosefinSans\\JosefinSans-Bold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        font = font.deriveFont(Font.PLAIN, 30);

        title = new JLabel("LOGIN DE PACIENTES");
        title.setBounds(0, 130, 400, 40);
        title.setFont(font);
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title);

        lbUsuario = new JLabel("Ingrese su nombre de usuario:");
        lbUsuario.setBounds(50, 200, 400, 50);
        lbUsuario.setForeground(Color.white);
        lbUsuario.setFont(custom);
        this.add(lbUsuario);

        tfUsuario = new JTextField();
        tfUsuario.setText("Usuario");
        tfUsuario.setForeground(Color.GRAY);
        tfUsuario.setBounds(50, 260, 300, 40);
        tfUsuario.setFont(custom);
        tfUsuario.setBorder(new LineBorder(Color.WHITE, 5, false));
        tfUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                usuarioClickeado();
            }
        });
        this.add(tfUsuario);

        sUsuario = new JSeparator();
        sUsuario.setBounds(50, 300, 300, 3);
        sUsuario.setBackground(Color.BLACK);
        sUsuario.setBorder(new LineBorder(Color.BLACK, 5, false));
        this.add(sUsuario);

        lbContrasenia = new JLabel("Ingrese su contraseña:");
        lbContrasenia.setBounds(50, 310, 400, 40);
        lbContrasenia.setForeground(Color.WHITE);
        lbContrasenia.setFont(custom);
        this.add(lbContrasenia);

        pfContrasenia = new JPasswordField();
        pfContrasenia.setBounds(50, 360, 300, 40);
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
        sContrasenia.setBounds(50, 400, 300, 3);
        sContrasenia.setBackground(Color.BLACK);
        sContrasenia.setBorder(new LineBorder(Color.BLACK, 5, false));
        this.add(sContrasenia);

       /* ImageIcon imagenUsuario = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\usuario.png");
        Image scaled = imagenUsuario.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imagenUsuario = new ImageIcon(scaled);*/

       /* lbImagenUsuario = new JLabel();
        lbImagenUsuario.setIcon(imagenUsuario);
        lbImagenUsuario.setBounds(0, 360, 420, 200);
        lbImagenUsuario.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbImagenUsuario);*/

        int round = 25;
        jprLogin = new JPanelRound();
        jprLogin.setBounds(160, 450, 100, 40);
        jprLogin.setRoundBottomLeft(round);
        jprLogin.setRoundBottomRight(round);
        jprLogin.setRoundTopLeft(round);
        jprLogin.setRoundTopRight(round);
        jprLogin.setBackground(new Color(37, 35, 39));

        btnLogin = new JLabel("Entrar");
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(custom.deriveFont(20.0f));
        jprLogin.add(btnLogin);
        this.add(jprLogin);

        lbErrorLogin = new JLabel();
        lbErrorLogin.setBounds(0, 500, 420, 20);
        lbErrorLogin.setForeground(Color.red);
        lbErrorLogin.setFont(custom.deriveFont(Font.PLAIN, 15));
        lbErrorLogin.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbErrorLogin);
    }

    public void usuarioClickeado() {
        lbErrorLogin.setText("");
        if (tfUsuario.getText().equals("Usuario")) {
            tfUsuario.setText("");
            tfUsuario.setForeground(Color.BLACK);
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
        if (tfUsuario.getText().isEmpty()) {
            tfUsuario.setText("Usuario");
            tfUsuario.setForeground(Color.GRAY);
        }
    }

}
