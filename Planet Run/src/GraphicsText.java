
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class GraphicsText extends JPanel implements ActionListener{

    private Image backgroundimg;
    private int j = 500;
    private static JButton btn;
    private int day = 1;
    
    public GraphicsText(){
        btn = new JButton("Click");
        btn.addActionListener(this);
    }
    

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        backgroundimg = new ImageIcon("src/images/spacetest03.jpg").getImage();
        g2D.drawImage(backgroundimg, 0, 0, null);
        for (int i = 0; i < day; i++) {
            g2D.setColor(Color.yellow);
            g2D.fillOval(j - 350, 100, 25, 25);
            j += 30;
        }
        for (int i = 0; i < 15 - day; i++) {
            g2D.setColor(Color.gray);
            g2D.fillOval(j - 350, 100, 25, 25);
            j += 30;
        }

    }

    public static void main(String[] args) {
        GraphicsText p = new GraphicsText();
        JFrame fr = new JFrame();
        
        p.add(btn);
        fr.setSize(700, 700);
        fr.add(p);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btn)){
            day++;
            System.out.println(day);
            repaint();
        }
    }
}
