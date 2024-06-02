package dev.two.project.Interface.Main.MainPatient;

import components.JPanelRound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class showAppointments extends JPanelRound {

    public JPanelRound jprInformationPanel;
    public JLabel jlNameArea;
    public JPanelRound ActuallyAppointment;
    public JTextArea ActuallyAppointmentInfo;
    public JTable doctorsTable;
    public JScrollPane scrollPaneTable;
    public JTextArea doctorsInfo;

    public showAppointments() {
        this.setLayout(null);
        this.setBounds(0, 0, 850, 620);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setBackground(new java.awt.Color(172, 189, 172));
        initComponents();
    }

    public void initComponents() {
        Font custom = new Font("Arial", Font.PLAIN, 18);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\resources\\font\\JosefinSans\\JosefinSans-Bold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        custom = custom.deriveFont(Font.PLAIN, 18);

        Font custom2 = new Font("Arial", Font.PLAIN, 15);
        try {
            custom2 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\resources\\font\\Sarala\\Sarala-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        custom2 = custom2.deriveFont(Font.PLAIN, 13);

        jlNameArea = new JLabel("MUESTRA DE CITAS PENDIENTES");
        jlNameArea.setBounds(0, 0, 200, 40);
        jlNameArea.setFont(custom);
        jlNameArea.setForeground(Color.BLACK);
        jlNameArea.setHorizontalAlignment(JLabel.CENTER);

        jprInformationPanel = new JPanelRound();
        jprInformationPanel.setBounds(200, 30, 400, 40);
        jprInformationPanel.setRoundTopRight(20);
        jprInformationPanel.setRoundBottomRight(20);
        jprInformationPanel.setRoundBottomLeft(20);
        jprInformationPanel.setRoundTopLeft(20);
        jprInformationPanel.setBackground(new Color(164, 165, 180));
        jprInformationPanel.add(jlNameArea);
        this.add(jprInformationPanel);


        String[] columnNames = {"ID Cita","Status","ID Doctor", "Doctor", "Fecha de Creación", "Hora de Creación", "Área"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        doctorsTable = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row)) {
                    component.setBackground(new Color(157, 155, 155));
                } else {
                    component.setBackground(new Color(108, 107, 107));
                }
                return component;
            }
        };
        doctorsTable.getTableHeader().setBackground(new Color(44, 42, 42));
        doctorsTable.getTableHeader().setForeground(Color.WHITE);
        TableColumn column = doctorsTable.getColumnModel().getColumn(0); // Obtén la columna por su índice
        column.setPreferredWidth(40);

        TableColumn column1 = doctorsTable.getColumnModel().getColumn(2); // Obtén la columna por su índice
        column1.setPreferredWidth(40);

        TableColumn column2 = doctorsTable.getColumnModel().getColumn(4); // Obtén la columna por su índice
        column2.setPreferredWidth(100);

        TableColumn column3 = doctorsTable.getColumnModel().getColumn(5); // Obtén la columna por su índice
        column3.setPreferredWidth(100);

        scrollPaneTable = new JScrollPane(doctorsTable);
        scrollPaneTable.setBounds(15, 80, 620, 280);
        this.add(scrollPaneTable);

        JPanelRound jprDoctorsInfo = new JPanelRound();
        jprDoctorsInfo.setBounds(640, 80, 200, 280);
        jprDoctorsInfo.setBackground(Color.BLACK);
        jprDoctorsInfo.setRoundBottomLeft(25);
        jprDoctorsInfo.setRoundBottomRight(25);
        jprDoctorsInfo.setRoundTopLeft(25);
        jprDoctorsInfo.setRoundTopRight(25);

        doctorsInfo = new JTextArea();
        doctorsInfo.setBounds(0, 0, 195, 280);
        doctorsInfo.setFont(custom2);
        doctorsInfo.setBackground(Color.BLACK);
        doctorsInfo.setForeground(Color.WHITE);
        doctorsInfo.setEditable(false);
        doctorsInfo.setBorder(new LineBorder(Color.BLACK, 10, true));
        jprDoctorsInfo.add(doctorsInfo);
        this.add(jprDoctorsInfo);

        ActuallyAppointmentInfo = new JTextArea();
        ActuallyAppointmentInfo.setBounds(0, 0, 280, 180);
        ActuallyAppointmentInfo.setFont(custom2);
        ActuallyAppointmentInfo.setBackground(Color.WHITE);
        ActuallyAppointmentInfo.setForeground(Color.BLACK);
        ActuallyAppointmentInfo.setEditable(false);
        ActuallyAppointmentInfo.setBorder(new LineBorder(Color.BLACK, 10, true));
        ActuallyAppointmentInfo.setLineWrap(true);
        ActuallyAppointmentInfo.setWrapStyleWord(true);

        ActuallyAppointment = new JPanelRound();
        ActuallyAppointment.setBounds(290, 400, 300, 200);
        ActuallyAppointment.setRoundBottomLeft(25);
        ActuallyAppointment.setRoundBottomRight(25);
        ActuallyAppointment.setRoundTopLeft(25);
        ActuallyAppointment.setRoundTopRight(25);
        ActuallyAppointment.setBackground(Color.WHITE);
        ActuallyAppointment.add(ActuallyAppointmentInfo);
        this.add(ActuallyAppointment);

    }
}
