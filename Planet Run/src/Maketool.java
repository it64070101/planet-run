
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

        pGadget = new JPanel();
        fr = new JFrame("Tool box");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        imgAxe = new ImageIcon("src/images/Axe.png");
        imgGun = new ImageIcon("src/images/Gun.png");
        imgHammer = new ImageIcon("src/images/Hammer.png");
        imgPick = new ImageIcon("src/images/Pickaxe.png");
        imgHook = new ImageIcon("src/images/Hook.png");

        gun = new JButton("Required: "+ToolBox.getGun().getSectorRequirement().getName()+" (Hard)", imgGun);
        axe = new JButton("Required: "+ToolBox.getAxe().getSectorRequirement().getName()+" (Hard)", imgAxe);
        hammer = new JButton("Required: "+ToolBox.getHammer().getSectorRequirement().getName()+" (Hard)", imgHammer);
        pick = new JButton("Required: "+ToolBox.getPick().getSectorRequirement().getName()+" (Hard)", imgPick);
        hook = new JButton("For fishing (Hard)", imgHook);
        
        setButton();

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
//        fr.setSize(300, 780);
        fr.pack();
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
            sectorCheck(ToolBox.getGun(), ToolBox.getGun().getSectorRequirement(), gun);
        } else if (e.getSource().equals(axe)) {
            sectorCheck(ToolBox.getAxe(), ToolBox.getAxe().getSectorRequirement(), axe);
        } else if (e.getSource().equals(hammer)) {
            sectorCheck(ToolBox.getHammer(), ToolBox.getHammer().getSectorRequirement(), hammer);
        } else if (e.getSource().equals(pick)) {
            sectorCheck(ToolBox.getPick(), ToolBox.getPick().getSectorRequirement(), pick);
        } else if (e.getSource().equals(hook)) {
            if (Player.craft(ToolBox.getHook(), MainUI.sliderInput())) {
                hook.setEnabled(false);
                hook.setText("Obtained");
            }
        }
        MainUI.update();
        MainUI.endOfDay();
    }

    public void sectorCheck(Gadget gadget, Sector sector, JButton btn) {
        if (sector.isExplored()) {
            if (Player.craft(gadget, MainUI.sliderInput())) {
                btn.setEnabled(false);
                btn.setText("Obtained");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You can't make " + gadget.getName() + " because " + sector.getName() + " is not discovered yet.");
        }

    }
    
    public void setButton(){
        Color bgColor = new Color(76, 103, 147);
        Color fgColor = new Color(174, 254, 255);
        Dimension preferedSize = new Dimension(256, 160);
        Font font = new Font("Ink Free", Font.BOLD, 15);
        int hText = JButton.CENTER;
        int vText = JButton.BOTTOM;
        
        checkObtained(ToolBox.getGun(), gun);
        checkObtained(ToolBox.getAxe(), axe);
        checkObtained(ToolBox.getHammer(), hammer);
        checkObtained(ToolBox.getPick(), pick);
        checkObtained(ToolBox.getHook(), hook);
        
        gun.setBackground(bgColor);
        axe.setBackground(bgColor);
        hammer.setBackground(bgColor);
        pick.setBackground(bgColor);
        hook.setBackground(bgColor);
        
        gun.setForeground(fgColor);
        axe.setForeground(fgColor);
        hammer.setForeground(fgColor);
        pick.setForeground(fgColor);
        hook.setForeground(fgColor);

        gun.setPreferredSize(preferedSize);
        axe.setPreferredSize(preferedSize);
        hammer.setPreferredSize(preferedSize);
        pick.setPreferredSize(preferedSize);
        hook.setPreferredSize(preferedSize);

        gun.setFont(font);
        axe.setFont(font);
        hammer.setFont(font);
        pick.setFont(font);
        hook.setFont(font);
        
        gun.setHorizontalTextPosition(hText);
        axe.setHorizontalTextPosition(hText);
        hammer.setHorizontalTextPosition(hText);
        pick.setHorizontalTextPosition(hText);
        hook.setHorizontalTextPosition(hText);
        
        gun.setVerticalTextPosition(vText);
        axe.setVerticalTextPosition(vText);
        hammer.setVerticalTextPosition(vText);
        pick.setVerticalTextPosition(vText);
        hook.setVerticalTextPosition(vText);
        
        gun.setToolTipText(ToolBox.getGun().getAbility());
        axe.setToolTipText(ToolBox.getAxe().getAbility());
        hammer.setToolTipText(ToolBox.getHammer().getAbility());
        pick.setToolTipText(ToolBox.getPick().getAbility());
        hook.setToolTipText(ToolBox.getHook().getAbility());
        
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
