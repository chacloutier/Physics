
import javafx.animation.PathTransition;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class parabolicMotion {
   private Display display;
   private Formules formules;
   private Inputs inputs;

   public parabolicMotion(Display d, Formules f, Inputs i) {
      display = d;
      formules = f;
      inputs = i;
   }

   public void affichage() {
      boolean noExit = true; // Si on veut pas que la balle ne dépasse pas les limites

      int resolution = (int) inputs.getValue(Inputs.resolutionIdx); // Nombre de point par seconde

      Path path = new Path(); // Pour définir le tracé de l'objet
      display.addMoveTo(path, 0, 0);

      // Initialisation des variables avant d'entrer dans la boucle
      boolean stop = false; // Si on sort du display, on arrête la boucle
      double maxTime = formules.getTotTime(); // Temps max ou le moment où l'on sort du display / de la boucle
      int maxIndex = (int) (maxTime * resolution); // MaxIndex de la boucle - ici seulement pour faciliter la lecture

      double x0 = 0;
      double y0 = 0;

      // Construction du tracé (path) de la trajectoire
      for (int i = 1; i <= maxIndex && !stop; i++) {
         double t = (double) i / resolution;

         double x = formules.getX(t);
         double y = formules.getY(t);

         if (noExit && display.isOut(x, y)) {
            maxTime = t;
            stop = true;
         }

         if (!stop) {
            display.addDot(x,y);
            display.addLineTo(path, x, y);

            // display.move(x0, y0, x, y, maxTime*1000/resolution);

            x0 = x;
            y0 = y;

         }
      }

      PathTransition pathTransition = new PathTransition();
      pathTransition.setDuration(Duration.millis(maxTime*1000));
      pathTransition.setNode(display.getNode());
      pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
      pathTransition.setCycleCount(PathTransition.INDEFINITE);
      pathTransition.setCycleCount(1); 
      pathTransition.setAutoReverse(false);

      pathTransition.setPath(path);
      pathTransition.play();
	  
   }
}