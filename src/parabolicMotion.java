
import javafx.animation.SequentialTransition;

public class ParabolicMotion {
   private Display display;
   private Formules formules;
   private Inputs inputs;

   public ParabolicMotion(Display d, Formules f, Inputs i) {
      display = d;
      formules = f;
      inputs = i;
   }

   public void affichage() {
      boolean noExit = true; // Si on veut pas que la balle ne dépasse pas les limites
      int resolution = (int) inputs.getValue(Inputs.resolutionIdx); // Nombre de point par seconde

      // Initialisation des variables avant d'entrer dans la boucle
      boolean stop = false; // Si on sort du display, on arrête la boucle
      double maxTime = formules.getTotTime(); // Temps max ou le moment où l'on sort du display / de la boucle
      int maxIndex = (int) (maxTime * resolution); // MaxIndex de la boucle - ici seulement pour faciliter la lecture
      double slice = maxTime * 1000 / maxIndex; // Tranche de temps en milliseconde

      Trajet trajet = new Trajet(inputs, slice);

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
            display.addDot(x, y); // Ajoute les points du tracé
            trajet.add(x, y);
         }
      }

      SequentialTransition sequentialTransition = new SequentialTransition(display.getNode(), trajet.getTransitions());
      sequentialTransition.play();

   }
}