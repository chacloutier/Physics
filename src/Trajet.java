import java.util.ArrayList;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class Trajet {
    private ArrayList<Transition> transitionList = new ArrayList<Transition>();

    private Inputs inputs;
    private double slice;

    public Trajet(Inputs i, double s) {
        inputs = i;
        slice = s;
    }

    public void add(double x, double y) {
        TranslateTransition transition = new TranslateTransition();

        int displayX = (int)(x*inputs.getValue(Inputs.zoomIdx)); 
        int displayY = (int)(-y*inputs.getValue(Inputs.zoomIdx)); 

        transition.setToX(displayX);
        transition.setToY(displayY);
        transition.setDuration(Duration.millis(slice));
        transitionList.add(transition);
    }
    
    // Transfer les données du ArrayList (array variable) en un array de taille fixe requis par SequentialTransition
    public Transition[] getTransitions() {
        Transition[] transitions = new Transition[transitionList.size()];
        for (int i=0;i<transitionList.size();i++) {
           transitions[i] = transitionList.get(i);
        }
        return transitions;
    }
}