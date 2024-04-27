package dev.two.project;

public class Ventana extends javax.swing.JFrame{


    public NewClass mipanel;

    public Ventana(){
        initComponents();
    }

    public void initComponents(){

        mipanel = new NewClass();

        this.setBounds(100, 100, 500, 500);
        this.setLayout(null);

        this.add(mipanel);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }

}
