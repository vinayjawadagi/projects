package photoalbum.model;

import java.awt.Color;
import java.util.Objects;

/**
 * This class represents the Shape Rectangle.
 */
public class Rectangle extends AbstractShape {

  /**
   * Constructor to initialize the variables.
   * @param name name of the shape.
   * @param corner Minimum corner of the rectangle.
   * @param width width of the rectangle.
   * @param height height of the rectangle.
   * @param color color of the shape rectangle.
   * @param type type of the shape.
   */
  public Rectangle(String name, IPoint corner, double width, double height,
                   Color color, String type) {
    super(name, color, corner, width, height, type);
  }

  /**
   * creates a copy of the class object.
   * @return a copy of thw class object.
   */
  public Rectangle copy() {
    return new Rectangle(this.getName(),this.getPoint().copy(),this.getHorizontalProperty(),
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
    sb.append("Min Corner: ").append(this.getPoint().toString()).append(", ");
    sb.append("Width: ").append(this.getHorizontalProperty()).append(", ");
    sb.append("Height: ").append(this.getVerticalProperty()).append(", ");
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
    Rectangle rectangleObj = (Rectangle) obj;
    return rectangleObj.getName().equals(this.getName())
        && rectangleObj.getPoint().equals(this.getPoint())
        && rectangleObj.getHorizontalProperty() == this.getHorizontalProperty()
        && this.getColor().equals(rectangleObj.getColor())
        && rectangleObj.getVerticalProperty() == this.getVerticalProperty()
        && this.getType().equals(rectangleObj.getType());
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
