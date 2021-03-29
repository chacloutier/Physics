
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


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

            new Display(stage);
        });

        Button sp = new Button("System of pulley");
            sp.setPrefSize(250, 20);
            sp.setOnAction(value -> {
            stage.setTitle("System of pulley");

            stage.show();
        });



        Button ip = new Button("Inclined plane");
            ip.setPrefSize(250, 20);
            ip.setOnAction(value -> {
            stage.setTitle("Inclined Plane");
            
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