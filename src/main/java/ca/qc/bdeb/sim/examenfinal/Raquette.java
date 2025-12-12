package ca.qc.bdeb.sim.examenfinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import javafx.geometry.Point2D;

public class Raquette extends ObjetDuJeu{

private boolean joueur;



    public Raquette(){
      this.joueur= joueur;

      if(joueur){

      }

    }



    @Override
protected void updatePhysique(double deltaTemps){
    boolean haut= Input.isKeyPressed(KeyCode.UP);
    boolean bas=Input.isKeyPressed(KeyCode.DOWN);


     x=0;

    if(haut){
       vy=-600;

    }

    if(bas){
      vy=600;
    }

    if(!haut && !bas ){
       vy=0;

    }
//    if(y>Main.HEIGHT){
//            vy=-vy;
//        }


        super.updatePhysique(deltaTemps);
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
