import com.sun.jdi.DoubleValue;
import de.paulkeller.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


/**
 * @author Paul Keller
 * @version 1.0
 * @date 11.12.2018
 */
public class VectorSpec {

  @BeforeEach
  public void init(){

  }

  @Test
  @DisplayName("adding two Vectors")
  void addingToVectorsWorks(){
    Vector a = new Vector(0.0,0.0);
    Vector b = new Vector(1.0,1.0);
    a.add(b);
    assertEquals(Double.valueOf(1),a.get(0));
    assertEquals(Double.valueOf(1),a.get(1));
  }

  @Test
  @DisplayName("subtracting two Vectors")
  void subtractingToVectorsWorks(){
    Vector a = new Vector(0.0,0.0);
    Vector b = new Vector(1.0,1.0);
    a.sub(b);
    assertEquals(Double.valueOf(-1),a.get(0));
    assertEquals(Double.valueOf(-1),a.get(1));
  }

  @Test
  @DisplayName("multiply Vector")
  void multiplyVectorWorks(){
    Vector a = new Vector(1.0,1.0);
    a.mult(1.1);
    assertEquals(Double.valueOf(1.1),a.get(0));
    assertEquals(Double.valueOf(1.1),a.get(1));
  }

  @Test
  @DisplayName("dividing Vector")
  void dividingVectorWorks(){
    Vector a = new Vector(1.0,1.0);
    a.div(0.5);
    assertEquals(Double.valueOf(2),a.get(0));
    assertEquals(Double.valueOf(2),a.get(1));
  }

  @Test
  @DisplayName("Length Vector")
  void lengthOfVectorWorks(){
    Vector a = new Vector(3.0,4.0);
    assertEquals(5.0,a.length());
  }

  @Test
  @DisplayName("normalize Vector")
  void normalizeVectorWorks(){
    Vector a = new Vector(3.0,4.0);
    a.normalize();
    assertEquals(Double.valueOf(0.6),a.get(0));
    assertEquals(Double.valueOf(0.8),a.get(1));
  }

  @Test
  @DisplayName("setMagnitude Vector")
  void setMagnitudeVectorWorks(){
    Vector a = new Vector(3.0,4.0);
    a.setMag(5);
    assertEquals(5,a.length());
    assertEquals(Double.valueOf(0.6*5), a.get(0));
    assertEquals(Double.valueOf(0.8*5), a.get(1));
  }

  @Test
  @DisplayName("limit Vector")
  void limitVectorWorks(){
    Vector a = new Vector(3.0,4.0);
    a.limit(8);
    assertEquals(5,a.length());
    a.limit(2.6);
    assertEquals(2.6, a.length());
  }

  @Test
  @DisplayName("distance between two Vectors")
  void distBetweenTwoVectorsWorks(){
    Vector a = new Vector(1.0,2.0);
    Vector b = new Vector(4.0,6.0);
    assertEquals(5,a.dist(b));
  }

  @Test
  @DisplayName("clone Vector")
  void cloneVectorWorks(){
    Vector a = new Vector(1.0,1.0);
    Vector aclone = a.clone();
    a.normalize();
    assertEquals(Double.valueOf(1.0),aclone.get(0));
    assertEquals(Double.valueOf(1.0),aclone.get(1));
    assertNotEquals(Double.valueOf(1.0),a.get(0));
    assertNotEquals(Double.valueOf(1.0),a.get(1));
  }
}
