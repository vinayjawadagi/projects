package photoalbum.model;

import java.awt.Color;
import java.util.Objects;

/**
 * This class represents an Unknown Shape.
 */
public class UnknownShape extends AbstractShape {

  /**
   * Constructor to initialize the variables.
   * @param name name of the shape.
   * @param center center of the Unknown Shape.
   * @param horizontalProperty horizontalProperty of the Unknown Shape.
   * @param verticalProperty verticalProperty of the Unknown Shape.
   * @param color color of the Unknown Shape.
   * @param type type of the shape.
   */
  public UnknownShape(String name, IPoint center, double horizontalProperty,
                      double verticalProperty, Color color, String type) {
    super(name, color, center, horizontalProperty, verticalProperty, type);
  }

  /**
   * creates a copy of the class object.
   * @return a copy of thw class object.
   */
  public UnknownShape copy() {
    return new UnknownShape(this.getName(),this.getPoint().copy(),this.getHorizontalProperty(),
        this.getVerticalProperty(),this.getColor(), this.getType());
  }

  /**
   * gets the String representation of the class object.
   * @return String representation of the class object.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: ").append(this.getName()).append("\n");
    sb.append("Type:").append(this.getType()).append("\n");
    sb.append("Point: ").append(getPoint().toString()).append(", ");
    sb.append("Horizontal Property: ").append(this.getHorizontalProperty()).append(", ");
    sb.append("Vertical Property: ").append(this.getVerticalProperty()).append(", ");
    sb.append("Color: ").append("(").append((double)this.getColor().getRed()).append(",")
        .append((double)this.getColor().getGreen()).append(",")
        .append((double)this.getColor().getBlue()).append(")");

    return sb.toString();
  }

  /**
   * Checks if another object is equal to the class object.
   * @param obj another object
   * @return if another object is equal to the class object.
   */
  public boolean equals(Object obj) {
    if (obj.getClass() != this.getClass()) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    UnknownShape shapeObj = (UnknownShape) obj;
    return shapeObj.getName().equals(this.getName()) && shapeObj.getPoint().equals(this.getPoint())
        && shapeObj.getHorizontalProperty() == this.getHorizontalProperty()
        && this.getColor().equals(shapeObj.getColor())
        && shapeObj.getVerticalProperty() == this.getVerticalProperty()
        && this.getType().equals(shapeObj.getType());
  }

  /**
   * Generates a hash for the class object.
   * @return a hash for the class object.
   */
  public int hashCode() {
    return Objects.hash(this.getName(),this.getPoint(),this.getHorizontalProperty(),
        this.getColor(),this.getVerticalProperty(),this.getType());
  }
}
