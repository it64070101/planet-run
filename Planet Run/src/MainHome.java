import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainHome implements ActionListener {
    private JFrame fr;
    private JPanel p1, p2;
    private JLabel title1;
    private JButton bStart, bConti, bHow, bExit;

    public MainHome(){
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
        title1.setFont(new Font("Dialog", Font.PLAIN, 50));
        title1.setBackground(new Color(255,255,255));
        p2.add(title1);

        fr.setLayout(new BorderLayout());
        // fr.add(p1, BorderLayout.LINE_END);
        fr.add(p2, BorderLayout.NORTH);       
        fr.add(p1, BorderLayout.PAGE_END);

        fr.setSize(1080, 960);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bStart.addActionListener(this);
        bConti.addActionListener(this);
        bHow.addActionListener(this);
        bExit.addActionListener(this);
    }

    public static void main(String[] args) {
        new MainHome();
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
    
}
