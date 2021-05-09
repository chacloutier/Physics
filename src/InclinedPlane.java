import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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
    public static Group group;
    private Scene scene;
    private Stage stage;
    private Group lightGroup = new Group();
    private static PointLight pLight = new PointLight();

    public static AnimationTimer timer = new MyTimer();
    public static InputIP inputIP = new InputIP(timer);

    private double velocity;
    private static double acceleration = Double.parseDouble(inputIP.tfAcceleration.getText());
    public static double angleDeg = Double.parseDouble(inputIP.tfAngle.getText());
    private static double angleRad = Math.toRadians(angleDeg);

    private static final double PLANEX = 500;
    private static final double PLANEY = 650;
    private static final double PLANEHALFLENGTH = 350;
    private static final double HALFBOX = 25;

    public static double translateX = PLANEX + HALFBOX - Math.cos(angleRad) * PLANEHALFLENGTH;
    public static double translateY = PLANEY - HALFBOX - Math.sin(angleRad) * PLANEHALFLENGTH;

    public static Box box = new Box(50, 50, 50);
    private static Box plane = new Box(700, 10, 50);
    public static My3DObject object = new My3DObject(box, 0, 0, acceleration * Math.cos(angleRad), acceleration * Math.sin(angleRad));
 

    public InclinedPlane(Stage s){

        startInclinedPlane();

        boolean fixedEyeAtCameraZero = false;
        PerspectiveCamera camera = new PerspectiveCamera(fixedEyeAtCameraZero);
        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(-5);

        stage = s;
        group = new Group();
        group.getChildren().addAll(plane, box, pLight, inputIP.textFields, App.back); 
        scene = new Scene(group, 1000, 700);
        scene.setFill(Color.LIGHTGRAY);
        scene.setCamera(camera);
        stage.setScene(scene);
        
        stage.show();
    }

    public static void startInclinedPlane() { //Creates the JavaFX 3D shapes
        
        pLight.setTranslateX(600); 
        pLight.setTranslateY(500); 
        pLight.setTranslateZ(-500); 
 
        final PhongMaterial blueMaterial = new PhongMaterial(); 
        blueMaterial.setSpecularColor(Color.AQUA); 
        blueMaterial.setDiffuseColor(Color.AQUA); 
 
        final PhongMaterial greenMaterial = new PhongMaterial(); 
        greenMaterial.setSpecularColor(Color.LAWNGREEN);
        greenMaterial.setDiffuseColor(Color.LAWNGREEN);

        inputIP.DisplayInput();

        box.setTranslateX(translateX);
        box.setTranslateY(translateY);
        box.setRotationAxis(Rotate.Z_AXIS);
        box.setRotate(angleDeg);
        box.setMaterial(blueMaterial);
        box.setCullFace(CullFace.BACK);

        plane.setTranslateX(PLANEX);
        plane.setTranslateY(PLANEY);
        plane.setRotationAxis(Rotate.Z_AXIS);
        plane.setRotate(angleDeg);
        plane.setMaterial(greenMaterial);
        plane.setCullFace(CullFace.BACK);
    }

    public static void resetObject(){
        angleDeg = Double.parseDouble(inputIP.tfAngle.getText());
        angleRad = Math.toRadians(angleDeg);
        box.setRotate(angleDeg);
        plane.setRotate(angleDeg);
        box.setTranslateX(PLANEX + HALFBOX - Math.cos(angleRad) * PLANEHALFLENGTH);
        box.setTranslateY(PLANEY - HALFBOX - Math.sin(angleRad) * PLANEHALFLENGTH);
        object.setvX(0);
        object.setvY(0);
        acceleration = Double.parseDouble(inputIP.tfAcceleration.getText());
        object.setaX(acceleration * Math.cos(angleRad));
        object.setaY(acceleration * Math.sin(angleRad));
    }

    public static class MyTimer extends AnimationTimer {

        int count = 0;
        long previousNow = 0;

        @Override
        public void handle(long now) {
            if(count != 0) {
                double deltaT = (now - previousNow) / (Math.pow(10, 9));
                object.updateState(deltaT);
            }
            count++;
            previousNow = now;
        }

        @Override
        public void start() {            
            count = 0;
            super.start();
        }

    }

    public static class My3DObject {

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

            double lastVx = vX;
            vX = lastVx + aX * deltaT;

            double lastVy = vY;
            vY = lastVy + aY * deltaT;

            if(shape.getTranslateX() > PLANEX + Math.cos(angleRad) * PLANEHALFLENGTH) {
                timer.stop();
            }
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

    

    

    
}
