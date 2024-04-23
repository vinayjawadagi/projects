package photoalbum.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a snapshot in a photo album.
 */
public class Snapshot implements ISnapshot {
  private String snapshotId;
  private LocalDateTime dateTime;
  private String description;
  private List<IShape> shapes;

  /**
   * Constructor to initialize the class variables.
   * @param description description of the snapshot.
   * @param shapes List of the shapes in the snapshot.
   */
  public Snapshot(String description, List<IShape> shapes) {
    this.description = description;
    this.snapshotId = LocalDateTime.now().toString();
    this.dateTime = LocalDateTime.now();
    this.shapes = new ArrayList<>(addShapes(shapes));
  }

  /**
   * fetches the snapshot id of the snapshot.
   * @return the snapshot id of the snapshot.
   */
  public String getSnapshotId() {
    return this.snapshotId;
  }

  /**
   * fetches the description of the snapshot.
   * @return the description of the snapshot.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * fetches the shapes List of the snapshot.
   * @return the shapes List of the snapshot.
   */
  public List<IShape> getShapes() {
    return this.shapes;
  }

  /**
   * gets the String representation of the snapshot object.
   * @return String representation of the snapshot object.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Snapshot ID: ").append(dateTime.toString()).append("\n");
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    sb.append("Timestamp: ").append(dateTimeFormatter.format(dateTime)).append("\n");
    sb.append("Description: ").append(description).append("\n");
    sb.append("Shape Information:").append("\n");

    for (int i = 0; i < shapes.size(); i++) {
      sb.append(shapes.get(i).toString());
      if (i != shapes.size() - 1) {
        sb.append("\n\n");
      }
    }

    return sb.toString();
  }

  /**
   * Checks if another object is equal to the class object.
   * @param obj another object
   * @return if another object is equal to the class object.
   */
  public boolean equals(Object obj) {
    if (obj.getClass() != this.getClass()) {
      return false;
    }
    if (obj == this)
      return true;
    Snapshot snapshot = (Snapshot) obj;
    return this.snapshotId.equals(snapshot.getSnapshotId());
  }

  /**
   * Generates a hash for the class object.
   * @return a hash for the class object.
   */
  public int hashCode() {
    return Objects.hash(this.snapshotId, this.dateTime, this.description);
  }

  /**
   * creates and returns a copy of list of shapes.
   * @param shapes list of shapes.
   * @return a copy of list of shapes.
   */
  private List<IShape> addShapes(List<IShape> shapes) {
    List<IShape> shapeList = new ArrayList<>();
    for (var shape: shapes) {
      shapeList.add(shape.copy());
    }
    return shapeList;
  }
}
