package photoalbum;

import photoalbum.controller.PhotoAlbumController;
import photoalbum.model.PhotoAlbumModel;
import photoalbum.view.GraphicalView;
import photoalbum.view.HtmlView;
import photoalbum.view.IPhotoAlbumView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Runs the program with input from command line.
 */
public class PhotoAlbumMain {
  /**
   * Run the Program with command line input.
   * @param args commands for the program.
   * @throws FileNotFoundException if the input file does not exist.
   */
  public static void main(String[] args) throws FileNotFoundException {
    List<String> arguments = new ArrayList<>(Arrays.asList(args));

    if (!arguments.contains("-in")) { // check if the command contains -in
      System.out.println("Input file command '-in' not found.");
      System.exit(0);
    }
    if (!arguments.contains("-v") && !arguments.contains("-view")) { // check if command contains -v
      System.out.println("View command '-v' or '-view' not found.");
      System.exit(0);
    }
    String viewCommand;
    if (arguments.contains("-v"))
      viewCommand = "-v";
    else
      viewCommand = "-view";

    String viewType = arguments.get(arguments.indexOf(viewCommand) + 1); // get the view type
    String in = arguments.get(arguments.indexOf("-in") + 1); // get the input filename

    if (viewType.equalsIgnoreCase("graphical")) { // if the view is graphical
      int width;
      int height;
      try {
        width = Integer.parseInt(arguments.get(arguments.indexOf(viewCommand) + 2));
        height = Integer.parseInt(arguments.get(arguments.indexOf(viewCommand) + 3));
      }
      catch (Exception e) {
        width = 1000;
        height = 1000;
      }
      PhotoAlbumModel model = new PhotoAlbumModel();
      IPhotoAlbumView view = new GraphicalView(width, height);
      PhotoAlbumController controller = new PhotoAlbumController(model, view);
      controller.go(in);
    }
    else if (viewType.equalsIgnoreCase("web")) { // if the view is html
      if (!arguments.contains("-out")) { //check if the command contains -out
        System.out.println("Output command '-out' not found.");
        System.exit(0);
      }
      String htmlFileName = arguments.get(arguments.indexOf("-out") + 1);
      PhotoAlbumModel model = new PhotoAlbumModel();
      IPhotoAlbumView view = new HtmlView(htmlFileName);
      PhotoAlbumController controller = new PhotoAlbumController(model, view);
      controller.go(in);
    }
    else { // if the view is not graphical or html
      System.out.println("Invalid command.");
      System.exit(0);
    }
  }
}