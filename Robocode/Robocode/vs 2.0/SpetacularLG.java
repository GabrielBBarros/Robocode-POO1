package robo;

import robocode.*;
import java.awt.Color;

public class SpetacularLG extends AdvancedRobot {

    boolean verifica_robo; // Olha se robo está no caminho dele
    double parede; // Movimentação de parede

    public void run() {

        setBodyColor(new java.awt.Color(10, 54, 175, 100));
        setGunColor(new java.awt.Color(242, 242, 242, 100));
        setRadarColor(Color.cyan);
        setBulletColor(Color.gray);

        // Ir até o final
        parede = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
        // Suponha que nenhum robo está ao seu caminho
        verifica_robo = false;

        // turnLeft to face a wall.
        // getHeading() % 90 means the reading(emainder of
        // getHeading() divided by 90.
        turnLeft(getHeading() % 90);
        ahead(parede);
        // Turn the gun to turn right 90 degrees.
        verifica_robo = true;
        turnGunRight(90);
        turnRight(90);

        while (true) {
            // Look before we turn when ahead() completes.
            verifica_robo = true;
            // Move up the wall
            ahead(parede);
            // Don't look now
            verifica_robo = false;
            // Turn to the next wall
            turnRight(90);
        }
    }
    
    //Se bater em um robo
    public void onHitRobot(HitRobotEvent e) {
        if (e.getBearing() > -90 && e.getBearing() < 90) {
            back(100);
        }
        else {
            ahead(100);
        }
    }

    /*Se escanear um robo se inimigo muito perto fire(3), se inimigo médio
    fire(2) e inimigo muito longe fire(1)*/
    public void onScannedRobot(ScannedRobotEvent inimigo) {

       
            fire(2);
        
    }

}
