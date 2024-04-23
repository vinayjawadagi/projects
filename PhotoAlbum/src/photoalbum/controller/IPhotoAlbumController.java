package photoalbum.controller;

import java.io.FileNotFoundException;

/**
 * Controller for the PhotoAlbum.
 */
public interface IPhotoAlbumController {
  /**
   * Initializes the process of executing the commands.
   * @param path path of the command file.
   * @throws FileNotFoundException if the command file is not found.
   */
  void go(String path) throws FileNotFoundException;
}
