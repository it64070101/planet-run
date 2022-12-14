/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

import java.awt.*;
import javax.swing.*;
// import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class MainUI extends JPanel {
    private JFrame fr;
    private JPanel pAll, pShip, pHuntingGround, pSectors, pGadget, pRest, pLabel, pButton, pMaketool, pComponent,
            pRocket;
    private JButton noseCone, shockcord, recoveryWadding, leftFin, rightFin;
    private JButton sectorA, sectorB, sectorC, sectorD, rest, maketool;
    private JButton huntingGround0, huntingGround1;
    // private JButton gun, axe, hammer, pick, hook;
    private JTextField dayTxt, foodTxt, starTxt, triangleTxt, squareTxt, circleTxt, title1;
    private ImageIcon rockcone, rockleft, rockright, rockbase, rockbody;
    private JDesktopPane dp1;
    private JInternalFrame inf1, inf2, inf3, inf4, inf5, inf6, inf7;

    public MainUI() {
        fr = new JFrame("Planet Run");

        pAll = new JPanel();
        pShip = new JPanel();
        pHuntingGround = new JPanel();
        pSectors = new JPanel();
        pGadget = new JPanel();
        pRest = new JPanel();
        pLabel = new JPanel();
        pButton = new JPanel();
        pComponent = new JPanel();
        pRocket = new JPanel();
        rockcone = new ImageIcon("rockcone.png");
        rockleft = new ImageIcon("rockleft.png");
        rockright = new ImageIcon("rockright.png");
        rockbase = new ImageIcon("rockbase.png");
        rockbody = new ImageIcon("rockbody.png");

        BorderLayout layout01 = new BorderLayout();
        // layout01.setBackground(Color.BLACK);

        noseCone = new JButton(rockcone);
        shockcord = new JButton(rockbody);
        recoveryWadding = new JButton(rockbase);
        leftFin = new JButton(rockleft);
        rightFin = new JButton(rockright);

        noseCone.setPreferredSize(new Dimension(100, 100));
        shockcord.setPreferredSize(new Dimension(150, 200));
        recoveryWadding.setPreferredSize(new Dimension(100, 100));
        leftFin.setPreferredSize(new Dimension(100, 100));
        rightFin.setPreferredSize(new Dimension(100, 100));

        pShip.setLayout(new BorderLayout(5, 5));
        pShip.setBackground(Color.BLACK);
        pShip.setSize(128, 128);
        pShip.add(noseCone, BorderLayout.NORTH);
        pShip.add(shockcord, BorderLayout.CENTER);
        pShip.add(recoveryWadding, BorderLayout.SOUTH);
        pShip.add(leftFin, BorderLayout.WEST);
        pShip.add(rightFin, BorderLayout.EAST);
        // noseCone.setBackground(Color.BLACK);

        sectorA = new JButton("Explore this Sector");
        sectorB = new JButton("Explore this Sector");
        sectorC = new JButton("Explore this Sector");
        sectorD = new JButton("Explore this Sector");
        rest = new JButton("Rest");
        maketool = new JButton("Make Tool");

        rest.setPreferredSize(new Dimension(100, 50));
        maketool.setPreferredSize(new Dimension(100, 50));

        pSectors.setLayout(new GridLayout(2, 2));
        pSectors.add(sectorA);
        pSectors.add(sectorB);
        pSectors.add(sectorC);
        pSectors.add(sectorD);

        huntingGround0 = new JButton("Fight this Animal");
        huntingGround1 = new JButton("Fight this Animal");

        pHuntingGround.setLayout(new GridLayout(2, 1));
        pHuntingGround.add(huntingGround0);
        pHuntingGround.add(huntingGround1);

        dayTxt = new JTextField("Day: 0");
        foodTxt = new JTextField("Food: 0");
        starTxt = new JTextField("Star: 0");
        triangleTxt = new JTextField("Triangle: 0");
        squareTxt = new JTextField("Square: 0");
        circleTxt = new JTextField("Circle: 0");
        title1 = new JTextField("Planet Run!");

        pLabel.add(dayTxt);
        pLabel.add(foodTxt);
        pLabel.add(starTxt);
        pLabel.add(triangleTxt);
        pLabel.add(squareTxt);
        pLabel.add(circleTxt);

        dayTxt.setEditable(false);
        foodTxt.setEditable(false);
        starTxt.setEditable(false);
        triangleTxt.setEditable(false);
        squareTxt.setEditable(false);
        circleTxt.setEditable(false);

        dp1 = new JDesktopPane();
        dp1.setSize(200, 200);
        inf1 = new JInternalFrame("Rocket", false, true, true, true);
        // inf2 = new JInternalFrame();
        // inf3 = new JInternalFrame();
        // inf4 = new JInternalFrame();
        // inf5 = new JInternalFrame();

        // inf1.setLayout(new FLowLayout());
        inf1.add(pComponent);
        inf1.add(maketool, BorderLayout.NORTH);
        inf1.add(pShip, BorderLayout.CENTER);
        inf1.add(rest, BorderLayout.SOUTH);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) inf1.getUI()).setNorthPane(null);
        // inf1.setSize(500, 500);
        inf1.pack();
        inf1.setMaximumSize(new Dimension(500, 500));
        inf1.setLocation(200, 280);
        // inf1.getContentPane().add(new JLabel("rocket"));
        // inf1.setUndecorated(true);
        // inf1.pack();
        inf1.setVisible(true);

        pButton.setLayout(new BorderLayout(5, 5));
        pButton.setBackground(Color.BLACK);
        pButton.add(maketool, BorderLayout.NORTH);
        pButton.add(pShip, BorderLayout.CENTER);
        pButton.add(rest, BorderLayout.SOUTH);

        pAll.setLayout(new FlowLayout(FlowLayout.CENTER));
        pAll.add(pLabel);
        pAll.setSize(100, 100);

        pComponent.setLayout(new BorderLayout(100, 100));
        pComponent.setBackground(Color.BLACK);
        // pComponent.add(title1, BorderLayout.NORTH);
        // pComponent.add(pAll, BorderLayout.NORTH);
        pComponent.add(pButton, BorderLayout.CENTER);
        // pComponent.add(pComponent);
        inf1.add(pComponent);
        dp1.add(inf1);

        // rocket panel
        pRocket.setLayout(new BorderLayout(5,40));
        pRocket.add(pAll, BorderLayout.NORTH);
        pRocket.add(inf1, BorderLayout.SOUTH);
        pRocket.setBackground(new Color(0,0,0,0));

        pAll.setLocation(30, 30);
        fr.setLayout(new FlowLayout());
        // fr.add(pAll);
        fr.add(pRocket);
        fr.add(pRocket);
        // fr.add(pComponent);
        fr.getContentPane().setBackground(Color.darkGray);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(1080, 960);
        // fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        // fr.setResizable(false);

    }

    public static void main(String[] args) {
        new MainUI();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; // cast for java2
        // my graphics:
        g2.setColor(Color.GREEN);
        // g2.drawCircle(g, 30, 30, 20);
        g2.fillRect(10, 10, 200, 50);
        // g2.setColor(new Color(0,0,255));
        g2.drawString("Hello World", 10, 10);

        super.paintComponent(g);
    }
    // public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
    // cg.drawOval(xCenter-r, yCenter-r, 2*r, 2*r);
    // }
}
