/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robot;
import robocode.*;
/**
 *
 * @author gabri
 */
public class Robo2_1 extends MeuRobo2 {
   
    public void configurarRobo() {
        configurarCor("Corinthians");
}
    public void onHitByBullet(HitByBulletEvent e){
        back(100);
        turnRight(90);
        ahead(50);
    }
    
}
