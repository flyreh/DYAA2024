package dev.two.project.Interface.Main.MainPatient.newAppointment;

import components.JPanelRound;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class newAppointmentOptions extends JPanelRound {

    public JPanelRound jprCreateDerma;
    public JLabel creteDerma;

    public JPanelRound jprcreateOfta;
    public JLabel createOfta;

    public JPanelRound jprCreateTrauma;
    public JLabel createTrauma;

    public JPanelRound jprTitle;
    public JLabel titleLabel;

    public JPanelRound jprCreateCardio;
    public JLabel createCardio;

    public JPanelRound jprCreateNutri;
    public JLabel createNutri;

    public JPanelRound jprCreateNephro;
    public JLabel createNephro;

    public newAppointmentOptions(){
        this.setLayout(new GridBagLayout());
        this.setBounds(0, 0, 850, 620);
        this.setRoundTopRight(50);
        this.setRoundBottomRight(50);
        this.setRoundBottomLeft(50);
        this.setRoundTopLeft(50);
        this.setBackground(new Color(88, 89, 96));
        initComponents();
    }

    public void initComponents(){
        Font custom = new Font("Arial", Font.PLAIN, 15);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\dev\\two\\project\\resources\\font\\JosefinSans\\JosefinSans-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);  // Margins around the components

        // Create and configure the title panel
        jprTitle = new JPanelRound();
        jprTitle.setPreferredSize(new Dimension(400, 60));
        jprTitle.setBackground(new Color(0, 0, 0));
        jprTitle.setRoundBottomLeft(50);
        jprTitle.setRoundBottomRight(50);
        jprTitle.setRoundTopLeft(50);
        jprTitle.setRoundTopRight(50);
        jprTitle.setLayout(new GridBagLayout()); // Set layout to GridBagLayout for centering

        titleLabel = new JLabel("Especialidades", JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(custom.deriveFont(Font.BOLD, 25));

        // Add titleLabel to jprTitle with GridBagLayout constraints
        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbcTitle.gridx = 0;
        gbcTitle.gridy = 0;
        gbcTitle.anchor = GridBagConstraints.CENTER;
        jprTitle.add(titleLabel, gbcTitle);

        // Add jprTitle to the main panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; // Spanning three columns
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(jprTitle, gbc);

        // Create and configure the Dermatology panel
        jprCreateDerma = new JPanelRound();
        jprCreateDerma.setPreferredSize(new Dimension(230, 180));
        jprCreateDerma.setBackground(new Color(0, 0, 0));
        jprCreateDerma.setRoundBottomLeft(50);
        jprCreateDerma.setRoundBottomRight(50);
        jprCreateDerma.setRoundTopLeft(50);
        jprCreateDerma.setRoundTopRight(50);
        jprCreateDerma.setLayout(new GridBagLayout()); // Set layout to GridBagLayout for centering

        ImageIcon originalIcon = new ImageIcon("src/dev/two/project/resources/media/img/cliente.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        creteDerma = new JLabel("Dermatologia", scaledIcon, JLabel.CENTER);
        creteDerma.setVerticalTextPosition(JLabel.TOP);
        creteDerma.setHorizontalTextPosition(JLabel.CENTER);
        creteDerma.setForeground(Color.WHITE);
        creteDerma.setFont(custom.deriveFont(Font.BOLD, 20));

        // Add creteDerma to jprCreateDerma with GridBagLayout constraints
        GridBagConstraints gbcDerma = new GridBagConstraints();
        gbcDerma.gridx = 0;
        gbcDerma.gridy = 0;
        gbcDerma.anchor = GridBagConstraints.CENTER;
        jprCreateDerma.add(creteDerma, gbcDerma);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Reset to one column
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(jprCreateDerma, gbc);

        // Create and configure the Ophthalmology panel
        jprcreateOfta = new JPanelRound();
        jprcreateOfta.setPreferredSize(new Dimension(230, 180));
        jprcreateOfta.setBackground(new Color(0, 0, 0));
        jprcreateOfta.setRoundBottomLeft(50);
        jprcreateOfta.setRoundBottomRight(50);
        jprcreateOfta.setRoundTopLeft(50);
        jprcreateOfta.setRoundTopRight(50);
        jprcreateOfta.setLayout(new GridBagLayout()); // Set layout to GridBagLayout for centering

        ImageIcon originalIconDoctor = new ImageIcon("src/dev/two/project/resources/media/img/doctoroption.png");
        Image originalImageDoctor = originalIconDoctor.getImage();
        Image scaledImageDoctor = originalImageDoctor.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDoctor = new ImageIcon(scaledImageDoctor);

        createOfta = new JLabel("Oftamologia", scaledIconDoctor, JLabel.CENTER);
        createOfta.setVerticalTextPosition(JLabel.TOP);
        createOfta.setHorizontalTextPosition(JLabel.CENTER);
        createOfta.setForeground(Color.WHITE);
        createOfta.setFont(custom.deriveFont(Font.BOLD, 20));

        // Add createOfta to jprcreateOfta with GridBagLayout constraints
        GridBagConstraints gbcOfta = new GridBagConstraints();
        gbcOfta.gridx = 0;
        gbcOfta.gridy = 0;
        gbcOfta.anchor = GridBagConstraints.CENTER;
        jprcreateOfta.add(createOfta, gbcOfta);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(jprcreateOfta, gbc);

        // Create and configure the Traumatology panel
        jprCreateTrauma = new JPanelRound();
        jprCreateTrauma.setPreferredSize(new Dimension(230, 180));
        jprCreateTrauma.setBackground(new Color(0, 0, 0));
        jprCreateTrauma.setRoundBottomLeft(50);
        jprCreateTrauma.setRoundBottomRight(50);
        jprCreateTrauma.setRoundTopLeft(50);
        jprCreateTrauma.setRoundTopRight(50);
        jprCreateTrauma.setLayout(new GridBagLayout()); // Set layout to GridBagLayout for centering

        ImageIcon originalIconRegDoctor = new ImageIcon("src/dev/two/project/resources/media/img/agregar-doctor.png");
        Image originalImageRegDoctor = originalIconRegDoctor.getImage();
        Image scaledImageRegDoctor = originalImageRegDoctor.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIconRegDoctor = new ImageIcon(scaledImageRegDoctor);

        createTrauma = new JLabel("Traumatologia", scaledIconRegDoctor, JLabel.CENTER);
        createTrauma.setVerticalTextPosition(JLabel.TOP);
        createTrauma.setHorizontalTextPosition(JLabel.CENTER);
        createTrauma.setForeground(Color.WHITE);
        createTrauma.setFont(custom.deriveFont(Font.BOLD, 20));

        // Add createTrauma to jprCreateTrauma with GridBagLayout constraints
        GridBagConstraints gbcTrauma = new GridBagConstraints();
        gbcTrauma.gridx = 0;
        gbcTrauma.gridy = 0;
        gbcTrauma.anchor = GridBagConstraints.CENTER;
        jprCreateTrauma.add(createTrauma, gbcTrauma);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(jprCreateTrauma, gbc);

        // Create and configure the Cardiology panel
        jprCreateCardio = new JPanelRound();
        jprCreateCardio.setPreferredSize(new Dimension(230, 180));
        jprCreateCardio.setBackground(new Color(0, 0, 0));
        jprCreateCardio.setRoundBottomLeft(50);
        jprCreateCardio.setRoundBottomRight(50);
        jprCreateCardio.setRoundTopLeft(50);
        jprCreateCardio.setRoundTopRight(50);
        jprCreateCardio.setLayout(new GridBagLayout()); // Set layout to GridBagLayout for centering

        ImageIcon originalIconCardio = new ImageIcon("src/dev/two/project/resources/media/img/cardiologia.png");
        Image originalImageCardio = originalIconCardio.getImage();
        Image scaledImageCardio = originalImageCardio.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIconCardio = new ImageIcon(scaledImageCardio);

        createCardio = new JLabel("Cardiologia", scaledIconCardio, JLabel.CENTER);
        createCardio.setVerticalTextPosition(JLabel.TOP);
        createCardio.setHorizontalTextPosition(JLabel.CENTER);
        createCardio.setForeground(Color.WHITE);
        createCardio.setFont(custom.deriveFont(Font.BOLD, 20));

        // Add createCardio to jprCreateCardio with GridBagLayout constraints
        GridBagConstraints gbcCardio = new GridBagConstraints();
        gbcCardio.gridx = 0;
        gbcCardio.gridy = 0;
        gbcCardio.anchor = GridBagConstraints.CENTER;
        jprCreateCardio.add(createCardio, gbcCardio);

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(jprCreateCardio, gbc);

        // Create and configure the Nutrition panel
        jprCreateNutri = new JPanelRound();
        jprCreateNutri.setPreferredSize(new Dimension(230, 180));
        jprCreateNutri.setBackground(new Color(0, 0, 0));
        jprCreateNutri.setRoundBottomLeft(50);
        jprCreateNutri.setRoundBottomRight(50);
        jprCreateNutri.setRoundTopLeft(50);
        jprCreateNutri.setRoundTopRight(50);
        jprCreateNutri.setLayout(new GridBagLayout()); // Set layout to GridBagLayout for centering

        ImageIcon originalIconNutri = new ImageIcon("src/dev/two/project/resources/media/img/nutricion.png");
        Image originalImageNutri = originalIconNutri.getImage();
        Image scaledImageNutri = originalImageNutri.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIconNutri = new ImageIcon(scaledImageNutri);

        createNutri = new JLabel("Nutricion", scaledIconNutri, JLabel.CENTER);
        createNutri.setVerticalTextPosition(JLabel.TOP);
        createNutri.setHorizontalTextPosition(JLabel.CENTER);
        createNutri.setForeground(Color.WHITE);
        createNutri.setFont(custom.deriveFont(Font.BOLD, 20));

        // Add createNutri to jprCreateNutri with GridBagLayout constraints
        GridBagConstraints gbcNutri = new GridBagConstraints();
        gbcNutri.gridx = 0;
        gbcNutri.gridy = 0;
        gbcNutri.anchor = GridBagConstraints.CENTER;
        jprCreateNutri.add(createNutri, gbcNutri);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(jprCreateNutri, gbc);

        // Create and configure the Nephrology panel
        jprCreateNephro = new JPanelRound();
        jprCreateNephro.setPreferredSize(new Dimension(230, 180));
        jprCreateNephro.setBackground(new Color(0, 0, 0));
        jprCreateNephro.setRoundBottomLeft(50);
        jprCreateNephro.setRoundBottomRight(50);
        jprCreateNephro.setRoundTopLeft(50);
        jprCreateNephro.setRoundTopRight(50);
        jprCreateNephro.setLayout(new GridBagLayout()); // Set layout to GridBagLayout for centering

        ImageIcon originalIconNephro = new ImageIcon("src/dev/two/project/resources/media/img/nefrologia.png");
        Image originalImageNephro = originalIconNephro.getImage();
        Image scaledImageNephro = originalImageNephro.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIconNephro = new ImageIcon(scaledImageNephro);

        createNephro = new JLabel("Nefrologia", scaledIconNephro, JLabel.CENTER);
        createNephro.setVerticalTextPosition(JLabel.TOP);
        createNephro.setHorizontalTextPosition(JLabel.CENTER);
        createNephro.setForeground(Color.WHITE);
        createNephro.setFont(custom.deriveFont(Font.BOLD, 20));

        // Add createNephro to jprCreateNephro with GridBagLayout constraints
        GridBagConstraints gbcNephro = new GridBagConstraints();
        gbcNephro.gridx = 0;
        gbcNephro.gridy = 0;
        gbcNephro.anchor = GridBagConstraints.CENTER;
        jprCreateNephro.add(createNephro, gbcNephro);

        gbc.gridx = 2;
        gbc.gridy = 2;
        this.add(jprCreateNephro, gbc);
    }
}