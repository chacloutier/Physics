import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;


import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;

public class DisplayInclinedPlane {
    public static VBox textFields;
    public Button stop = new Button("Reset");
    public Button start = new Button("Start");
    public AnimationTimer timer;
    public static TextField tfAcceleration = new TextField("9.8");
    public static TextField tfAngle = new TextField("30.0");
    public static TextField tfVelocityX = new TextField("0.0");
    public static TextField tfVelocityY = new TextField("0.0");
    public static TextField tfVelocity = new TextField("0.0");
    public Label labAcceleration = new Label("Acceleration (m/s^2): ");
    public Label labAngle = new Label("Angle (˚): ");
    public Label labVelX = new Label("Velocity X (m/s): ");
    public Label labVelY = new Label("Velocity Y (m/s): ");
    public Label labVel = new Label("Resulting Velocity (m/s): ");
    public HBox hBoxAcc;
    public HBox hBoxAng;
    public HBox hBoxBut; 
    public HBox hBoxX; 
    public HBox hBoxY; 
    public HBox hBoxResulting; 
    public static VBox velocity;
    public HBox total;

    public DisplayInclinedPlane() {}

    public DisplayInclinedPlane(AnimationTimer timer){
        this.timer = timer;
    }

    public void DisplayIp() {

        Font font = new Font("Impact", 20);

        tfAcceleration.setAlignment(Pos.CENTER);
        tfAngle.setAlignment(Pos.CENTER);
        tfVelocityX.setAlignment(Pos.CENTER);
        tfVelocityY.setAlignment(Pos.CENTER);
        tfVelocity.setAlignment(Pos.CENTER);

        tfAcceleration.setMaxWidth(80);
        tfAngle.setMaxWidth(80);
        tfVelocityX.setMaxWidth(100);
        tfVelocityY.setMaxWidth(100);
        tfVelocity.setMaxWidth(100);

        tfAcceleration.setFont(font);
        tfAngle.setFont(font);
        tfVelocityX.setFont(font);
        tfVelocityY.setFont(font);
        tfVelocity.setFont(font);

        tfVelocityX.setEditable(false);
        tfVelocityY.setEditable(false);
        tfVelocity.setEditable(false);

        tfVelocityX.setStyle("-fx-text-fill: #696969");
        tfVelocityY.setStyle("-fx-text-fill: #696969");
        tfVelocity.setStyle("-fx-text-fill: #696969");


        labAcceleration.setFont(font);
        labAngle.setFont(font);
        labVelX.setFont(font);
        labVelY.setFont(font);
        labVel.setFont(font);

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
        
        hBoxAcc = new HBox(8);
        hBoxAng = new HBox(8);
        hBoxBut = new HBox(8);

        hBoxX = new HBox(8);
        hBoxY = new HBox(8);
        hBoxResulting = new HBox(8);

        hBoxAcc.setAlignment(Pos.CENTER);
        hBoxAng.setAlignment(Pos.CENTER);
        hBoxBut.setAlignment(Pos.CENTER);

        hBoxX.setAlignment(Pos.CENTER);
        hBoxY.setAlignment(Pos.CENTER);
        hBoxResulting.setAlignment(Pos.CENTER);

        hBoxAcc.getChildren().addAll(labAcceleration, tfAcceleration);
        hBoxAng.getChildren().addAll(labAngle, tfAngle);
        hBoxBut.getChildren().addAll(start, stop);

        hBoxX.getChildren().addAll(labVelX, tfVelocityX);
        hBoxY.getChildren().addAll(labVelY, tfVelocityY);
        hBoxResulting.getChildren().addAll(labVel, tfVelocity);

        textFields = new VBox(20);
        textFields.setTranslateX(50);
        textFields.setTranslateY(50);
        textFields.setRotationAxis(Rotate.X_AXIS);
        textFields.setRotate(-5);
        textFields.setAlignment(Pos.CENTER);
        textFields.getChildren().addAll(hBoxAcc, hBoxAng, hBoxBut);

        velocity = new VBox(20);
        velocity.setTranslateX(600);
        velocity.setTranslateY(50);
        velocity.setRotationAxis(Rotate.X_AXIS);
        velocity.setRotate(-5);
        velocity.setAlignment(Pos.CENTER);
        velocity.getChildren().addAll(hBoxX, hBoxY, hBoxResulting);
    }
}
