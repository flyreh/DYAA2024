package dev.two.project.Interface.FrameDark;

import javax.swing.*;
import java.awt.*;

public class FrameDark  extends JFrame {
    private PanelRoundDark paneldark;

    public FrameDark(){
        this.setSize(1200,800);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,0));
        initComponents();
    }
    public void initComponents(){
        paneldark = new PanelRoundDark();
        this.add(paneldark);
    }
}
