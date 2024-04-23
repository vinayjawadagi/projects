package photoalbum.model;

import java.util.List;

/**
 * Interface for the class Snapshot.
 */
public interface ISnapshot {
  /**
   * fetches the snapshot id of the snapshot.
   * @return the snapshot id of the snapshot.
   */
  String getSnapshotId();

  /**
   * Gets the description of the snapshot.
   * @return the description of the snapshot.
   */
  String getDescription();

  /**
   * Gets the shapes in the snapshot.
   * @return the shapes in the snapshot.
   */
  List<IShape> getShapes();

  /**
   * gets the String representation of the snapshot object.
   * @return String representation of the snapshot object.
   */
  String toString();
}
