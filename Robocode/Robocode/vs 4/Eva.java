package Robos;
import robocode.*;
import java.awt.Color;

public class Eva extends AdvancedRobot{

    public void run() {
            
        //Colocar cores no robo
        //Cor do corpo
        setBodyColor(new java.awt.Color(10, 54, 175, 100));
        //Cor do canhão
        setGunColor(new java.awt.Color(242, 242, 242, 100));
        //Cor do radar
        setRadarColor(Color.cyan);
        //Cor da bala
        setBulletColor(Color.gray);
        
        while(true){
        turnRight(100);
        turnGunRight(360);
        turnLeft(100);
        } 
    }
    
/*Quandoo robo é escaneado ele verifica a energia e adistancia para tomar 
    decisões de potencia de disparo*/
    public void onScannedRobot(ScannedRobotEvent e){
                     double energia;//Variavel de energia
                     double distancia;//Variavel de distancia
    
                    //Variavel de distancia pega distancia
                    distancia = e.getDistance();
                    //Variavel de energia pega energia
                    energia =e.getEnergy(); 
                    //Estrutura condiconal
                    if ((distancia <= 50) && (energia>=80)){
                        fire(3);
                    }
                    else if ((distancia <= 50)&& (energia<80)){
                        fire(2);
                    }
                    else if ((distancia > 50)&& (energia<80)){
                        fire(1);
                    }
                    else{
                        fire(1);
                    }
            }
    
    //Faz uma dança em caso de vitória
     public void onWin(WinEvent e) {
            turnRight(60);
            turnLeft(30);
            back(30);
            ahead(30);	     
	} 
     
     //Se bater na parede
     public void onHitWall(HitWallEvent e) {
        back(50);
        turnLeft(50);
        
   }
}
    
 
