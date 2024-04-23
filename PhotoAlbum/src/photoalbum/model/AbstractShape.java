package photoalbum.model;


import java.awt.Color;

/**
 * This class represents an abstract shape.
 */
public abstract class AbstractShape implements IShape {
  private String name;
  private Color color;
  private double horizontalProperty;
  private double verticalProperty;
  private IPoint point;
  private String type;

  /**
   * Constructor to initialize the variables.
   * @param name name of the shape.
   * @param point Point to represent the shape on a 2d plane.
   * @param horizontalProperty horizontalProperty of the shape.
   * @param verticalProperty verticalProperty of the shape.
   * @param color color of the shape.
   * @param type type of the shape.
   */
  public AbstractShape(String name, Color color, IPoint point, double horizontalProperty,
                       double verticalProperty, String type) {
    this.name = name;
    this.color = color;
    this.point = point;
    this.horizontalProperty = horizontalProperty;
    this.verticalProperty = verticalProperty;
    this.type = type;
  }

  /**
   * Sets the color to the specified color.
   * @param color color to be set to.
   */
  public void setColor(Color color) {
    this.color = color;
  }

  /**
   * moves the point to the specified point.
   * @param newPoint point to be moved to.
   */
  public void move(IPoint newPoint) {
    this.point = newPoint;
  }

  /**
   * sets the horizontal property of the shape.
   * @param horizontalProperty new value of the horizontal property.
   */
  public void setHorizontalProperty(double horizontalProperty) {
    this.horizontalProperty = horizontalProperty;
  }

  /**
   * sets the vertical property of the shape.
   * @param verticalProperty new value of the vertical property.
   */
  public void setVerticalProperty(double verticalProperty) {
    this.verticalProperty = verticalProperty;
  }

  /**
   * Changes the property of the shape.
   * @param oldValue old value of the shape property.
   * @param newValue new value of the shape property.
   */
  public void changeShape(double oldValue, double newValue) {
    if (this.horizontalProperty == oldValue)
      setHorizontalProperty(newValue);
    else
      setVerticalProperty(newValue);
  }

  /**
   * fetches the horizontal property of the shape.
   * @return the horizontal property of the shape.
   */
  public double getHorizontalProperty() {
    return this.horizontalProperty;
  }

  /**
   * fetches the vertical property of the shape.
   * @return the vertical property of the shape.
   */
  public double getVerticalProperty() {
    return this.verticalProperty;
  }

  /**
   * gets the point representing the shape on a 2d plane.
   * @return point representing the shape on a 2d plane.
   */
  public IPoint getPoint() {
    return this.point;
  }

  /**
   * gets the name of the shape.
   * @return the name of the shape.
   */
  public String getName() {
    return this.name;
  }

  /**
   * gets the color of the shape.
   * @return color of the shape.
   */
  public Color getColor() {
    return this .color;
  }

  /**
   * gets the type of the shape.
   * @return the type of the shape.
   */
  public String getType() {
    return this.type;
  }

}
