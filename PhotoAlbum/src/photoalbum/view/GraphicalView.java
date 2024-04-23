package photoalbum.view;

import photoalbum.model.IShape;
import photoalbum.model.ISnapshot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This class implements the Graphical view of the photo album using
 * swing.
 */
public class GraphicalView extends JFrame implements IPhotoAlbumView {
  /**
   * Stores the index of the current snapshot that the user is viewing.
   */
  private int currentSnapshotIndex = 0;

  /**
   * Label to hold the snapshot id and description of the current snapshot.
   */
  private JLabel snapshotIdLabel;
  /**
   * List of all the snapshots taken by the user.
   */
  private List<ISnapshot> snapshots;

  /**
   * Constructor to initialize the class varaibles.
   * @param width width of the window.
   * @param height height of the window.
   */
  public GraphicalView(int width, int height) {
    this.snapshots = new ArrayList<>();
    setTitle("Snapshots Display");
    setSize(width, height); // set the width and height provided from input
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    // Create the buttons
    JButton nextButton = new JButton("Next"); // button that shows the next snapshot
    nextButton.addActionListener(e -> showNextSnapshot());

    JButton prevButton = new JButton("Previous"); // button that shows the previous snapshot
    prevButton.addActionListener(e -> showPreviousSnapshot());

    JButton showSnapshotsButton = new JButton("Show Snapshots");// button to show the list of snapshot
    showSnapshotsButton.addActionListener(e -> showAvailableSnapshots());

    JButton exitOnClick = new JButton("Quit"); // button that quits the program
    exitOnClick.addActionListener(e -> System.exit(0));

    // Set up the button panel to display the buttons
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.setBackground(new Color(207,185,151));
    buttonPanel.add(prevButton);
    buttonPanel.add(showSnapshotsButton);
    buttonPanel.add(nextButton);
    buttonPanel.add(exitOnClick);

    // Set up the label panel to display the label
    JPanel labelPanel = new JPanel(new FlowLayout((FlowLayout.CENTER)));
    labelPanel.setBackground(new Color(207,185,151));
    snapshotIdLabel = new JLabel("", SwingConstants.CENTER);
    snapshotIdLabel.setFont(new Font("Taberna",Font.PLAIN, 16));
    labelPanel.add(snapshotIdLabel);

    // Set up the snapshot panel to display the snapshot
    SnapshotPanel snapshotPanel = new SnapshotPanel();
    snapshotPanel.setBackground(Color.lightGray);

    // Create the main panel and add other components
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(buttonPanel,BorderLayout.SOUTH); // display the buttons at the bottom
    panel.add(labelPanel,BorderLayout.NORTH); // display the label at the top
    panel.add(snapshotPanel,BorderLayout.CENTER); // display the snapshot at the center
    setContentPane(panel);
  }

  /**
   * Adds the snapshots taken by the user and enables the preview of the snapshots.
   * @param snapshots snapshots taken by the user.
   */
  public void go(List<ISnapshot> snapshots) {
    if (snapshots.isEmpty()) {
      System.out.println("No Snapshots to display, exiting program.");
      System.exit(0);
    }

    this.snapshots.addAll(snapshots);
    updateSnapshotNameLabel(); // sets the label to the first snapshot description
    repaint();
    setVisible(true);
  }

  /**
   * Updates the label with the current snapshot details.
   */
  private void updateSnapshotNameLabel() {
    if (currentSnapshotIndex >= 0 && currentSnapshotIndex < snapshots.size()) {
      String id = snapshots.get(currentSnapshotIndex).getSnapshotId();
      String description = snapshots.get(currentSnapshotIndex).getDescription();
      snapshotIdLabel.setText("<html>Current Snapshot: " + id + "<br>" + description + "</html>");
    } else {
      snapshotIdLabel.setText("No Snapshot");
    }
  }

  /**
   * When the next button is clicked, shows the next snapshot.
   * if there's no next snapshot, opens a dialogue saying no more snapshots available.
   */
  private void showNextSnapshot() {
    if (currentSnapshotIndex < snapshots.size() - 1) {
      currentSnapshotIndex++;
      updateSnapshotNameLabel();
      repaint();
    } else {
      showNoSnapshotsDialog("No next Snapshot available.");
    }
  }

  /**
   * When the previous button is clicked, shows the previous snapshot.
   * if there's no previous snapshot, opens a dialogue saying no more snapshots available.
   */
  private void showPreviousSnapshot() {
    if (currentSnapshotIndex > 0) {
      currentSnapshotIndex--;
      updateSnapshotNameLabel();
      repaint();
    } else {
      showNoSnapshotsDialog("No previous Snapshot available.");
    }
  }

  /**
   * Shows a list of available snapshots to the user among which the user can choose a
   * snapshot to preview.
   */
  private void showAvailableSnapshots() {
    ISnapshot[] snapshotArray = snapshots.toArray(new ISnapshot[0]);
    String[] ids = new String[snapshots.size()];
    for (int i = 0; i < snapshots.size(); i++) {
      ids[i] = snapshots.get(i).getSnapshotId();
    }
    String selectedSnapshot = (String) JOptionPane.showInputDialog(this,
        "Select a Snapshot:", "Available Snapshots",
        JOptionPane.QUESTION_MESSAGE, null,
        ids, snapshotArray[currentSnapshotIndex].getSnapshotId());

    if (selectedSnapshot != null) {
      for (var snap: snapshots) {
        if (Objects.equals(snap.getSnapshotId(), selectedSnapshot)) {
          currentSnapshotIndex = snapshots.indexOf(snap);
        }
      }
      updateSnapshotNameLabel();
      repaint();
    }
  }

  /**
   * Displays a message to the user in a pop-up dialogue.
   * @param message the message to be shown.
   */
  private void showNoSnapshotsDialog(String message) {
    JOptionPane.showMessageDialog(this, message, "No Snapshots", JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * This class represents the panel that displays the snapshot.
   */
  private class SnapshotPanel extends JPanel {
    /**
     * Paints the snapshot on the view.
     * @param g the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      if (currentSnapshotIndex >= 0 && currentSnapshotIndex < snapshots.size()) {
        List<IShape> shapeList = new ArrayList<>(snapshots.get(currentSnapshotIndex).getShapes());
        if (shapeList.isEmpty()) {
          return;
        }
        for (IShape shape: shapeList) {
          int x = (int)shape.getPoint().getX();
          int y = (int) shape.getPoint().getY();
          int horizontalProperty = (int)shape.getHorizontalProperty();
          int verticalProperty = (int)shape.getVerticalProperty();

          g.setColor(shape.getColor());

          if (shape.getType().equals("oval"))
            g.fillOval(x,y,horizontalProperty,verticalProperty);
          else
            g.fillRect(x,y,horizontalProperty,verticalProperty);
        }
      }
    }
  }

  //  /**
  //   * Test the view.
  //   */
  //  public static void main(String[] args) throws FileNotFoundException {
  //    PhotoAlbumModel model = new PhotoAlbumModel();
  //    GraphicalView view = new GraphicalView(1000,1000);
  //    PhotoAlbumController controller = new PhotoAlbumController(model,view);
  //    controller.go("hoops.txt");
  //  }
}
