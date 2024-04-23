package photoalbum.view;

import photoalbum.model.ISnapshot;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Web view of the photo album using
 * Html and SVG.
 */
public class HtmlView implements IPhotoAlbumView {
  /**
   * List of all the snapshots taken by the user.
   */
  private List<ISnapshot> snapshots;
  /**
   * Name of the file provided by the user.
   */
  private String newHtmlFileName;

  /**
   * Constructor to initialize the class variables.
   * @param newHtmlFileName name of the html file.
   */
  public HtmlView(String newHtmlFileName) {
    this.snapshots = new ArrayList<>();
    this.newHtmlFileName = newHtmlFileName;
  }

  /**
   * Adds the snapshots taken by the user and enables the preview of the snapshots.
   * creates the html content by using a predefined html 'skeleton'.
   * @param snapshots snapshots taken by the user.
   */
  public void go(List<ISnapshot> snapshots) {
    if (snapshots.isEmpty()) {
      throw new IllegalArgumentException("No Snapshots to display, Please take some snapshots!");
    }

    this.snapshots.addAll(snapshots);
    StringBuilder sb = new StringBuilder();
    sb.append(HtmlConstant.htmlStart.getValue());
    for (var snap : snapshots) {
      sb.append(HtmlConstant.snapshotStart.getValue().replace("@description",snap.getDescription())
          .replace("@snapshot_id",snap.getSnapshotId()));
      if (!snap.getShapes().isEmpty()) {
        for (var shape : snap.getShapes()) {
          if (shape.getType().equals("oval")) {
            sb.append(HtmlConstant.circle.getValue().replace("@name", shape.getName())
                .replace("@x_axis", String.valueOf(shape.getPoint().getX()))
                .replace("@y_axis", String.valueOf(shape.getPoint().getY()))
                .replace("@width", String.valueOf(shape.getHorizontalProperty()))
                .replace("@height", String.valueOf(shape.getVerticalProperty()))
                .replace("@rgb", shape.getColor().getRed() + ","
                                 + shape.getColor().getGreen() + "," + shape.getColor().getBlue()));
          } else {
            sb.append(HtmlConstant.rect.getValue().replace("@name", shape.getName())
                .replace("@x_axis", String.valueOf(shape.getPoint().getX()))
                .replace("@y_axis", String.valueOf(shape.getPoint().getY()))
                .replace("@width", String.valueOf(shape.getHorizontalProperty()))
                .replace("@height", String.valueOf(shape.getVerticalProperty()))
                .replace("@rgb", shape.getColor().getRed() + ","
                                 + shape.getColor().getGreen() + "," + shape.getColor().getBlue()));
          }
        }
      }
      sb.append(HtmlConstant.snapshotEnd.getValue());
    }
    sb.append(HtmlConstant.htmlEnd.getValue());

    try {
      File html = new File(newHtmlFileName);
      FileWriter writer = new FileWriter(html);
      writer.write(sb.toString());
      writer.close();
      Desktop desktop = Desktop.getDesktop();
      desktop.open(html);
    } catch (IOException e) {
      System.out.println("Error reading or writing to file. Please check the path or file name.");
      e.printStackTrace();
    }
  }
}
