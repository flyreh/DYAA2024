package dev.two.project.Interface.Main.MainLogin;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class mainPanel extends JPanel{

    public mainPanelLogo mainPanelLogo;
    public mainPanelOptions mainPanelOptions;

    public mainPanel(){
        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        initComponents();
    }

    public void initComponents(){
        mainPanelLogo = new mainPanelLogo();
        this.add(mainPanelLogo);

        mainPanelOptions = new mainPanelOptions();
        this.add(mainPanelOptions);

    }
}
