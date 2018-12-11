import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Paul Keller
 * @version 1.0
 * @date 11.12.2018
 */
public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
    primaryStage.setTitle("Flocking Simulation");
    primaryStage.setScene(new Scene(root,root.prefWidth(750),750));
    primaryStage.show();
    primaryStage.setOnCloseRequest(event -> System.exit(0));
  }
}
