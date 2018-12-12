package de.paulkeller;

/**
 * @author Paul Keller
 * @version 1.0
 * @date 11.12.2018
 */
public class Boid {
  private Vector position;
  private Vector acceleration;
  public Vector velocity;
  private double maxVelocity;
  private double maxForce;
  public Boid(double x, double y, double maxVelocity, double maxForce){
    position = new Vector(x, y);
    velocity = new Vector((-maxVelocity/2)+Math.random()*maxVelocity,(-maxVelocity/2)+Math.random()*maxVelocity);
    acceleration=new Vector(0.0,0.0);
    this.maxVelocity=maxVelocity;
    this.maxForce=maxForce;
  }

  public void edges(double maxWidth, double maxHeight){
    if(position.get(0)>maxWidth)position.set(0,0.0);
    else if(position.get(0)<0)position.set(0,maxWidth);
    if(position.get(1)>maxHeight)position.set(1,0.0);
    else if(position.get(1)<0)position.set(1,maxHeight);
  }


  Vector genSteering(Boid[] boids, GenSteeringInterface gen, boolean subPosition, int perceptionRadius){
    Vector steering = new Vector(0.0,0.0);
    int total = 0;
    for(Boid other: boids){
      double d = position.dist(other.position);
      if(!other.equals(this)&&d<perceptionRadius){
        steering.add(gen.apply(this,other,d));
        total++;
      }
    }
    if(total>0){
      steering.div(total);
      if(subPosition)steering.sub(this.position);
      steering.setMag(maxVelocity);
      steering.sub(this.velocity);
      steering.limit(maxForce);
    }
    return steering;
  }

  public void flock(Boid[] boids, double alignment, double cohesion, double separation){

    //alignment
    this.acceleration.add(genSteering(boids,(t,other,d)-> other.velocity,false,50).mult(alignment));

    //cohesion
    this.acceleration.add(genSteering(boids,(t,other,d)->other.position,true,50).mult(cohesion));

    //separation
    this.acceleration.add(genSteering(boids,(t,other,d)->{
      Vector pos = t.position.clone();
      pos.sub(other.position);
      if(pos.get(0)==0&&pos.get(1)==0) return pos;
      else pos.div(d*d);
      return pos;
    },false,50).mult(separation));

  }

  public void update() {

    position.add(velocity);

    velocity.add(acceleration);

    velocity.limit(maxVelocity);

    acceleration.mult(0);

  }

  public Vector getPosition(){
    return position;
  }
}
