package photoalbum.model;

import java.util.Objects;

/**
 * This class represents a point in a 2-dimensional cartesian plane.
 */
public class Point implements IPoint {
  private double x;
  private double y;

  /**
   * Default constructor initializes the class variables to default valeus.
   */
  public Point() {
    this.x = 0.0;
    this.y = 0.0;
  }

  /**
   * Constructor to initialize the class varaibles.
   * @param x x coordinate of the point.
   * @param y y coordinate of the point.
   */
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   *  gets the x coordinate.
   * @return the x coordinate.
   */
  public double getX() {
    return x;
  }

  /**
   *  gets the y coordinate.
   * @return the y coordinate.
   */
  public double getY() {
    return y;
  }

  /**
   * sets the x coordinate.
   * @param x new x coordinate.
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * sets the y coordinate.
   * @param y new y coordinate.
   */
  public void setY(double y) {
    this.y = y;
  }

  /**
   * gets a copy of the class object.
   * @return copy of the class object.
   */
  public Point copy() {
    return new Point(this.x,this.y);
  }

  /**
   * gets the String representation of the class object.
   * @return String representation of the class object.
   */
  public String toString() {
    return "(" + x + "," + y + ")";
  }

  /**
   * Checks if another object is equal to the class object.
   * @param o another object
   * @return if another object is equal to the class object.
   */
  public boolean equals(Object o) {
    if (o.getClass() != this.getClass()) {
      return false;
    }
    if (o == this) {
      return true;
    }
    Point pointObj = (Point) o;
    return this.x == pointObj.x && this.y == pointObj.y;
  }

  /**
   * Generates a hash for the class object.
   * @return a hash for the class object.
   */
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }
}
