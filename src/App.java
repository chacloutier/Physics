import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

//git add .
//git commit m- "message"
//git push

//git pull

public class App extends Application {
    
    public void start(Stage stage){
        Button button= new Button("Hi");
        Scene scene=new Scene(button, 400, 400);
        stage.setTitle("Hello world");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[]args) throws Exception{
        launch(args);
    }
}