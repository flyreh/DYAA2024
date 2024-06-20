package dev.two.project.Interface.Main.MainDoctor;

import components.JPanelRound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
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

    public MainDoctorCard() {
        setLayout(null);
        setBounds(300, 80, 850, 650);
        setRoundTopLeft(50);
        setRoundBottomLeft(50);
        setRoundBottomRight(50);
        setRoundTopRight(50);
        setBackground(new Color(10, 10, 10, 100));
        initComponents();
    }

    public void initComponents() {
        Font customFont18 = new Font("Arial", Font.PLAIN, 18);
        Font customFont12 = new Font("Arial", Font.PLAIN, 12);

        try {
            customFont18 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\resources\\font\\JosefinSans\\JosefinSans-Bold.ttf")).deriveFont(Font.PLAIN, 18);
            customFont12 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\resources\\font\\Sarala\\Sarala-Regular.ttf")).deriveFont(Font.PLAIN, 12);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }

        jlNameArea = new JLabel("MUESTRA DE CITAS POR REALIZAR");
        jlNameArea.setBounds(0, 0, 400, 30);
        jlNameArea.setFont(customFont18);
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
        add(jprInformationPanel);

        String[] columnNames = {"ID Cita", "Estado", "Nombre Paciente", "Apellido Paciente", "Fecha Creación", "Hora Creación", "Área"};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames);
        AppointmentsTable = new JTable(tableModel) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                if (isRowSelected(row)) {
                    component = new DefaultTableCellRenderer() {
                        @Override
                        protected void paintComponent(Graphics g) {
                            Graphics2D g2d = (Graphics2D) g;
                            GradientPaint gp = new GradientPaint(0, 0, new Color(218, 21, 21, 139), 0, getHeight(), new Color(12, 65, 194, 159));
                            g2d.setPaint(gp);
                            g2d.fillRect(0, 0, getWidth(), getHeight());
                            super.paintComponent(g);
                        }
                    }.getTableCellRendererComponent(this, getValueAt(row, column), false, false, row, column);
                } else {
                    component.setBackground(new Color(73, 73, 73));
                }
                return component;
            }
        };
        AppointmentsTable.getTableHeader().setBackground(new Color(44, 42, 42));
        AppointmentsTable.getTableHeader().setForeground(Color.WHITE);

        scrollPaneTable = new JScrollPane(AppointmentsTable);
        scrollPaneTable.setBounds(25, 60, 750, 150);
        scrollPaneTable.setBackground(new Color(73, 73, 73));
        scrollPaneTable.getViewport().setBackground(new Color(73, 73, 73));
        add(scrollPaneTable);

        jlNameArea = new JLabel("PACIENTE SELECCIONADO");
        jlNameArea.setBounds(0, 0, 400, 30);
        jlNameArea.setFont(customFont18);
        jlNameArea.setForeground(Color.BLACK);
        jlNameArea.setHorizontalAlignment(JLabel.CENTER);

        jprInformationPanel = new JPanelRound();
        jprInformationPanel.setBounds(25, 250, 300, 30);
        jprInformationPanel.setRoundTopRight(20);
        jprInformationPanel.setRoundBottomRight(20);
        jprInformationPanel.setRoundBottomLeft(20);
        jprInformationPanel.setRoundTopLeft(20);
        jprInformationPanel.setBackground(new Color(164, 165, 180));
        jprInformationPanel.add(jlNameArea);
        add(jprInformationPanel);

        JPanelRound patientInfoPanel = new JPanelRound();
        patientInfoPanel.setBounds(25, 320, 300, 300);
        patientInfoPanel.setBackground(Color.BLACK);
        patientInfoPanel.setRoundBottomLeft(25);
        patientInfoPanel.setRoundBottomRight(25);
        patientInfoPanel.setRoundTopLeft(25);
        patientInfoPanel.setRoundTopRight(25);

        PatientAppointmentInfo = new JTextArea();
        PatientAppointmentInfo.setBounds(0, 0, 245, 230);
        PatientAppointmentInfo.setFont(customFont12);
        PatientAppointmentInfo.setBackground(Color.BLACK);
        PatientAppointmentInfo.setForeground(Color.WHITE);
        PatientAppointmentInfo.setEditable(false);
        PatientAppointmentInfo.setLineWrap(true);
        PatientAppointmentInfo.setWrapStyleWord(true);
        PatientAppointmentInfo.setBorder(new LineBorder(Color.BLACK, 10, true));
        patientInfoPanel.add(PatientAppointmentInfo);
        add(patientInfoPanel);

        jlNameArea = new JLabel("PACIENTE ACTUAL:");
        jlNameArea.setBounds(0, 0, 400, 30);
        jlNameArea.setFont(customFont18);
        jlNameArea.setForeground(Color.BLACK);
        jlNameArea.setHorizontalAlignment(JLabel.CENTER);

        jprInformationPanel = new JPanelRound();
        jprInformationPanel.setBounds(350, 250, 300, 30);
        jprInformationPanel.setRoundTopRight(20);
        jprInformationPanel.setRoundBottomRight(20);
        jprInformationPanel.setRoundBottomLeft(20);
        jprInformationPanel.setRoundTopLeft(20);
        jprInformationPanel.setBackground(new Color(164, 165, 180));
        jprInformationPanel.add(jlNameArea);
        add(jprInformationPanel);

        ActuallyAppointmentInfo = new JTextArea();
        ActuallyAppointmentInfo.setBounds(0, 0, 245, 179);
        ActuallyAppointmentInfo.setFont(customFont12);
        ActuallyAppointmentInfo.setBackground(Color.BLACK);
        ActuallyAppointmentInfo.setForeground(Color.WHITE);
        ActuallyAppointmentInfo.setEditable(false);
        ActuallyAppointmentInfo.setLineWrap(true);
        ActuallyAppointmentInfo.setWrapStyleWord(true);
        ActuallyAppointmentInfo.setBorder(new LineBorder(Color.BLACK, 10, true));

        ActuallyAppointment = new JPanelRound();
        ActuallyAppointment.setBounds(350, 320, 300, 300);
        ActuallyAppointment.setRoundBottomLeft(25);
        ActuallyAppointment.setRoundBottomRight(25);
        ActuallyAppointment.setRoundTopLeft(25);
        ActuallyAppointment.setRoundTopRight(25);
        ActuallyAppointment.setBackground(Color.BLACK);
        ActuallyAppointment.add(ActuallyAppointmentInfo);
        add(ActuallyAppointment);

        jlNameArea = new JLabel("ATENDER");
        jlNameArea.setBounds(0, 0, 80, 30);
        jlNameArea.setFont(customFont18);
        jlNameArea.setForeground(Color.BLACK);
        jlNameArea.setHorizontalAlignment(JLabel.CENTER);

        AtentionApp = new JPanelRound();
        AtentionApp.setBounds(15, 15, 120, 40);
        AtentionApp.setRoundBottomLeft(25);
        AtentionApp.setRoundBottomRight(25);
        AtentionApp.setRoundTopLeft(25);
        AtentionApp.setRoundTopRight(25);
        AtentionApp.setBackground(new Color(57, 129, 118));
        AtentionApp.add(jlNameArea);

        jlNameArea = new JLabel("POSTERGAR");
        jlNameArea.setBounds(0, 0, 80, 30);
        jlNameArea.setFont(customFont18);
        jlNameArea.setForeground(Color.BLACK);
        jlNameArea.setHorizontalAlignment(JLabel.CENTER);

        PostponeApp = new JPanelRound();
        PostponeApp.setBounds(15, 65, 120, 40);
        PostponeApp.setRoundBottomLeft(25);
        PostponeApp.setRoundBottomRight(25);
        PostponeApp.setRoundTopLeft(25);
        PostponeApp.setRoundTopRight(25);
        PostponeApp.setBackground(new Color(197, 106, 58));
        PostponeApp.add(jlNameArea);

        ButtonsPanel = new JPanelRound();
        ButtonsPanel.setLayout(null);
        ButtonsPanel.setBounds(675, 500, 150, 120);
        ButtonsPanel.setRoundBottomLeft(25);
        ButtonsPanel.setRoundBottomRight(25);
        ButtonsPanel.setRoundTopLeft(25);
        ButtonsPanel.setRoundTopRight(25);
        ButtonsPanel.setBackground(new Color(241, 233, 233, 190));
        ButtonsPanel.add(AtentionApp);
        ButtonsPanel.add(PostponeApp);
        add(ButtonsPanel);
    }
}

