
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Maketool implements ActionListener, WindowListener {

    private JFrame fr;
    private JFrame toolBtn;
    // private JLabel la1, la2, la3, la4, la5;
    private JPanel pGadget;
    private JButton gun, axe, hammer, pick, hook;
    private ImageIcon imgAxe, imgGun, imgHammer, imgPick, imgHook;

    public Maketool() {

        System.out.println("Set to false");
        pGadget = new JPanel();
        fr = new JFrame();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        imgAxe = new ImageIcon("src/images/Axe.png");
        imgGun = new ImageIcon("src/images/Gun.png");
        imgHammer = new ImageIcon("src/images/Hammer.png");
        imgPick = new ImageIcon("src/images/Pickaxe.png");
        imgHook = new ImageIcon("src/images/Hook.png");

        gun = new JButton("Make Gun", imgGun);
        checkObtained(ToolBox.gun, gun);
        axe = new JButton("Make Axe", imgAxe);
        checkObtained(ToolBox.axe, axe);
        hammer = new JButton("Make Hammer", imgHammer);
        checkObtained(ToolBox.hammer, hammer);
        pick = new JButton("Make Pick", imgPick);
        checkObtained(ToolBox.pick, pick);
        hook = new JButton("Make Hook", imgHook);
        checkObtained(ToolBox.hook, hook);

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

        pGadget.setLayout(new GridLayout(5, 1, 10, 10));
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
        fr.setLocation((int) (screenSize.width - (screenSize.width / 5.5)), (int) (screenSize.height - (screenSize.height / 1.1)));
        fr.setResizable(false);
        fr.getContentPane().setBackground(new Color(40, 42, 58));
//        fr.setUndecorated(true);
        gun.addActionListener(this);
        axe.addActionListener(this);
        hammer.addActionListener(this);
        pick.addActionListener(this);
        hook.addActionListener(this);
        fr.addWindowListener(this);
    }

    public static void checkObtained(Gadget gadget, JButton btt) {
        if (gadget.isObtained()) {
            btt.setEnabled(false);
            btt.setText("Obtained");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(gun)) {
            sectorCheck(ToolBox.gun, Area.sectorMap.get("Altar"), gun);
        } else if (e.getSource().equals(axe)) {
            sectorCheck(ToolBox.axe, Area.sectorMap.get("Mountain"), axe);
        } else if (e.getSource().equals(hammer)) {
            sectorCheck(ToolBox.hammer, Area.sectorMap.get("Forest"), hammer);
        } else if (e.getSource().equals(pick)) {
            sectorCheck(ToolBox.pick, Area.sectorMap.get("Desert"), pick);
        } else if (e.getSource().equals(hook)) {
            if (Player.construction(ToolBox.hook, MainUI.sliderInput())) {
                hook.setEnabled(false);
                hook.setText("Obtained");
            }
        }
        MainUI.update();
        MainUI.endOfDay();
    }

    public void sectorCheck(Gadget gadget, Sector sector, JButton btn) {
        if (sector.isExplored()) {
            if (Player.construction(gadget, MainUI.sliderInput())) {
                btn.setEnabled(false);
                btn.setText("Obtained");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You can't make " + gadget.getName() + " because " + sector.getName() + " is not discovered yet.");
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
        MainHome.fr1.setEnabled(false);

//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosing(WindowEvent e) {
        MainHome.fr1.setEnabled(true);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosed(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowIconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
