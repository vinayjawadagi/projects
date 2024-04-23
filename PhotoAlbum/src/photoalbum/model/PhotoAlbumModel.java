package photoalbum.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class represents a Photo album model.
 */
public class PhotoAlbumModel implements IPhotoAlbumModel {
  private List<ISnapshot> snapshots;
  private List<String> snapshotIdList;
  private Map<String, IShape> shapes;
  private List<IShape> shapeList;
  private List<String> logger;

  /**
   * Constructor to initialize the class variables.
   */
  public PhotoAlbumModel() {
    this.snapshots = new ArrayList<>();
    this.shapes = new HashMap<>();
    this.shapeList = new ArrayList<>();
    this.snapshotIdList = new ArrayList<>();
    this.logger = new ArrayList<>();
  }

  /**
   * Creates a Shape based on the specified shape type.
   * @param name name of the shape.
   * @param point point representing the location of the shape on a 2d plane.
   * @param horizontalProperty horizontal property of the shape like xRadius, width etc.
   * @param verticalProperty vertical property of the shape like yRadius, height etc.
   * @param color color of the shape
   * @param type type of the shape like rectangle, oval etc.
   * @return an IShape object of the specified shape details.
   */
  public IShape createShape(String name, IPoint point, double horizontalProperty,
                            double verticalProperty, Color color, String type) {
    if (horizontalProperty < 0 || verticalProperty < 0) {
      throw new IllegalArgumentException("Horizontal or vertical property cannot be negative.");
    }
    if (name == null || name.isEmpty() || type == null || type.isEmpty()) {
      throw new IllegalArgumentException("Invalid input values!");
    }

    IShape shape;
    if (type.equals("rectangle")) {
      shape = new Rectangle(name,point,horizontalProperty,verticalProperty,color,type);
    } else if (type.equals("oval")) {
      shape = new Oval(name,point,horizontalProperty,verticalProperty,color,type);
    } else {
      shape = new UnknownShape(name,point,horizontalProperty,verticalProperty,color,type);
    }
    shapes.put(name,shape);
    shapeList.add(shape);
    logger.add("Created Shape " + name + " :\n" + printShapes() + "\n");
    return shape;
  }

  /**
   * Moves the point of the shape to the specified position.
   * @param name name of the shape to be moved.
   * @param newPoint new point to be moved to.
   */
  public void move(String name, IPoint newPoint) {
    checkIfExists(name);

    IShape shape = shapes.get(name);
    shape.move(newPoint);
    logger.add("Moved Shape " + name + " :\n" + printShapes() + "\n");

  }

  /**
   * Changes the horizontal or vertical property of the shape.
   * @param name name of the shape to be changed.
   * @param oldValue old value of the property.
   * @param newValue new value of the property.
   */
  public void changeShapeProperty(String name, double oldValue, double newValue) {
    checkIfExists(name);

    IShape shape = shapes.get(name);
    shape.changeShape(oldValue, newValue);
    logger.add("Changed Shape property " + name + " :\n" + printShapes() + "\n");
  }

  /**
   * Changes the color of the shape.
   * @param name name of the shape to be changed.
   * @param color new color of the shape.
   */
  public void changeShapeColor(String name, Color color) {
    checkIfExists(name);

    IShape shape = shapes.get(name);
    shape.setColor(color);
    logger.add("Changed Shape " + name + " color :\n" + printShapes() + "\n");
  }

  /**
   * Removes the specified shape.
   * @param name name of the shape to be removed.
   */
  public void removeShape(String name) {
    checkIfExists(name);
    IShape shape = shapes.remove(name);
    shapeList.remove(shape);
    logger.add("Removed Shape " + name + " :\n" + printShapes() + "\n");
  }

  /**
   * Takes a snapshot of the current state.
   */
  public ISnapshot takeSnapshot(String description) {
    ISnapshot snapshot = new Snapshot(description,
        shapeList);
    snapshots.add(snapshot);
    snapshotIdList.add(snapshot.getSnapshotId());
    logger.add("You took a Snapshot :\n" + snapshot + "\n");
    return snapshot;
  }

  /**
   * Prints all the snapshots that were taken.
   * @return String containing string representation of all the snapshots taken.
   */
  public String printSnapshot() {
    if (snapshots.isEmpty()) {
      return "No Snapshots to print!";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("Printing Snapshots\n");
    for (int i = 0; i < snapshots.size(); i++) {
      sb.append(snapshots.get(i).toString());
      if (i != snapshots.size() - 1) {
        sb.append("\n\n\n");
      }
    }
    logger.add("Snapshots were printed." + "\n");
    return sb.toString();
  }

  /**
   * Resets the snapshots taken, clears the log and resets the photo album.
   * @return String that includes the SnapshotIds of all the snapshots that were taken before reset.
   */
  public String reset() {
    snapshots.clear();
    shapes.clear();
    shapeList.clear();
    logger.clear();
    String snapShotIds = this.snapshotIdList.toString();
    snapshotIdList.clear();
    return "List of snapshots taken before reset: " + snapShotIds;
  }

  /**
   * Log holds the details of all the changes made,
   * this method returns a String that contains all the changes that were made.
   * @return String that contains all the changes that were made.
   */
  public String logHistory() {
    StringBuilder sb = new StringBuilder();
    for (var log: logger) {
      sb.append(log).append("\n");
    }
    sb.append("\n");
    return sb.toString();
  }

  //region helper methods
  /**
   * Creates and returns a String containing all the current shapes in the photo.
   * @return returns a String containing all the current shapes in the photo.
   */
  private String printShapes() {
    StringBuilder sb = new StringBuilder();
    List<IShape> shapeList = shapes.values().stream().collect(Collectors.toList());
    for (int i = 0; i < shapeList.size(); i++) {
      sb.append(shapeList.get(i).toString());
      if (i != shapeList.size() - 1) {
        sb.append("\n");
      }
    }
    return sb.toString();
  }

  /**
   * Checks if the shape exists.
   * @param name name of the shape.
   */
  private void checkIfExists(String name) {
    if (!shapes.containsKey(name)) {
      throw new java.util.NoSuchElementException("Shape " + name + " does not exist.");
    }
  }

  //endregion
}
