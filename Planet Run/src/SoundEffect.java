/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Squid3rd
 */
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
//import javax.swing.JOptionPane;

public class SoundEffect {
    
    public static void playEffect(String filepath){
//        InputStream music;
        try{
            File music1 = new File(filepath);
            if(music1.exists()){
                
                AudioInputStream audio = AudioSystem.getAudioInputStream(music1);
                Clip clip = AudioSystem.getClip();
                
                clip.start();
                
//                clip.loop(Clip.LOOP_CONTINUOUSLY);
                
//                JOptionPane.showMessageDialog(null, "Pause");
//                long clipTimePosition = clip.getMicrosecondPosition();
//                clip.stop();
//                
//                JOptionPane.showMessageDialog(null, "Resume");
//                clip.setMicrosecondPosition(clipTimePosition);
//                clip.start();
            }
            else{
                System.out.println("Peter");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
