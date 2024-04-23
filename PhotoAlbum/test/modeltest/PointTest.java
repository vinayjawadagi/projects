package modeltest;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import photoalbum.model.ISnapshot;
import photoalbum.model.Point;
import photoalbum.model.Snapshot;

import java.util.ArrayList;

/**
 * class to test the point class.
 */
public class PointTest {
  private Point x;
  private Point y;

  /**
   * Initialize the test variables.
   */
  @Before
  public void setUp() {
    x = new Point();
    y = new Point(-12.3, 32.0);
  }

  /**
   * test getX() method.
   */
  @Test
  public void testGetX() {
    assertEquals(0.0,x.getX());
    assertEquals(-12.3,y.getX());
  }

  /**
   * test getY() method.
   */
  @Test
  public void testGetY() {
    assertEquals(0.0,x.getY());
    assertEquals(32.0,y.getY());
  }

  /**
   * test setX() method.
   */
  @Test
  public void testSetX() {
    x.setX(1.1);
    y.setX(1.1);
    assertEquals(1.1, x.getX());
    assertEquals(1.1, y.getX());
  }

  /**
   * test setY() method.
   */
  @Test
  public void testSetY() {
    x.setY(2.1);
    y.setY(2.1);
    assertEquals(2.1, x.getY());
    assertEquals(2.1, y.getY());
  }

  /**
   * test copy() method.
   */
  @Test
  public void testCopy() {
    Point x1 = x.copy();
    Point y1 = y.copy();

    x1.setX(12.2);
    x1.setY(32.4);

    y1.setX(12.2);
    y1.setY(32.4);

    assertNotEquals(x1,x);
    assertNotEquals(y1,y);
  }

  /**
   * test equals() method.
   */
  @Test
  public void testEquals() {
    assertEquals(true, x.equals(x));
    assertEquals(true, y.equals(y));

    Point x1 = x.copy();
    Point y1 = y.copy();
    assertEquals(true, x.equals(x1));
    assertEquals(true, y.equals(y1));

    ISnapshot snapshot = new Snapshot("", new ArrayList<>());
    assertEquals(false, x.equals(snapshot));
    assertEquals(false,x.equals(snapshot));
  }
}
