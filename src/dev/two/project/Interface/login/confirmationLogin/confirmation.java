package dev.two.project.Interface.login.confirmationLogin;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class confirmation extends JFrame {
    private JPanelRound panelConfirmacion;
    private JLabel jlConfirmacion;
    private JLabel jlGifConfirmacion;

    public confirmation() {
        this.setSize(400, 400);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        initComponents();
    }

    public void initComponents() {

        Font fuenteCustom = new Font("Arial", Font.PLAIN, 20);
        try {
            fuenteCustom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\resources\\font\\JosefinSans\\JosefinSans-Bold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        fuenteCustom = fuenteCustom.deriveFont(Font.PLAIN, 20);

        panelConfirmacion = new JPanelRound();
        panelConfirmacion.setBounds(0, 0, 400, 400);
        panelConfirmacion.setBackground(new Color(41, 39, 43));
        panelConfirmacion.setRoundBottomLeft(50);
        panelConfirmacion.setRoundBottomRight(50);
        panelConfirmacion.setRoundTopLeft(50);
        panelConfirmacion.setRoundTopRight(50);
        panelConfirmacion.setLayout(null);
        this.add(panelConfirmacion);

        jlConfirmacion = new JLabel("¡Inicio de sesión exitoso!");
        jlConfirmacion.setBounds(0, 270, 400, 30);
        jlConfirmacion.setFont(fuenteCustom);
        jlConfirmacion.setForeground(Color.WHITE);
        jlConfirmacion.setHorizontalAlignment(JLabel.CENTER);
        panelConfirmacion.add(jlConfirmacion);

        ImageIcon gifCheck = new ImageIcon("src\\dev\\two\\project\\resources\\media\\img\\usuario_check.png");
        Image scaled = gifCheck.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

        gifCheck = new ImageIcon(scaled);

        jlGifConfirmacion = new JLabel();
        jlGifConfirmacion.setBounds(130, 70, 300, 200);
        jlGifConfirmacion.setIcon(gifCheck);
        jlGifConfirmacion.setVerticalAlignment(JLabel.CENTER);
        panelConfirmacion.add(jlGifConfirmacion);
    }

}
