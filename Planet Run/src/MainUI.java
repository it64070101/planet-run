
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;

import java.util.*;

public class MainUI extends JPanel implements ActionListener, Runnable{

    private JFrame fr;
    private JPanel pAll, pShip, pHuntingGround, pSectors, pGadget, pRest, pLabel, pButton, pMaketool, pComponent,
            pRocket, pHuntAll, pSec, pInmain, pInRocket, showclock;
    private JButton noseCone, shockcord, recoveryWadding, leftFin, rightFin;
    private JButton sectorA, sectorB, sectorC, sectorD, rest, maketool;
    private JButton huntingGround0, huntingGround1;
    private JButton exit;
    private JTextField dayTxt, foodTxt, starTxt, triangleTxt, squareTxt, circleTxt, title1, HPTxt, energyTxt;
    private ImageIcon rockcone, rockleft, rockright, rockbase, rockbody, sec1, sec2, sec3, sec4, ani1, ani2, queSym;
    private JLabel name, clockshow;
    public MainUI() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenDPI = Toolkit.getDefaultToolkit().getScreenResolution();
        double scaleTest = (double)96/screenDPI;
        System.out.println(screenDPI+ " hey " + scaleTest);
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
        pInRocket = new JPanel();
        pRocket = new JPanel();
        rockcone = new ImageIcon("src/images/rockcone.png");
        rockleft = new ImageIcon("src/images/rockleft.png");
        rockright = new ImageIcon("src/images/rockright.png");
        rockbase = new ImageIcon("src/images/rockbase.png");
        rockbody = new ImageIcon("src/images/rockbody.png");

        // BorderLayout layout01 = new BorderLayout();
        // layout01.setBackground(Color.BLACK);

        noseCone = new JButton(rockcone);
        shockcord = new JButton(rockbody);
        recoveryWadding = new JButton(rockbase);
        leftFin = new JButton(rockleft);
        rightFin = new JButton(rockright);

        noseCone.setPreferredSize(new Dimension((int)(100*scaleTest), (int)(100*scaleTest)));
        shockcord.setPreferredSize(new Dimension((int)(150*scaleTest), (int)(200*scaleTest)));
        recoveryWadding.setPreferredSize(new Dimension(100, 100));
        leftFin.setPreferredSize(new Dimension((int)(100*scaleTest), (int)(100*scaleTest)));
        rightFin.setPreferredSize(new Dimension((int)(100*scaleTest), (int)(100*scaleTest)));
        
        noseCone.setBackground(new Color(98, 79, 130));
        shockcord.setBackground(new Color(98, 79, 130));
        recoveryWadding.setBackground(new Color(98, 79, 130));
        leftFin.setBackground(new Color(98, 79, 130));
        rightFin.setBackground(new Color(98, 79, 130));

        pShip.setLayout(new BorderLayout(5, 5));
        pShip.setBackground(Color.BLACK);
        pShip.setSize((int)(128*scaleTest), (int)(128*scaleTest));
        pShip.add(noseCone, BorderLayout.NORTH);
        pShip.add(shockcord, BorderLayout.CENTER);
        pShip.add(recoveryWadding, BorderLayout.SOUTH);
        pShip.add(leftFin, BorderLayout.WEST);
        pShip.add(rightFin, BorderLayout.EAST);
        
        
        queSym = new ImageIcon("src/images/ques.png");
        sec1 = new ImageIcon("src/images/Sec1.png");
        sec2 = new ImageIcon("src/images/Sec2.png");
        sec3 = new ImageIcon("src/images/Sec3.png");
        sec4 = new ImageIcon("src/images/Sec4.png");
        sectorA = new JButton("Explore this Sector", queSym);
        sectorB = new JButton("Explore this Sector", queSym);
        sectorC = new JButton("Explore this Sector", queSym);
        sectorD = new JButton("Explore this Sector", queSym);
        sectorA.setPreferredSize(new Dimension((int)(250*scaleTest), (int)(160*scaleTest)));
        sectorB.setPreferredSize(new Dimension((int)(250*scaleTest), (int)(160*scaleTest)));
        sectorC.setPreferredSize(new Dimension((int)(250*scaleTest), (int)(160*scaleTest)));
        sectorD.setPreferredSize(new Dimension((int)(250*scaleTest), (int)(160*scaleTest)));
        sectorA.setFont(new Font("Ink Free", Font.BOLD, (int)(15*scaleTest)));
        sectorB.setFont(new Font("Ink Free", Font.BOLD, (int)(15*scaleTest)));
        sectorC.setFont(new Font("Ink Free", Font.BOLD, (int)(15*scaleTest)));
        sectorD.setFont(new Font("Ink Free", Font.BOLD, (int)(15*scaleTest)));
        sectorA.setBackground(new Color(63, 0, 113));
        sectorB.setBackground(new Color(63, 0, 113));
        sectorC.setBackground(new Color(63, 0, 113));
        sectorD.setBackground(new Color(63, 0, 113));
        sectorA.setForeground(new Color(198, 151, 73));
        sectorB.setForeground(new Color(198, 151, 73));
        sectorC.setForeground(new Color(198, 151, 73));
        sectorD.setForeground(new Color(198, 151, 73));

        rest = new JButton("Rest");
        rest.setPreferredSize(new Dimension((int)(100*scaleTest), (int)(50*scaleTest)));
        rest.setBackground(new Color(63, 59, 108));
        rest.setForeground(new Color(163, 199, 214));
        rest.setFont(new Font("Ink Free", Font.BOLD, (int)(35*scaleTest)));
        
        maketool = new JButton("Make Tool");
        maketool.setPreferredSize(new Dimension((int)(100*scaleTest), (int)(50*scaleTest)));
        maketool.setBackground(new Color(63, 59, 108));
        maketool.setForeground(new Color(163, 199, 214));
        maketool.setFont(new Font("Ink Free", Font.BOLD, (int)(35*scaleTest)));

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

        ani1 = new ImageIcon("src/images/Ani1.png");
        ani2 = new ImageIcon("src/images/Ani2.png");
        huntingGround0 = new JButton("Fight this Animal", ani1);
        huntingGround1 = new JButton("Fight this Animal", ani2);
        pHuntingGround.setLayout(new GridLayout(2, 1, (int)(50*scaleTest), (int)(50*scaleTest)));
        pHuntingGround.add(huntingGround0);
        pHuntingGround.add(huntingGround1);
        huntingGround0.setPreferredSize(new Dimension((int)(350*scaleTest), (int)(220*scaleTest)));
        huntingGround1.setPreferredSize(new Dimension((int)(350*scaleTest), (int)(220*scaleTest)));
        huntingGround0.setBackground(new Color(63, 0, 113));
        huntingGround0.setForeground(new Color(255,255,255));
        huntingGround0.setFont(new Font("Ink Free", Font.BOLD, (int)(20*scaleTest)));
        huntingGround1.setBackground(new Color(63, 0, 113));
        huntingGround1.setForeground(new Color(255,255,255));
        pHuntingGround.setBackground(new Color(0, 0, 0, 0));
        huntingGround1.setFont(new Font("Ink Free", Font.BOLD, (int)(20*scaleTest)));
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
        pLabel.setBackground(new Color(24, 39, 71));
        
        dayTxt.setBackground(new Color(24, 39, 71));
        dayTxt.setForeground(new Color(245, 213, 174));
        foodTxt.setBackground(new Color(24, 39, 71));
        foodTxt.setForeground(new Color(245, 213, 174));
        starTxt.setBackground(new Color(24, 39, 71));
        starTxt.setForeground(new Color(245, 213, 174));
        triangleTxt.setBackground(new Color(24, 39, 71));
        triangleTxt.setForeground(new Color(245, 213, 174));
        squareTxt.setBackground(new Color(24, 39, 71));
        squareTxt.setForeground(new Color(245, 213, 174));
        circleTxt.setBackground(new Color(24, 39, 71));
        circleTxt.setForeground(new Color(245, 213, 174));
        title1.setBackground(new Color(24, 39, 71));
        title1.setForeground(new Color(245, 213, 174));
        HPTxt.setBackground(new Color(24, 39, 71));
        HPTxt.setForeground(new Color(245, 213, 174));
        energyTxt.setBackground(new Color(24, 39, 71));
        energyTxt.setForeground(new Color(245, 213, 174));
        name.setBackground(new Color(24, 39, 71));
        name.setForeground(new Color(245, 213, 174));

        dayTxt.setEditable(false);
        HPTxt.setEditable(false);
        energyTxt.setEditable(false);
        foodTxt.setEditable(false);
        starTxt.setEditable(false);
        triangleTxt.setEditable(false);
        squareTxt.setEditable(false);
        circleTxt.setEditable(false);


        pButton.setLayout(new BorderLayout(5, 5));
        pButton.setBackground(Color.BLACK);
        pButton.add(maketool, BorderLayout.NORTH);
        pButton.add(pShip, BorderLayout.CENTER);
        pButton.add(rest, BorderLayout.SOUTH);

        pAll.setLayout(new FlowLayout(FlowLayout.CENTER));
        pAll.add(pLabel);
        pAll.setSize(100, 100);
        pAll.setBackground(new Color(24, 39, 71));
        pAll.setForeground(new Color(254, 194, 96));

        // pComponent.setLayout(new BorderLayout(20, 100));
        // pComponent.setBackground(Color.BLACK);
        // pComponent.add(pButton, BorderLayout.CENTER);

        // pInmain = new JPanel();
        // pInmain.setLayout(new GridLayout(1, 3, 50, 50));
        // pInmain.add(pSec);
        // pInmain.add(pRocket);
        // pInmain.add(pHuntAll);
        // pInmain.setBackground(Color.darkGray);
        // pInmain.setBorder(new EmptyBorder(20,20,20,20));

        showclock = new JPanel();
        clockshow = new JLabel("");
        showclock.setForeground(new Color(234, 234, 234));
        showclock.add(clockshow);
        showclock.setSize(200,200);
        showclock.setBackground(new Color(249, 102, 102));
        
        
        pSec.setBounds((int) ((screenSize.width-(screenSize.width/1.075))*scaleTest),(int) ((screenSize.height-(screenSize.height/1.1))*scaleTest), (int)(250*scaleTest),(int)(1000*scaleTest));
        pRocket.setBounds((int) ((screenSize.width-(screenSize.width/1.345))*scaleTest),(int) ((screenSize.height-(screenSize.height/1.1))*scaleTest), (int)(700*scaleTest),(int)(850*scaleTest));
        pHuntAll.setBounds((int) ((screenSize.width-(screenSize.width/3.25))*scaleTest),(int) ((screenSize.height-(screenSize.height/1.1))*scaleTest), (int)(500*scaleTest),(int)(500*scaleTest));
        fr.add(showclock);
        showclock.setBounds((int) ((screenSize.width-(screenSize.width/1.5))*scaleTest),(int) ((screenSize.height-(screenSize.height/1.225))*scaleTest), (int)(300*scaleTest),(int)(60*scaleTest));
        exit = new JButton("exit");
        exit.setBounds((int) ((screenSize.width-325)*scaleTest),(int) ((screenSize.height-150)*scaleTest),(int) (250*scaleTest),(int) (75*scaleTest));
        exit.setBackground(new Color(220, 95, 0));
        exit.setForeground(new Color(238, 238, 238));

        // rocket panel
        pRocket.setLayout(new BorderLayout(150,180));
        pRocket.add(pAll, BorderLayout.NORTH);
        pRocket.add(pButton, BorderLayout.CENTER);
        pRocket.setBackground(new Color(0,0,0,0));
       

        pAll.setLocation(30, 30);
        
        fr.getContentPane().setBackground(new Color(0,0,0,0));
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fr.setSize(screenSize.width, screenSize.height);
        fr.setUndecorated(true);
        fr.setLayout(null);
        fr.add(exit);
        fr.add(pSec);
        fr.add(pRocket);
        fr.add(pHuntAll);
        
        
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);

        
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
        fr.setResizable(false);


        
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
        exit.addActionListener(this);

    }

    public static void main(String[] args) {
        MainUI mainUI = new MainUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(maketool)) {
            new Maketool();
        }
        else if (e.getSource().equals(sectorA)) {
            sectorA.setIcon(sec1);
            sectorA.setBackground(new Color(69, 60, 103));
            sectorA.setForeground(new Color(242, 247, 161));
            sectorA.setText("Sectors A");
            // sectorA.setEnabled(false);
        }
        else if (e.getSource().equals(sectorB)) {
            sectorB.setIcon(sec2);
            sectorB.setBackground(new Color(69, 60, 103));
            sectorB.setForeground(new Color(242, 247, 161));
            sectorB.setText("Sectors B");
            // sectorB.setEnabled(false);
        }
        else if (e.getSource().equals(sectorC)) {
            sectorC.setIcon(sec3);
            sectorC.setBackground(new Color(69, 60, 103));
            sectorC.setForeground(new Color(242, 247, 161));
            sectorC.setText("Sectors C");
            // sectorC.setEnabled(false);
        }
        else if (e.getSource().equals(sectorD)) {
            sectorD.setIcon(sec4);
            sectorD.setBackground(new Color(69, 60, 103));
            sectorD.setForeground(new Color(242, 247, 161));
            sectorD.setText("Sectors D");
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
                noseCone.setBackground(new Color(159, 115, 171));
            }
        }
        else if (e.getSource().equals(shockcord)){
            if (Player.fix(Ship.shockcord)){
                shockcord.setEnabled(false);
                shockcord.setBackground(new Color(159, 115, 171));
            }
        }
        else if (e.getSource().equals(recoveryWadding)){
            if (Player.fix(Ship.recoveryWadding)){
                recoveryWadding.setEnabled(false);
                recoveryWadding.setBackground(new Color(159, 115, 171));
            }
        }
        else if (e.getSource().equals(leftFin)){
            if (Player.fix(Ship.leftFin)){
                leftFin.setEnabled(false);
                leftFin.setBackground(new Color(159, 115, 171));
            }
        }
        else if (e.getSource().equals(rightFin)){
            if (Player.fix(Ship.rightFin)){
                rightFin.setEnabled(false);
                rightFin.setBackground(new Color(159, 115, 171));
            }
        }
        else if (e.getSource().equals(exit)){
            System.exit(0);
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
    
    public void run(){
        int count = 0;
        int sec = 0;
        int min = 0;
        int hour = 0; 
        
        while (true){
            clockshow.setFont(new Font("Tahoma", Font.PLAIN, 32));
            clockshow.setText(String.format("%02d", hour)+" : "+ String.format("%02d", min)+ " : " + String.format("%02d", sec));
            System.out.println(sec);
            try{
            Thread.sleep(1000);
            count++;
            sec = count%60;
            min = (count/60)%60;
            hour = count/3600;
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
        }
      
        
    }

}
