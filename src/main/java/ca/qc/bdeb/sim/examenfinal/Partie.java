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

    protected Raquette raquetteGauche;
    protected Raquette raquetteDroite;
    protected boolean finPartie;


    public Partie() {
        this.raquetteGauche= new Raquette(true,true);
        this.raquetteDroite= new Raquette(false, false);


    }

    public void update(double deltaTemps) {
        if(Input.isKeyPressed(KeyCode.UP)) {
            raquetteGauche.deplacer(deltaTemps, -600);
        }
         if(Input.isKeyPressed(KeyCode.DOWN)){
             raquetteGauche.deplacer(deltaTemps, 600);
         }






        raquetteGauche.updatePhysique(deltaTemps);
        raquetteDroite.updatePhysique(deltaTemps);




        // TODO : Faire avancer le jeu
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



       if(finPartie) {
           context.setFill(Color.RED);
           context.setFont(javafx.scene.text.Font.font(60));
           context.fillText("GAME OVER", Main.WIDTH / 2 - 250, Main.HEIGHT / 2 - 30);
       }
        // TODO : Dessiner le jeu
    }
}
