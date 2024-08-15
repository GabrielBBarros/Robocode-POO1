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
public class MeuRobo2 extends RoboBasico
    {
        int forca_tiro = 1;
        public void atirar(){
        fire(1);
        }
public void atirar(int forca){
    fire(forca);
}
public void configurarRobo() {
    configurarCor("Corinthians");
}
public void mover(){
    setAhead(200);
    setTurnRight(30);
    turnGunRight(10);
}

public void onScannedRobot(ScannedRobotEvent e) {
    atirar(forca_tiro);
    if (forca_tiro <= 3)
    forca_tiro++;
    else
    forca_tiro = 1;
    atirar();
}
public void onHitWall(HitWallEvent e) {
// quando bater na parede, recuar 50 e virar 45 graus
    back(50);
    turnRight(45);
    }
}