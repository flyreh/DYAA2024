package dev.two.project.Interface.Main.MainPatient;

import components.JPanelRound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class showHistory extends JPanelRound {
    public JPanelRound jprInformationPanel;
    public JLabel jlNameArea;
    public JPanelRound createAppointment;
    public JTable doctorsTable;
    public JScrollPane scrollPaneTable;
    public JTextArea doctorsInfo;

    public showHistory() {
        this.setLayout(null);
        this.setBounds(0, 0, 850, 620);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setBackground(new java.awt.Color(142, 157, 142));
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
        custom2 = custom2.deriveFont(Font.PLAIN, 15);

        jlNameArea = new JLabel(">> HISTORIAL DE CITAS <<");
        jlNameArea.setBounds(0, 0, 200, 40);
        jlNameArea.setForeground(Color.BLACK);
        jlNameArea.setFont(custom);
        jlNameArea.setHorizontalAlignment(SwingConstants.CENTER);

        jprInformationPanel = new JPanelRound();
        jprInformationPanel.setBounds(200, 30, 400, 40);
        jprInformationPanel.setRoundTopRight(20);
        jprInformationPanel.setRoundBottomRight(20);
        jprInformationPanel.setRoundBottomLeft(20);
        jprInformationPanel.setRoundTopLeft(20);
        jprInformationPanel.setBackground(new Color(164, 165, 180));
        jprInformationPanel.add(jlNameArea);
        this.add(jprInformationPanel);

        String[] columnNames = {"ID Cita","Status", "Doctor", "H.Creación", "H.Atención"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        doctorsTable = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row)) {
                    component.setBackground(new Color(119, 119, 119));
                } else {
                    component.setBackground(new Color(110, 129, 110));
                }
                return component;
            }
        };
        doctorsTable.getTableHeader().setBackground(new Color(44, 42, 42));
        doctorsTable.getTableHeader().setForeground(Color.WHITE);
        scrollPaneTable = new JScrollPane(doctorsTable);
        scrollPaneTable.setBounds(50, 250, 480, 300);
        this.add(scrollPaneTable);

        JPanelRound jprDoctorsInfo = new JPanelRound();
        jprDoctorsInfo.setBounds(555, 250, 230, 300);
        jprDoctorsInfo.setBackground(Color.BLACK);
        jprDoctorsInfo.setRoundBottomLeft(25);
        jprDoctorsInfo.setRoundBottomRight(25);
        jprDoctorsInfo.setRoundTopLeft(25);
        jprDoctorsInfo.setRoundTopRight(25);

        doctorsInfo = new JTextArea();
        doctorsInfo.setBounds(0, 0, 250, 300);
        doctorsInfo.setFont(custom2);
        doctorsInfo.setBackground(Color.BLACK);
        doctorsInfo.setForeground(Color.WHITE);
        doctorsInfo.setEditable(false);
        doctorsInfo.setBorder(new LineBorder(Color.BLACK, 10, true));
        jprDoctorsInfo.add(doctorsInfo);
        this.add(jprDoctorsInfo);

        createAppointment = new JPanelRound();
        createAppointment.setBounds(50, 200, 200, 40);
        createAppointment.setRoundBottomLeft(25);
        createAppointment.setRoundBottomRight(25);
        createAppointment.setRoundTopLeft(25);
        createAppointment.setRoundTopRight(25);
        createAppointment.setBackground(Color.WHITE);
        createAppointment.add(new JLabel("Ordenar Alfabeticamente"));
        this.add(createAppointment);

    }
}
