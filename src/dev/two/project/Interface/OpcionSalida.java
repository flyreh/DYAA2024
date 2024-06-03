package dev.two.project.Interface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class OpcionSalida {
    public JButton btSi;
    public JButton btNo;
    private JDialog dialog;

    public OpcionSalida() {
        initComponents();
    }

    private void initComponents() {

        Font customFnt = new Font("Arial Narrow", Font.PLAIN, 15);
        try {
            customFnt = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\resources\\font\\Sarala\\Sarala-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        customFnt = customFnt.deriveFont(Font.PLAIN, 15);

        btSi = new JButton("Sí");
        btSi.setBackground(Color.BLACK);
        btSi.setBorder(new LineBorder(Color.BLACK, 5, true));
        btSi.setForeground(Color.WHITE);
        btSi.setFont(customFnt);

        btNo = new JButton("No");
        btNo.setBackground(Color.BLACK);
        btNo.setBorder(new LineBorder(Color.BLACK, 5, true));
        btNo.setForeground(Color.WHITE);
        btNo.setFont(customFnt);

        btSi.addActionListener((ActionEvent e) -> {
            ejecutar();
            closeDialog();
        });
        btNo.addActionListener((ActionEvent e) -> {
            closeDialog();
        });
    }

    public void generarOptionPane() {
        JOptionPane optionPane = new JOptionPane(
                "¿Seguro que desea salir?",
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                getIcon("src\\dev\\two\\project\\resources\\media\\img\\SalirOptionPane.png", 40, 40),
                new Object[]{btSi, btNo},
                btNo);
        dialog = optionPane.createDialog("Salir");
        dialog.setIconImage((getIcon("src\\dev\\two\\project\\resources\\media\\img\\iconmain.png", 40, 40)).getImage());
        dialog.setVisible(true);
    }

    private ImageIcon getIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image scaled = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaled);
        return icon;
    }

    private void closeDialog() {
        dialog.setVisible(false);
        dialog.dispose();
    }

    public void ejecutar() {

    }
}
