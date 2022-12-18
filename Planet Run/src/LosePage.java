/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.Graphics;

import javax.swing.*;
import java.util.*;
/**
 *
 * @author Squid3rd
 */
public class LosePage extends JPanel implements ActionListener ,Runnable {
    private JFrame fr;
    private JPanel p1, p2, p3;
    private JLabel title1;
    private JButton bRetry, bExit;
    private JLabel hfixer, hrocketeer, htoolmaker, hjack, hdis,hapex, hbarely, hunbreak, htotal, htime, hfinals;
    private JLabel dfixer, drocketeer, dtoolmaker, djack, ddis,dapex, dbarely, dunbreak, dtotal, dtime, dfinals;

    Image backgroundimg;
    Image ani1,ani2, rocket;

    public int px = 0, py = 0;
    
    final int PANEL_HEIGHT = 300;
    final int PANEL_WIDTH = 500;
    int x = 225;
    int y = 200;
    int xVelo = 5;
    int yVelo = 5;

    public LosePage(JFrame fr){
        this.fr = fr;
        p1 = new JPanel();
//        p1.setLayout(new GridLayout(5,1,5,10));
        p2 = new JPanel();
//        p2.setLayout(new BorderLayout());

//        p3 = new JPanel();
//        p3.setSize(new Dimension(500,500));
//        p3.setLayout(new GridLayout(12,2,0,2));
//        p3.setPreferredSize(new Dimension(500,500));
        
        
        bRetry = new JButton("Retry");
        bExit = new JButton("Exit");
        
//        hfixer = new JLabel("Fixer");
//        hrocketeer = new JLabel("Rocketeering");
//        htoolmaker = new JLabel("Toolmaker");
//        hjack = new JLabel("Jack of all tools");
//        hdis = new JLabel("Discover");
//        hapex = new JLabel("Apex Predator");
//        hbarely = new JLabel("Barely a Scratch");
//        hunbreak = new JLabel("Unbreakable");
//        htotal = new JLabel("Total Score");
//        htime = new JLabel("Time Taken");
//        hfinals = new JLabel("Final Score");
//        
//        dfixer = new JLabel(": 555555555555555555555555555");
//        drocketeer = new JLabel(": ");
//        dtoolmaker = new JLabel(": ");
//        djack = new JLabel(": ");
//        ddis = new JLabel(": ");
//        dapex = new JLabel(": ");
//        dbarely = new JLabel(": ");
//        dunbreak = new JLabel(": ");
//        dtotal = new JLabel(": ");
//        dtime = new JLabel(": ");
//        dfinals = new JLabel(": ");

        p1.setBackground(new Color(0,0,0,0));
        p2.setBackground(new Color(0,0,0,0));
//        p3.setBackground(new Color(0,0,0,0));
        
        bRetry.setPreferredSize(new Dimension(250,80));
        bExit.setPreferredSize(new Dimension(250,80));
        
        bRetry.setFont(new Font("Ink Free", Font.BOLD, 25));
        bRetry.setBackground(new Color(192, 96, 161));
        bRetry.setForeground(new Color(255,255,255));
        bExit.setFont(new Font("Ink Free", Font.BOLD, 25));
        bExit.setBackground(new Color(192, 96, 161));
        bExit.setForeground(new Color(255,255,255));
        
//        p1.add(new JLabel());   p1.add(new JLabel());   
        p1.add(bRetry); 
        p2.add(bExit);
//        p2.add(p1);
        
        
//        p3.add(hfixer); p3.add(dfixer);
//        p3.add(hrocketeer); p3.add(drocketeer);
//        p3.add(htoolmaker); p3.add(dtoolmaker);
//        p3.add(hjack); p3.add(djack);
//        p3.add(hdis); p3.add(ddis);
//        p3.add(hapex); p3.add(dapex);
//        p3.add(hbarely); p3.add(dbarely);
//        p3.add(hunbreak); p3.add(dunbreak);
//        p3.add(htotal); p3.add(dtotal);
//        p3.add(new JLabel()); p3.add(new JLabel());
//        p3.add(htime); p3.add(dtime);
//        p3.add(hfinals); p3.add(dfinals);
        
//        timer = new Timer(1000, null);
//        timer.start();
        
//        setSize(512, 512);
//        setOpaque(false);
        setLayout(null);
        add(p1);
        add(p2);
//        add(p3);
        p1.setBounds(1450,650, 110, 110);
        p2.setBounds(1450,750, 110, 110);
//        p3.setBounds(850,500, 110, 110);
        
//        setLayout(new GridLayout(1,15));
//        add(new JLabel());
//        add(new JLabel());
//        add(new JLabel());
//        add(new JLabel());
//        add(new JLabel());
//        add(new JLabel());
//        add(new JLabel());
//        add(new JLabel());
//        add(new JLabel());
//        add(new JLabel());
//        add(new JLabel());
//        add(new JLabel());
//        add(p2);
//        add(new JLabel());
      
        
        bRetry.addActionListener(this);
        bExit.addActionListener(this);

        
    }

    public static void main(String[] args) {
        System.out.println("i am working!");
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
        
    }
        
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        Graphics2D gString = (Graphics2D) g;
        Graphics2D gRocket = (Graphics2D) g;
        Graphics2D gBorder = (Graphics2D) g;
        
        Graphics2D ghFixer = (Graphics2D) g;
        Graphics2D ghRocketeer = (Graphics2D) g;
        Graphics2D ghToolmaker = (Graphics2D) g;
        Graphics2D ghJack = (Graphics2D) g;
        Graphics2D ghDis = (Graphics2D) g;
        Graphics2D ghBarely = (Graphics2D) g;
        Graphics2D ghApex = (Graphics2D) g;
        Graphics2D ghUnbreak = (Graphics2D) g;
        Graphics2D ghTotal = (Graphics2D) g;
        Graphics2D ghTime = (Graphics2D) g;
        Graphics2D ghFinals = (Graphics2D) g;
        
        Graphics2D gdFixer = (Graphics2D) g;
        Graphics2D gdRocketeer = (Graphics2D) g;
        Graphics2D gdToolmaker = (Graphics2D) g;
        Graphics2D gdJack = (Graphics2D) g;
        Graphics2D gdDis = (Graphics2D) g;
        Graphics2D gdBarely = (Graphics2D) g;
        Graphics2D gdApex = (Graphics2D) g;
        Graphics2D gdUnbreak = (Graphics2D) g;
        Graphics2D gdTotal = (Graphics2D) g;
        Graphics2D gdTime = (Graphics2D) g;
        Graphics2D gdFinals = (Graphics2D) g;
        
        ani1 = new ImageIcon("src/images/Ani3.png").getImage();
        ani2 = new ImageIcon("src/images/Ani4.png").getImage();
        backgroundimg = new ImageIcon("src/images/spacetest04.png").getImage();
        rocket = new ImageIcon("src/images/Player.png").getImage();
        
        g2D.drawImage(backgroundimg, 0, 0, null);
        g2D.drawImage(ani1, 1,1, null);
        g2D.drawImage(ani2, 1450,1, null);
        
        gString.setFont(new Font("Ink Free", Font.BOLD, 50));
        gString.setColor(new Color(255,255,0));
        gString.drawString("You couldn't survived Planet Run!", 650, 180);
        
        gBorder.setColor(new Color(0,0,0));
        gBorder.fillRect(127,140,475,525);
        
        gRocket.setColor(new Color(255,255,255));
        gRocket.fillRect(140,150,450,500);
        gRocket.drawImage(rocket,x,y,null);
        
//        Header
        ghFixer.setFont(new Font("Ink Free", Font.BOLD, 40));
        ghFixer.setColor(new Color(255,255,255));
        ghFixer.drawString("You survived " + "15" + " days", 675, 290);
        
        ghRocketeer.setFont(new Font("Ink Free", Font.BOLD, 25));
        ghRocketeer.setColor(new Color(255,0,0));
        ghRocketeer.drawString("Impressive! but not enough to get back to earth", 675, 340);

        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(bRetry)){
            
        }
        else if(e.getSource().equals(bExit)){
            System.exit(0);
        }
        

    }
    public void run(){
        while(true){
            try{
                if(x>=PANEL_WIDTH - 150 || x<120){
                    xVelo = xVelo * -1;
                }
                if(y>=PANEL_HEIGHT - 30 || y<150){
                    yVelo = yVelo * -1;
                }
                x = x + xVelo;
                y = y + yVelo;
                repaint();
                Thread.sleep(25);
            }
            catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
//        if(x>=PANEL_WIDTH - rocket.getWidth(null) || x<0){
//            xVelo = xVelo * -1;
//        }
//        if(y>=PANEL_HEIGHT - rocket.getHeight(null) || y<0){
//            yVelo = yVelo * -1;
//        }
//        x = x + xVelo;
//        y = y + yVelo;
//        repaint();
    }

