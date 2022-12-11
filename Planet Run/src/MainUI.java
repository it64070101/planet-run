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

public class MainUI {
    private JFrame fr;
    private JPanel pAll, pShip, pHuntingGround, pSectors, pGadget, pRest, pLabel, pButton;
    private JButton noseCone, shockcord, recoveryWadding, leftFin, rightFin;
    private JButton sectorA, sectorB, sectorC, sectorD, rest;
    private JButton huntingGround0, huntingGround1;
    private JButton gun, axe, hammer, pick, hook;
    private JTextField dayTxt, foodTxt, starTxt, triangleTxt, squareTxt, circleTxt;
    
    public MainUI(){
        fr = new JFrame("Planet Run");
        
        pAll = new JPanel();
        pShip = new JPanel();
        pHuntingGround = new JPanel();
        pSectors = new JPanel();
        pGadget = new JPanel();
        pRest = new JPanel();
        pLabel = new JPanel();
        pButton = new JPanel();
        
        noseCone = new JButton("<html>Fix<br>Nose Cone</html>");
        shockcord = new JButton("<html>Fix<br>Shockcord</html>");
        recoveryWadding = new JButton("<html>Fix<br>Recovery<br>Wadding</html>");
        leftFin = new JButton("<html>Fix<br>Left<br>Fin</html>");
        rightFin = new JButton("<html>Fix<br>Right<br>Fin</html>");
        
        pButton.setLayout(new GridLayout(2,2));
        
        pShip.setLayout(new BorderLayout());
        pShip.setSize(256, 256);
        pShip.add(noseCone, BorderLayout.NORTH);
        pShip.add(shockcord, BorderLayout.CENTER);
        pShip.add(recoveryWadding, BorderLayout.SOUTH);
        pShip.add(leftFin, BorderLayout.WEST);
        pShip.add(rightFin, BorderLayout.EAST);
        
        sectorA = new JButton("Explore this Sector");
        sectorB = new JButton("Explore this Sector");
        sectorC = new JButton("Explore this Sector");
        sectorD = new JButton("Explore this Sector");
        rest = new JButton("Rest");
        
        pSectors.setLayout(new GridLayout(2,2));
        pSectors.add(sectorA);
        pSectors.add(sectorB);
        pSectors.add(sectorC);
        pSectors.add(sectorD);
        
        huntingGround0 = new JButton("Fight this Animal");
        huntingGround1 = new JButton("Fight this Animal");
        
        pHuntingGround.setLayout(new GridLayout(3, 1));
        pHuntingGround.add(huntingGround0);
        pHuntingGround.add(huntingGround1);
        pHuntingGround.add(rest);
        
        gun = new JButton("Make Gun");
        axe = new JButton("Make Axe");
        hammer = new JButton("Make Hammer");
        pick = new JButton("Make Pick");
        hook = new JButton("Make Hook");
        
        pGadget.setLayout(new GridLayout(5,1));
        pGadget.add(gun);
        pGadget.add(axe);
        pGadget.add(hammer);
        pGadget.add(pick);
        pGadget.add(hook);
        
        
        dayTxt = new JTextField("Day: 0");
        foodTxt = new JTextField("Food: 0");
        starTxt = new JTextField("Star: 0");
        triangleTxt = new JTextField("Triangle: 0");
        squareTxt = new JTextField("Square: 0");
        circleTxt = new JTextField("Circle: 0");
        
        pLabel.add(dayTxt);
        pLabel.add(foodTxt);
        pLabel.add(starTxt);
        pLabel.add(triangleTxt);
        pLabel.add(squareTxt);
        pLabel.add(circleTxt);
        
        pButton.add(pShip);
        pButton.add(pHuntingGround);
        pButton.add(pSectors);
        pButton.add(pGadget);
        
        pAll.setLayout(new BorderLayout());
        
        pAll.add(pLabel, BorderLayout.NORTH);
        pAll.add(pButton);
        
        fr.add(pAll);
        
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(512, 512);
        fr.setVisible(true);
    }
    
    public static void main(String[] args) {
        new MainUI();
    }
}
