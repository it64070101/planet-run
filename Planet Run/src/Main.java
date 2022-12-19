import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        
        MainHome.getMusicplay().playMusic(MainHome.titleMusic);

        JFrame fr = new JFrame();
        MainHome p = new MainHome(fr);
        fr.setMinimumSize(new Dimension(1600, 900));
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.add(p);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
