package dev.two.project.userinterface;

import javax.swing.*;
import dev.two.project.userinterface.login.*;

public class MainWindow extends JFrame {
    public NewClass mipanel;
    public
    public loginPatient loginPatient;

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
