import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class InclinedPlane {
    private Group group = new Group();
    private Scene scene;
    private Stage stage;
    private Group lightGroup = new Group();
    private PointLight pLight = new PointLight();
    private My3DObject shapeCube = new My3DObject();

    private Inputs inputs = new Inputs();
    private FormulasIP formulas = new FormulasIP(inputs);

    private Box box = new Box(100, 100, 100);
    private Box plane = new Box(2000, 100, 10);
    private Sphere sphere = new Sphere(20);

    public InclinedPlane(Stage s){
        StartInclinedPlane();

        stage = s;
        group.getChildren().addAll(box, pLight);
        scene = new Scene(group, 1000, 1000);
        scene.setFill(Color.LIGHTGREEN);
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new MyTimer();
        timer.start();
    }

    public void StartInclinedPlane(){
        pLight.setTranslateX(500);
        pLight.setTranslateY(500);
        pLight.setTranslateZ(-500);

        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setSpecularColor(Color.AQUA);
        blueMaterial.setDiffuseColor(Color.AQUA);

        box.setTranslateX(200);
        box.setTranslateY(400);
        box.getTransforms().addAll(new Rotate(20, Rotate.X_AXIS), new Rotate(10, Rotate.Z_AXIS), new Rotate(30, Rotate.Y_AXIS));
        box.setMaterial(blueMaterial);
        box.setCullFace(CullFace.BACK);   
    }

    private class MyTimer extends AnimationTimer {

        int count = 0;
        long previousNow = 0;
        My3DObject test = new My3DObject(box, 50, 30, 0, 0);

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


            shape.setTranslateX(pX + vX * deltaT + 0.5 * aX * Math.pow(deltaT, 2));
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




    

    
}
