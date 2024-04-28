/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.two.project.userinterface;
import components.JPanelRound;
import java.awt.*;

/**
 *
 * @author Usuario
 */
public class NewClass extends JPanelRound {

    public NewClass(){
        this.setLayout(null);
        this.setBounds(100, 100, 30, 30);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setRoundBottomLeft(8);
        this.setRoundBottomRight(8);
        this.setRoundTopLeft(8);
        this.setRoundTopRight(8);
        initComponets();

    }

    public void initComponets(){

    }
    
}
