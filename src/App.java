import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

//git add .
//git commit -m "message"
//git push

//git pull

public class App extends Application {

   public static void main(String args[]) {
      launch(args);
   }

   public void start(Stage primaryStage) {
      primaryStage.setTitle("Test");
      Group group = new Group();
      Scene scene = new Scene(group, 600, 350);
      scene.setFill(Color.BLACK);
      primaryStage.setScene(scene);
      primaryStage.show();


   /*   parabolicMotion pm = new parabolicMotion();
       Circle c = new Circle(100, 300, 16, Color.AQUA);
       Line l = new Line(100, 300, 500, 300);
       l.setStroke(Color.AQUA);
       group.getChildren().addAll(c, l);
       final Timeline timeline = new Timeline();
       timeline.setCycleCount(Timeline.INDEFINITE);
       timeline.setAutoReverse(false);
       KeyValue xKV = new KeyValue(c.centerXProperty(), 200); // angle
       KeyValue yKV = new KeyValue(c.centerYProperty(), 100, new Interpolator() { // angle
          @Override
          protected double curve(double t) {
             
             double a = pm.calculA();
             double b = pm.calculB();
             double c = pm.calculC();

             return a * Math.pow((t - .5), 2) + 1; // parabole
          }
       });
       KeyFrame xKF = new KeyFrame(Duration.millis(pm.calculTime()*1000), xKV); // temps
       KeyFrame yKF = new KeyFrame(Duration.millis(pm.calculTime()*1000), yKV); // temps
       timeline.getKeyFrames().addAll(xKF, yKF);
       timeline.play();*/
   }
}