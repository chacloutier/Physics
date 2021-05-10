
import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

//git add .
//git commit -m "message"
//git push

//git pull

public class App extends Application {
    private Group group = new Group();
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
        title.setTranslateY(200);

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
            InclinedPlane.timer.stop();
            DisplayInclinedPlane.tfAngle.setText("30.0");
            DisplayInclinedPlane.tfAcceleration.setText("9.8");
            InclinedPlane.resetObject();
            stage.setScene(scene1);
            
        });

        int random = (int)(11 * Math.random());
        Text funFact = new Text("Fun Fact: \n" + getFunFact(random));
        funFact.setTextAlignment(TextAlignment.CENTER);
        funFact.setFont(new Font("Impact", 40));
        funFact.wrappingWidthProperty().bind(scene1.widthProperty().subtract(200));
        funFact.setTranslateX(100);
        funFact.setTranslateY(650);

        ScaleTransition st = new ScaleTransition(Duration.millis(1500), funFact);
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(0.7);
        st.setToY(0.7);
        st.setCycleCount(Timeline.INDEFINITE);
        st.setAutoReverse(true);
        st.play();

        FillTransition fill = new FillTransition(Duration.millis(1500), funFact);
        fill.setFromValue(Color.DARKBLUE);
        fill.setToValue(Color.SALMON);
        fill.setCycleCount(Timeline.INDEFINITE);
        fill.setAutoReverse(true);
        fill.play();

        group.getChildren().addAll(layout, title, funFact);
        
        stage.setHeight(1000);
        stage.setWidth(1000);

        
        stage.show();
        
    }

    public String getFunFact(int num) {
        switch (num) {
            case 1:
                return "Because of differences in gravity, a 200 pound person would only weigh 76 pounds on Mars.";
            case 2:
                return "Comes from the Greek word, physikḗ, which means 'science of nature.'";
            case 3:
                return "An apple didn’t fall on Newton’s head when he discovered the law of universal gravitation. He simply wondered why apples fall downward rather than sideways.";
            case 4:
                return "Galileo discovered the law of free fall after dropping two spheres from the Leaning Tower of Pisa.";
            case 5:
                return "A sun made of bananas would be just as hot";
            case 6: 
                return "When traveling at 80 kilometres per hour (50 miles per hour), cars use around half of their fuel just to overcome wind resistance.";
            case 7: 
                return "Light from the Earth takes just 1.255 seconds to reach the Moon.";
            case 8:
                return "The faster you move the heavier you weigh";
            case 9:
                return "Electric eels can stun both predators and prey with electric shocks of around 500 volts.";
            default:
                return "When traveling at 80 kilometres per hour (50 miles per hour), cars use around half of their fuel just to overcome wind resistance.";
        }
    }
    
}