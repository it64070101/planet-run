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
    int xVelo = 2;
    int yVelo = 2;

    public LosePage(JFrame fr){
        this.fr = fr;
        p1 = new JPanel();
        p2 = new JPanel();
        bRetry = new JButton("Retry");
        bExit = new JButton("Exit");
        p1.setBackground(new Color(0,0,0,0));
        p2.setBackground(new Color(0,0,0,0));
        
        bRetry.setPreferredSize(new Dimension(250,80));
        bExit.setPreferredSize(new Dimension(250,80));
        
        bExit.setFont(new Font("Pixellari", Font.BOLD, 25));
        bExit.setBackground(MainUI.btnColor);
        bExit.setForeground(new Color(255,255,255));
        
        p2.add(bExit);
        
        setLayout(null);
        add(p1);
        add(p2);

        p1.setBounds(screenScale(1450),screenScale(650), screenScale(110), screenScale(110));
        p2.setBounds(screenScale(1450),screenScale(750), screenScale(110), screenScale(110));
        bExit.addActionListener(this);

        
    }

    public static void main(String[] args) {
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
        
        ani1 = new ImageIcon("src/images/Ani5.png").getImage();
        ani2 = new ImageIcon("src/images/Ani6.png").getImage();
        backgroundimg = new ImageIcon("src/images/spacetest04.png").getImage();
        rocket = new ImageIcon("src/images/Player.png").getImage();
        
        g2D.drawImage(backgroundimg, 0, 0, null);
        g2D.drawImage(ani1, 1,1, null);
        g2D.drawImage(ani2, 1450,1, null);
        
        gString.setFont(new Font("Pixellari", Font.BOLD, 50));
        gString.setColor(new Color(255,255,0));
        gString.drawString("You couldn't survived Planet Run!", 650, 180);
        
        gBorder.setColor(new Color(0,0,0));
        gBorder.fillRect(127,140,475,525);
        
        gRocket.setColor(new Color(255,255,255));
        gRocket.fillRect(140,150,450,500);
        gRocket.drawImage(rocket,x,y,null);
        
//        Header
        ghFixer.setFont(new Font("Pixellari", Font.BOLD, 40));
        ghFixer.setColor(new Color(255,255,255));
        ghFixer.drawString("You survived " + MainUI.getDay() + " days", 675, 290);
        
        ghRocketeer.setFont(new Font("Pixellari", Font.BOLD, 25));
        ghRocketeer.setColor(new Color(255,0,0));
        ghRocketeer.drawString("Impressive! but not enough to get back to earth", 675, 340);

        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(bExit)){
            MainUI.exitAsk();
        }
        
    
        

    }
    public void run(){
        while(true){
            try{
                if(x>=PANEL_WIDTH-10 || x<120){
                    xVelo = xVelo * -1;
                }
                if(y>=PANEL_HEIGHT+225 || y<150){
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
    public static int screenScale(double pixel) {
        int screenDPI = Toolkit.getDefaultToolkit().getScreenResolution();
        double scaleTest = (double) 96 / screenDPI;
        return (int) (pixel * scaleTest);
    }
}

