package ca.qc.bdeb.sim.examenfinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Balle extends ObjetDuJeu{













    public boolean collision(Raquette autre){
        return !(this.getDroite() < autre.getGauche() ||
                this.getBas() < autre.getHaut() ||
                autre.getDroite() < this.getGauche() ||
                autre.getBas() < this.getHaut());


    }

    public void rebondir() {
        vx= -vx;
        vy= Math.random()*360-180; //DEMANDER A CHAT

    }
    @Override

    public void draw(GraphicsContext context) {

        context.setFill(Color.WHITE);
        context.fillOval(x,y,25,25);

    }
}
