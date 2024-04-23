package photoalbum.view;

/**
 * Contains the predefined skeleton of a html code.
 */
public enum HtmlConstant {
  htmlStart("""
        <!DOCTYPE html>
        <html>
        <head>
        <style>
            .snapshot {
                border: 5px outset red;
                background-color: lightblue;
            }
        </style>
        </head>
        <body>
        <h1>Snapshots:</h1>
        """),
  snapshotStart("""
        <div class="snapshot">
            <h2>@snapshot_id</h2>
            <h3>@description</h3>
            <svg width="1000" height="1000">
            """),
  circle("""
              <ellipse id="@name" cx="@x_axis" cy="@y_axis" rx="@width" ry="@height" fill="rgb(@rgb)">
              </ellipse>
      """),
  rect("""
              <rect id="@name" x="@x_axis" y="@y_axis" width="@width" height="@height" fill="rgb(@rgb)">
              </rect>
      """),
  snapshotEnd("""
            </svg>
        </div>
        <p></p>
        """),
  htmlEnd("</body>\n" + "</html>");
  private String value;
  HtmlConstant(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
