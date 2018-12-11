package de.paulkeller;

/**
 * @author Paul Keller
 * @version 1.0
 * @date 11.12.2018
 */
public class Vector extends java.util.Vector<Double> implements Cloneable{
  public Vector(Double a, Double b){
    super();
    this.add(a);
    this.add(b);
  }
  public void add (Vector b){
        this.set(0, this.get(0) + b.get(0));
        this.set(1, this.get(1) + b.get(1));
  }

  public void sub(Vector b){
    this.set(0, this.get(0) - b.get(0));
    this.set(1, this.get(1) - b.get(1));
  }

  public Vector mult(double value){
    this.set(0,this.get(0)*value);
    this.set(1, this.get(1)*value);
    return this;
  }

  public void div(double value){
    this.set(0,get(0)/value);
    this.set(1,get(1)/value);
  }

  public void limit(double limit){
    if(length()>limit){
      normalize();
      mult(limit);
    }
  }

  public void setMag(double value){
    normalize();
    mult(value);
  }

  public double length(){
    return Math.sqrt(get(0)*get(0)+get(1)*get(1));
  }


  public void normalize(){
    div(length());
  }

  public double dist(Vector other){
    Vector distVector = new Vector(other.get(0)-get(0),other.get(1)-get(1));
    return distVector.length();
  }

  @Override
  public Vector clone(){
    return new Vector(get(0),get(1));
  }


}
