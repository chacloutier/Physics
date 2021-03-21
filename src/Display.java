import javafx.util.Duration;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.shape.Sphere;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Display {
    private Group group;
    private Scene scene;

    private Inputs inputs = new Inputs();
    private Formules formules = new Formules(inputs);
    private parabolicMotion animation = new parabolicMotion(this, formules, inputs);

    // Objets affichés
    private Sphere sphere;
    private Circle top;
    private Line lh;
    private Line lv;

    private int dimensionX;
    private int dimensionY;
    private int marge;

    public Display() {
        setDimension(1000, 700);
        setMarge(50);

        // Champs Velocite
        Text labelV = new Text("Velocity");
        labelV.setFill(Color.ANTIQUEWHITE);
        //
        TextField velocityTxt = new TextField();
        velocityTxt.setPromptText("Velocity");
        velocityTxt.setPrefColumnCount(4);
        velocityTxt.setText(String.valueOf(inputs.getValue(Inputs.velocityIdx)));
        inputs.addTextField(Inputs.velocityIdx, velocityTxt);

        // Champs Gravite
        Text labelG = new Text("Gravity");
        labelG.setFill(Color.ANTIQUEWHITE);
        //
        TextField gravityTxt = new TextField();
        gravityTxt.setPromptText("Gravity");
        gravityTxt.setPrefColumnCount(4);
        gravityTxt.setText(String.valueOf(inputs.getValue(Inputs.gravityIdx)));
        inputs.addTextField(Inputs.gravityIdx, gravityTxt);

        // Champs Angle
        Text labelA = new Text("Angle");
        labelA.setFill(Color.ANTIQUEWHITE);
        //
        TextField angleTxt = new TextField();
        angleTxt.setPromptText("Angle");
        angleTxt.setPrefColumnCount(4);
        angleTxt.setText(String.valueOf(inputs.getValue(Inputs.angleIdx)));
        inputs.addTextField(Inputs.angleIdx, angleTxt);

        // Champs Resolution
        Label labelR = new Label("Resolution");
        labelR.setTextFill(Color.AQUAMARINE);
        //
        TextField resoTxt = new TextField();
        resoTxt.setPromptText("Resolution");
        resoTxt.setPrefColumnCount(4);
        resoTxt.setText(String.valueOf(inputs.getValue(Inputs.resolutionIdx)));
        inputs.addTextField(Inputs.resolutionIdx, resoTxt);

        // Champs Zoom
        Label labelZ = new Label("Zoom");
        labelZ.setTextFill(Color.AQUAMARINE);
        //
        TextField zoomTxt = new TextField();
        zoomTxt.setPromptText("Zoom");
        zoomTxt.setPrefColumnCount(4);
        zoomTxt.setText(String.valueOf(inputs.getValue(Inputs.zoomIdx)));
        inputs.addTextField(Inputs.zoomIdx, zoomTxt);

        // Titre avec les paramètres
        Text titre = new Text();
        titre.setFill(Color.BEIGE);
        titre.setText("Please enter parameters");
        titre.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        // Boutton Go
        Button go = new Button("Go");
        go.setPrefSize(60, 20);
        go.setOnAction(value -> {
            // On efface tout
            group.getChildren().removeAll(sphere, top, lh, lv);

            // Création des composantes graphiques
            this.createObjects();

            inputs.setValues();

            // Titre avec les paramètres
            String t = "Velo:" + inputs.getValue(Inputs.velocityIdx) + " - Grav:" + inputs.getValue(Inputs.gravityIdx)
                    + " - Angle:" + inputs.getValue(Inputs.angleIdx);
            titre.setText(t);

            top.setCenterX(convertToDisplayX(formules.getMaxX() / 2));
            top.setCenterY(convertToDisplayY(formules.getMaxY()));

            animation.affichage();
        });

        // Boutton Clear
        Button clear = new Button("Clear");
        clear.setPrefSize(60, 20);
        clear.setOnAction(value -> {
            // On efface tout
            group.getChildren().removeAll(sphere, top, lh, lv);
        });

        
        
        // Creating a GridPane container pour les fenetres textes et les bouttons
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        grid.add(titre, 3, 0);

        grid.add(labelV, 0, 1);
        grid.add(labelG, 0, 2);
        grid.add(labelA, 0, 3);
        grid.add(labelR, 0, 4);
        grid.add(labelZ, 0, 5);

        grid.add(velocityTxt, 1, 1);
        grid.add(gravityTxt, 1, 2);
        grid.add(angleTxt, 1, 3);
        grid.add(resoTxt, 1, 4);
        grid.add(zoomTxt, 1, 5);

        grid.add(go, 2, 1);
        grid.add(clear, 2, 2);

        group = new Group();
        group.getChildren().addAll(grid);

        // Création de la Scene
        scene = new Scene(group, dimensionX, dimensionY);
        scene.setFill(Color.BLACK);

        
    }

    private void createObjects() {
        // Création du cercle animé
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.ORANGE);
        sphere = new Sphere(15);
        sphere.setTranslateX(getDisplayStartX());
        sphere.setTranslateY(getDisplayStartY());
        sphere.setMaterial(material);
    

        // Création du point sommet
        top = new Circle(getDisplayStartX(), getDisplayStartY(), 2, Color.RED);

        // Création de la ligne horizontal
        lh = new Line(getDisplayStartX(), getDisplayStartY(), getDisplayEndX(), getDisplayStartY());
        lh.setStroke(Color.AQUA);

        // Création de la ligne vertical
        lv = new Line(getDisplayEndX(), getDisplayStartY(), getDisplayEndX(), getDisplayEndY());
        lv.setStroke(Color.RED);


       /* PerspectiveCamera camera = new PerspectiveCamera(true);

        camera.setTranslateZ(-1000);
        camera.setTranslateX(1000);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(45);
        */


        group.getChildren().addAll(sphere, top, lh, lv);
    }

    // Pour avoir le 0 en Y en bas de l'ecran
    private int invertY(int y) {
        return dimensionY - y;
    }

    private void setDimension(int x, int y) {
        dimensionX = x;
        dimensionY = y;
    }

    private void setMarge(int m) {
        marge = m;
    }

    private double getDisplayStartX() {
        return marge;
    }

    private double getDisplayStartY() {
        return this.invertY(marge);
    }

    private double getDisplayEndX() {
        return dimensionX - marge;
    }

    private double getDisplayEndY() {
        return invertY(dimensionY - marge);
    }

    private int convertToDisplayX(double x) {
        return (int) (x * inputs.getValue(Inputs.zoomIdx)) + marge;
    }

    private int convertToDisplayY(double y) {
        return invertY((int) (y * inputs.getValue(Inputs.zoomIdx)) + marge);
    }

    // Method public
    public boolean isOut(double x, double y) {
        return ((boolean) (x * inputs.getValue(Inputs.zoomIdx) > (dimensionX - 2 * marge))
                || (boolean) (y * inputs.getValue(Inputs.zoomIdx) > dimensionY - 2 * marge));
    }

    public void addMoveTo(Path p, double x, double y) {
        p.getElements().add(new MoveTo(convertToDisplayX(x), convertToDisplayY(y)));
    }

    public void addLineTo(Path p, double x, double y) {
        p.getElements().add(new LineTo(convertToDisplayX(x), convertToDisplayY(y)));
    }

    public void addDot(double x, double y) {
        Circle dot = new Circle(convertToDisplayX(x), convertToDisplayY(y), 2, Color.YELLOW);
        group.getChildren().add(dot);
    }

    public void move(double x0, double y0, double x, double y, double time) {
        Circle node = new Circle(convertToDisplayX(x0), convertToDisplayY(y0), 2, Color.BEIGE);
        group.getChildren().add(node);
        Path path = new Path(); 
        addMoveTo(path, x0, y0);
        addLineTo(path, x, y);

        TranslateTransition theTransition = new TranslateTransition( Duration.millis(time), node);
        theTransition.setByX( x );
        theTransition.setByY( y );
        theTransition.setCycleCount( 1 );
        theTransition.setAutoReverse( false );
        theTransition.play();

        /*
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(time));
        pathTransition.setNode(node);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);

        pathTransition.setPath(path);
        pathTransition.play();
        */
    }

    public Node getNode() {
        return sphere;
    }

    public Scene getScene() {
        return scene;
    }
}