/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robot;
import robocode.*;
import java.awt.Color;
/**
 *
 * @author gabri
 */
public class Fantastic_LG extends AdvancedRobot {
   
    public void run(){
    
    setBodyColor(new java.awt.Color(10,54,175,100));
    setGunColor(new java.awt.Color(242,242,242,100));
    setRadarColor(Color.cyan);
    setBulletColor(Color.gray);
    
    while(true){
        mover();
    }
    }
    
    public void mover(){
        ahead(100);
        turnGunRight(180);
        back(50);
        setAhead(200);
        setTurnRight(30);
        turnGunRight(10);
}
    public void onHitByBullet(HitByBulletEvent e){
        setBack(80);
        setTurnLeft(90);
        setAhead(50); 
    }
    
    public void onScannedRobot(ScannedRobotEvent e){
        double distance = e.getDistance();

        if (distance < 50){
            fire(2);
        }
        else if (distance < 100){
            fire(1.5);
        }
        else{
            fire(1);
        }
    }
    
    public void onHitWall(HitWallEvent e) {
// quando bater na parede, recuar 50 e virar 45 graus
        setBack(50);
        setTurnLeft(70);
    }
    
    
}
