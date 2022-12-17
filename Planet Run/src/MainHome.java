import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.Graphics;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainHome extends JPanel implements ActionListener {
    private JFrame fr;
    private JPanel p1, p2;
    private JLabel title1;
    private JButton bStart, bConti, bHow, bExit;

    Image backgroundimg;
    Image ani1,ani2,ani3,ani4;

    public int px = 0, py = 0;

    public MainHome(JFrame fr){
        // MainHome p = new MainHome();
        this.fr = fr;
        p1 = new JPanel();
        p1.setLayout(new GridLayout(5,1,5,10));
        p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        bStart = new JButton("Start");
        bConti = new JButton("Continue");
        bHow = new JButton("How to Play");
        bExit = new JButton("Exit");
        
        p1.setBackground(new Color(0,0,0,0));
        p2.setBackground(new Color(0,0,0,0));
        
        bStart.setPreferredSize(new Dimension(450,80));
        bConti.setPreferredSize(new Dimension(450,80));
        bHow.setPreferredSize(new Dimension(450,80));
        bExit.setPreferredSize(new Dimension(450,80));
        
        bStart.setFont(new Font("Ink Free", Font.BOLD, 25));
        bStart.setBackground(new Color(192, 96, 161));
        bStart.setForeground(new Color(240, 202, 163));
        bConti.setFont(new Font("Ink Free", Font.BOLD, 25));
        bConti.setBackground(new Color(192, 96, 161));
        bConti.setForeground(new Color(240, 202, 163));
        bHow.setFont(new Font("Ink Free", Font.BOLD, 25));
        bHow.setBackground(new Color(192, 96, 161));
        bHow.setForeground(new Color(240, 202, 163));
        bExit.setFont(new Font("Ink Free", Font.BOLD, 25));
        bExit.setBackground(new Color(192, 96, 161));
        bExit.setForeground(new Color(240, 202, 163));
        
        p1.add(bStart); p1.add(bConti);
        p1.add(bHow); p1.add(bExit);    p1.add(new JLabel());
        p2.add(p1, BorderLayout.SOUTH);
        
        setSize(512, 512);
        setOpaque(false);
        setLayout(new GridLayout(1,3));
//        p1.setBounds(50,50, 500, 500);
        add(new JLabel());
        add(p2); 
        add(new JLabel());
//        p1.setBounds(50,50, 500, 500);

         bStart.addActionListener(this);
         bConti.addActionListener(this);
         bHow.addActionListener(this);
         bExit.addActionListener(this);
//        addKeyListener(this);
    }

    public static void main(String[] args) {
        System.out.println("i am working!");
        JFrame fr = new JFrame();
        MainHome p = new MainHome(fr);
        fr.setMinimumSize(new Dimension(1600, 900));
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.add(p);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
    

    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(bStart)){
            new Dice(6);
            new Player("Chokchai");
            new Storage();
            new Area();
            new Ship();
            new ToolBox();
            
            MainUI frame = new MainUI();
            Thread n1 = new Thread(frame);
            n1.start();
            fr.dispose();
        }
        else if(e.getSource().equals(bConti)){
            
        }
        else if(e.getSource().equals(bHow)){
            
        }
        else if(e.getSource().equals(bExit)){
            System.exit(0);
            
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        Graphics2D gString = (Graphics2D) g;
        ani1 = new ImageIcon("src/images/Ani1.png").getImage();
        ani2 = new ImageIcon("src/images/Ani2.png").getImage();
        backgroundimg = new ImageIcon("src/images/spacetest01.jpg").getImage();
        g2D.drawImage(backgroundimg, 0, 0, null);
        g2D.drawImage(ani1, 1,1, null);
        g2D.drawImage(ani2, 1450,1, null);
        gString.setFont(new Font("Ink Free", Font.BOLD, 70));
        gString.setColor(new Color(252, 249, 190));
        gString.drawString("Planet run the BoardGame with Java", 190, 180);
        
        
        
        }

  
    

    
}
