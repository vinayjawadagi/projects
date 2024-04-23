package photoalbum.view;

import photoalbum.model.ISnapshot;

import java.util.List;

/**
 * Interface for the Photo album views.
 */
public interface IPhotoAlbumView {
  /**
   * Initializes the view with the snapshots and displays the snapshots.
   * @param snapshots the snapshots taken by the user.
   */
  void go(List<ISnapshot> snapshots);
}
