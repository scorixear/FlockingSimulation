package de.paulkeller;

import java.util.ArrayList;

/**
 * @author Paul Keller
 * @version 1.0
 * @date 11.12.2018
 */
public class Flock extends ArrayList<Boid> {
  private Boid[] boids;
  private double maxHeight;
  private double maxWidth;
  public Flock(int amount, double maxWidth, double maxHeight, double maxForce, double maxVelocity){
      boids = new Boid[amount];
      for(int i = 0;i<amount;i++){
        //boids[i] = new Boid(Math.random()*maxWidth, Math.random()*maxHeight,maxVelocity,maxForce);
        boids[i] = new Boid(maxWidth/2, maxHeight/2, maxVelocity, maxForce);
      }
      this.maxHeight=maxHeight;
      this.maxWidth=maxWidth;
  }

  public void runFlock(double alignment, double cohesion, double separation){
    for(Boid b: boids){
      b.edges(maxWidth,maxHeight);
      b.flock(boids, alignment, cohesion, separation);

    }
    for(Boid b: boids){
      b.update();
    }

  }

  public Boid[] getBoids(){
    return boids;
  }
}
