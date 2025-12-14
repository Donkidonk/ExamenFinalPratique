package ca.qc.bdeb.sim.examenfinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Balle extends ObjetDuJeu{

Random r = new Random();
double vy;
double vx;
double x;
    private double direction;

public Balle(){
    this.vx = 300;
    this.vy= 180;
    this.direction=direction;
    this.x=Main.WIDTH/2;
    this.y= Main.WIDTH/2;


}
    @Override
    protected void updatePhysique(double deltaTemps){

        x += deltaTemps * vx*-1;
        y += deltaTemps * vy;






    }











    public boolean collision(Raquette autre){
        return !(this.getDroite() < autre.getGauche() ||
                this.getBas() < autre.getHaut() ||
                autre.getDroite() < this.getGauche() ||
                autre.getBas() < this.getHaut());


    }

    public void rebondir() {

            vx = -vx;
            vy = Math.random() * 360 - 180; //DEMANDER A CHAT

    }
    public void reintinialiser(){
    x= Main.WIDTH/2;
    y=Main.HEIGHT/2;
//    int rand= r.nextInt(1,2);
//    if(rand==1){
//        rand=-1;
//    }
//    if(rand == 2){
//        rand=1;
//    }
//    vx= rand*vx;
//    vy=rand*vy;



    }


    @Override

    public void draw(GraphicsContext context) {

        context.setFill(Color.WHITE);
        context.fillOval(x,y,25,25);

    }

    public void setDirection(){
    if(Math.random()<=0.5){
        direction=1;
    }
    if(Math.random()>0.5){
        direction=-1;
    }
    }
}
