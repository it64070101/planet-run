import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainHome {
    private JFrame fr;
    private JPanel p1, p2;
    private JLabel la1;
    private JButton bStart, bConti, bHow, bExit;

    public MainHome(){
        fr = new JFrame();
        p1 = new JPanel();
        p2 = new JPanel();
        bStart = new JButton("Start");
        bConti = new JButton("Continue");
        bHow = new JButton("How to Play");
        bExit = new JButton("Exit");

        bStart.setPreferredSize(new Dimension(150, 50));

        p1.setLayout(new GridLayout(4,1,5,5));
        p1.add(bStart); p1.add(bConti); 
        p1.add(bHow); p1.add(bExit); 

        fr.setLayout(new BorderLayout());
        fr.add(p1, BorderLayout.LINE_END);
        fr.add(p1, BorderLayout.PAGE_END);

        fr.setSize(1080, 960);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainHome();
    }
}
