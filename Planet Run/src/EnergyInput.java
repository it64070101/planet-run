/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class EnergyInput{

    private static JPanel pInput, pEnergy;
    private ButtonGroup group;
    private JRadioButton e1, e2, e3, e4, e5, e6;
    private JLabel howMany;

    public EnergyInput() {

        pInput = new JPanel(new BorderLayout());
        pEnergy = new JPanel();
        group = new ButtonGroup();
        howMany = new JLabel("How many energy ?");

        e1 = new JRadioButton("1");
        e1.setActionCommand(e1.getText());
        e2 = new JRadioButton("2");
        e2.setActionCommand(e2.getText());
        e3 = new JRadioButton("3");
        e3.setActionCommand(e3.getText());
        e4 = new JRadioButton("4");
        e4.setActionCommand(e4.getText());
        e5 = new JRadioButton("5");
        e5.setActionCommand(e5.getText());
        e6 = new JRadioButton("6");
        e6.setActionCommand(e6.getText());

        group.add(e1);
        group.add(e2);
        group.add(e3);
        group.add(e4);
        group.add(e5);
        group.add(e6);

        select();
        e1.setSelected(true);

        pEnergy.add(e1);
        pEnergy.add(e2);
        pEnergy.add(e3);
        pEnergy.add(e4);
        pEnergy.add(e5);
        pEnergy.add(e6);

        pInput.add(howMany, BorderLayout.NORTH);
        pInput.add(pEnergy);
        int num = 0;
        JOptionPane.showMessageDialog(null, pInput);
            if (e1.isSelected()) {
                num = 1;
            } else if (e2.isSelected()) {
                num = 2;
            } else if (e3.isSelected()) {
                num = 3;
            }
             else if (e4.isSelected()) {
                num = 4;
            }
             else if (e5.isSelected()) {
                num = 5;
            }
             else if (e6.isSelected()) {
                num = 6;
            }
                    System.out.println(num);


    }

    public static void main(String[] args) {
        new Player("");
        new EnergyInput();
    }

    public void select() {
        if (Player.energy < 6) {
            e6.setEnabled(false);
        }
        if (Player.energy < 5) {
            e5.setEnabled(false);
        }
        if (Player.energy < 4) {
            e4.setEnabled(false);
        }
        if (Player.energy < 3) {
            e3.setEnabled(false);
        }
        if (Player.energy < 2) {
            e2.setEnabled(false);
        }
    }

}
