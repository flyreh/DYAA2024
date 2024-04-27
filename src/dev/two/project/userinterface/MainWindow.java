package dev.two.project.userinterface;

import javax.swing.*;

public class MainWindow extends JFrame {
    public NewClass mipanel;

    public MainWindow(){
        initComponents();
    }

    public void initComponents(){

        mipanel = new NewClass();

        this.setBounds(100, 100, 500, 500);
        this.setLayout(null);

        this.add(mipanel);
    }

    public static void main(String[] args) {
        MainWindow ventana = new MainWindow();
        ventana.setVisible(true);
    }

}
