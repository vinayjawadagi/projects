package modeltest;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import photoalbum.model.IShape;
import photoalbum.model.Oval;
import photoalbum.model.Point;
import photoalbum.model.Rectangle;
import photoalbum.model.UnknownShape;

import java.awt.Color;

/**
 * Class to test the functionality of Shape classes.
 */
public class ShapesTest {
  private IShape o;
  private IShape r;
  private IShape t;

  /**
   * Initialize the test variables.
   */
  @Before
  public void setUp() {
    o = new Oval("o", new Point(1.3,2.4),30,40,new Color(255,0,0),"oval");
    r = new Rectangle("r", new Point(), 20, 15, new Color(0,255,0), "rectangle");
    t = new UnknownShape("t", new Point(2.3,4.5), 33.33,
        56.34,new Color(0,0,255),"triangle");
  }

  /**
   * test setColor() method.
   */
  @Test
  public void testSetColor() {
    Color color = new Color(255,255,255);
    o.setColor(color);
    r.setColor(color);
    t.setColor(color);
    String oResponse = """
        Name: o
        Type:oval
        Center: (1.3,2.4), X radius: 30.0, Y radius: 40.0, Color: (255.0,255.0,255.0)""";
    String rResponse = """
        Name: r
        Type:rectangle
        Min Corner: (0.0,0.0), Width: 20.0, Height: 15.0, Color: (255.0,255.0,255.0)""";
    String tResponse = """
        Name: t
        Type:triangle
        Point: (2.3,4.5), Horizontal Property: 33.33, Vertical Property: 56.34, Color: (255.0,255.0,255.0)""";

    assertEquals(o.toString(), oResponse);
    assertEquals(r.toString(), rResponse);
    assertEquals(t.toString(), tResponse);
  }

  /**
   * test the move() method.
   */
  @Test
  public void testMove() {
    o.move(new Point());
    r.move(new Point(43,33));
    t.move(new Point());

    String oResponse = """
        Name: o
        Type:oval
        Center: (0.0,0.0), X radius: 30.0, Y radius: 40.0, Color: (255.0,0.0,0.0)""";
    String rResponse = """
        Name: r
        Type:rectangle
        Min Corner: (43.0,33.0), Width: 20.0, Height: 15.0, Color: (0.0,255.0,0.0)""";
    String tResponse = """
        Name: t
        Type:triangle
        Point: (0.0,0.0), Horizontal Property: 33.33, Vertical Property: 56.34, Color: (0.0,0.0,255.0)""";

    assertEquals(o.toString(), oResponse);
    assertEquals(r.toString(), rResponse);
    assertEquals(t.toString(), tResponse);
  }

  /**
   * test setHorizontalProperty() method.
   */
  @Test
  public void testSetHorizontalProperty() {
    o.setHorizontalProperty(0);
    r.setHorizontalProperty(0);
    t.setHorizontalProperty(0);

    String oResponse = """
        Name: o
        Type:oval
        Center: (1.3,2.4), X radius: 0.0, Y radius: 40.0, Color: (255.0,0.0,0.0)""";
    String rResponse = """
        Name: r
        Type:rectangle
        Min Corner: (0.0,0.0), Width: 0.0, Height: 15.0, Color: (0.0,255.0,0.0)""";
    String tResponse = """
        Name: t
        Type:triangle
        Point: (2.3,4.5), Horizontal Property: 0.0, Vertical Property: 56.34, Color: (0.0,0.0,255.0)""";

    assertEquals(o.toString(), oResponse);
    assertEquals(r.toString(), rResponse);
    assertEquals(t.toString(), tResponse);
  }

  /**
   * test setVerticalProperty() method.
   */
  @Test
  public void testSetVerticalProperty() {
    o.setVerticalProperty(0);
    r.setVerticalProperty(0);
    t.setVerticalProperty(0);

    String oResponse = """
        Name: o
        Type:oval
        Center: (1.3,2.4), X radius: 30.0, Y radius: 0.0, Color: (255.0,0.0,0.0)""";
    String rResponse = """
        Name: r
        Type:rectangle
        Min Corner: (0.0,0.0), Width: 20.0, Height: 0.0, Color: (0.0,255.0,0.0)""";
    String tResponse = """
        Name: t
        Type:triangle
        Point: (2.3,4.5), Horizontal Property: 33.33, Vertical Property: 0.0, Color: (0.0,0.0,255.0)""";

    assertEquals(o.toString(), oResponse);
    assertEquals(r.toString(), rResponse);
    assertEquals(t.toString(), tResponse);
  }

  /**
   * Test changeShape() method.
   */
  @Test
  public void testChangeShape() {
    o.changeShape(30,3.14);
    r.changeShape(20,3.14);
    t.changeShape(33.33,3.14);

    String oResponse = """
        Name: o
        Type:oval
        Center: (1.3,2.4), X radius: 3.14, Y radius: 40.0, Color: (255.0,0.0,0.0)""";
    String rResponse = """
        Name: r
        Type:rectangle
        Min Corner: (0.0,0.0), Width: 3.14, Height: 15.0, Color: (0.0,255.0,0.0)""";
    String tResponse = """
        Name: t
        Type:triangle
        Point: (2.3,4.5), Horizontal Property: 3.14, Vertical Property: 56.34, Color: (0.0,0.0,255.0)""";

    assertEquals(o.toString(), oResponse);
    assertEquals(r.toString(), rResponse);
    assertEquals(t.toString(), tResponse);
  }

  /**
   * test the copy method.
   */
  @Test
  public void testCopy() {
    IShape o1 = o.copy();
    IShape r1 = r.copy();
    IShape t1 = t.copy();

    o1.setColor(new Color(1,2,3));
    r1.setColor(new Color(1,2,3));
    t1.setColor(new Color(1,2,3));
    assertNotEquals(o,o1);
    assertNotEquals(r,r1);
    assertNotEquals(t,t1);
  }

  /**
   * test toString() method.
   */
  @Test
  public void testToString() {
    String oResponse = """
        Name: o
        Type:oval
        Center: (1.3,2.4), X radius: 30.0, Y radius: 40.0, Color: (255.0,0.0,0.0)""";
    String rResponse = """
        Name: r
        Type:rectangle
        Min Corner: (0.0,0.0), Width: 20.0, Height: 15.0, Color: (0.0,255.0,0.0)""";
    String tResponse = """
        Name: t
        Type:triangle
        Point: (2.3,4.5), Horizontal Property: 33.33, Vertical Property: 56.34, Color: (0.0,0.0,255.0)""";

    assertEquals(o.toString(), oResponse);
    assertEquals(r.toString(), rResponse);
    assertEquals(t.toString(), tResponse);
  }

  /**
   * test equals() method.
   */
  @Test
  public void testEquals() {
    assertEquals(false, o.equals(r));
    assertEquals(false, r.equals(t));
    assertEquals(false, t.equals(o));

    assertEquals(true, o.equals(o));
    assertEquals(true, r.equals(r));
    assertEquals(true, t.equals(t));

    Oval o1 = new Oval("o", new Point(1.3,2.4),30,40,new Color(255,0,0),"oval");
    Rectangle r1 = new Rectangle("r", new Point(), 20, 15, new Color(0,255,0), "rectangle");
    UnknownShape t1 = new UnknownShape("t", new Point(2.3,4.5), 33.33,
        56.34,new Color(0,0,255),"triangle");

    assertEquals(o.equals(o1), true);
    assertEquals(r.equals(r1), true);
    assertEquals(t.equals(t1), true);
  }
}
