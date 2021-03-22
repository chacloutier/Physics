import javafx.scene.control.TextField;

public class Inputs {
    // Utilisé dans Formules
    public static final int velocityIdx = 0;
    public static final int gravityIdx = 1;
    public static final int angleIdx = 2;
    // Utilisé dans Animation
    public static final int resolutionIdx = 3; // le nombre de point par seconde
    public static final int zoomIdx = 4; // le nombre de point par seconde

    private TextField[] textFields = new TextField[5];

    // Valeur par defaut
    double[] parametres = { 100, 20, 80, 5, 2 };

    private void setValue(int Indx) {
        try {
            Double v = Double.parseDouble(textFields[Indx].getText());
            parametres[Indx] = v;
        } catch (Exception e) {

        }
    }

    public void addTextField(int idx, TextField t) {
        textFields[idx] = t;
    }

    public void setValues() {
        for (int i = 0; i < textFields.length; i++) {
            this.setValue(i);
        }
    }

    public double getValue(int Indx) {
        return parametres[Indx];
    }
}