package Lucas_Luiz_Gabriel;
import robocode.*;
import java.awt.Color;

public class Wall_E extends AdvancedRobot{
    boolean verifica_robo; // Olha se robo está no caminho dele
    double parede; // Movimentação de parede

    public void run() {
            
        //Colocar cores no robo
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
            if( pertoParede()){
                turnRight(90);
            }
        }
    }
    
    //Se bater em um robo
    public void onHitRobot(HitRobotEvent e) {
        mira(e.getBearing());
     
    }
    
    public void mira(double Adv) {
        
	double A=getHeading()+Adv-getGunHeading();
	if (!(A > -180 && A <= 180)) {
		while (A <= -180) {
			A += 360;
		}
		while (A > 180) {
			A -= 360;
		}
	}
	turnGunRight(A);
        
}
    //Função ve se está perto da parede
    public boolean pertoParede() {
	return (getX() < 100 || getX() > getBattleFieldWidth() - 100 ||
		getY() < 100 || getY() > getBattleFieldHeight() - 100);
}
    
    /**/
    public void onScannedRobot(ScannedRobotEvent e){
            if(verifica_robo){
                    mira(e.getBearing());
                    double distancia = e.getDistance();
                    double energia =e.getEnergy();

                    if ((distancia <= 50) && (energia>=80)){
                        fire(3);
                    }
                    else if ((distancia <= 50)&& (energia<80)){
                        fire(2);
                    }
                    else if ((distancia > 50)&& (energia<80)){
                        fire(1.5);
                    }
                    else{
                        fire(1);
                    }
            }
        
    }
    public void onWin(WinEvent e) {
            int cont = 0;
            while(cont<10) {
			turnRight(30);
			turnLeft(30);
                        back(30);
                        ahead(30);
                        cont++;
		}
	}
  
}
