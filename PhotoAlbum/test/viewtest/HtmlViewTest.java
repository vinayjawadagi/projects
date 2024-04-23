package viewtest;

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
 * Test the Html view class' functionality.
 */
public class HtmlViewTest {
  private IPhotoAlbumView html1;
  private IPhotoAlbumView html2;
  private IPhotoAlbumModel model;

  /**
   * Initialize the test variables.
   */
  @Before
  public void setUp() {
    this.model = new PhotoAlbumModel();
    this.html1 = new HtmlView("hoops_test_view.html");
    this.html2 = new HtmlView("playground_test_view.html");
  }

  /**
   * test html view happy path.
   */
  @Test
  public void testViewHappy() throws IOException {
    IPhotoAlbumController controller = new PhotoAlbumController(model,html1);
    controller.go("hoops.txt");
    String html = new String(Files.readAllBytes(Paths.get("HtmlViews/hoops_test_view.html")));
    String result = html.replaceAll("<h2>.*?</h2>","<h2></h2>");
    assertEquals(result, HtmlResponses.hoops.getValue());

    IPhotoAlbumController controller1 = new PhotoAlbumController(model,html2);
    controller1.go("playground.txt");
    String html1 = new String(Files.readAllBytes(Paths.get("HtmlViews/playground_test_view.html")));
    String result1 = html1.replaceAll("<h2>.*?</h2>","<h2></h2>");
    assertEquals(result1, HtmlResponses.playground.getValue());
  }

  /**
   * test html view when there's no snapshots available to show.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testViewNoSnapshotsToShow() throws FileNotFoundException {
    IPhotoAlbumController controller = new PhotoAlbumController(model,html2);
    controller.go("no_snapshot.txt");
  }
}
