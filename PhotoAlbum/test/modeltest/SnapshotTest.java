package modeltest;

import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;
import photoalbum.model.IShape;
import photoalbum.model.ISnapshot;
import photoalbum.model.Oval;
import photoalbum.model.Point;
import photoalbum.model.Snapshot;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to test the functionality of Snapshot class.
 */
public class SnapshotTest {
  private ISnapshot snapshot;
  List<IShape> shapeList;

  /**
   * Initialize the test variables.
   */
  @Before
  public void setUp() {
    shapeList = new ArrayList<>();
    shapeList.add(new Oval("o",new Point(),10,10, new Color(0,0,0),"oval"));
    snapshot = new Snapshot("",shapeList);
  }

  /**
   * test getSnapShotId() method.
   */
  @Test
  public void testGetSnapShotId() {
    StringBuilder sb1 = new StringBuilder();
    StringBuilder  sb2 = new StringBuilder();
    sb1.append(LocalDateTime.now());
    sb1.delete(sb1.length() - 4, sb1.length());
    sb2.append(snapshot.getSnapshotId());
    sb2.delete(sb2.length() - 4, sb2.length());
    assertEquals(sb1.toString(), sb2.toString() );
  }

  /**
   * test equals() method.
   */
  @Test
  public void testEquals() {
    IShape shape = new Oval("o",new Point(),10,10, new Color(0,0,0),"oval");
    assertEquals(false, snapshot.equals(shape));
    assertEquals(true, snapshot.equals(snapshot));
  }
}
