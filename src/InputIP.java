import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;

import com.sun.prism.paint.Color;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;

public class InputIP {
    public static VBox textFields = new VBox(20);
    public Button stop = new Button("Reset");
    public Button start = new Button("Start");
    public AnimationTimer timer;
    public TextField tfAcceleration = new TextField("9.8");
    public TextField tfAngle = new TextField("30.0");
    public Label labAcceleration = new Label("Acceleration (m/s^2): ");
    public Label labAngle = new Label("Angle (˚): ");


    public InputIP() {}

    public InputIP(AnimationTimer timer){
        this.timer = timer;
    }

    public void DisplayInput() {

        HBox hBoxAcc = new HBox(8);
        HBox hBoxAng = new HBox(8);
        HBox hBoxBut = new HBox(8);

        Font font = new Font("Impact", 20);

        hBoxAcc.setAlignment(Pos.CENTER);
        hBoxAng.setAlignment(Pos.CENTER);
        hBoxBut.setAlignment(Pos.CENTER);

        tfAcceleration.setAlignment(Pos.CENTER);
        tfAngle.setAlignment(Pos.CENTER);

        tfAcceleration.setMaxWidth(80);
        tfAngle.setMaxWidth(80);

        tfAcceleration.setFont(font);
        tfAngle.setFont(font);

        labAcceleration.setFont(font);
        labAngle.setFont(font);

        start.setPrefSize(80, 20);
        start.setFont(font);
        start.setStyle("-fx-background-color: #40E0D0");

        stop.setPrefSize(80, 20);
        stop.setFont(font);
        stop.setStyle("-fx-background-color: #40E0D0");

        start.setOnAction(e ->{
            InclinedPlane.resetObject();
            timer.start();
        });

        stop.setOnAction(e ->{
            timer.stop();
            InclinedPlane.resetObject();
        });

        hBoxAcc.getChildren().addAll(labAcceleration, tfAcceleration);
        hBoxAng.getChildren().addAll(labAngle, tfAngle);
        hBoxBut.getChildren().addAll(start, stop);

        textFields.setTranslateX(50);
        textFields.setTranslateY(50);
        textFields.setRotationAxis(Rotate.X_AXIS);
        textFields.setRotate(-5);
        textFields.setAlignment(Pos.CENTER);
        textFields.getChildren().addAll(hBoxAcc, hBoxAng, hBoxBut);

    }
}
