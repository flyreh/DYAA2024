package dev.two.project.Interface;

import javax.swing.*;

import java.awt.*;
import dev.two.project.Interface.Main.MainLogin.*;

public class MainWindow extends JFrame {
    public NewClass mipanel;
    public dev.two.project.Interface.login.loginPatient.loginPatient loginPatient;
    //public Main ----
    public HeaderPanel headerpanel;
    public ExitPanel exitPanel;
    public mainPanel mainPanel;

    public MainWindow(){
        this.setTitle("BuildSphere App");
        this.setSize(1200, 800);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0,0));
        initComponents();
    }

    public void initComponents(){

        headerpanel = new HeaderPanel();
        this.add(headerpanel);

        mainPanel = new mainPanel();
        this.add(mainPanel);

        exitPanel = new ExitPanel();
        this.add(exitPanel);
    }

    public static void main(String[] args) {
        MainWindow ventana = new MainWindow();
        ventana.setVisible(true);
    }

}
