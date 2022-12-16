import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class HomePanel extends JPanel implements ActionListener{
    private final int PANEL_WIDTH = 1600;
    private final int PANEL_HEIGHT = 900;
    Image ani;
    Image backgroundimg;
    Timer timer;

    int xVelo = 1;
    int yValo = 1;
    int x = 0;
    int y = 0;

    HomePanel(){
        this.setPreferredSize(new Dimension(1600,900));
        this.setBackground(Color.BLACK);
        ani = new ImageIcon("images/Ani1.png").getImage();
        backgroundimg = new ImageIcon("images/spacetest.jpg").getImage();
        timer = new Timer(1000, null);
    }

    public void paint(Graphics g){

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(backgroundimg, 0, 0, null);
        g2D.drawImage(ani, x, y, null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        x = x + xVelo;
        repaint();
    }

    public static void main(String[] args) {
        new HomeFrame();
        
    }
}
