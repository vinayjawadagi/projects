package photoalbum.model;

import java.awt.Color;

/**
 * This interface represents the Shape classes rectangle, oval etc.
 */
public interface IShape {
  /**
   * Moves the Shape to specified point.
   * @param point point to be moved to.
   */
  void move(IPoint point);

  /**
   * Sets the color of the shape to specified color.
   * @param color color to be set to.
   */
  void setColor(Color color);

  /**
   * Changes the property of the shape.
   * @param oldValue old value of the shape property.
   * @param newValue new value of the shape property.
   */
  void changeShape(double oldValue, double newValue);

  /**
   * sets the horizontal property of tha shape.
   * @param horizontalProperty new value of the horizontal property.
   */
  void setHorizontalProperty(double horizontalProperty);

  /**
   * sets the vertical property of tha shape.
   * @param verticalProperty new value of the vertical property.
   */
  void setVerticalProperty(double verticalProperty);

  /**
   * creates a copy of the class object.
   * @return a copy of thw class object.
   */
  IShape copy();

  /**
   * Gets the type of shape.
   * @return the type of shape.
   */
  String getType();

  /**
   * gets the name of the shape.
   * @return name of the shape.
   */
  String getName();

  /**
   * gets the color of the shape.
   * @return the color of the shape.
   */
  Color getColor();

  /**
   * gets the Horizontal Property of the shape.
   * @return the Horizontal Property of the shape.
   */
  double getHorizontalProperty();

  /**
   * gets the Vertical Property of the shape.
   * @return the Vertical Property of the shape.
   */
  double getVerticalProperty();

  /**
   * gets the point of the shape.
   * @return the point of the shape.
   */
  IPoint getPoint();

  /**
   * gets the String representation of the class object.
   * @return String representation of the class object.
   */
  String toString();
}
