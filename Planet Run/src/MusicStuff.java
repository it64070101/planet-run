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
import javax.swing.JOptionPane;

public class MusicStuff {

    public static void playMusic(String filepath) {
//        InputStream music;
        try {
            File music1 = new File(filepath);
            if (music1.exists()) {

                AudioInputStream audio = AudioSystem.getAudioInputStream(music1);
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
//                
                if(clip.isRunning()){
                    JOptionPane.showMessageDialog(null, "Pause");
                    clip.stop();
                }
                else{
                    clip.start();
                }
//                clip.start();
                
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                double gain = 0.25;
                float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
                gainControl.setValue(dB);

//                JOptionPane.showMessageDialog(null, "Pause");
//                long clipTimePosition = clip.getMicrosecondPosition();
//                clip.stop();
//                
//                JOptionPane.showMessageDialog(null, "Resume");
//                clip.setMicrosecondPosition(clipTimePosition);
//                clip.start();
            } else {
                System.out.println("Peter");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void stopMusic(String filepath){
//        InputStream music;
        try{
            File music1 = new File(filepath);
            if(music1.exists()){
                
                AudioInputStream audio = AudioSystem.getAudioInputStream(music1);
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                double gain = 0.25;
                float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
                gainControl.setValue(dB);
//                
//                if(clip.isActive()){
                    clip.stop();
//                }
//                else{
//                    clip.start();
//                }
//                clip.start();
                
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
