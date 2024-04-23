package modeltest;

import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;
import photoalbum.model.IPhotoAlbumModel;
import photoalbum.model.IShape;
import photoalbum.model.ISnapshot;
import photoalbum.model.Oval;
import photoalbum.model.PhotoAlbumModel;
import photoalbum.model.Point;
import photoalbum.model.Rectangle;
import photoalbum.model.UnknownShape;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class to test the functionality of PhotoAlbumModel class.
 */
public class PhotoAlbumModelTest {
  private IPhotoAlbumModel photoAlbum;
  private IShape oval;
  private IShape rectangle;
  private IShape triangle;

  /**
   * Initialize the test variables.
   */
  @Before
  public void setUp() {
    photoAlbum = new PhotoAlbumModel();
    oval = new Oval("o", new Point(13,23),10,20, new Color(255,0,0),"oval");
    rectangle = new Rectangle("r", new Point(12,34),30,40,new Color(0,0,255),"rectangle");
    triangle = new UnknownShape("t",new Point(22,33),70,56,new Color(0,255,0),"triangle");
  }

  //region createShape() tests
  /**
   * test create shape method happy path.
   */
  @Test
  public void testCreateShapeHappy() {
    IShape shape = photoAlbum.createShape("o", new Point(13,23),10,20, getColor("red"),"oval");
    assertEquals(shape,oval);
    shape = photoAlbum.createShape("r", new Point(12,34),30,40,getColor("blue"),"rectangle");
    assertEquals(shape,rectangle);
    shape = photoAlbum.createShape("t",new Point(22,33),70,56,getColor("green"),"triangle");
  }

  /**
   * test create shape method null name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullName() {
    photoAlbum.createShape(null, new Point(),77,56, getColor("red"),"rectangle");
  }

  /**
   * test create shape method empty name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyName() {
    photoAlbum.createShape("", new Point(),77,56, getColor("red"),"rectangle");
  }

  /**
   * test create shape method null type.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullType() {
    photoAlbum.createShape("r", new Point(),77,56, getColor("red"),null);
  }

  /**
   * test create shape method empty type.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyType() {
    photoAlbum.createShape("r", new Point(),77,56, getColor("red"),"");
  }

  /**
   * test create shape negative horizontal property.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeHorizontalProperty() {
    photoAlbum.createShape("c", new Point(), -1,23,getColor("red"), "oval");
  }

  /**
   * test create shape negative vertical property.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeVerticalProperty() {
    photoAlbum.createShape("c", new Point(), 22,-23,getColor("red"), "oval");
  }

  //endregion

  //region move() tests

  /**
   * test move method happy path.
   */
  @Test
  public void testMoveHappy() {
    IShape shape = photoAlbum.createShape("o", new Point(),10,20, getColor("red"),"oval");
    Point point = new Point(13,23);
    photoAlbum.move("o",point);
    assertEquals(oval, shape);
  }

  /**
   * test move method when non-existent shape name is passed.
   */
  @Test(expected = NoSuchElementException.class)
  public void testMoveUnhappy() {
    photoAlbum.move("cube", new Point());
  }

  //endregion

  //region changeShapeProperty() tests

  /**
   * test change shape property happy path.
   */
  @Test
  public void testChangeShapeProperty() {
    IShape shape = photoAlbum.createShape("r", new Point(12,34),1,2,
        getColor("blue"),"rectangle");
    photoAlbum.changeShapeProperty("r",1,30);
    photoAlbum.changeShapeProperty("r",2,40);
    assertEquals(shape,rectangle);
  }

  /**
   * test change shape property for undefined shape.
   */
  @Test(expected = NoSuchElementException.class)
  public void testChangePropertyUnhappy() {
    photoAlbum.changeShapeProperty("z", 20,10);
  }
  //endregion

  //region changeShapeColor() tests

  /**
   * test change shape color happy path.
   */
  @Test
  public void testChangeShapeColor() {
    IShape shape = photoAlbum.createShape("t", new Point(22,33),70,
        56,getColor("red"), "triangle");

    photoAlbum.changeShapeColor("t",getColor("green"));

    assertEquals(shape,triangle);
  }

  /**
   * test change color when shape is not defined.
   */
  @Test(expected = NoSuchElementException.class)
  public void testChangeColorInvalidShapeName() {
    photoAlbum.changeShapeColor("t",getColor("red"));
  }

  //endregion

  //region removeShape() tests

  /**
   * test removeShape() method.
   */
  @Test
  public void testRemoveShape() {
    IShape shape = photoAlbum.createShape("sq",new Point(),20,68,getColor("red"),"square");
    String response = """
        Created Shape sq :
        Name: sq
        Type:square
        Point: (0.0,0.0), Horizontal Property: 20.0, Vertical Property: 68.0, Color: (255.0,0.0,0.0)
        
        Removed Shape sq :



        """;
    photoAlbum.removeShape("sq");

    assertEquals(response,photoAlbum.logHistory());
  }
  //endregion

  //region takeSnapshot() tests

  /**
   * test takeSnapshot() method.
   */
  @Test
  public void testTakeSnapshot() {
    photoAlbum.createShape("r",new Point(),90,74,getColor("red"),"rectangle");
    photoAlbum.createShape("o",new Point(23,22),40,47,getColor("red"),"oval");
    ISnapshot snapshot = photoAlbum.takeSnapshot("");
    assertEquals(photoAlbum.printSnapshot(),"Printing Snapshots\n" + snapshot);
  }

  //endregion

  //region printSnapshot() tests

  /**
   * test print snapshot happy path.
   */
  @Test
  public void testPrintSnapshot() {
    photoAlbum.createShape("r",new Point(),90,74,getColor("red"),"rectangle");
    ISnapshot snapshot1 = photoAlbum.takeSnapshot("");
    photoAlbum.createShape("o",new Point(23,22),40,47,getColor("red"),"oval");
    ISnapshot snapshot2 = photoAlbum.takeSnapshot("");
    assertEquals(photoAlbum.printSnapshot(), "Printing Snapshots\n"
        + snapshot1 + "\n\n\n" + snapshot2);
  }

  /**
   * test print snapshot when there's no snapshots.
   */
  @Test
  public void testPrintSnapshotEmpty() {
    assertEquals(photoAlbum.printSnapshot(), "No Snapshots to print!");
  }
  //endregion

  //region reset() tests

  /**
   * test reset() method.
   */
  @Test
  public void testReset() {
    photoAlbum.createShape("r",new Point(),90,74,getColor("red"),"rectangle");
    ISnapshot s1 = photoAlbum.takeSnapshot("");
    photoAlbum.createShape("o",new Point(23,22),40,47,getColor("red"),"oval");
    ISnapshot s2 = photoAlbum.takeSnapshot("");
    ISnapshot s3 = photoAlbum.takeSnapshot("");
    List<String> idList = new ArrayList<>();
    idList.add(s1.getSnapshotId());
    idList.add(s2.getSnapshotId());
    idList.add(s3.getSnapshotId());
    assertEquals("List of snapshots taken before reset: " + idList, photoAlbum.reset());
    assertEquals(photoAlbum.printSnapshot(), "No Snapshots to print!");
  }

  //endregion

  //region logHistory() tests

  /**
   * test logHistory() method.
   */
  @Test
  public void testLogHistory() {
    photoAlbum.createShape("r",new Point(),90,74,getColor("red"),"rectangle");
    photoAlbum.createShape("o",new Point(54,23.43),19,43,getColor("yellow"),"oval");
    photoAlbum.move("r",new Point(12,23.5));
    photoAlbum.changeShapeColor("r",getColor("blue"));
    photoAlbum.changeShapeProperty("r",90,98);
    photoAlbum.removeShape("o");
    String res = """
        Created Shape r :
        Name: r
        Type:rectangle
        Min Corner: (0.0,0.0), Width: 90.0, Height: 74.0, Color: (255.0,0.0,0.0)
        
        Created Shape o :
        Name: r
        Type:rectangle
        Min Corner: (0.0,0.0), Width: 90.0, Height: 74.0, Color: (255.0,0.0,0.0)
        Name: o
        Type:oval
        Center: (54.0,23.43), X radius: 19.0, Y radius: 43.0, Color: (255.0,255.0,0.0)
        
        Moved Shape r :
        Name: r
        Type:rectangle
        Min Corner: (12.0,23.5), Width: 90.0, Height: 74.0, Color: (255.0,0.0,0.0)
        Name: o
        Type:oval
        Center: (54.0,23.43), X radius: 19.0, Y radius: 43.0, Color: (255.0,255.0,0.0)
        
        Changed Shape r color :
        Name: r
        Type:rectangle
        Min Corner: (12.0,23.5), Width: 90.0, Height: 74.0, Color: (0.0,0.0,255.0)
        Name: o
        Type:oval
        Center: (54.0,23.43), X radius: 19.0, Y radius: 43.0, Color: (255.0,255.0,0.0)
        
        Changed Shape property r :
        Name: r
        Type:rectangle
        Min Corner: (12.0,23.5), Width: 98.0, Height: 74.0, Color: (0.0,0.0,255.0)
        Name: o
        Type:oval
        Center: (54.0,23.43), X radius: 19.0, Y radius: 43.0, Color: (255.0,255.0,0.0)
        
        Removed Shape o :
        Name: r
        Type:rectangle
        Min Corner: (12.0,23.5), Width: 98.0, Height: 74.0, Color: (0.0,0.0,255.0)
        

        """;
    assertEquals(photoAlbum.logHistory(),res);
  }
  //endregion

  private Color getColor(String colorString) {
    try {
      return (Color)Color.class.getField(colorString.toUpperCase()).get(null);
    } catch (Exception e) {

      return null;
    }
  }
}
