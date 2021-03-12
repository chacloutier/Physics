import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.transform.Rotate;

public class InclinedPlane{
    public Box plane;
    public Box box;

    final PhongMaterial blueMaterial = new PhongMaterial();
    blueMaterial.setSpecularColor(Color.AQUA);
    blueMaterial.setDiffuseColor(Color.AQUA);
        
    final PhongMaterial greenMaterial = new PhongMaterial();
    greenMaterial.setSpecularColor(Color.LIGHTGREEN);
    greenMaterial.setDiffuseColor(Color.LIGHTGREEN);

    public InclinedPlane(){
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
    }
}