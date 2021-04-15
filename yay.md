/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtest;

import java.awt.Toolkit;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Sphere;

public class JavaFxTest extends Application {
    
    public My3DObject newObject;
    public Box box;
    public Box plane;
    public Sphere ball;
    public Cylinder pulley;
    public Cylinder center;
    public Group root;
    public Polyline strap;
    public Box box1;6
    public Box box2;
    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        
        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setSpecularColor(Color.AQUA);
        blueMaterial.setDiffuseColor(Color.AQUA);
        
        final PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setSpecularColor(Color.LIGHTGREEN);
        greenMaterial.setDiffuseColor(Color.LIGHTGREEN);
        
        final PhongMaterial silverMaterial = new PhongMaterial();
        silverMaterial.setSpecularColor(Color.SILVER);
        silverMaterial.setDiffuseColor(Color.SILVER);
        
        final PhongMaterial whiteMaterial = new PhongMaterial();
        whiteMaterial.setSpecularColor(Color.WHITE);
        whiteMaterial.setDiffuseColor(Color.WHITE);
        
        Region root1 = (Region)FXMLLoader.load(getClass().getResource("/Resources/scenePhysics.fxml"));
        root1.setRotationAxis(Rotate.X_AXIS);
        root1.setRotate(-15);
        root1.setTranslateX(150);
        root1.setTranslateY(-155);
        root1.setTranslateZ(-400);
        

        box = new Box(100, 100, 100);
        box.setCullFace(CullFace.NONE);
        box.setTranslateX(200);
        box.setTranslateY(0);
        box.setTranslateZ(0);
        box.setRotationAxis(Rotate.Z_AXIS);
        box.setRotate(27);
        box.setMaterial(blueMaterial);
        
        plane = new Box(2000, 10, 100);
        plane.setCullFace(CullFace.NONE);
        plane.setTranslateX(400);
        plane.setTranslateY(157);
        plane.setTranslateZ(0);
        plane.setRotationAxis(Rotate.Z_AXIS);
        plane.setRotate(27);
        plane.setMaterial(greenMaterial);
        
        ball = new Sphere(30);
        ball.setCullFace(CullFace.NONE);
        ball.setTranslateX(450);
        ball.setTranslateY(50);
        ball.setTranslateZ(0);
        ball.setMaterial(silverMaterial);
        
        pulley = new Cylinder(50, 50, 50);
        pulley.setCullFace(CullFace.NONE);
        pulley.setTranslateX(450);
        pulley.setTranslateY(100);
        pulley.setTranslateZ(0);
        pulley.setRotationAxis(Rotate.X_AXIS);
        pulley.setRotate(90);
        pulley.setMaterial(silverMaterial);
        
        center = new Cylinder(15, 75, 50);
        center.setCullFace(CullFace.NONE);
        center.setTranslateX(450);
        center.setTranslateY(100);
        center.setTranslateZ(0);
        center.setRotationAxis(Rotate.X_AXIS);
        center.setRotate(90);
        center.setMaterial(whiteMaterial);
        
        box1 = new Box(50, 50, 50);
        box1.setCullFace(CullFace.NONE);
        box1.setTranslateX(390);
        box1.setTranslateY(300);
        box1.setTranslateZ(0);
        box1.setRotationAxis(Rotate.Z_AXIS);
        box1.setRotate(0);
        box1.setMaterial(blueMaterial);
        
        box2 = new Box(50, 50, 50);
        box2.setCullFace(CullFace.NONE);
        box2.setTranslateX(500);
        box2.setTranslateY(400);
        box2.setTranslateZ(0);
        box2.setRotationAxis(Rotate.Z_AXIS);
        box2.setRotate(0);
        box2.setMaterial(blueMaterial);
        
//        strap = new Polyline();
//        ObservableList<Double> list1 = strap.getPoints();
//        strap.setStroke(Color.RED);
//        double scaleFactor = 60;    
//        for (int x = -400; x <= 500; x++) {
//            list1.add(x + 450.0);
//            list1.add(-5.0 * );
//        }
        
        PointLight pLight = new PointLight();
        pLight.setColor(Color.WHITE);
        pLight.setTranslateX(1000);
        pLight.setTranslateY(-800);
        pLight.setTranslateZ(-700);
        
        Group lightGroup = new Group();
        lightGroup.getChildren().add(pLight);
        
//        PointLight pLight1 = new PointLight();
//        pLight1.setColor(Color.WHITE);
//        pLight1.setRotationAxis(Rotate.Y_AXIS);
//        pLight1.setRotate(60);
//        pLight1.setTranslateX(200);
//        pLight1.setTranslateY(-10);
//        pLight1.setTranslateZ(-10);
//        
//        PointLight pLight2 = new PointLight();
//        pLight2.setColor(Color.WHITE);
//        pLight2.setRotationAxis(Rotate.Y_AXIS);
//        pLight2.setRotate(60);
//        pLight2.setTranslateX(600);
//        pLight2.setTranslateY(-10);
//        pLight2.setTranslateZ(-10);
//        
//        Group lightGroup = new Group();
//        lightGroup.getChildren().addAll(pLight, pLight1, pLight2);
        
//        AmbientLight aLight = new AmbientLight();
//        aLight.setColor(Color.GREEN);
//        aLight.setRotationAxis(Rotate.X_AXIS);
//        aLight.setRotate(0);
//        aLight.setTranslateX(600);
//        aLight.setTranslateY(150);
//        aLight.setTranslateZ(1);
//        Group lightGroup = new Group();
//        lightGroup.getChildren().addAll(pLight, aLight);
        
//        objectIP = new My3DObject(box, 40, 20);
//        
//        objectP1 = new My3DObject(box, 40, 20);
        
        boolean fixedEyeAtCameraZero = false;
        PerspectiveCamera camera = new PerspectiveCamera(fixedEyeAtCameraZero);
        camera.setTranslateX(150);
        camera.setTranslateY(-150);
        camera.setTranslateZ(-350);
        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(-15);
      
        root = new Group();
        root.setRotationAxis(Rotate.X_AXIS);
        root.setRotate(0);
        
        root.getChildren().addAll(root1, lightGroup, pulley, center, box1, box2);
        
//        FXMLLoader loader = new FXMLLoader();
//        FXMLController controller = new FXMLController();
         
//        controller.inclinedPlane.setOnAction(e -> {
//            newObject = new My3DObject(box, 40, 20);
//            root.getChildren().clear();
//            root.getChildren().addAll(root1, lightGroup, box, plane);
//        });
//        controller.pulley.setOnAction(e -> {
//            newObject = new My3DObject(pulley, 0, 0);
//            root.getChildren().clear();
//            root.getChildren().addAll(root1, lightGroup, pulley);
//        });
       
        
        

        Scene scene = new Scene(root, 600, 600, true);
        
        root1.prefWidthProperty().bind(scene.widthProperty());
        root1.prefHeightProperty().bind(scene.heightProperty());
        
        scene.setFill(Color.WHITE);
        scene.setCamera(camera);
        stage.setScene(scene);
        stage.setTitle("3D Example");

        stage.show();
        
        AnimationTimer timer = new MyTimer();
                
        timer.start();
         
    }
  
    public static void main(String[] args) {
        launch(args);
    }
    
    private class MyTimer extends AnimationTimer {
        
        int count = 0;
        long previousNow = 0;
        
        @Override
        public void handle(long now) {
            if(count != 0){
                double deltaT = (now - previousNow) / (Math.pow(10, 9));
//                System.out.println(deltaT);
                //newObject.updateState(deltaT);
            } 
            count++;
            previousNow = now;
        }
    }
    
    public class My3DObject {
        
        private Shape3D shape;
        private double vX;
        private double vY;
        private double aX;
        private double aY;
        private double pX;
        private double pY;
        
        public My3DObject(Shape3D shape, double vX, double vY, double aX, double aY) {
            this.shape = shape;
            this.vX = vX;
            this.vY = vY;
            this.aX = aX;
            this.aY = aY;
        }
        
        public My3DObject(Shape3D shape){
            this.shape = shape;
        }
        
        
        public void updateState(double deltaT) {
           pX = shape.getTranslateX();
           pY = shape.getTranslateY();
           
           shape.setTranslateX(pX + vX * deltaT);
           shape.setTranslateY(pY + vY * deltaT + 0.5 * aY * Math.pow(deltaT, 2));
           
        }
        
    }
}
