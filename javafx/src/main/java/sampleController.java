import de.paulkeller.Boid;
import de.paulkeller.Flock;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

/**
 * @author Paul Keller
 * @version 1.0
 * @date 11.12.2018
 */
public class sampleController {

  @FXML
  public Pane gamePane;
  @FXML
  public Slider alignSlider;
  public Slider cohesionSlider;
  public Slider separationSlider;


  public void initialize(){
    Flock flock = new Flock(100,gamePane.getPrefWidth(),gamePane.getPrefHeight(),0.2,4);
    for(Boid b:flock.getBoids()){
      BoidCircle c = new BoidCircle(b,b.getPosition().get(0),b.getPosition().get(1),5);
      gamePane.getChildren().add(c);
    }
    Thread t = new Thread(()->{
      while(true){
        flock.runFlock(alignSlider.getValue(),cohesionSlider.getValue(),separationSlider.getValue());
        //System.out.println("Flock updated");
        for(Node n: gamePane.getChildren()){
          if(n instanceof BoidCircle)
          Platform.runLater(((BoidCircle) n)::update);
        }
        try {
          Thread.sleep(17);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    t.start();
  }
}
