import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;
import java.awt.Graphics2D;
import java.awt.Graphics;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainHome extends JPanel implements ActionListener {
    private JFrame fr;
    private JPanel p1, p2;
    private JLabel title1;
    private static JLabel test;
    private JButton bStart, bConti, bHow, bExit;

    Image backgroundimg;
    Image ani;

    public int px = 0, py = 0;

    public MainHome(){
        // MainHome p = new MainHome();
        fr = new JFrame();
        p1 = new JPanel();
        p2 = new JPanel();
        bStart = new JButton("Start");
        bConti = new JButton("Continue");
        bHow = new JButton("How to Play");
        bExit = new JButton("Exit");
        title1 = new JLabel("Planet run the Boardgame, with JAVA");

        title1.setHorizontalAlignment(JLabel.CENTER);
        title1.setVerticalAlignment(JLabel.CENTER);
        bStart.setPreferredSize(new Dimension(150, 50));

        p1.setLayout(new GridLayout(4,1,5,5));
        p1.add(bStart); p1.add(bConti); 
        p1.add(bHow); p1.add(bExit); 

        // p2.setSize(200,200);;
        p2.setBorder(new EmptyBorder(100, 10, 10, 10));
        title1.setFont(new Font("Ink Free", Font.BOLD, 50));
        title1.setForeground(new Color(0,255,255));
        p2.add(title1);

        fr.setLayout(new FlowLayout());
        // fr.add(p1, BorderLayout.LINE_END);
        fr.add(p2, BorderLayout.NORTH);       
        fr.add(p1, BorderLayout.PAGE_END);
        // fr.add(p);

        fr.setSize(1080, 960);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // fr.setContentPane(new JLabel(new ImageIcon("images/spacetest.jpg")));

        // bStart.addActionListener(this);
        // bConti.addActionListener(this);
        // bHow.addActionListener(this);
        // bExit.addActionListener(this);
    }

    public static void main(String[] args) {
        MainHome p = new MainHome();
        test = new JLabel("TTTT");
        // test.setForeground(Color.WHITE);
        JFrame fr = new JFrame();
        fr.setSize(1600, 900);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // fr.add(test);
        fr.add(test);
        // fr.add(test);
        // fr.add(test);
        fr.add(p);
        // fr.pack();
        // fr.addKeyListener(p);

        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(bStart)){
            new Main();
            // fr.dispose();
        }
        else if(e.getSource().equals(bConti)){
            
        }
        else if(e.getSource().equals(bHow)){
            
        }
        else if(e.getSource().equals(bExit)){
            fr.dispose();
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        ani = new ImageIcon("images/Ani1.png").getImage();
        backgroundimg = new ImageIcon("images/spacetest.jpg").getImage();
        // Image n1 = backgroundimg.getScaledInstance(1600,900, Image.SCALE_SMOOTH);
        // Image n2 = new ImageIcon(n1);
        // g2D.drawString("MEEEEEEEEEEEEE", 100, 100);
        g2D.drawImage(backgroundimg, 0, 0, null);
        g2D.drawImage(ani, 1,1, null);
        }
    
}
