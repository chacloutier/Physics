import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

//git add .
//git commit -m "message"
//git push

//git pull

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    private Group group;
    private Scene scene;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {

        Button pb = new Button("Parabolic motion");
            pb.setPrefSize(250, 20);
            
            pb.setOnAction(value -> {
            stage.setTitle("Projectile motion");

            Display d = new Display();
            stage.setScene(d.getScene());
            stage.show();
        });

        Button sp = new Button("System of pulley");
            sp.setPrefSize(250, 20);
            sp.setOnAction(value -> {
            stage.setTitle("System of pulley");

            stage.show();
        });



        Button ip = new Button("Incline plane");
            ip.setPrefSize(250, 20);
            ip.setOnAction(value -> {
            stage.setTitle("Incline Plane");
            
            stage.show();
        });

        HBox layout= new HBox();
        
        layout.setSpacing(10);
        layout.setPadding(new Insets(0, 20, 10, 20)); 
        layout.setPrefSize(50, 50);
        

        layout.getChildren().addAll(pb, ip, sp);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene1= new Scene(layout, 1000, 1000);
        scene1.setFill(Color.AQUA);
        
        stage.setScene(scene1);
        
        stage.setHeight(1000);
        stage.setWidth(1000);

        
        stage.show();
        
    }
    
}