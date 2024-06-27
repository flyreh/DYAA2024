package dev.two.project.Interface.Main.MainPatient;

import components.JPanelRound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class showHistory extends JPanelRound {
    public JPanelRound jprInformationPanel;
    public JLabel jlNameArea;
    public JPanelRound SorterHistory;
    public JTable TableHistory;
    public JScrollPane scrollPaneTable;
    public JTextArea appointmentInfo;

    public JPanelRound BackSorterTable;

    public showHistory() {
        this.setLayout(null);
        this.setBounds(0, 0, 850, 620);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        this.setBackground(new java.awt.Color(40, 40, 40,100));
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
        TableHistory = new JTable(model) {
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
                }else{
                    component.setBackground(new Color(73, 73, 73));
                }
                return component;
            }
        };
        TableHistory.setGridColor(new Color(98, 98, 98));
        TableHistory.getTableHeader().setBackground(new Color(44, 42, 42));
        TableHistory.getTableHeader().setForeground(Color.WHITE);
        TableHistory.setForeground(Color.WHITE);
        TableHistory.getTableHeader().setFont(new Font("Cascadia Mono", Font.BOLD, 11));
        TableHistory.setRowHeight(23);
        TableHistory.setFont(new Font("Cascadia Mono", Font.ITALIC | Font.BOLD, 13));

        scrollPaneTable = new JScrollPane(TableHistory);
        scrollPaneTable.setBounds(50, 250, 480, 330);
        scrollPaneTable.setBackground(new Color(73, 73, 73));
        scrollPaneTable.getViewport().setBackground(new Color(73, 73, 73));
        this.add(scrollPaneTable);

        JPanelRound jprAppointmentInfo = new JPanelRound();
        jprAppointmentInfo.setBounds(565, 230, 250, 350);
        jprAppointmentInfo.setBackground(Color.BLACK);
        jprAppointmentInfo.setRoundBottomLeft(25);
        jprAppointmentInfo.setRoundBottomRight(25);
        jprAppointmentInfo.setRoundTopLeft(25);
        jprAppointmentInfo.setRoundTopRight(25);

        appointmentInfo = new JTextArea();
        appointmentInfo.setLineWrap(true);
        appointmentInfo.setWrapStyleWord(true);
        appointmentInfo.setBounds(0, 0, 248, 350);
        appointmentInfo.setFont(custom2);
        appointmentInfo.setBackground(Color.BLACK);
        appointmentInfo.setForeground(Color.WHITE);
        appointmentInfo.setEditable(false);
        appointmentInfo.setBorder(new LineBorder(Color.BLACK, 10, true));

        jprAppointmentInfo.add(appointmentInfo);
        this.add(jprAppointmentInfo);

        SorterHistory = new JPanelRound();
        SorterHistory.setBounds(50, 200, 200, 40);
        SorterHistory.setRoundBottomLeft(25);
        SorterHistory.setRoundBottomRight(25);
        SorterHistory.setRoundTopLeft(25);
        SorterHistory.setRoundTopRight(25);
        SorterHistory.setBackground(Color.WHITE);
        SorterHistory.add(new JLabel("Ordenar Alfabeticamente"));
        this.add(SorterHistory);

        BackSorterTable = new JPanelRound();
        BackSorterTable.setBounds(270, 200, 200, 40);
        BackSorterTable.setRoundBottomLeft(25);
        BackSorterTable.setRoundBottomRight(25);
        BackSorterTable.setRoundTopLeft(25);
        BackSorterTable.setRoundTopRight(25);
        BackSorterTable.setBackground(Color.WHITE);
        BackSorterTable.add(new JLabel("Reordenar"));
        this.add(BackSorterTable);
    }
}