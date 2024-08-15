
package Robots;
import robocode.*;


public class Robo2_2 extends MeuRobo2{
    
    
public void onScannedRobot(ScannedRobotEvent e){
    double distance = e.getDistance();
    
    if (distance < 50){
        fire(3);
    }
    else if (distance < 100){
        fire(2);
    }
    else{
        fire(1);
    }
}
}