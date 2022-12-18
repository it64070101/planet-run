
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

public class MainUI extends JPanel implements ActionListener, Runnable {

    public static JFrame fr;
    private static JPanel pAll, pShip, pHuntingGround, pSectors, pGadget, pRest, pLabel, pButton, pMaketool, pComponent,
            pRocket, pHuntAll, pSec, pInmain, pInRocket, showclock;
    private static JButton noseCone, shockcord, recoveryWadding, leftFin, rightFin;
    private static JButton sector1, sector2, sector3, sector4, rest, maketool;
    public static JButton huntingGround0, huntingGround1;
    private static JButton exit;
    private static JTextField dayTxt, foodTxt, starTxt, triangleTxt, squareTxt, circleTxt, title1, HPTxt, energyTxt;
    public static ImageIcon rockcone, rockleft, rockright, rockbase, rockbody, sec1, sec2, sec3, sec4, ani1, ani2,ani3, ani4,ani5, ani6, queSym;
    private static JLabel name, clockshow;

    private static JPanel pInput, pEnergy, pEat;
    private static ButtonGroup group;
    private static JRadioButton e1, e2, e3, e4, e5, e6;
    private static JLabel howMany;
    private static JSlider slider;
    
    public static int day;
    private static int sec;
    public static int score;
    public static Animal[] huntingGround;
    public static Animal[] animalDeck;

    public MainUI() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenDPI = Toolkit.getDefaultToolkit().getScreenResolution();
        double scaleTest = (double)96/screenDPI;
        day = 0;
        sec = 0;

        huntingGround = new Animal[2];
        animalDeck = new Animal[6];

        animalDeck[0] = new BirdKing();
        animalDeck[1] = new DoubleDog();
        animalDeck[2] = new Fourleg();
        animalDeck[3] = new Fishman();
        animalDeck[4] = new Snailbox();
        animalDeck[5] = new Rhinocow();

        ani1 = new ImageIcon("src/images/Ani1.png");
        ani2 = new ImageIcon("src/images/Ani2.png");
        ani3 = new ImageIcon("src/images/Ani3.png");
        ani4 = new ImageIcon("src/images/Ani4.png");
        ani5 = new ImageIcon("src/images/Ani5.png");
        ani6 = new ImageIcon("src/images/Ani6.png");

        while(huntingGround[0] == null){
            int redrawing = (int) (Math.random() * 10) % 6;
            huntingGround[0] = animalDeck[redrawing];
            animalDeck[redrawing] = null;
            if(huntingGround[0] instanceof BirdKing){
                huntingGround0 = new JButton("Fight this Animal", ani1);
            }else if (huntingGround[0] instanceof DoubleDog){
                huntingGround0 = new JButton("Fight this Animal", ani2);
            }else if (huntingGround[0] instanceof Fourleg){
                huntingGround0 = new JButton("Fight this Animal", ani3);
            }else if (huntingGround[0] instanceof Fishman){
                huntingGround0 = new JButton("Fight this Animal", ani4);
            }else if (huntingGround[0] instanceof Snailbox){
                huntingGround0 = new JButton("Fight this Animal", ani5);
            }else if (huntingGround[0] instanceof Rhinocow){
                huntingGround0 = new JButton("Fight this Animal", ani6);
            }  
        }
        while(huntingGround[1] == null){
            int redrawing = (int) (Math.random() * 10) % 6;
            huntingGround[1] = animalDeck[redrawing];
            animalDeck[redrawing] = null;
            if(huntingGround[1] instanceof BirdKing){
                huntingGround1 = new JButton("Fight this Animal", ani1);
            }else if (huntingGround[1] instanceof DoubleDog){
                huntingGround1 = new JButton("Fight this Animal", ani2);
            }else if (huntingGround[1] instanceof Fourleg){
                huntingGround1 = new JButton("Fight this Animal", ani3);
            }else if (huntingGround[1] instanceof Fishman){
                huntingGround1 = new JButton("Fight this Animal", ani4);
            }else if (huntingGround[1] instanceof Snailbox){
                huntingGround1 = new JButton("Fight this Animal", ani5);
            }else if (huntingGround[1] instanceof Rhinocow){
                huntingGround1 = new JButton("Fight this Animal", ani6);
            }
        }

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

        noseCone = new JButton(rockcone);
        shockcord = new JButton(rockbody);
        recoveryWadding = new JButton(rockbase);
        leftFin = new JButton(rockleft);
        rightFin = new JButton(rockright);

        noseCone.setPreferredSize(new Dimension(screenScale(100), screenScale(100)));
        shockcord.setPreferredSize(new Dimension(screenScale(150), screenScale(200)));
        recoveryWadding.setPreferredSize(new Dimension(screenScale(100), screenScale(100)));
        leftFin.setPreferredSize(new Dimension(screenScale(100), screenScale(100)));
        rightFin.setPreferredSize(new Dimension(screenScale(100), screenScale(100)));

        noseCone.setBackground(new Color(98, 79, 130));
        shockcord.setBackground(new Color(98, 79, 130));
        recoveryWadding.setBackground(new Color(98, 79, 130));
        leftFin.setBackground(new Color(98, 79, 130));
        rightFin.setBackground(new Color(98, 79, 130));

        pShip.setLayout(new BorderLayout(screenScale(5), screenScale(5)));
        pShip.setBackground(Color.BLACK);
        pShip.setSize(screenScale(128), screenScale(128));
        pShip.add(noseCone, BorderLayout.NORTH);
        pShip.add(shockcord, BorderLayout.CENTER);
        pShip.add(recoveryWadding, BorderLayout.SOUTH);
        pShip.add(leftFin, BorderLayout.WEST);
        pShip.add(rightFin, BorderLayout.EAST);

        queSym = new ImageIcon("src/images/ques.png");
        sec1 = new ImageIcon("src/images/Forest.png");
        sec2 = new ImageIcon("src/images/Desert.png");
        sec3 = new ImageIcon("src/images/Mountain.png");
        sec4 = new ImageIcon("src/images/Altar.png");
        sector1 = new JButton("Explore this Sector", queSym);
        sector2 = new JButton("Explore this Sector", queSym);
        sector3 = new JButton("Explore this Sector", queSym);
        sector4 = new JButton("Explore this Sector", queSym);

        sector1.setPreferredSize(new Dimension(screenScale(250), screenScale(160)));
        sector2.setPreferredSize(new Dimension(screenScale(250), screenScale(160)));
        sector3.setPreferredSize(new Dimension(screenScale(250), screenScale(160)));
        sector4.setPreferredSize(new Dimension(screenScale(250), screenScale(160)));
        sector1.setFont(new Font("Ink Free", Font.BOLD, screenScale(15)));
        sector2.setFont(new Font("Ink Free", Font.BOLD, screenScale(15)));
        sector3.setFont(new Font("Ink Free", Font.BOLD, screenScale(15)));
        sector4.setFont(new Font("Ink Free", Font.BOLD, screenScale(15)));
        sector1.setBackground(new Color(192, 96, 161));
        sector2.setBackground(new Color(192, 96, 161));
        sector3.setBackground(new Color(192, 96, 161));
        sector4.setBackground(new Color(192, 96, 161));
        sector1.setForeground(new Color(198, 151, 73));
        sector2.setForeground(new Color(198, 151, 73));
        sector3.setForeground(new Color(198, 151, 73));
        sector4.setForeground(new Color(198, 151, 73));

        rest = new JButton("Rest");
        rest.setPreferredSize(new Dimension(screenScale(100), screenScale(50)));
        rest.setBackground(new Color(63, 59, 108));
        rest.setForeground(new Color(163, 199, 214));
        rest.setFont(new Font("Ink Free", Font.BOLD, screenScale(35)));
        rest.setToolTipText("Heal 1HP/Energy");

        maketool = new JButton("Make Tool");
        maketool.setPreferredSize(new Dimension(screenScale(100), screenScale(50)));
        maketool.setBackground(new Color(63, 59, 108));
        maketool.setForeground(new Color(163, 199, 214));
        maketool.setFont(new Font("Ink Free", Font.BOLD, screenScale(35)));
        maketool.setToolTipText("Crafting your Gadgets");

        pSectors.setLayout(new GridLayout(4, 1, screenScale(50), screenScale(50)));
        pSectors.add(sector1);
        pSectors.add(sector2);
        pSectors.add(sector3);
        pSectors.add(sector4);
        pSectors.setBackground(new Color(0, 0, 0, 0));
        pSec = new JPanel();
        pSec.setLayout(new FlowLayout());
        pSec.add(pSectors);
        pSec.setAlignmentX(Component.LEFT_ALIGNMENT);
        pSec.setBackground(new Color(0, 0, 0, 0));

        pHuntingGround.setLayout(new GridLayout(2, 1, screenScale(50), screenScale(50)));
        pHuntingGround.add(huntingGround0);
        pHuntingGround.add(huntingGround1);
        huntingGround0.setPreferredSize(new Dimension(screenScale(350), screenScale(220)));
        huntingGround1.setPreferredSize(new Dimension(screenScale(350), screenScale(220)));
        huntingGround0.setBackground(new Color(192, 96, 161));

        huntingGround0.setForeground(new Color(255,255,255));
        huntingGround0.setFont(new Font("Ink Free", Font.BOLD, screenScale(20)));

        huntingGround1.setBackground(new Color(192, 96, 161));
        huntingGround1.setForeground(new Color(255, 255, 255));
        pHuntingGround.setBackground(new Color(0, 0, 0, 0));
        huntingGround1.setFont(new Font("Ink Free", Font.BOLD, screenScale(20)));
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

        slider = new JSlider(1, 6, 1);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);

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

        pButton.setLayout(new BorderLayout(screenScale(5), screenScale(5)));
        pButton.setBackground(Color.BLACK);
        pButton.add(maketool, BorderLayout.NORTH);
        pButton.add(pShip, BorderLayout.CENTER);
        pButton.add(rest, BorderLayout.SOUTH);

        pAll.setLayout(new FlowLayout(FlowLayout.CENTER));
        pAll.add(pLabel);
        pAll.setSize(screenScale(100), screenScale(100));
        pAll.setBackground(new Color(24, 39, 71));
        pAll.setForeground(new Color(254, 194, 96));

        showclock = new JPanel();
        clockshow = new JLabel("");
        showclock.setForeground(new Color(234, 234, 234));
        showclock.add(clockshow);
        showclock.setSize(screenScale(200), screenScale(200));
        showclock.setBackground(new Color(249, 102, 102));
        
        pSec.setBounds(screenScale(0),screenScale(50), screenScale(450),screenScale(1000));
        pRocket.setBounds(screenScale(500),screenScale(50), screenScale(650),screenScale(850));
        pHuntAll.setBounds(screenScale(500+700),screenScale(50), screenScale(500),screenScale(500));
        add(showclock);
        showclock.setBounds(screenScale(500+350-150),screenScale(150), screenScale(250),screenScale(60));
        exit = new JButton("exit");
        exit.setBounds(screenScale(500+700+15+175),screenScale(825),screenScale(200),screenScale(75));

        exit.setBackground(new Color(220, 95, 0));
        exit.setForeground(new Color(238, 238, 238));

        // rocket panel
        pRocket.setLayout(new BorderLayout(screenScale(150),screenScale(180)));
        pRocket.add(pAll, BorderLayout.NORTH);
        pRocket.add(pButton, BorderLayout.CENTER);
        pRocket.setBackground(new Color(0, 0, 0, 0));

        pAll.setLocation(screenScale(30), screenScale(30));

        update();

//        fr.getContentPane().setBackground(new Color(0, 0, 0, 0));
//        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        fr.setSize(screenSize.width, screenSize.height);
//        fr.setUndecorated(true);
//        fr.setLayout(null);
//        fr.add(exit);
//        fr.add(pSec);
//        fr.add(pRocket);
//        fr.add(pHuntAll);
//
//        fr.setLocationRelativeTo(null);
//        fr.setVisible(true);
//
//        fr.setLocationRelativeTo(null);
//        fr.setVisible(true);
//        fr.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
//        fr.setResizable(false);
        
        setSize(screenSize.width, screenSize.height);
        setLayout(null);
        add(exit);
        add(pSec);
        add(pRocket);
        add(pHuntAll);
       
        maketool.addActionListener(this);
        sector1.addActionListener(this);
        sector2.addActionListener(this);
        sector3.addActionListener(this);
        sector4.addActionListener(this);
        huntingGround0.addActionListener(this);
        huntingGround1.addActionListener(this);
        rest.addActionListener(this);
        noseCone.addActionListener(this);
        shockcord.addActionListener(this);
        recoveryWadding.addActionListener(this);
        leftFin.addActionListener(this);
        rightFin.addActionListener(this);
        exit.addActionListener(this);

        pInput = new JPanel(new BorderLayout());
        pEnergy = new JPanel();
        group = new ButtonGroup();
        howMany = new JLabel("How many energy ?");

        e1 = new JRadioButton("1");
        e1.setActionCommand(e1.getText());
        e2 = new JRadioButton("2");
        e2.setActionCommand(e2.getText());
        e3 = new JRadioButton("3");
        e3.setActionCommand(e3.getText());
        e4 = new JRadioButton("4");
        e4.setActionCommand(e4.getText());
        e5 = new JRadioButton("5");
        e5.setActionCommand(e5.getText());
        e6 = new JRadioButton("6");
        e6.setActionCommand(e6.getText());

        group.add(e1);
        group.add(e2);
        group.add(e3);
        group.add(e4);
        group.add(e5);
        group.add(e6);

        pEnergy.add(e1);
        pEnergy.add(e2);
        pEnergy.add(e3);
        pEnergy.add(e4);
        pEnergy.add(e5);
        pEnergy.add(e6);

        pInput.add(howMany, BorderLayout.NORTH);
        pInput.add(slider);

        Main.day++;

    }

    public static void main(String[] args) {
        new Dice(6);
        new Player("Chokchai");
        new Storage();
        new Area();
        new Ship();
        new ToolBox();
        day = 0;

        huntingGround = new Animal[2];
        animalDeck = new Animal[6];
        MainUI frame = new MainUI();
        
        JFrame fr = new JFrame();
        fr.getContentPane().setBackground(new Color(0, 0, 0, 0));
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fr.setUndecorated(true);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
        fr.setResizable(false);
        fr.add(frame);
        JOptionPane.showMessageDialog(null, "You start day " + Main.day + " with " + Player.HP + " HP and " + Player.energy + " Energy.","Day "+Main.day,JOptionPane.PLAIN_MESSAGE);
        Thread n1 = new Thread(frame);
        n1.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(maketool)) {
           new Maketool();
           fr.setEnabled(false);
        } else if (e.getSource().equals(sector1)) {
            if (!Area.A.isExplored()) {
                Player.explore(Area.A, sliderInput());
            } else {
                Player.gather(Area.A, sliderInput());
            }
        } else if (e.getSource().equals(sector2)) {
            if (!Area.B.isExplored()) {
                Player.explore(Area.B, sliderInput());
            } else {
                Player.gather(Area.B, sliderInput());
            }
        } else if (e.getSource().equals(sector3)) {
            if (!Area.C.isExplored()) {
                Player.explore(Area.C, sliderInput());
            } else {
                Player.gather(Area.C, sliderInput());
            }
        } else if (e.getSource().equals(sector4)) {
            if (!Area.D.isExplored()) {
                Player.explore(Area.D, sliderInput());
            } else {
                Player.gather(Area.D, sliderInput());
            }
        } else if (e.getSource().equals(huntingGround0)) {
            Player.hunting(huntingGround[0], sliderInput());
            if(!huntingGround[0].getIsAlive()){
                huntingGround0.setEnabled(false);
                huntingGround0.setText("Animal Killed!");
                huntingGround0.setBackground(new Color(128, 128, 128));
                huntingGround[0] = null;
            }
        } else if (e.getSource().equals(huntingGround1)) {
            Player.hunting(huntingGround[1], sliderInput());
            if(!huntingGround[1].getIsAlive()){
                huntingGround1.setEnabled(false);
                huntingGround1.setText("Animal Killed!");
                huntingGround1.setBackground(new Color(128, 128, 128));
                huntingGround[1] = null;
            }
        } else if (e.getSource().equals(rest)) {
            Player.rest(restInput());
        } else if (e.getSource().equals(noseCone)) {
            if (Player.fix(Ship.noseCone)) {
                noseCone.setEnabled(false);
                noseCone.setBackground(new Color(159, 115, 171));
            }
        } else if (e.getSource().equals(shockcord)) {
            if (Player.fix(Ship.shockcord)) {
                shockcord.setEnabled(false);
                shockcord.setBackground(new Color(159, 115, 171));
            }
        } else if (e.getSource().equals(recoveryWadding)) {
            if (Player.fix(Ship.recoveryWadding)) {
                recoveryWadding.setEnabled(false);
                recoveryWadding.setBackground(new Color(159, 115, 171));
            }
        } else if (e.getSource().equals(leftFin)) {
            if (Player.fix(Ship.leftFin)) {
                leftFin.setEnabled(false);
                leftFin.setBackground(new Color(159, 115, 171));
            }
        } else if (e.getSource().equals(rightFin)) {
            if (Player.fix(Ship.rightFin)) {
                rightFin.setEnabled(false);
                rightFin.setBackground(new Color(159, 115, 171));
            }
        } else if (e.getSource().equals(exit)) {
            System.exit(0);
        }
        update();
        if (Player.HP < 1) {
            JOptionPane.showMessageDialog(null,"Your HP is below than 1. You lose.", "You Lose.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        endOfDay();
    }

    public static void update() {
        dayTxt.setText("Day: " + Main.day);
        foodTxt.setText("Food: " + Storage.food.getAmount());
        starTxt.setText("Star: " + Storage.star.getAmount());
        triangleTxt.setText("Triangle: " + Storage.triangle.getAmount());
        squareTxt.setText("Square: " + Storage.square.getAmount());
        circleTxt.setText("Circle: " + Storage.circle.getAmount());
        title1.setText("Planet Run!");
        HPTxt.setText("HP: " + Player.HP);
        energyTxt.setText("Energy: " + Player.energy);
        sectorDiscover(Area.A, sector1);
        sectorDiscover(Area.B, sector2);
        sectorDiscover(Area.C, sector3);
        sectorDiscover(Area.D, sector4);
        if(Player.HP >= 4){
            rest.setEnabled(false);
        }else{
            rest.setEnabled(true);
        }
    }

    public static int sliderInput() {
        slider.setMaximum(Player.energy);
        slider.setMinimum(1);
        int num = 0;
        howMany.setText("How many energy do you want to use ? ");
        JOptionPane.showMessageDialog(null, pInput, "Energy Input",JOptionPane.PLAIN_MESSAGE);
        num = slider.getValue();

        return num;

    }

    public static int sliderInput(int max) {
        int num = 0;
        if (Storage.food.getAmount() < 1) {
            num = 0;
        } else {
            if (max > 4){
                max = 4;
            }
            slider.setMaximum(max);
            slider.setMinimum(0);
            howMany.setText("How many food do you want to eat ? ");
            JOptionPane.showMessageDialog(null, pInput,"Food Input",JOptionPane.PLAIN_MESSAGE);
            num = slider.getValue();
        }
        return num;
    }
    
        public static int restInput() {
            int num;
            slider.setMaximum(4-Player.HP);
            slider.setMinimum(0);
            howMany.setText("How much do you want to rest ? (Using Energy)");
            JOptionPane.showMessageDialog(null, pInput, "Energy Input",JOptionPane.PLAIN_MESSAGE);
            num = slider.getValue();
        return num;
    }

    public static void sectorDiscover(Sector sector, JButton secBtn) {
        if (sector.isExplored()) {
            secBtn.setIcon(new ImageIcon("src/images/"+sector.getName()+".png"));
            secBtn.setBackground(new Color(247, 135, 87));
            secBtn.setForeground(new Color(242, 247, 161));
            secBtn.setText(sector.getName());
        } else {
            secBtn.setPreferredSize(new Dimension(250, 160));
            secBtn.setFont(new Font("Ink Free", Font.BOLD, 15));
            secBtn.setBackground(new Color(192, 96, 161));
            secBtn.setForeground(new Color(198, 151, 73));
        }

    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void run() {
        int count = 0;
        int min = 0;
        int hour = 0;

        while (true) {
            clockshow.setFont(new Font("Tahoma", Font.PLAIN, 32));
            clockshow.setText(String.format("%02d", hour) + " : " + String.format("%02d", min) + " : " + String.format("%02d", sec));
            try {
                Thread.sleep(1000);
                count++;
                sec = count % 60;
                min = (count / 60) % 60;
                hour = count / 3600;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static int screenScale(double pixel){
        int screenDPI = Toolkit.getDefaultToolkit().getScreenResolution();
        double scaleTest = (double)96/screenDPI;
        return (int)(pixel*scaleTest);
    }

    public static void select() {
        if (Player.energy < 6) {
            e6.setEnabled(false);
        }
        if (Player.energy < 5) {
            e5.setEnabled(false);
        }
        if (Player.energy < 4) {
            e4.setEnabled(false);
        }
        if (Player.energy < 3) {
            e3.setEnabled(false);
        }
        if (Player.energy < 2) {
            e2.setEnabled(false);
        }
        e1.setSelected(true);
    }
    
    public static int scoring(){
        double total = 0;
        //Fixer Bonus
        total += (Ship.partFixed*(Ship.partFixed+1))/2;
        //Rocketeering
        if(Ship.partFixed == 5){
            total += 30;
        }
        //Toolmaker
        total += ToolBox.toolMade;
        //Jack of all tools
        if(ToolBox.toolMade == 5){
            total += 10;
        }
        //Discoverer
        total += Area.areaExplored;
        //apex legend
        total += Player.animalKilled;
        //nas
        total += Player.HP;
        //un
        if(Player.HP == 4){
            total += 8;
        }
        System.out.println(total+" , "+sec);
        return (int)((total/sec)*1000);
    } 
    
    public static void endOfDay(){
        if (Player.energy < 1) {

            JOptionPane.showMessageDialog(null, "End day, time for dinner.", "", JOptionPane.PLAIN_MESSAGE);
            Player.eat(sliderInput(Storage.food.getAmount()));
            if (Player.HP < 1) {
                JOptionPane.showMessageDialog(null, "Your HP is below than 1. You lose.", "You lose.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            Main.day++;
            if (Main.day > 15) {
                JOptionPane.showMessageDialog(null, "Your 15th day has ended. Blast off!", "",JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "Your score is: "+ scoring(),"Score",JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "You start day " + Main.day + " with " + Player.HP + " HP and " + Player.energy + " Energy.","Day "+Main.day,JOptionPane.PLAIN_MESSAGE);
                if (ToolBox.hook.isObtained() && Dice.rollAgainst(1, 2)) {
                    JOptionPane.showMessageDialog(null, "You gain 1 food from hook.","Bonus food.",JOptionPane.PLAIN_MESSAGE);
                    Storage.food.gain(1);
                }
                update();
                boolean animalDeckIsEmpty = (animalDeck[0] == null) && (animalDeck[1] == null) && (animalDeck[2] == null) && (animalDeck[3] == null) && (animalDeck[4] == null) && (animalDeck[5] == null);
                if(animalDeckIsEmpty){
                    animalDeck[0] = new BirdKing();
                    animalDeck[1] = new DoubleDog();
                    animalDeck[2] = new Fourleg();
                    animalDeck[3] = new Fishman();
                    animalDeck[4] = new Snailbox();
                    animalDeck[5] = new Rhinocow();
                }
                while(huntingGround[0] == null){
                    int redrawing = (int) (Math.random() * 10) % 6;
                    huntingGround[0] = animalDeck[redrawing];
                    animalDeck[redrawing] = null;
                    if(huntingGround[0] instanceof BirdKing){
                        huntingGround0.setIcon(ani1);
                    }else if (huntingGround[0] instanceof DoubleDog){
                        huntingGround0.setIcon(ani2);
                    }else if (huntingGround[0] instanceof Fourleg){
                        huntingGround0.setIcon(ani3);
                    }else if (huntingGround[0] instanceof Fishman){
                        huntingGround0.setIcon(ani4);
                    }else if (huntingGround[0] instanceof Snailbox){
                        huntingGround0.setIcon(ani5);
                    }else if (huntingGround[0] instanceof Rhinocow){
                        huntingGround0.setIcon(ani6);
                    }
                    huntingGround0.setEnabled(true);
                    huntingGround0.setText("Fight this Animal!");
                    huntingGround0.setBackground(new Color(192, 96, 161));
                }
                while(huntingGround[1] == null){
                    int redrawing = (int) (Math.random() * 10) % 6;
                    huntingGround[1] = animalDeck[redrawing];
                    animalDeck[redrawing] = null;
                    if(huntingGround[1] instanceof BirdKing){
                        huntingGround1.setIcon(ani1);
                    }else if (huntingGround[1] instanceof DoubleDog){
                        huntingGround1.setIcon(ani2);
                    }else if (huntingGround[1] instanceof Fourleg){
                        huntingGround1.setIcon(ani3);
                    }else if (huntingGround[1] instanceof Fishman){
                        huntingGround1.setIcon(ani4);
                    }else if (huntingGround[1] instanceof Snailbox){
                        huntingGround1.setIcon(ani5);
                    }else if (huntingGround[1] instanceof Rhinocow){
                        huntingGround1.setIcon(ani6);
                    }
                    huntingGround1.setEnabled(true);
                    huntingGround1.setText("Fight this Animal!");
                    huntingGround1.setBackground(new Color(192, 96, 161));
                }
            }
        }
    }

     Image backgroundimg;
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        backgroundimg = new ImageIcon("src/images/spacetest03.jpg").getImage();
        g2D.drawImage(backgroundimg, 0, 0, null);
        
        }
}
