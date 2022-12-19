
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.*;

public class MainHome extends JPanel implements ActionListener {

    public static JFrame fr, fr1;
    private JPanel p1, p2, pName;
    private JLabel title1, nameLbl;
    private JButton bStart, bHighscore, bHow, bExit;
    private String name;
    private JTextField nameField;
    public static MainUI frame;
    private int ch;
    private static String str = "";
    private static String titleMusic = "title.wav", playingMusic = "playing.wav";
    private static MusicStuff musicplay = new MusicStuff();
    private static HashMap<String, Integer> highScore;
    private static LinkedHashMap<String, Integer> sortedScore;

    Image backgroundimg;
    Image ani1, ani2, ani3, ani4;

    public int px = 0, py = 0;

    public MainHome(JFrame fr) {
        sortedScore = new LinkedHashMap<>();
        highScore = new HashMap<String, Integer>();
        
        

        
        this.fr = fr;
        p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 1, 5, 10));
        p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        bStart = new JButton("Start");
        bHighscore = new JButton("Leaderboard");
        bHow = new JButton("How to Play");
        bExit = new JButton("Exit");
        pName = new JPanel(new GridLayout(2, 1));
        nameField = new JTextField("Christopher", 10);
        nameLbl = new JLabel("What is your name ?");
        pName.add(nameLbl);
        pName.add(nameField);

        p1.setBackground(new Color(0, 0, 0, 0));
        p2.setBackground(new Color(0, 0, 0, 0));

        bStart.setPreferredSize(new Dimension(450, 80));
        bHighscore.setPreferredSize(new Dimension(450, 80));
        bHow.setPreferredSize(new Dimension(450, 80));
        bExit.setPreferredSize(new Dimension(450, 80));

        bStart.setFont(new Font("Ink Free", Font.BOLD, 25));
        bStart.setBackground(new Color(192, 96, 161));
        bStart.setForeground(new Color(255, 255, 255));
        bHighscore.setFont(new Font("Ink Free", Font.BOLD, 25));
        bHighscore.setBackground(new Color(192, 96, 161));
        bHighscore.setForeground(new Color(255, 255, 255));
        bHow.setFont(new Font("Ink Free", Font.BOLD, 25));
        bHow.setBackground(new Color(192, 96, 161));
        bHow.setForeground(new Color(255, 255, 255));
        bExit.setFont(new Font("Ink Free", Font.BOLD, 25));
        bExit.setBackground(new Color(192, 96, 161));
        bExit.setForeground(new Color(255, 255, 255));

        p1.add(bStart);
        p1.add(bHow);
        p1.add(bHighscore);
        p1.add(bExit);
        p1.add(new JLabel());
        p2.add(p1, BorderLayout.SOUTH);

        setSize(512, 512);
        setOpaque(false);
        setLayout(new GridLayout(1, 3));
        add(new JLabel());
        add(p2);
        add(new JLabel());

        bStart.addActionListener(this);
        bHighscore.addActionListener(this);
        bHow.addActionListener(this);
        bExit.addActionListener(this);
    }
    
    static String filepath = "maintest.wav";
    static String effect1 = "soundclick.wav";
//    private MusicStuff musicplay = new MusicStuff();
    
    public static void main(String[] args) {
//        String filepath = "songtest.wav";

//        MusicStuff musicplay = new MusicStuff();
        MusicStuff.playMusic(filepath);

        JFrame fr = new JFrame();
        MainHome p = new MainHome(fr);
        fr.setMinimumSize(new Dimension(1600, 900));
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.add(p);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bStart)) {
//            System.out.println(frame);

//            String filepath = "songtest.wav";
//            MusicStuff musicplay = new MusicStuff();
            
            
            SoundEffect ef = new SoundEffect();
//            ef.playEffect(effect1);
            
            JOptionPane.showMessageDialog(null, pName, "What is your name ?", JOptionPane.PLAIN_MESSAGE);
            name = nameField.getText();
            if (nameField.getText().equals("") || nameField.getText() == null) {
                name = "Christopher";
            }
            new Dice(6);
            new Player(name);
            new Storage();
            new Area();
            new Ship();
            new ToolBox();
            
            try {
                frame = new MainUI();
            }
            catch (Exception ex){
                System.out.println(ex);
                frame = new MainUI();
            }
            

            fr1 = new JFrame();
            fr1.getContentPane().setBackground(new Color(0, 0, 0, 0));
            fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fr1.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fr1.setUndecorated(true);
            fr1.setLocationRelativeTo(null);
            fr1.setVisible(true);
            fr1.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
            fr1.setResizable(false);
            fr1.add(frame);
//            MainHome.musicplay.playMusic(MainHome.playingMusic);
            JOptionPane.showMessageDialog(null, "You start day " + MainUI.getDay() + " with " + Player.getEnergy() + " Energy.", "Day " + MainUI.getDay(), JOptionPane.PLAIN_MESSAGE);

//            musicplay.stopMusic("songtest.wav");
//            musicplay.playMusic("maintest.wav");
            
            Thread n1 = new Thread(frame);
            n1.start();

            fr.dispose();

        } else if (e.getSource().equals(bHighscore)) {
            highScore();
        } else if (e.getSource().equals(bHow)) {
            
//            MusicStuff.stopMusic(filepath);
            SoundEffect ef = new SoundEffect();
            ef.playEffect(effect1);
            
            howToPlay();
        } else if (e.getSource().equals(bExit)) {
            System.exit(0);

        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        Graphics2D gString = (Graphics2D) g;
        ani1 = new ImageIcon("src/images/Ani1.png").getImage();
        ani2 = new ImageIcon("src/images/Ani2.png").getImage();
        backgroundimg = new ImageIcon("src/images/spacetest01.jpg").getImage();
        g2D.drawImage(backgroundimg, 0, 0, null);
        g2D.drawImage(ani1, 1, 1, null);
        g2D.drawImage(ani2, 1450, 1, null);
        gString.setFont(new Font("Ink Free", Font.BOLD, 70));
        gString.setColor(new Color(255, 255, 255));
        gString.drawString("Planet run the BoardGame with Java", 190, 180);
    }

    public void howToPlay() {
        try ( FileReader fileReader = new FileReader("src/rules.txt");) {
            while ((ch = fileReader.read()) != -1) {
                str += (char) ch;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JPanel p = new JPanel();

        JTextArea ta = new JTextArea(str, 30, 100);
        ta.setLineWrap(true);
        ta.setEditable(false);
        ta.setWrapStyleWord(true);
        JScrollPane taScroll = new JScrollPane(ta);
        taScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p.add(taScroll);
        JOptionPane.showMessageDialog(null, taScroll, "How to Play", JOptionPane.PLAIN_MESSAGE);
    }

    public void highScore() {
        sortScore();
        JPanel p = new JPanel();
        String data[][] = new String[highScore.keySet().size()][2];
        int index = 0;
        
        for (String key : sortedScore.keySet()) {
            data[index][0] = key;
            data[index][1] = sortedScore.get(key)+"";
            index++;
        }
        String column[] = {"NAME", "SCORE"};
        JTable jt = new JTable(data, column);
        jt.setEnabled(false);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        p.add(sp);
        JOptionPane.showMessageDialog(null, p, "Leaderboard", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void sortScore(){
        try(FileInputStream fIn = new FileInputStream("HighScore.dat");
            ObjectInputStream oin = new ObjectInputStream(fIn);){
            highScore = (HashMap<String, Integer>) oin.readObject();
        }
        catch(IOException ioe){
            System.out.println(ioe);
        }
        catch(ClassNotFoundException cnfe){
            System.out.println(cnfe);
        }
        
        ArrayList<Integer> score = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : highScore.entrySet()) {
            score.add(entry.getValue());
        }
        Collections.sort(score); 
        Collections.reverse(score);
        for (int num : score) {
            for (Entry<String, Integer> entry : highScore.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedScore.put(entry.getKey(), num);
                }
            }
        }
    }

    public static HashMap<String, Integer> getHighScore() {
        return highScore;
    }

    public static void setHighScore(HashMap<String, Integer> highScore) {
        MainHome.highScore = highScore;
    }
    
    

}
