package photoalbum.model;

import java.awt.Color;
import java.util.Objects;

/**
 * This class represents the Shape Oval.
 */
public class Oval extends AbstractShape {
  /**
   * Constructor to initialize the variables.
   * @param name name of the shape.
   * @param center Center of the Oval.
   * @param xRadius x radius of the Oval.
   * @param yRadius y radius of the oval.
   * @param color color of the shape oval.
   * @param type type of the shape.
   */
  public Oval(String name, IPoint center, double xRadius, double yRadius,
              Color color, String type) {
    super(name, color, center, xRadius, yRadius, type);
  }

  /**
   * creates a copy of the class object.
   * @return a copy of thw class object.
   */
  public Oval copy() {
    return new Oval(this.getName(),this.getPoint().copy(),this.getHorizontalProperty(),
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
    sb.append("Center: ").append(getPoint().toString()).append(", ");
    sb.append("X radius: ").append(this.getHorizontalProperty()).append(", ");
    sb.append("Y radius: ").append(this.getVerticalProperty()).append(", ");
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
    Oval ovalObj = (Oval) obj;
    return ovalObj.getName().equals(this.getName()) && ovalObj.getPoint().equals(this.getPoint())
        && ovalObj.getHorizontalProperty() == this.getHorizontalProperty()
        && this.getColor().equals(ovalObj.getColor())
        && ovalObj.getVerticalProperty() == this.getVerticalProperty()
        && this.getType().equals(ovalObj.getType());
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
