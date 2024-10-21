package dev.two.project.Interface.Main.MainPatient.newAppointment;

import components.JPanelRound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCreateAppointment extends JPanelRound {
    public JPanelRound jprInformationPanel;
    public JLabel jlNameArea;
    public JPanelRound createAppointment;
    public JLabel jlCreateAppointment;
    public JTable doctorsTable;
    public JScrollPane scrollPaneTable;
    public JTextArea doctorsInfo;

    public ViewCreateAppointment() {
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
        custom = custom.deriveFont(Font.PLAIN, 15);

        Font custom2 = new Font("Arial", Font.PLAIN, 15);
        try {
            custom2 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\resources\\font\\Sarala\\Sarala-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        custom2 = custom2.deriveFont(Font.PLAIN, 15);

        jlNameArea = new JLabel(">> CREACIÓN DE CITAS <<");
        jlNameArea.setBounds(0, 0, 150, 40);
        jlNameArea.setFont(custom);
        jlNameArea.setForeground(Color.BLACK);

        jprInformationPanel = new JPanelRound();
        jprInformationPanel.setBounds(200, 30, 400, 40);
        jprInformationPanel.setRoundTopRight(20);
        jprInformationPanel.setRoundBottomRight(20);
        jprInformationPanel.setRoundBottomLeft(20);
        jprInformationPanel.setRoundTopLeft(20);
        jprInformationPanel.setBackground(new Color(164, 165, 180));
        jprInformationPanel.add(jlNameArea);
        this.add(jprInformationPanel);


        String[] columnNames = {"ID", "Nombre", "Apellido", "Teléfono"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        doctorsTable = new JTable(model) {
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
        doctorsTable.setGridColor(new Color(98, 98, 98));
        doctorsTable.getTableHeader().setBackground(new Color(44, 42, 42));
        doctorsTable.getTableHeader().setForeground(Color.WHITE);
        doctorsTable.setRowHeight(23);
        doctorsTable.setForeground(Color.WHITE);
        doctorsTable.setFont(new Font("Cascadia Mono", Font.BOLD, 13));

        scrollPaneTable = new JScrollPane(doctorsTable);
        scrollPaneTable.setBounds(50, 100, 400, 300);
        scrollPaneTable.setBackground(new Color(73, 73, 73));
        scrollPaneTable.getViewport().setBackground(new Color(73, 73, 73));
        this.add(scrollPaneTable);

        JPanelRound jprDoctorsInfo = new JPanelRound();
        jprDoctorsInfo.setBounds(500, 100, 250, 300);
        jprDoctorsInfo.setBackground(Color.BLACK);
        jprDoctorsInfo.setRoundBottomLeft(25);
        jprDoctorsInfo.setRoundBottomRight(25);
        jprDoctorsInfo.setRoundTopLeft(25);
        jprDoctorsInfo.setRoundTopRight(25);

        doctorsInfo = new JTextArea();
        doctorsInfo.setBounds(0, 0, 200, 400);
        doctorsInfo.setFont(custom2);
        doctorsInfo.setBackground(Color.BLACK);
        doctorsInfo.setForeground(Color.WHITE);
        doctorsInfo.setEditable(false);
        doctorsInfo.setBorder(new LineBorder(Color.BLACK, 10, true));
        jprDoctorsInfo.add(doctorsInfo);
        this.add(jprDoctorsInfo);

        jlCreateAppointment = new JLabel("Crear cita con este doctor");
        jlCreateAppointment.setBounds(550, 540, 220, 20);
        jlCreateAppointment.setFont(custom2);

        createAppointment = new JPanelRound();
        createAppointment.setBounds(500, 450, 220, 40);
        createAppointment.setRoundBottomLeft(25);
        createAppointment.setRoundBottomRight(25);
        createAppointment.setRoundTopLeft(25);
        createAppointment.setRoundTopRight(25);
        createAppointment.setBackground(Color.WHITE);
        createAppointment.add(jlCreateAppointment);
        this.add(createAppointment);

    }

}
