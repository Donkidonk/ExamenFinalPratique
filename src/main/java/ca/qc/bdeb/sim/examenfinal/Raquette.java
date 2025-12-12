package ca.qc.bdeb.sim.examenfinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import javafx.geometry.Point2D;

public class Raquette extends ObjetDuJeu{

private boolean joueur;
private boolean gauche;
private double direction;
private double duree;




    public Raquette(boolean joueur, boolean gauche){

      this.joueur= joueur;
      this.gauche = gauche;
      this.w= 15; //LARGEUR
      this.h=90;//HAUTEUR
      this.y= (Main.WIDTH-h)/2;
      this.vx=0;

      if(joueur){
          this.vy=600;
          this.x=10;
      }
      else{
          this.vy=200;
          this.x=Main.WIDTH-w-10;
          choisir();

      }


    }



    @Override
protected void updatePhysique(double deltaTemps){


        super.updatePhysique(deltaTemps);


}



public void choisir(){

        if(Math.random()<0.5){
            direction= -1;

        }
        else{
            direction =1;
        }
        duree= Math.random()+1;


}




//
//    - Position : côté gauche du terrain. Initialement : centrée verticalement.
//            - Forme : rectangle blanc de largeur=15px et de hauteur=90px.
//- Déplacement : vertical contrôlé par le joueur
    @Override
    public void draw(GraphicsContext context) {



        context.setFill(Color.WHITE);
        context.fillRect(x,y,15,90);

    }
}
