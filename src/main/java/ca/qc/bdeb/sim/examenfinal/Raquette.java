package ca.qc.bdeb.sim.examenfinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import javafx.geometry.Point2D;

public class Raquette extends ObjetDuJeu{


    private Point2D position;
    private Point2D deplacement;

@Override
protected void updatePhysique(double deltaTemps){
    boolean haut= Input.isKeyPressed(KeyCode.UP);
    boolean bas=Input.isKeyPressed(KeyCode.DOWN);

    if(haut){
         deplacement  = new Point2D(deplacement.getX(),
                 600);
    }

    if(bas){
        deplacement= new Point2D(deplacement.getX(),
                -600);
    }
    position = position.add(deplacement.multiply(deltaTemps));
}
    public Raquette(){
        this.position= position;
        this.deplacement= deplacement;
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
