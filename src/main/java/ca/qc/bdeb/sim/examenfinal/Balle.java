package ca.qc.bdeb.sim.examenfinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Balle extends ObjetDuJeu{






    @Override

    public void draw(GraphicsContext context) {

        context.setFill(Color.WHITE);
        context.fillOval(x,y,25,25);

    }
}
