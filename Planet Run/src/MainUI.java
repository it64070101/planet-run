
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
    private static JTextField title1;
    public static ImageIcon rockcone, rockleft, rockright, rockbase, rockbody, sec1, sec2, sec3, sec4, ani1, ani2, ani3, ani4, ani5, ani6, queSym;
    private static JLabel name, clockshow;

    private static JPanel pInput, pEnergy, pEat;
    private static ButtonGroup group;
    private static JRadioButton e1, e2, e3, e4, e5, e6;
    private static JLabel howMany;
    private static JSlider slider;

    private static int day;
    private static int sec;
    private static int score;
    private static Animal[] huntingGround;
    private static Animal[] animalDeck;

    private static JLabel food, wood, rock, sand, star, energy, HP;

    public MainUI() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenDPI = Toolkit.getDefaultToolkit().getScreenResolution();
        double scaleTest = (double) 96 / screenDPI;
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

        while (huntingGround[0] == null) {
            int redrawing = (int) (Math.random() * 10) % 6;
            huntingGround[0] = animalDeck[redrawing];
            animalDeck[redrawing] = null;
            if (huntingGround[0] instanceof BirdKing) {
                huntingGround0 = new JButton(huntingGround[0].getFoodDrop() + " Food " + huntingGround[0].getDifficulty(), ani1);
            } else if (huntingGround[0] instanceof DoubleDog) {
                huntingGround0 = new JButton(huntingGround[0].getFoodDrop() + " Food " + huntingGround[0].getDifficulty(), ani2);
            } else if (huntingGround[0] instanceof Fourleg) {
                huntingGround0 = new JButton(huntingGround[0].getFoodDrop() + " Food " + huntingGround[0].getDifficulty(), ani3);
            } else if (huntingGround[0] instanceof Fishman) {
                huntingGround0 = new JButton(huntingGround[0].getFoodDrop() + " Food " + huntingGround[0].getDifficulty(), ani4);
            } else if (huntingGround[0] instanceof Snailbox) {
                huntingGround0 = new JButton(huntingGround[0].getFoodDrop() + " Food " + huntingGround[0].getDifficulty(), ani5);
            } else if (huntingGround[0] instanceof Rhinocow) {
                huntingGround0 = new JButton(huntingGround[0].getFoodDrop() + " Food " + huntingGround[0].getDifficulty(), ani6);
            }
            huntingGround0.setToolTipText("Fight this animal");
        }
        while (huntingGround[1] == null) {
            int redrawing = (int) (Math.random() * 10) % 6;
            huntingGround[1] = animalDeck[redrawing];
            animalDeck[redrawing] = null;
            if (huntingGround[1] instanceof BirdKing) {
                huntingGround1 = new JButton(huntingGround[1].getFoodDrop() + " Food " + huntingGround[1].getDifficulty(), ani1);
            } else if (huntingGround[1] instanceof DoubleDog) {
                huntingGround1 = new JButton(huntingGround[1].getFoodDrop() + " Food " + huntingGround[1].getDifficulty(), ani2);
            } else if (huntingGround[1] instanceof Fourleg) {
                huntingGround1 = new JButton(huntingGround[1].getFoodDrop() + " Food " + huntingGround[1].getDifficulty(), ani3);
            } else if (huntingGround[1] instanceof Fishman) {
                huntingGround1 = new JButton(huntingGround[1].getFoodDrop() + " Food " + huntingGround[1].getDifficulty(), ani4);
            } else if (huntingGround[1] instanceof Snailbox) {
                huntingGround1 = new JButton(huntingGround[1].getFoodDrop() + " Food " + huntingGround[1].getDifficulty(), ani5);
            } else if (huntingGround[1] instanceof Rhinocow) {
                huntingGround1 = new JButton(huntingGround[1].getFoodDrop() + " Food " + huntingGround[1].getDifficulty(), ani6);
            }
            huntingGround1.setToolTipText("Fight this animal");
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

        noseCone = new JButton("(Wood x1, Sand x1, Rock x1)", rockcone);
        shockcord = new JButton("(Wood x1, Sand x1, Rock x1)", rockbody);
        recoveryWadding = new JButton("(Wood x1, Sand x1, Rock x1)", rockbase);
        leftFin = new JButton("(Star x4)", rockleft);
        rightFin = new JButton("(Star x4)", rockright);

        noseCone.setPreferredSize(new Dimension(screenScale(100), screenScale(160)));
        shockcord.setPreferredSize(new Dimension(screenScale(150), screenScale(180)));
        recoveryWadding.setPreferredSize(new Dimension(screenScale(100), screenScale(160)));
        leftFin.setPreferredSize(new Dimension(screenScale(100), screenScale(80)));
        rightFin.setPreferredSize(new Dimension(screenScale(100), screenScale(80)));

        setShip();

        pShip.setLayout(new BorderLayout(screenScale(5), screenScale(5)));
        pShip.setBackground(Color.BLACK);
        pShip.setSize(screenScale(200), screenScale(200));
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
        sector1 = new JButton("Explore (Easy+)", queSym);
        sector2 = new JButton("Explore (Easy+)", queSym);
        sector3 = new JButton("Explore (Easy+)", queSym);
        sector4 = new JButton("Explore (Easy+)", queSym);

        ImageIcon foodIcon = new ImageIcon(new ImageIcon("src/images/food.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        ImageIcon woodIcon = new ImageIcon(new ImageIcon("src/images/wood.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        ImageIcon rockIcon = new ImageIcon(new ImageIcon("src/images/rock.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        ImageIcon sandIcon = new ImageIcon(new ImageIcon("src/images/sand.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        ImageIcon starIcon = new ImageIcon(new ImageIcon("src/images/star.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        ImageIcon HPIcon = new ImageIcon(new ImageIcon("src/images/star.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        ImageIcon energyIcon = new ImageIcon(new ImageIcon("src/images/star.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));

        setSector();

        rest = new JButton("Rest");
        rest.setPreferredSize(new Dimension(screenScale(100), screenScale(50)));
        rest.setBackground(new Color(88, 62, 138));
        rest.setForeground(new Color(163, 199, 214));
        rest.setFont(new Font("Pixellari", Font.BOLD, screenScale(35)));
        rest.setToolTipText("Heal 1HP/Energy");

        maketool = new JButton("Tool Box");
        maketool.setPreferredSize(new Dimension(screenScale(100), screenScale(50)));
        maketool.setBackground(new Color(88, 62, 138));
        maketool.setForeground(new Color(163, 199, 214));
        maketool.setFont(new Font("Pixellari", Font.BOLD, screenScale(35)));
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
        huntingGround0.setPreferredSize(new Dimension(screenScale(350), screenScale(180)));
        huntingGround1.setPreferredSize(new Dimension(screenScale(350), screenScale(180)));

        huntingGround0.setBackground(new Color(200, 55, 135));
        huntingGround0.setForeground(new Color(255, 255, 255));
        huntingGround0.setFont(new Font("Pixellari", Font.BOLD, screenScale(20)));

        huntingGround1.setBackground(new Color(200, 55, 135));
        huntingGround1.setForeground(new Color(255, 255, 255));
        huntingGround1.setFont(new Font("Pixellari", Font.BOLD, screenScale(20)));

        pHuntingGround.setBackground(new Color(0, 0, 0, 0));
        pHuntAll = new JPanel();
        pHuntAll.setLayout(new FlowLayout());
        pHuntAll.add(pHuntingGround);
        pHuntAll.setBackground(new Color(0, 0, 0, 0));

        food = new JLabel("2", foodIcon, JLabel.CENTER);
        wood = new JLabel("0", woodIcon, JLabel.CENTER);
        sand = new JLabel("0", sandIcon, JLabel.CENTER);
        rock = new JLabel("0", rockIcon, JLabel.CENTER);
        star = new JLabel("0", starIcon, JLabel.CENTER);

//        dayTxt = new JTextField("Day: " + day);
//        foodTxt = new JTextField("Food: " + Storage.getFood().getAmount());
//        starTxt = new JTextField("Star: " + Storage.getStar().getAmount());
//        triangleTxt = new JTextField("Wood: " + Storage.getTriangle().getAmount());
//        squareTxt = new JTextField("Rock: " + Storage.getSquare().getAmount());
//        circleTxt = new JTextField("Sand: " + Storage.getCircle().getAmount());
        title1 = new JTextField("Planet Run!");
//        HPTxt = new JTextField("HP: " + Player.getHP());
//        energyTxt = new JTextField("Energy: " + Player.getEnergy());
        name = new JLabel(Player.getName());

        slider = new JSlider(1, 6, 1);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);

        pLabel.add(food);
        pLabel.add(wood);
        pLabel.add(sand);
        pLabel.add(rock);
        pLabel.add(star);
//        pLabel.add(HPTxt);
//        pLabel.add(energyTxt);
        pLabel.setBackground(new Color(29, 48, 87));

        food.setForeground(new Color(245, 213, 174));
        wood.setForeground(new Color(245, 213, 174));
        sand.setForeground(new Color(245, 213, 174));
        rock.setForeground(new Color(245, 213, 174));
        star.setForeground(new Color(245, 213, 174));

        food.setFont(new Font("Pixellari", Font.BOLD, screenScale(32)));
        wood.setFont(new Font("Pixellari", Font.BOLD, screenScale(32)));
        sand.setFont(new Font("Pixellari", Font.BOLD, screenScale(32)));
        rock.setFont(new Font("Pixellari", Font.BOLD, screenScale(32)));
        star.setFont(new Font("Pixellari", Font.BOLD, screenScale(32)));



        pButton.setLayout(new BorderLayout(screenScale(5), screenScale(5)));
        pButton.setBackground(Color.BLACK);
        pButton.add(maketool, BorderLayout.NORTH);
        pButton.add(pShip, BorderLayout.CENTER);
        pButton.add(rest, BorderLayout.SOUTH);

        pAll.setLayout(new FlowLayout(FlowLayout.CENTER));
        pAll.add(pLabel);
        pAll.setSize(screenScale(100), screenScale(100));
        pAll.setBackground(new Color(29, 48, 87));
        pAll.setForeground(new Color(254, 194, 96));

        showclock = new JPanel();
        clockshow = new JLabel("");
        clockshow.setForeground(new Color(255, 255, 255));
        showclock.setForeground(new Color(234, 234, 234));
        showclock.add(clockshow);
        showclock.setSize(screenScale(200), screenScale(200));
        showclock.setBackground(new Color(30, 0, 69));

        pSec.setBounds(screenScale(0), screenScale(50), screenScale(450), screenScale(1000));
        pRocket.setBounds(screenScale(500), screenScale(50), screenScale(650), screenScale(850));
        pHuntAll.setBounds(screenScale(500 + 700), screenScale(50), screenScale(500), screenScale(500));
        add(showclock);
        showclock.setBounds(screenScale(640 - 150), screenScale(190), screenScale(200), screenScale(60));
        exit = new JButton("exit");
        exit.setBounds(screenScale(500 + 700 + 15 + 175), screenScale(825), screenScale(200), screenScale(75));

        exit.setBackground(new Color(220, 95, 0));
        exit.setForeground(new Color(238, 238, 238));

        // rocket panel
        pRocket.setLayout(new BorderLayout(screenScale(150), screenScale(180)));
        pRocket.add(pAll, BorderLayout.NORTH);
        pRocket.add(pButton, BorderLayout.CENTER);
        pRocket.setBackground(new Color(0, 0, 0, 0));

        pAll.setLocation(screenScale(30), screenScale(30));

        update();

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

        dayPass();
        update();

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
        JOptionPane.showMessageDialog(null, "You start day " + day + " with " + Player.getHP() + " HP and " + Player.getEnergy() + " Energy.", "Day " + day, JOptionPane.PLAIN_MESSAGE);
        Thread n1 = new Thread(frame);
        n1.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(maketool)) {
            new Maketool();
            fr.setEnabled(false);
        } else if (e.getSource().equals(sector1)) {
            if (!Area.getA().isExplored()) {
                Player.explore(Area.getA(), sliderInput());
            } else {
                Player.gather(Area.getA(), sliderInput());
            }
        } else if (e.getSource().equals(sector2)) {
            if (!Area.getB().isExplored()) {
                Player.explore(Area.getB(), sliderInput());
            } else {
                Player.gather(Area.getB(), sliderInput());
            }
        } else if (e.getSource().equals(sector3)) {
            if (!Area.getC().isExplored()) {
                Player.explore(Area.getC(), sliderInput());
            } else {
                Player.gather(Area.getC(), sliderInput());
            }
        } else if (e.getSource().equals(sector4)) {
            if (!Area.getD().isExplored()) {
                Player.explore(Area.getD(), sliderInput());
            } else {
                Player.gather(Area.getD(), sliderInput());
            }
        } else if (e.getSource().equals(huntingGround0)) {
            Player.hunt(huntingGround[0], sliderInput());
            if (!huntingGround[0].getIsAlive()) {
                huntingGround0.setEnabled(false);
                huntingGround0.setText("Animal Killed!");
                huntingGround0.setBackground(new Color(128, 128, 128));
                huntingGround[0] = null;
            }
        } else if (e.getSource().equals(huntingGround1)) {
            Player.hunt(huntingGround[1], sliderInput());
            if (!huntingGround[1].getIsAlive()) {
                huntingGround1.setEnabled(false);
                huntingGround1.setText("Animal Killed!");
                huntingGround1.setBackground(new Color(128, 128, 128));
                huntingGround[1] = null;
            }
        } else if (e.getSource().equals(rest)) {
            Player.rest(restInput());
        } else if (e.getSource().equals(noseCone)) {
            if (Player.fix(Ship.getNoseCone())) {
                noseCone.setEnabled(false);
                noseCone.setBackground(new Color(159, 115, 171));
            }
        } else if (e.getSource().equals(shockcord)) {
            if (Player.fix(Ship.getShockcord())) {
                shockcord.setEnabled(false);
                shockcord.setBackground(new Color(159, 115, 171));
            }
        } else if (e.getSource().equals(recoveryWadding)) {
            if (Player.fix(Ship.getRecoveryWadding())) {
                recoveryWadding.setEnabled(false);
                recoveryWadding.setBackground(new Color(159, 115, 171));
            }
        } else if (e.getSource().equals(leftFin)) {
            if (Player.fix(Ship.getLeftFin())) {
                leftFin.setEnabled(false);
                leftFin.setBackground(new Color(159, 115, 171));
            }
        } else if (e.getSource().equals(rightFin)) {
            if (Player.fix(Ship.getRightFin())) {
                rightFin.setEnabled(false);
                rightFin.setBackground(new Color(159, 115, 171));
            }
        } else if (e.getSource().equals(exit)) {
            exitAsk();
        }
        update();
        if (Player.getHP() < 1) {
            JOptionPane.showMessageDialog(null, "Your HP is below than 1. You lose.", "You Lose.", JOptionPane.ERROR_MESSAGE);
            JFrame fr = new JFrame();
            LosePage p = new LosePage(fr);
            Thread t1 = new Thread(p);
            fr.setMinimumSize(new Dimension(1600, 900));
            fr.setLocationRelativeTo(null);
            fr.setVisible(true);
            fr.setResizable(false);
            fr.add(p);
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            t1.start();
            MainHome.fr1.dispose();
//            System.exit(0);
        }
        endOfDay();
    }

    public static void update() {

//        dayTxt.setText("Day: " + day);
        food.setText(": " + Storage.getFood().getAmount() + "  ");
        star.setText(": " + Storage.getStar().getAmount() + "  ");
        wood.setText(": " + Storage.getTriangle().getAmount() + "  ");
        rock.setText(": " + Storage.getSquare().getAmount() + "  ");
        sand.setText(": " + Storage.getCircle().getAmount() + "  ");
        title1.setText("Planet Run!");
//        HPTxt.setText("HP: " + Player.getHP());
//        energyTxt.setText("Energy: " + Player.getEnergy());
        sectorDiscover(Area.getA(), sector1);
        sectorDiscover(Area.getB(), sector2);
        sectorDiscover(Area.getC(), sector3);
        sectorDiscover(Area.getD(), sector4);
        if (Player.getHP() >= 4) {
            rest.setEnabled(false);
        } else {
            rest.setEnabled(true);
        }
        if (MainHome.frame != null) {
            MainHome.frame.repaint();
        }
    }

    public void setSector() {
        Dimension preferSize = new Dimension(screenScale(250), screenScale(160));
        Font font = new Font("Pixellari", Font.BOLD, screenScale(15));
        Color bgColor = new Color(194, 68, 161);
        Color fgColor = new Color(255, 255, 255);
        int hText = JButton.CENTER;
        int vText = JButton.BOTTOM;

        sector1.setPreferredSize(preferSize);
        sector2.setPreferredSize(preferSize);
        sector3.setPreferredSize(preferSize);
        sector4.setPreferredSize(preferSize);

        sector1.setFont(font);
        sector2.setFont(font);
        sector3.setFont(font);
        sector4.setFont(font);

        sector1.setBackground(bgColor);
        sector2.setBackground(bgColor);
        sector3.setBackground(bgColor);
        sector4.setBackground(bgColor);

        sector1.setForeground(fgColor);
        sector2.setForeground(fgColor);
        sector3.setForeground(fgColor);
        sector4.setForeground(fgColor);

        sector1.setHorizontalTextPosition(hText);
        sector2.setHorizontalTextPosition(hText);
        sector3.setHorizontalTextPosition(hText);
        sector4.setHorizontalTextPosition(hText);

        sector1.setVerticalTextPosition(vText);
        sector2.setVerticalTextPosition(vText);
        sector3.setVerticalTextPosition(vText);
        sector4.setVerticalTextPosition(vText);

        sector1.setToolTipText("Explore this Sector");
        sector2.setToolTipText("Explore this Sector");
        sector3.setToolTipText("Explore this Sector");
        sector4.setToolTipText("Explore this Sector");
    }

    public void setShip() {
        Color bgColor = new Color(117, 92, 170);
        Color fgColor = new Color(255, 255, 255);
        int htext = JButton.CENTER;
        int vtext = JButton.BOTTOM;

        noseCone.setBackground(bgColor);
        shockcord.setBackground(bgColor);
        recoveryWadding.setBackground(bgColor);
        leftFin.setBackground(bgColor);
        rightFin.setBackground(bgColor);

        noseCone.setForeground(fgColor);
        shockcord.setForeground(fgColor);
        recoveryWadding.setForeground(fgColor);
        leftFin.setForeground(fgColor);
        rightFin.setForeground(fgColor);

        noseCone.setHorizontalTextPosition(htext);
        shockcord.setHorizontalTextPosition(htext);
        recoveryWadding.setHorizontalTextPosition(htext);
        leftFin.setHorizontalTextPosition(htext);
        rightFin.setHorizontalTextPosition(htext);

        noseCone.setVerticalTextPosition(vtext);
        shockcord.setVerticalTextPosition(vtext);
        recoveryWadding.setVerticalTextPosition(vtext);
        leftFin.setVerticalTextPosition(vtext);
        rightFin.setVerticalTextPosition(vtext);

        noseCone.setToolTipText("Fix Nose Cone");
        shockcord.setToolTipText("Fix Shockcord");
        recoveryWadding.setToolTipText("Fix Recovery Wadding");
        leftFin.setToolTipText("Fix Left Fin");
        rightFin.setToolTipText("Fix Right Fin");
    }

    public static int sliderInput() {
        slider.setMaximum(Player.getEnergy());
        slider.setMinimum(1);
        int num = 0;
        howMany.setText("How many energy do you want to use ? ");
        JOptionPane.showMessageDialog(null, pInput, "Energy Input", JOptionPane.PLAIN_MESSAGE);
        num = slider.getValue();

        return num;

    }

    public static int sliderInput(int max) {
        int num = 0;
        if (Storage.getFood().getAmount() < 1) {
            num = 0;
        } else {
            if (max > 4) {
                max = 4;
            }
            slider.setMaximum(max);
            slider.setMinimum(0);
            howMany.setText("How many food do you want to eat ? ");
            JOptionPane.showMessageDialog(null, pInput, "Food Input", JOptionPane.PLAIN_MESSAGE);
            num = slider.getValue();
        }
        return num;
    }

    public static int restInput() {
        int num;
        int max;
        if (Player.getEnergy() > 4 - Player.getHP()) {
            max = 4 - Player.getHP();
        } else {
            max = Player.getEnergy();
        }
        slider.setMaximum(max);
        slider.setMinimum(0);
        howMany.setText("How much do you want to rest ? (Using Energy)");
        JOptionPane.showMessageDialog(null, pInput, "Energy Input", JOptionPane.PLAIN_MESSAGE);
        num = slider.getValue();
        return num;
    }

    public static void sectorDiscover(Sector sector, JButton secBtn) {
        if (sector.isExplored()) {
            secBtn.setIcon(new ImageIcon("src/images/" + sector.getName() + ".png"));
            secBtn.setBackground(new Color(247, 135, 87));
            secBtn.setForeground(new Color(255, 255, 255));
            secBtn.setText(sector.getName() + ": " + sector.getResource().getName() + " (Easy)");
        } else {
            secBtn.setPreferredSize(new Dimension(250, 160));
            secBtn.setFont(new Font("Pixellari", Font.BOLD, screenScale(15)));
            secBtn.setBackground(new Color(192, 96, 161));
            secBtn.setForeground(new Color(255, 255, 255));
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
            if (day == 15 && Player.getEnergy() == 0) {
                break;
            }
            clockshow.setFont(new Font("Pixellari", Font.PLAIN, screenScale(32)));
            clockshow.setText(String.format("%02d", hour) + " : " + String.format("%02d", min) + " : " + String.format("%02d", sec));
            try {
                Thread.sleep(1000);
                count++;
                sec = count % 60;
                min = (count / 60) % 60;
                hour = count / 3600;
                if (x >= PANEL_WIDTH - 100 || x < screenScale(1200)) {
                    xVelo = xVelo * -1;
                }
                if (y >= PANEL_HEIGHT - 50 || y < screenScale(500)) {
                    yVelo = yVelo * -1;
                }
                x = x + xVelo;
                y = y + yVelo;
                repaint();
//                Thread.sleep(25);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static int screenScale(double pixel) {
        int screenDPI = Toolkit.getDefaultToolkit().getScreenResolution();
        double scaleTest = (double) 96 / screenDPI;
        return (int) (pixel * scaleTest);
    }

    public static int scoring() {
        double total = 0;
        //Fixer Bonus
        total += (Ship.getPartFixed() * (Ship.getPartFixed() + 1)) / 2;
        //Rocketeering
        if (Ship.getPartFixed() == 5) {
            total += 30;
        }
        //Toolmaker
        total += ToolBox.getToolMade();
        //Jack of all tools
        if (ToolBox.getToolMade() == 5) {
            total += 10;
        }
        //Discoverer
        total += Area.getAreaExplored();
        //apex legend
        total += Player.getAnimalKilled();
        //nas
        total += Player.getHP();
        //un
        if (Player.getHP() == 4) {
            total += 8;
        }
//        System.out.println(total + " , " + sec);
        MainUI.setScore((int)((total / sec) * 1000));
        return MainUI.getScore();
    }

    public static void endOfDay() {
        if (MainHome.frame != null) {
            MainHome.frame.repaint();
        }
        if (Player.getEnergy() < 1) {

            JOptionPane.showMessageDialog(null, "End day, time for dinner.", "", JOptionPane.PLAIN_MESSAGE);
            Player.eat(sliderInput(Storage.getFood().getAmount()));
            if (Player.getHP() < 1) {
                JOptionPane.showMessageDialog(null, "Your HP is below than 1. You lose.", "You lose.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            dayPass();
            if (day > 15) {
                JOptionPane.showMessageDialog(null, "Your 15th day has ended. Blast off!", "", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "Your score is: " + scoring(), "Score", JOptionPane.PLAIN_MESSAGE);
                JFrame fr = new JFrame();
                WinPage p = new WinPage(fr);
                Thread t1 = new Thread(p);
                fr.setMinimumSize(new Dimension(1600, 900));
                fr.setLocationRelativeTo(null);
                fr.setVisible(true);
                fr.setResizable(false);
                fr.add(p);
                fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                t1.start();
                MainHome.fr1.dispose();
//                System.exit(0);
            } else {
                String bonus = "";
                if (ToolBox.getHook().isObtained() && Dice.rollAgainst(1, 2)) {
                    bonus = " (and +1 food from hook)";
                    Storage.getFood().gain(1);
                }
                JOptionPane.showMessageDialog(null, "You start day " + day + " with " + Player.getEnergy() + " Energy." + bonus, "Day " + day, JOptionPane.PLAIN_MESSAGE);
                update();
                boolean animalDeckIsEmpty = (animalDeck[0] == null) && (animalDeck[1] == null) && (animalDeck[2] == null) && (animalDeck[3] == null) && (animalDeck[4] == null) && (animalDeck[5] == null);
                if (animalDeckIsEmpty) {
                    animalDeck[0] = new BirdKing();
                    animalDeck[1] = new DoubleDog();
                    animalDeck[2] = new Fourleg();
                    animalDeck[3] = new Fishman();
                    animalDeck[4] = new Snailbox();
                    animalDeck[5] = new Rhinocow();
                }
                String diff = "";
                String foodDrop = "";
                while (huntingGround[0] == null) {
                    int redrawing = (int) (Math.random() * 10) % 6;
                    huntingGround[0] = animalDeck[redrawing];
                    animalDeck[redrawing] = null;
                    if (huntingGround[0] instanceof BirdKing) {
                        huntingGround0.setIcon(ani1);
                        diff = huntingGround[0].getDifficulty();
                        foodDrop = huntingGround[0].getFoodDrop() + " Food ";
                    } else if (huntingGround[0] instanceof DoubleDog) {
                        huntingGround0.setIcon(ani2);
                        diff = huntingGround[0].getDifficulty();
                        foodDrop = huntingGround[0].getFoodDrop() + " Food ";
                    } else if (huntingGround[0] instanceof Fourleg) {
                        huntingGround0.setIcon(ani3);
                        diff = huntingGround[0].getDifficulty();
                        foodDrop = huntingGround[0].getFoodDrop() + " Food ";
                    } else if (huntingGround[0] instanceof Fishman) {
                        huntingGround0.setIcon(ani4);
                        diff = huntingGround[0].getDifficulty();
                        foodDrop = huntingGround[0].getFoodDrop() + " Food ";
                    } else if (huntingGround[0] instanceof Snailbox) {
                        huntingGround0.setIcon(ani5);
                        diff = huntingGround[0].getDifficulty();
                        foodDrop = huntingGround[0].getFoodDrop() + " Food ";
                    } else if (huntingGround[0] instanceof Rhinocow) {
                        huntingGround0.setIcon(ani6);
                        diff = huntingGround[0].getDifficulty();
                        foodDrop = huntingGround[0].getFoodDrop() + " Food ";
                    }
                    huntingGround0.setEnabled(true);
                    huntingGround0.setText(foodDrop + diff);
                    huntingGround0.setBackground(new Color(200, 55, 135));
                }
                while (huntingGround[1] == null) {
                    int redrawing = (int) (Math.random() * 10) % 6;
                    huntingGround[1] = animalDeck[redrawing];
                    animalDeck[redrawing] = null;
                    if (huntingGround[1] instanceof BirdKing) {
                        huntingGround1.setIcon(ani1);
                        diff = huntingGround[1].getDifficulty();
                        foodDrop = huntingGround[1].getFoodDrop() + " Food ";
                    } else if (huntingGround[1] instanceof DoubleDog) {
                        huntingGround1.setIcon(ani2);
                        diff = huntingGround[1].getDifficulty();
                        foodDrop = huntingGround[1].getFoodDrop() + " Food ";
                    } else if (huntingGround[1] instanceof Fourleg) {
                        huntingGround1.setIcon(ani3);
                        diff = huntingGround[1].getDifficulty();
                        foodDrop = huntingGround[1].getFoodDrop() + " Food ";
                    } else if (huntingGround[1] instanceof Fishman) {
                        huntingGround1.setIcon(ani4);
                        diff = huntingGround[1].getDifficulty();
                        foodDrop = huntingGround[1].getFoodDrop() + " Food ";
                    } else if (huntingGround[1] instanceof Snailbox) {
                        huntingGround1.setIcon(ani5);
                        diff = huntingGround[1].getDifficulty();
                        foodDrop = huntingGround[1].getFoodDrop() + " Food ";
                    } else if (huntingGround[1] instanceof Rhinocow) {
                        huntingGround1.setIcon(ani6);
                        diff = huntingGround[1].getDifficulty();
                        foodDrop = huntingGround[1].getFoodDrop() + " Food ";
                    }
                    huntingGround1.setEnabled(true);
                    huntingGround1.setText(foodDrop + diff);
                    huntingGround1.setBackground(new Color(200, 55, 135));
                }
            }
        }
    }

//    public void changeday(){
//        repaint();
//    }
    int j;
    Image backgroundimg, rocket, heart, bolt;
    int x = screenScale(1200);
    int y = screenScale(550);
    int xVelo = 5;
    int yVelo = 5;
    final int PANEL_WIDTH = screenScale(1700);
    final int PANEL_HEIGHT = screenScale(650);

    public void paintComponent(Graphics g) {
        // int j = screenScale(1000);
        Graphics2D g2D = (Graphics2D) g;
        Graphics2D gRocket = (Graphics2D) g;
        Graphics2D gBorder = (Graphics2D) g;
        backgroundimg = new ImageIcon("src/images/spacetest03.jpg").getImage();
        rocket = new ImageIcon("src/images/Player.png").getImage();
        bolt = new ImageIcon("src/images/bolt.png").getImage();
        heart = new ImageIcon("src/images/heart.png").getImage();
        g2D.drawImage(backgroundimg, 0, 0, null);
        g2D.setFont(new Font("Pixellari", Font.BOLD, screenScale(32)));
        g2D.setColor(new Color(255, 239, 235));
        g2D.drawString("Day " + day, screenScale(500), screenScale(148));
        j = screenScale(605);

        for (int i = 0; i < day; i++) {
            g2D.setColor(Color.yellow);
            g2D.fillOval(j, screenScale(130), 25, 25);
            j += 30;
        }
        for (int i = 0; i < 15 - day; i++) {
            g2D.setColor(Color.gray);
            g2D.fillOval(j, screenScale(130), 25, 25);
            j += 30;
        }
        gBorder.setColor(new Color(255, 255, 0));
        gBorder.fillRect(screenScale(1215), screenScale(485), 500, 250);

        gRocket.setColor(new Color(0, 0, 0));
        gRocket.fillRect(screenScale(1225), screenScale(500), 475, 225);
        gRocket.drawImage(rocket, x, y, null);
        
        g2D.setFont(new Font("Pixellari", Font.BOLD, screenScale(24)));
        g2D.setColor(new Color(255, 239, 235));
        g2D.drawString("HP " , screenScale(700), screenScale(210));
        g2D.drawString("Energy ", screenScale(700), screenScale(250));
        j = screenScale(800);
        for (int i=0; i< Player.getHP();i++){
            g2D.drawImage(heart, j, screenScale(180), null);
            j += 32;
        }
        j = screenScale(800);
        for (int i=0; i< Player.getEnergy();i++){
            g2D.drawImage(bolt, j, screenScale(220), null);
            j += 32;
        }
    }

    public static void dayPass() {
        setDay(getDay() + 1);
    }

    public static int getDay() {
        return day;
    }

    public static void setDay(int day) {
        MainUI.day = day;
    }

    public static int getSec() {
        return sec;
    }

    public static void setSec(int sec) {
        MainUI.sec = sec;
    }

    public static void exitAsk() {
        int num = JOptionPane.showConfirmDialog(null, "Do you want to quit the game ?", "Exit", JOptionPane.YES_NO_OPTION);
        if (num == 0) {
            System.exit(0);
        }
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        MainUI.score = score;
    }

}
