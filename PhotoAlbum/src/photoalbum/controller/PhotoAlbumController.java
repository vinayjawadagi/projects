package photoalbum.controller;

import photoalbum.model.IPhotoAlbumModel;
import photoalbum.model.IPoint;
import photoalbum.model.ISnapshot;
import photoalbum.model.Point;
import photoalbum.view.IPhotoAlbumView;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Controller for the PhotoAlbum.
 */
public class PhotoAlbumController implements IPhotoAlbumController {
  private IPhotoAlbumModel model;
  private IPhotoAlbumView view;
  private List<ISnapshot> snapshots;

  /**
   * Constructor to initialize the class variables.
   * @param model photo album model.
   * @param view graphical view or html view.
   */
  public PhotoAlbumController(IPhotoAlbumModel model, IPhotoAlbumView view) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("View or model cannot be null.");
    }
    this.model = model;
    this.view = view;
    this.snapshots = new ArrayList<>();
  }

  /**
   * Initializes the process of executing the commands.
   * @param path path of the command file.
   * @throws FileNotFoundException if the command file is not found.
   */
  public void go(String path) throws FileNotFoundException {
    java.io.File file = new java.io.File(path);
    Scanner scanner = new Scanner(file);
    try {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();

        // replace multi space with single space
        String command = line.trim().replaceAll("\\s{2,}", " ");
        if (command.contains("#") || command.isEmpty()) { // ignore comments
          continue;
        }
        String[] word = command.toLowerCase().split(" ");
        List<String> words = new ArrayList<>(Arrays.asList(word));
        if (words.contains("shape")) {
          //  0      1          2        3    4   5   6   7    8  9
          //shape   myrect   rectangle  200  200 50  100  255  0  0
          String name = words.get(1);
          String type = words.get(2);
          Point point = new Point(Double.parseDouble(words.get(3)),
              Double.parseDouble(words.get(4)));
          Color color = new Color(Integer.parseInt(words.get(7)), Integer.parseInt(words.get(8)),
              Integer.parseInt(words.get(9)));
          model.createShape(name, point, Double.parseDouble(words.get(5)),
              Double.parseDouble(words.get(6)), color, type);
        } else if (words.contains("move")) {
          // 0    1          2       3
          //move myrect     300     200
          String name = words.get(1);
          IPoint point = new Point(Double.parseDouble(words.get(2)),
              Double.parseDouble(words.get(3)));
          model.move(name, point);
        } else if (words.contains("color")) {
          // 0      1       2  3   4
          //color myrect    0  0  255
          String name = words.get(1);
          Color color = new Color(Integer.parseInt(words.get(2)), Integer.parseInt(words.get(3)),
              Integer.parseInt(words.get(4)));
          model.changeShapeColor(name, color);
        } else if (words.contains("resize")) {
          //  0       1      2       3
          //resize myrect   25      100
          String name = words.get(1);
          model.changeShapeProperty(name, Double.parseDouble(words.get(2)),
              Double.parseDouble(words.get(3)));
        } else if (words.contains("remove")) {
          //remove myrect
          String name = words.get(1);
          model.removeShape(name);
        } else if (words.contains("snapshot")) {
          //snapShot 2nd selfie
          String description;
          if (words.size() == 1) {
            description = "";
          } else {
            String result = command.replace("snapShot", "")
                .replace("snapshot", "")
                .replace("Snapshot", "");
            description = result.substring(1);
          }
          ISnapshot snapshot = model.takeSnapshot(description);
          this.snapshots.add(snapshot);
        } else {
          throw new IllegalArgumentException();
        }
      }
    }
    catch (Exception e) {
      throw new IllegalArgumentException("Invalid Command format, please recheck.");
    }
    view.go(snapshots); // pass the snapshots to the view and generate view.
  }
}
