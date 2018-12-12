import de.paulkeller.Boid;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * @author Paul Keller
 * @version 1.0
 * @date 11.12.2018
 */
public class BoidCircle extends Circle {
  private Boid boid;
  public BoidCircle(Boid b, double centerX, double centerY, double raidus){
    super(centerX,centerY,raidus);
    boid=b;
  }
  public void update(){
    setCenterX(boid.getPosition().get(0));
    setCenterY(boid.getPosition().get(1));
  }
}
