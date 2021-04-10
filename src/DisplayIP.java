import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class DisplayIP {
    private Group group = new Group();
    private Scene scene;
    private Stage stage;
    private Group lightGroup = new Group();
    private PointLight pLight = new PointLight();

    private Inputs inputs = new Inputs();
    private FormulasIP formulas = new FormulasIP(inputs);

    private Box box = new Box(100, 100, 100);
    private Box plane = new Box(2000, 100, 10);
    private Sphere sphere = new Sphere(20);

    public DisplayIP(Stage s){
        inclinedPlane();

        stage = s;
        group.getChildren().addAll(box, pLight);
        scene = new Scene(group, 1000, 1000);
        scene.setFill(Color.ALICEBLUE);
        stage.setScene(scene);
        stage.show();
    }

    public void inclinedPlane(){
        pLight.setTranslateX(500);
        pLight.setTranslateY(500);
        pLight.setTranslateZ(-200);

        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setSpecularColor(Color.AQUA);
        blueMaterial.setDiffuseColor(Color.AQUA);

        box.setTranslateX(500);
        box.setTranslateY(500);
        // box.setRotationAxis(Rotate.X_AXIS);
        // box.setRotate(50);
        box.getTransforms().addAll(new Rotate(30, Rotate.X_AXIS), new Rotate(10, Rotate.Z_AXIS));
        box.setMaterial(blueMaterial);
        box.setCullFace(CullFace.NONE);
        box.setOpacity(1);

    }




    

    
}
