package Robots;

import robocode.*;

public class Robo2_1 extends MeuRobo2 {
   
    public void configurarRobo() {
        configurarCor("Santos");
}
    public void onHitByBullet(HitByBulletEvent e){
        back(100);
        turnRight(90);
        ahead(50);
    }
    
}