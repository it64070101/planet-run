
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.border.EmptyBorder;

import java.util.*;

public class MainUI extends JPanel implements ActionListener {

    private JFrame fr;
    private JPanel pAll, pShip, pHuntingGround, pSectors, pGadget, pRest, pLabel, pButton, pMaketool, pComponent,
            pRocket, pHuntAll, pSec, pInmain;
    private JButton noseCone, shockcord, recoveryWadding, leftFin, rightFin;
    private JButton sectorA, sectorB, sectorC, sectorD, rest, maketool;
    private JButton huntingGround0, huntingGround1;
    // private JButton gun, axe, hammer, pick, hook;
    private JTextField dayTxt, foodTxt, starTxt, triangleTxt, squareTxt, circleTxt, title1, HPTxt, energyTxt;
    private ImageIcon rockcone, rockleft, rockright, rockbase, rockbody, sec1, sec2, sec3, sec4, ani1, ani2, queSym;
    private JDesktopPane dp1;
    private JInternalFrame inf1, inf2, inf3, inf4, inf5, inf6, inf7;
    private JLabel name;

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
        rockcone = new ImageIcon("images/rockcone.png");
        rockleft = new ImageIcon("images/rockleft.png");
        rockright = new ImageIcon("images/rockright.png");
        rockbase = new ImageIcon("images/rockbase.png");
        rockbody = new ImageIcon("images/rockbody.png");

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
        queSym = new ImageIcon("images/ques.png");
        sec1 = new ImageIcon("images/Sec1.png");
        sec2 = new ImageIcon("images/Sec2.png");
        sec3 = new ImageIcon("images/Sec3.png");
        sec4 = new ImageIcon("images/Sec4.png");
        sectorA = new JButton("Explore this Sector", queSym);
        sectorB = new JButton("Explore this Sector", queSym);
        sectorC = new JButton("Explore this Sector", queSym);
        sectorD = new JButton("Explore this Sector", queSym);
//        sectorA.setBackground(Color.GRAY);
        rest = new JButton("Rest");
        maketool = new JButton("Make Tool");
        sectorA.setPreferredSize(new Dimension(250, 160));
        sectorB.setPreferredSize(new Dimension(250, 160));
        sectorC.setPreferredSize(new Dimension(250, 160));
        sectorD.setPreferredSize(new Dimension(250, 160));

        rest.setPreferredSize(new Dimension(100, 50));
        maketool.setPreferredSize(new Dimension(100, 50));

        pSectors.setLayout(new GridLayout(4, 1, 50, 50));
        pSectors.add(sectorA);
        pSectors.add(sectorB);
        pSectors.add(sectorC);
        pSectors.add(sectorD);
        pSectors.setBackground(new Color(0, 0, 0, 0));
        pSec = new JPanel();
        pSec.setLayout(new FlowLayout());
        pSec.add(pSectors);
        pSec.setAlignmentX(Component.LEFT_ALIGNMENT);
        pSec.setBackground(new Color(0, 0, 0, 0));

        ani1 = new ImageIcon("images/Ani.png");
        ani2 = new ImageIcon("images/Ani.png");
        huntingGround0 = new JButton("Fight this Animal", ani1);
        huntingGround1 = new JButton("Fight this Animal", ani2);

        pHuntingGround.setLayout(new GridLayout(2, 1, 50, 50));
        pHuntingGround.add(huntingGround0);
        pHuntingGround.add(huntingGround1);
        huntingGround0.setPreferredSize(new Dimension(350, 220));
        huntingGround1.setPreferredSize(new Dimension(350, 220));
        pHuntingGround.setBackground(new Color(0, 0, 0, 0));
        pHuntAll = new JPanel();
        pHuntAll.setLayout(new FlowLayout());
        pHuntAll.add(pHuntingGround);
        pHuntAll.setBackground(new Color(0, 0, 0, 0));

        dayTxt = new JTextField("Day: " + Main.day);
        foodTxt = new JTextField("Food: " + Storage.food.getAmount());
        starTxt = new JTextField("Star: " + Storage.star.getAmount());
        triangleTxt = new JTextField("Triangle: " + Storage.triangle.getAmount());
        squareTxt = new JTextField("Square: " + Storage.square.getAmount());
        circleTxt = new JTextField("Circle: " + Storage.circle.getAmount());
        title1 = new JTextField("Planet Run!");
        HPTxt = new JTextField("HP: " + Player.HP);
        energyTxt = new JTextField("Energy: " + Player.energy);
        name = new JLabel(Player.name);

        pLabel.add(name);
        pLabel.add(dayTxt);
        pLabel.add(HPTxt);
        pLabel.add(energyTxt);
        pLabel.add(foodTxt);
        pLabel.add(starTxt);
        pLabel.add(triangleTxt);
        pLabel.add(squareTxt);
        pLabel.add(circleTxt);

        dayTxt.setEditable(false);
        HPTxt.setEditable(false);
        energyTxt.setEditable(false);
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

        pInmain = new JPanel();
        pInmain.setLayout(new GridLayout(1, 3, 50, 50));
        pInmain.add(pSec);
        pInmain.add(pRocket);
        pInmain.add(pHuntAll);
        pInmain.setBackground(new Color(0, 0, 0, 0));
        pInmain.setBorder(new EmptyBorder(100,20,20,20));
        // pInmain.setFill(true);

        // rocket panel
        pRocket.setLayout(new BorderLayout(5, 40));
        pRocket.add(pAll, BorderLayout.NORTH);
        pRocket.add(inf1, BorderLayout.SOUTH);
        pRocket.setBackground(new Color(0, 0, 0, 0));

        pAll.setLocation(30, 30);
        fr.setLayout(new FlowLayout());
        fr.add(pInmain);
        // fr.add(pAll);
        // fr.add(pRocket);
        // fr.add(pSectors, FlowLayout.LEFT);
        // fr.add(pHuntingGround);
        // fr.add(pComponent);
        fr.getContentPane().setBackground(Color.darkGray);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(1280, 960);
        // fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
        // fr.setResizable(false);

        maketool.addActionListener(this);
        sectorA.addActionListener(this);
        sectorB.addActionListener(this);
        sectorC.addActionListener(this);
        sectorD.addActionListener(this);
        huntingGround0.addActionListener(this);
        huntingGround1.addActionListener(this);
        rest.addActionListener(this);
        noseCone.addActionListener(this);
        shockcord.addActionListener(this);
        recoveryWadding.addActionListener(this);
        leftFin.addActionListener(this);
        rightFin.addActionListener(this);

        // fr.setFill(true);
    }

    public static void main(String[] args) {
        MainUI mainUI = new MainUI();
        // mainUI.run();
        // Thread n1 = new Thread(mainUI);
        // n1.start();
    }

//     public void paintComponent(Graphics g) {
    // Graphics2D g2 = (Graphics2D) g; // cast for java2
    // my graphics:
    // g2.setColor(Color.GREEN);
    // g2.drawCircle(g, 30, 30, 20);
    // g2.fillRect(10, 10, 200, 50);
    // g2.setColor(new Color(0,0,255));
    // g2.drawString("Hello World", 10, 10);
//         super.paintComponent(g);
//     }
    // public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
    // cg.drawOval(xCenter-r, yCenter-r, 2*r, 2*r);
    // }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(maketool)) {
            new Maketool();
        }
        else if (e.getSource().equals(sectorA)) {
            sectorA.setIcon(sec1);
            sectorA.setText("SectorsAAAA");
            // sectorA.setEnabled(false);
        }
        else if (e.getSource().equals(sectorB)) {
            sectorB.setIcon(sec2);
            sectorB.setText("SectorsBBBB");
            // sectorB.setEnabled(false);
        }
        else if (e.getSource().equals(sectorC)) {
            sectorC.setIcon(sec3);
            sectorC.setText("SectorsCCCC");
            // sectorC.setEnabled(false);
        }
        else if (e.getSource().equals(sectorD)) {
            sectorD.setIcon(sec4);
            sectorD.setText("SectorsDDDD");
            // sectorD.setEnabled(false);
        }
        else if (e.getSource().equals(huntingGround0)) {
            huntingGround0.setEnabled(false);
            huntingGround0.setText("Animal Killed!");
        }
        else if (e.getSource().equals(huntingGround1)) {
            huntingGround1.setEnabled(false);
            huntingGround1.setText("Animal Killed!");
        }
        else if (e.getSource().equals(rest)) {
            Player.rest(energyInput());
        }
        else if (e.getSource().equals(noseCone)){
            if (Player.fix(Ship.noseCone)){
                noseCone.setEnabled(false);
            }
        }
        else if (e.getSource().equals(shockcord)){
            if (Player.fix(Ship.shockcord)){
                shockcord.setEnabled(false);
            }
        }
        else if (e.getSource().equals(recoveryWadding)){
            if (Player.fix(Ship.recoveryWadding)){
                recoveryWadding.setEnabled(false);
            }
        }
        else if (e.getSource().equals(leftFin)){
            if (Player.fix(Ship.leftFin)){
                leftFin.setEnabled(false);
            }
        }
        else if (e.getSource().equals(rightFin)){
            if (Player.fix(Ship.rightFin)){
                rightFin.setEnabled(false);
            }
        }
        update();

    }

    public void update() {
        dayTxt.setText("Day: " + Main.day);
        foodTxt.setText("Food: " + Storage.food.getAmount());
        starTxt.setText("Star: " + Storage.star.getAmount());
        triangleTxt.setText("Triangle: " + Storage.triangle.getAmount());
        squareTxt.setText("Square: " + Storage.square.getAmount());
        circleTxt.setText("Circle: " + Storage.circle.getAmount());
        title1.setText("Planet Run!");
        HPTxt.setText("HP: " + Player.HP);
        energyTxt.setText("Energy: " + Player.energy);
    }

    public int energyInput() {
        String num = "";
        
        do {
            num = JOptionPane.showInputDialog(null, "How Many Energy (Number)");
            if (num == null){
                num = "0";
            }

        } while (!isNumeric(num) || num.equals("") || Integer.parseInt(num) > Player.energy || 0 == Integer.parseInt(num));
        return Integer.parseInt(num);

    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

// public void run() {
//         while(fr.isValid()){
//             try{
//                 pSectors.setLocation(pSectors.getLocation().x+((int)(Math.random()* 20)-10), pSectors.getLocation().y+((int)(Math.random()* 20)-10));
//                 Thread.sleep(100);
//             }
//             catch (InterruptedException ex){
//                     ex.printStackTrace();
//                 }
//             }
//         }
}
