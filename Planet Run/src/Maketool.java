import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Maketool{

    private JFrame fr;
    // private JLabel la1, la2, la3, la4, la5;
    private JPanel pGadget;
    private JButton gun, axe, hammer, pick, hook;
    private ImageIcon imgAxe, imgGun, imgHammer, imgPick, imgHook;

    public Maketool(){
        pGadget = new JPanel();
        fr = new JFrame();

        imgAxe = new ImageIcon("images/Axe.png");
        imgGun = new ImageIcon("images/Gun.png");
        imgHammer = new ImageIcon("images/Hammer.png");
        imgPick = new ImageIcon("images/Pickaxe.png");
        imgHook = new ImageIcon("images/Hook.png");

        gun = new JButton("Make Gun", imgGun);
        axe = new JButton("Make Axe", imgAxe);
        hammer = new JButton("Make Hammer", imgHammer);
        pick = new JButton("Make Pick", imgPick);
        hook = new JButton("Make Hook", imgHook);
        
        pGadget.setLayout(new GridLayout(5,1, 10, 10));
        pGadget.add(gun);
        pGadget.add(axe);
        pGadget.add(hammer);
        pGadget.add(pick);
        pGadget.add(hook);

        fr.setLayout(new FlowLayout());
        // p.setBackground(Color.BLACK);
        fr.add(pGadget);
        pGadget.setBackground(Color.BLACK);

        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(300, 780);
        fr.setLocation(1000,30);
        fr.setResizable(false);
        fr.getContentPane().setBackground(Color.BLACK);
    }
    public static void main(String[] args) {
        new Maketool();
    }
}