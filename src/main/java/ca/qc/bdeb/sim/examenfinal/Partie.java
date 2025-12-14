package ca.qc.bdeb.sim.examenfinal;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class Partie  {



    protected int score;

    double timerFin=0;

    protected Raquette raquetteGauche;
    protected Raquette raquetteDroite;
    protected boolean finPartie;
    protected Balle balle;
    protected int pointageJoueur;
    protected int pointageRobot;
    boolean but;
    long debut = System.nanoTime();


    public Partie() {
        this.raquetteGauche= new Raquette(true,true);
        this.raquetteDroite= new Raquette(false, false);
        this.balle= new Balle();
        this.pointageRobot=0;
        this.pointageJoueur=0;



    }

    public void update(double deltaTemps) {
        if(Input.isKeyPressed(KeyCode.UP)) {
            raquetteGauche.deplacer(deltaTemps, -600);
        }
         if(Input.isKeyPressed(KeyCode.DOWN)){
             raquetteGauche.deplacer(deltaTemps, 600);
         }


         if(balle.collision(raquetteDroite) ){
             balle.rebondir();}

         if(balle.collision(raquetteGauche)){
             balle.rebondir();
         }


        if(balle.x>= Main.WIDTH || balle.x<0){

//            finPartie= true;
            balle.x= Main.WIDTH/2;
        }

        if(balle.y>= Main.HEIGHT && balle.x<= Main.WIDTH/2){
            pointageRobot++;
            balle.reintinialiser();
        }
        if(balle.y>= Main.HEIGHT && balle.x>= Main.WIDTH/2){
            pointageJoueur++;
            balle.reintinialiser();
        }
        if(pointageRobot==3 || pointageJoueur==3){
            finPartie=true;
            recommencer();
        }






        raquetteGauche.updatePhysique(deltaTemps);
        raquetteDroite.updatePhysique(deltaTemps);
        balle.updatePhysique(deltaTemps);



        // TODO : Faire avancer le jeu
    }
    public void recommencer(){
        balle.x= Main.WIDTH/2;
        balle.y= Main.HEIGHT/2;
        balle.vy= 180;
        balle.vx=300;
        pointageJoueur=0;
        pointageRobot=0;

    }


    public void draw(GraphicsContext context) {



        context.setFill(Color.BLACK);

        context.fillRect(0,0,640, 480);

        context.setLineDashes(0);
        context.setStroke(Color.WHITE);
        context.strokeRect(Main.WIDTH/2-(350/2),100,350,250);

        context.setLineDashes(5);
        context.strokeLine(Main.WIDTH/2,480 //taille en y
               ,Main.WIDTH/2,0);

        context.setLineDashes(0);
        context.strokeLine(640,480/2,0,480/2);
        raquetteGauche.draw(context);
        raquetteDroite.draw(context);
        balle.draw(context);

        context.setFill(Color.WHITE);

        context.setFont(Font.font(55));
        context.fillText(Integer.toString(pointageJoueur), Main.WIDTH / 4, 50);
        context.fillText(Integer.toString(pointageRobot), (Main.WIDTH / 4)*3, 50);






        if(finPartie) {

           context.setFill(Color.RED);
           context.setFont(javafx.scene.text.Font.font(60));
           context.fillText("GAME OVER", Main.WIDTH / 2 - 250, Main.HEIGHT / 2 - 30);

       }
        // TODO : Dessiner le jeu
    }
}
