import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class InclinedPlane {
    private Group group = new Group();
    private Scene scene;
    private Stage stage;
    private Group lightGroup = new Group();
    private PointLight pLight = new PointLight();
    private My3DObject shapeCube = new My3DObject();
    private double velocity;
    private double acceleration;
    private double angle = 30;
    private VBox textFields = new VBox(20);
    private AnimationTimer timer = new MyTimer(); 

    private Inputs inputs = new Inputs();
    private FormulasIP formulas = new FormulasIP(inputs);

    private Box box = new Box(100, 100, 100);
    private Box plane = new Box(1000, 10, 100);

    private My3DObject test = new My3DObject(box, 10, 10, 100, 0);

    public InclinedPlane(Stage s){
        StartInclinedPlane();

        stage = s;
        scene = new Scene(group, 1000, 1000);
        scene.setFill(Color.LIGHTGREEN);
        stage.setScene(scene);
        stage.show();

    }

    public void StartInclinedPlane() { //Creates the JavaFX 3D shapes
        group.getChildren().addAll(plane, box, pLight, textFields);

        pLight.setTranslateX(600);
        pLight.setTranslateY(500);
        pLight.setTranslateZ(-500);

        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setSpecularColor(Color.AQUA);
        blueMaterial.setDiffuseColor(Color.AQUA);

        final PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setSpecularColor(Color.LAWNGREEN);
        greenMaterial.setDiffuseColor(Color.LAWNGREEN);

        // box.setTranslateX(1000 - (Math.cos(angle) * 1000));
        // box.setTranslateY(1000 - (Math.sin(angle) * 1000));
        box.setTranslateX(165);
        box.setTranslateY(420);
        box.getTransforms().addAll(new Rotate(10, Rotate.X_AXIS), new Rotate(angle, Rotate.Z_AXIS), new Rotate(20, Rotate.Y_AXIS)); //Z_AXIS WILL CHANGE
        box.setMaterial(blueMaterial);
        box.setCullFace(CullFace.BACK);
        
        plane.setTranslateX(500);
        plane.setTranslateY(700);
        plane.getTransforms().addAll(new Rotate(10, Rotate.X_AXIS), new Rotate(angle, Rotate.Z_AXIS), new Rotate(20, Rotate.Y_AXIS)); //Z_AXIS WILL CHANGE
        plane.setMaterial(greenMaterial);
        plane.setCullFace(CullFace.BACK);
        
        DisplayInput();
    }

    private class MyTimer extends AnimationTimer {

        int count = 0;
        long previousNow = 0;

        @Override
        public void handle(long now) {
            if(count != 0) {
                double deltaT = (now - previousNow) / (Math.pow(10, 9));
                test.updateState(deltaT);
            }
            count++;
            previousNow = now;
        }
    }

    public class My3DObject {

        private Shape3D shape;
        private double pX;
        private double pY;
        private double vX;
        private double vY;
        private double aX;
        private double aY;

        public My3DObject(){
        }

        public My3DObject(Shape3D shape, double vX, double vY, double aX, double aY) {
            this.shape = shape;
            this.vX = vX;
            this.vY = vY;
            this.aX = aX;
            this.aY = aY;
        }

        public void updateState(double deltaT) {
            pX = shape.getTranslateX();
            pY = shape.getTranslateY();

            shape.setTranslateX(pX + vX * deltaT + 0.5 * aX * Math.pow(deltaT, 2)); //have to change velocity for there to be acceleration
            shape.setTranslateY(pY + vY * deltaT + 0.5 * aY * Math.pow(deltaT, 2));

        }

        public void setShape(Shape3D shape) {
            this.shape = shape;
        }

        public void setvX(double vX) {
            this.vX = vX;
        }

        public void setvY(double vY) {
            this.vY = vY;
        }

        public void setaX(double aX) {
            this.aX = aX;
        }

        public void setaY(double aY) {
            this.aY = aY;
        }

        public Shape3D getShape() {
            return shape;
        }

        public double getvX() {
            return vX;
        }

        public double getvY() {
            return vY;
        }
        
        public double getaX() {
            return aX;
        }

        public double getaY() {
            return aY;
        }
    }

    public void DisplayInput() {

        HBox hBoxVel = new HBox(8);
        HBox hBoxAcc = new HBox(8);
        HBox hBoxAng = new HBox(8);
        HBox hBoxBut = new HBox(8);

        Font font = new Font("Impact", 20);

        hBoxVel.setAlignment(Pos.CENTER);
        hBoxAcc.setAlignment(Pos.CENTER);
        hBoxAng.setAlignment(Pos.CENTER);
        hBoxBut.setAlignment(Pos.CENTER);

        TextField tfVelocity = new TextField("10.0");
        TextField tfAcceleration = new TextField("9.8");
        TextField tfAngle = new TextField("30.0");

        tfVelocity.setAlignment(Pos.CENTER);
        tfAcceleration.setAlignment(Pos.CENTER);
        tfAngle.setAlignment(Pos.CENTER);
        tfVelocity.setMaxWidth(80);
        tfAcceleration.setMaxWidth(80);
        tfAngle.setMaxWidth(80);
        tfVelocity.setFont(font);

        Label labVelocity = new Label("Velocity (m/s): ");
        Label labAcceleration = new Label("Acceleration (m/s^2): ");
        Label labAngle = new Label("Angle (˚): ");
        labVelocity.setFont(font);

        Button start = new Button("Start");
        start.setPrefSize(80, 20);
        start.setFont(font);
        start.setOnAction(e ->{
            timer.start();
        });

        Button stop = new Button("Clear");
        stop.setPrefSize(80, 20);
        stop.setFont(font);
        stop.setOnAction(e ->{
            timer.stop();
        });

        hBoxVel.getChildren().addAll(labVelocity, tfVelocity);
        hBoxAcc.getChildren().addAll(labAcceleration, tfAcceleration);
        hBoxAng.getChildren().addAll(labAngle, tfAngle);
        hBoxBut.getChildren().addAll(start, stop);

        textFields.setTranslateX(50);
        textFields.setTranslateY(50);
        textFields.setAlignment(Pos.CENTER);
        textFields.getChildren().addAll(hBoxVel, hBoxAcc, hBoxAng, hBoxBut);

        

    }

    
}
