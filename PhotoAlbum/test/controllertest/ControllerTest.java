package controllertest;

import static junit.framework.TestCase.assertEquals;

import photoalbum.controller.IPhotoAlbumController;
import photoalbum.controller.PhotoAlbumController;
import htmlresponses.HtmlResponses;
import org.junit.Before;
import org.junit.Test;
import photoalbum.model.IPhotoAlbumModel;
import photoalbum.model.PhotoAlbumModel;
import photoalbum.view.HtmlView;
import photoalbum.view.IPhotoAlbumView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class to test the functionality of the photo album controller.
 */
public class ControllerTest {
  private IPhotoAlbumController ctrlr1;
  private IPhotoAlbumController ctrlr2;

  /**
   * Initialize the test variables.
   */
  @Before
  public void setController() {
    IPhotoAlbumModel model = new PhotoAlbumModel();
    IPhotoAlbumView view = new HtmlView("demo_test_view.html");
    this.ctrlr1 = new PhotoAlbumController(model,view);
    IPhotoAlbumView view1 = new HtmlView("hanoi_test_view.html");
    this.ctrlr2 = new PhotoAlbumController(model,view1);
  }

  /**
   * Test controller happy path.
   * @throws IOException if the file doesn't exist.
   */
  @Test
  public void testControllerHappy() throws IOException {
    this.ctrlr1.go("demo_input.txt");
    String html = new String(Files.readAllBytes(Paths.get("HtmlViews/demo_test_view.html")));
    String result = html.replaceAll("<h2>.*?</h2>","<h2></h2>");
    assertEquals(result, HtmlResponses.demo.getValue());

    this.ctrlr2.go("hanoi.txt");
    String html2 = new String(Files.readAllBytes(Paths.get("HtmlViews/hanoi_test_view.html")));
    String result1 = html2.replaceAll("<h2>.*?</h2>","<h2></h2>");
    assertEquals(result1,HtmlResponses.hanoi.getValue());
  }

  /**
   * Test the controller when model is null. must throw illegal argument exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testControllerNullModel() {
    IPhotoAlbumController ctr = new PhotoAlbumController(null,new HtmlView(""));
  }

  /**
   * Test the controller when view is null. must throw illegal argument exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testControllerNullView() {
    IPhotoAlbumController ctr = new PhotoAlbumController(new PhotoAlbumModel(),null);
  }

  /**
   * Test the go method when file does not exist.
   */
  @Test(expected = FileNotFoundException.class)
  public void testGoInvalidFile() throws FileNotFoundException {
    ctrlr1.go("john_cena.txt");
  }

  /**
   * Test the go method when invalid command is passed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGoInvalidCommand() throws FileNotFoundException {
    ctrlr2.go("invalid_commands.txt");
  }
}
