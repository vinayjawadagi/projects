package photoalbum.model;

import java.awt.Color;

/**
 * Interface for th PhotoAlbumModel class.
 */
public interface IPhotoAlbumModel {
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
  IShape createShape(String name, IPoint point, double horizontalProperty,
                     double verticalProperty, Color color, String type);

  /**
   * Moves the point of the shape to the specified position.
   * @param name name of the shape to be moved.
   * @param newPoint new point to be moved to.
   */
  void move(String name, IPoint newPoint);

  /**
   * Changes the horizontal or vertical property of the shape.
   * @param name name of the shape to be changed.
   * @param oldValue old value of the property.
   * @param newValue new value of the property.
   */
  void changeShapeProperty(String name, double oldValue, double newValue);

  /**
   * Changes the color of the shape.
   * @param name name of the shape to be changed.
   * @param color new color of the shape.
   */
  void changeShapeColor(String name, Color color);

  /**
   * Removes the specified shape.
   * @param name name of the shape to be removed.
   */
  void removeShape(String name);

  /**
   * Takes a snapshot of the current state.
   */
  ISnapshot takeSnapshot(String description);

  /**
   * Prints all the snapshots that were taken.
   * @return String containing string representation of all the snapshots taken.
   */
  String printSnapshot();

  /**
   * Resets the snapshots taken, clears the log and resets the photo album.
   * @return String that includes the SnapshotIds of all the snapshots that were taken before reset.
   */
  String reset();

  /**
   * Log hold the details of all the changes made,
   * this method returns a String that contains all the changes that were made.
   * @return String that contains all the changes that were made.
   */
  String logHistory();
}
