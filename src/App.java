
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//git add .
//git commit -m "message"
//git push

//git pull

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    private Group group = new Group();
    private Scene scene;
    public static Button back = new Button("Back");
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        Font font = new Font("Impact", 20);

        Label title = new Label("Physics Generator 2021");
        title.setFont(new Font("Impact", 80));
        title.setTranslateX(125);
        title.setTranslateY(300);

        Button pb = new Button("Parabolic motion");
        pb.setPrefSize(250, 20);
        pb.setFont(font);
            
        pb.setOnAction(value -> {
            stage.setTitle("Projectile motion");

            new Display(stage);
        });

        Button ip = new Button("Inclined plane");
        ip.setPrefSize(250, 20);
        ip.setFont(font);

        ip.setOnAction(value -> {
            stage.setTitle("Inclined Plane");
            new InclinedPlane(stage);
        });

        HBox layout= new HBox();
        
        layout.setSpacing(10);
        layout.setTranslateX(240);
        layout.setTranslateY(450);

        layout.getChildren().addAll(pb, ip);
        layout.setAlignment(Pos.CENTER);

        
        Scene scene1= new Scene(group, 1000, 1000);
        scene1.setFill(Color.AQUA);
        
        stage.setScene(scene1);

        back.setFont(font);
        back.setPrefSize(80,20);
        back.setTranslateX(50);
        back.setTranslateY(900);

        back.setOnAction(e -> {
            stage.setScene(scene1);
            
        });

        group.getChildren().addAll(layout, title);
        
        stage.setHeight(1000);
        stage.setWidth(1000);

        
        stage.show();
        
    }
    
}