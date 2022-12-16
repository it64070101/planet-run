import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Maketool implements ActionListener{

    private JFrame fr;
    // private JLabel la1, la2, la3, la4, la5;
    private JPanel pGadget;
    private JButton gun, axe, hammer, pick, hook;
    private ImageIcon imgAxe, imgGun, imgHammer, imgPick, imgHook;

    public Maketool(){
        pGadget = new JPanel();
        fr = new JFrame();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        imgAxe = new ImageIcon("src/images/Axe.png");
        imgGun = new ImageIcon("src/images/Gun.png");
        imgHammer = new ImageIcon("src/images/Hammer.png");
        imgPick = new ImageIcon("src/images/Pickaxe.png");
        imgHook = new ImageIcon("src/images/Hook.png");

        gun = new JButton("Make Gun", imgGun);
        axe = new JButton("Make Axe", imgAxe);
        hammer = new JButton("Make Hammer", imgHammer);
        pick = new JButton("Make Pick", imgPick);
        hook = new JButton("Make Hook", imgHook);
        
        gun.setBackground(new Color(76, 103, 147));
        axe.setBackground(new Color(76, 103, 147));
        hammer.setBackground(new Color(76, 103, 147));
        pick.setBackground(new Color(76, 103, 147));
        hook.setBackground(new Color(76, 103, 147));
        gun.setForeground(new Color(174, 254, 255));
        axe.setForeground(new Color(174, 254, 255));
        hammer.setForeground(new Color(174, 254, 255));
        pick.setForeground(new Color(174, 254, 255));
        hook.setForeground(new Color(174, 254, 255));
        
        gun.setPreferredSize(new Dimension(250, 136));
        axe.setPreferredSize(new Dimension(250, 136));
        hammer.setPreferredSize(new Dimension(250, 136));
        pick.setPreferredSize(new Dimension(250, 136));
        hook.setPreferredSize(new Dimension(250, 136));
        
        gun.setFont(new Font("Ink Free", Font.BOLD, 15));
        axe.setFont(new Font("Ink Free", Font.BOLD, 15));
        hammer.setFont(new Font("Ink Free", Font.BOLD, 15));
        pick.setFont(new Font("Ink Free", Font.BOLD, 15));
        hook.setFont(new Font("Ink Free", Font.BOLD, 15));
        
        
        pGadget.setLayout(new GridLayout(5,1, 10, 10));
        pGadget.add(gun);
        pGadget.add(axe);
        pGadget.add(hammer);
        pGadget.add(pick);
        pGadget.add(hook);

        fr.setLayout(new FlowLayout());
        // p.setBackground(Color.BLACK);
        fr.add(pGadget);
        pGadget.setBackground(new Color(40, 42, 58));

        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(300, 780);
        fr.setLocation((int) (screenSize.width-(screenSize.width/5.5)),(int) (screenSize.height-(screenSize.height/1.1)));
        fr.setResizable(false);
        fr.getContentPane().setBackground(new Color(40, 42, 58));
        
        gun.addActionListener(this);
        axe.addActionListener(this);
        hammer.addActionListener(this);
        pick.addActionListener(this);
        hook.addActionListener(this);
    }
    public static void main(String[] args) {
        new Maketool();
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(gun)){
            gun.setEnabled(false);
            gun.setText("Sold!");
        }
        else if (e.getSource().equals(axe)){
            axe.setEnabled(false);
            axe.setText("Sold!");
        }
        else if (e.getSource().equals(hammer)){
            hammer.setEnabled(false);
            hammer.setText("Sold!");
        }
        else if (e.getSource().equals(pick)){
            pick.setEnabled(false);
            pick.setText("Sold!");
        }
        else if (e.getSource().equals(hook)){
            hook.setEnabled(false);
            hook.setText("Sold!");
        }
    }
}