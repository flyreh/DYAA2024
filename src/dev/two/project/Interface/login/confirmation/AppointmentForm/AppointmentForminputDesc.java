package dev.two.project.Interface.login.confirmation.AppointmentForm;

import components.JPanelRound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AppointmentForminputDesc extends JPanel {

    public JLabel etiqueta_direccionObra;
    public JPanelRound campoDesc;
    public static JTextArea campo_direccionObra;

    public JButton Aceptar;
    public JButton Cancelar;

    public AppointmentForminputDesc() {
        initComponents();
    }

    public void initComponents() {

        Font mifuentepanel = new Font("Arial Narrow", Font.PLAIN, 16);
        try {
            mifuentepanel = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\Sarala\\Sarala-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }

        this.setLayout(null);
        Color Micolorpanel = new Color(25, 23, 27);
        this.setBackground(Micolorpanel);
        mifuentepanel = mifuentepanel.deriveFont(Font.PLAIN, 16);


        etiqueta_direccionObra = new JLabel("Descripción: ");
        etiqueta_direccionObra.setBounds(25, 110, 250, 20);
        etiqueta_direccionObra.setForeground(Color.WHITE);
        etiqueta_direccionObra.setFont(mifuentepanel);
        campo_direccionObra = new JTextArea();
        campo_direccionObra.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        campo_direccionObra.setBounds(185, 110, 255, 80);
        campo_direccionObra.setBorder(new LineBorder(Color.WHITE, 5, false));

        campoDesc = new JPanelRound();
        campoDesc.setBounds(185, 110, 260, 85);
        campoDesc.setBackground(new Color(255, 255, 255));
        campoDesc.setRoundBottomLeft(20);
        campoDesc.setRoundBottomRight(20);
        campoDesc.setRoundTopLeft(20);
        campoDesc.setRoundTopRight(20);
        campoDesc.add(campo_direccionObra);
        this.add(campoDesc);

        Color micolorBoton = new Color(110, 190, 170);
        Aceptar = new JButton("Crear");
        Aceptar.setBounds(45, 200, 150, 45);
        Aceptar.setBackground(micolorBoton);
        Aceptar.setForeground(Color.WHITE);
        Aceptar.setBorder(new LineBorder(micolorBoton, 3, true));
        Aceptar.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        ImageIcon aceptar = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\gif\\aceptar.png");
        Aceptar.setIcon(aceptar);

        Color micolorBoton_2 = new Color(240, 30, 80);
        Cancelar = new JButton("Cancelar");
        Cancelar.setBounds(205, 200, 150, 45);
        Cancelar.setBackground(micolorBoton_2);
        Cancelar.setForeground(Color.WHITE);
        Cancelar.setBorder(new LineBorder(micolorBoton_2, 5, true));
        Cancelar.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        ImageIcon mostrar = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\gif\\MostrarDetalles.png");
        Cancelar.setIcon(mostrar);

        this.add(etiqueta_direccionObra);
        this.add(campo_direccionObra);

        this.add(Aceptar);
        this.add(Cancelar);

    }

    public static void  LimpiarDatos() {
        campo_direccionObra.setText("");
    }
}
