package photoalbum.model;

/**
 * Interface for the concrete class Point.
 */
public interface IPoint {
  /**
   *  gets the x coordinate.
   * @return the x coordinate.
   */
  public double getX();

  /**
   *  gets the y coordinate.
   * @return the y coordinate.
   */
  public double getY();

  /**
   * sets the x coordinate.
   * @param x new x coordinate.
   */
  public void setX(double x);

  /**
   * sets the y coordinate.
   * @param y new y coordinate.
   */
  public void setY(double y);

  /**
   * gets a copy of the class object.
   * @return copy of the class object.
   */
  public Point copy();

  /**
   * gets the String representation of the class object.
   * @return String representation of the class object.
   */
  public String toString();
}
