import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

import java.awt.*;


public class HomeFrame extends JFrame{
    private JFrame fr;
    private JPanel p1, p2;
    private JLabel title1;
    private static JLabel test;
    private JButton bStart, bConti, bHow, bExit;

    HomePanel panel;

    HomeFrame(){
        // fr = new JFrame();
        // p1 = new JPanel();
        // p2 = new JPanel();
        // bStart = new JButton("Start");
        // bConti = new JButton("Continue");
        // bHow = new JButton("How to Play");
        // bExit = new JButton("Exit");
        // title1 = new JLabel("Planet run the Boardgame, with JAVA");

        // title1.setHorizontalAlignment(JLabel.CENTER);
        // title1.setVerticalAlignment(JLabel.CENTER);
        // bStart.setPreferredSize(new Dimension(150, 50));

        // p1.setLayout(new GridLayout(4,1,5,5));
        // p1.add(bStart); p1.add(bConti); 
        // p1.add(bHow); p1.add(bExit); 

        // // p2.setSize(200,200);;
        // p2.setBorder(new EmptyBorder(100, 10, 10, 10));
        // title1.setFont(new Font("Ink Free", Font.BOLD, 50));
        // title1.setForeground(new Color(0,255,255));
        // p2.add(title1);

        // this.setLayout(new FlowLayout());
        // // this.add(p1, BorderLayout.LINE_END);
        // this.add(p2, BorderLayout.NORTH);       
        // this.add(p1, BorderLayout.PAGE_END);
        // this.add(p);

        panel = new HomePanel();

        this.setSize(1080, 960);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // public static void main(String[] args) {
    //     new HomeFrame();
    // }
}
