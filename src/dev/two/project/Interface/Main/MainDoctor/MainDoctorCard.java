package dev.two.project.Interface.Main.MainDoctor;

import components.JPanelRound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainDoctorCard extends JPanelRound {
    public JPanelRound jprInformationPanel;
    public JLabel jlNameArea;
    public JPanelRound ActuallyAppointment;
    public JTextArea ActuallyAppointmentInfo;
    public JTable AppointmentsTable;
    public JScrollPane scrollPaneTable;
    public JTextArea PatientAppointmentInfo;

    public JPanelRound ButtonsPanel;
    public JPanelRound AtentionApp;
    public JPanelRound PostponeApp;


    public MainDoctorCard(){
        this.setLayout(null);
        this.setBounds(300, 80, 850, 650);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setBackground(new java.awt.Color(142, 157, 142));
        initComponents();
    }

    public void initComponents(){
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
        custom2 = custom2.deriveFont(Font.PLAIN, 12);

        jlNameArea = new JLabel("MUESTRA DE CITAS POR REALIZAR");
        jlNameArea.setBounds(0, 0, 400, 30);
        jlNameArea.setFont(custom);
        jlNameArea.setForeground(Color.BLACK);
        jlNameArea.setHorizontalAlignment(JLabel.CENTER);

        jprInformationPanel = new JPanelRound();
        jprInformationPanel.setBounds(210, 10, 400, 30);
        jprInformationPanel.setRoundTopRight(20);
        jprInformationPanel.setRoundBottomRight(20);
        jprInformationPanel.setRoundBottomLeft(20);
        jprInformationPanel.setRoundTopLeft(20);
        jprInformationPanel.setBackground(new Color(164, 165, 180));
        jprInformationPanel.add(jlNameArea);
        this.add(jprInformationPanel);


        String[] columnNames = {"ID Cita","Status", "Nombre Paciente","Apellido Paciente", "F.Creación", "H.Creación", "Área"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        AppointmentsTable = new JTable(model) {
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
        AppointmentsTable.getTableHeader().setBackground(new Color(44, 42, 42));
        AppointmentsTable.getTableHeader().setForeground(Color.WHITE);

        scrollPaneTable = new JScrollPane(AppointmentsTable);
        scrollPaneTable.setBounds(25, 60, 750, 150);
        this.add(scrollPaneTable);

        JPanelRound jprPatientAppInfo = new JPanelRound();
        jprPatientAppInfo.setBounds(250, 220, 250, 200);
        jprPatientAppInfo.setBackground(Color.BLACK);
        jprPatientAppInfo.setRoundBottomLeft(25);
        jprPatientAppInfo.setRoundBottomRight(25);
        jprPatientAppInfo.setRoundTopLeft(25);
        jprPatientAppInfo.setRoundTopRight(25);

        PatientAppointmentInfo = new JTextArea();
        PatientAppointmentInfo.setBounds(0, 0, 245, 230);
        PatientAppointmentInfo.setFont(custom2);
        PatientAppointmentInfo.setBackground(Color.BLACK);
        PatientAppointmentInfo.setForeground(Color.WHITE);
        PatientAppointmentInfo.setEditable(false);
        PatientAppointmentInfo.setLineWrap(true);
        PatientAppointmentInfo.setWrapStyleWord(true);
        PatientAppointmentInfo.setBorder(new LineBorder(Color.BLACK, 10, true));
        jprPatientAppInfo.add(PatientAppointmentInfo);
        this.add(jprPatientAppInfo);

        ActuallyAppointmentInfo = new JTextArea();
        ActuallyAppointmentInfo.setBounds(0, 0, 245, 179);
        ActuallyAppointmentInfo.setFont(custom2);
        ActuallyAppointmentInfo.setBackground(Color.BLACK);
        ActuallyAppointmentInfo.setForeground(Color.WHITE);
        ActuallyAppointmentInfo.setEditable(false);
        ActuallyAppointmentInfo.setLineWrap(true);
        ActuallyAppointmentInfo.setWrapStyleWord(true);
        ActuallyAppointmentInfo.setBorder(new LineBorder(Color.BLACK, 10, true));

        ActuallyAppointment = new JPanelRound();
        ActuallyAppointment.setBounds(250, 450, 250, 190);
        ActuallyAppointment.setRoundBottomLeft(25);
        ActuallyAppointment.setRoundBottomRight(25);
        ActuallyAppointment.setRoundTopLeft(25);
        ActuallyAppointment.setRoundTopRight(25);
        ActuallyAppointment.setBackground(Color.BLACK);
        ActuallyAppointment.add(ActuallyAppointmentInfo);
        this.add(ActuallyAppointment);

        AtentionApp = new JPanelRound();
        AtentionApp.setBounds(15, 15, 80, 40);
        AtentionApp.setRoundBottomLeft(25);
        AtentionApp.setRoundBottomRight(25);
        AtentionApp.setRoundTopLeft(25);
        AtentionApp.setRoundTopRight(25);
        AtentionApp.setBackground(new Color(63, 143, 69));

        PostponeApp = new JPanelRound();
        PostponeApp.setBounds(15, 65, 80, 40);
        PostponeApp.setRoundBottomLeft(25);
        PostponeApp.setRoundBottomRight(25);
        PostponeApp.setRoundTopLeft(25);
        PostponeApp.setRoundTopRight(25);
        PostponeApp.setBackground(new Color(126, 70, 88));

        ButtonsPanel = new JPanelRound();
        ButtonsPanel.setLayout(null);
        ButtonsPanel.setBounds(510, 500, 120, 120);
        ButtonsPanel.setRoundBottomLeft(25);
        ButtonsPanel.setRoundBottomRight(25);
        ButtonsPanel.setRoundTopLeft(25);
        ButtonsPanel.setRoundTopRight(25);
        ButtonsPanel.setBackground(Color.WHITE);
        ButtonsPanel.add(AtentionApp);
        ButtonsPanel.add(PostponeApp);
        this.add(ButtonsPanel);



    }

}
