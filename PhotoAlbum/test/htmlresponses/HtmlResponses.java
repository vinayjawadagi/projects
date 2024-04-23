package htmlresponses;

/**
 * This enum contains the responses for some of the command files.
 */
public enum HtmlResponses {
  demo("""
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
      <div class="snapshot">
          <h2></h2>    
          <h3>After first selfie</h3>
          <svg width="1000" height="1000">
              <rect id="myrect" x="200.0" y="200.0" width="50.0" height="100.0" fill="rgb(255,0,0)">
              </rect>
              <ellipse id="myoval" cx="500.0" cy="100.0" rx="60.0" ry="30.0" fill="rgb(0,255,1)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>2nd selfie</h3>
          <svg width="1000" height="1000">
              <rect id="myrect" x="100.0" y="300.0" width="50.0" height="100.0" fill="rgb(255,0,0)">
              </rect>
              <ellipse id="myoval" cx="500.0" cy="100.0" rx="60.0" ry="30.0" fill="rgb(0,255,1)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3></h3>
          <svg width="1000" height="1000">
              <rect id="myrect" x="100.0" y="300.0" width="50.0" height="100.0" fill="rgb(0,0,255)">
              </rect>
              <ellipse id="myoval" cx="500.0" cy="400.0" rx="60.0" ry="30.0" fill="rgb(0,255,1)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Selfie after removing the rectangle from the picture</h3>
          <svg width="1000" height="1000">
              <ellipse id="myoval" cx="500.0" cy="400.0" rx="60.0" ry="30.0" fill="rgb(0,255,1)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      </body>
      </html>"""),
  hanoi("""
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
      <div class="snapshot">
          <h2></h2>
          <h3>One</h3>
          <svg width="1000" height="1000">
              <ellipse id="myoval" cx="500.0" cy="400.0" rx="60.0" ry="30.0" fill="rgb(0,255,1)">
              </ellipse>
              <rect id="s0" x="100.0" y="75.0" width="20.0" height="15.0" fill="rgb(255,0,255)">
              </rect>
              <rect id="s1" x="90.0" y="90.0" width="40.0" height="15.0" fill="rgb(255,153,100)">
              </rect>
              <rect id="s2" x="80.0" y="105.0" width="60.0" height="15.0" fill="rgb(142,178,0)">
              </rect>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Two</h3>
          <svg width="1000" height="1000">
              <ellipse id="myoval" cx="500.0" cy="400.0" rx="60.0" ry="30.0" fill="rgb(0,255,1)">
              </ellipse>
              <rect id="s0" x="100.0" y="75.0" width="20.0" height="15.0" fill="rgb(255,0,255)">
              </rect>
              <rect id="s1" x="90.0" y="90.0" width="40.0" height="15.0" fill="rgb(255,153,100)">
              </rect>
              <rect id="s2" x="80.0" y="105.0" width="60.0" height="15.0" fill="rgb(142,178,0)">
              </rect>
              <rect id="s3" x="70.0" y="120.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="50.0" y="135.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <rect id="s6" x="40.0" y="150.0" width="140.0" height="15.0" fill="rgb(0,102,255)">
              </rect>
              <rect id="s7" x="30.0" y="165.0" width="160.0" height="15.0" fill="rgb(51,0,255)">
              </rect>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Three</h3>
          <svg width="1000" height="1000">
              <ellipse id="myoval" cx="500.0" cy="400.0" rx="60.0" ry="30.0" fill="rgb(0,255,1)">
              </ellipse>
              <rect id="s0" x="100.0" y="75.0" width="20.0" height="15.0" fill="rgb(255,0,255)">
              </rect>
              <rect id="s1" x="90.0" y="90.0" width="40.0" height="15.0" fill="rgb(255,153,100)">
              </rect>
              <rect id="s2" x="80.0" y="105.0" width="60.0" height="15.0" fill="rgb(142,178,0)">
              </rect>
              <rect id="s3" x="70.0" y="120.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="50.0" y="135.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <rect id="s6" x="40.0" y="150.0" width="140.0" height="15.0" fill="rgb(0,102,255)">
              </rect>
              <rect id="s7" x="30.0" y="165.0" width="160.0" height="15.0" fill="rgb(51,0,255)">
              </rect>
              <rect id="s8" x="20.0" y="180.0" width="180.0" height="15.0" fill="rgb(204,0,255)">
              </rect>
              <rect id="s9" x="10.0" y="195.0" width="200.0" height="15.0" fill="rgb(255,0,153)">
              </rect>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Four</h3>
          <svg width="1000" height="1000">
              <ellipse id="myoval" cx="500.0" cy="400.0" rx="60.0" ry="30.0" fill="rgb(0,255,1)">
              </ellipse>
              <rect id="s0" x="600.0" y="195.0" width="20.0" height="15.0" fill="rgb(255,0,255)">
              </rect>
              <rect id="s1" x="590.0" y="180.0" width="40.0" height="15.0" fill="rgb(255,153,100)">
              </rect>
              <rect id="s2" x="580.0" y="165.0" width="60.0" height="15.0" fill="rgb(142,178,0)">
              </rect>
              <rect id="s3" x="570.0" y="150.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="560.0" y="135.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <rect id="s6" x="550.0" y="120.0" width="140.0" height="15.0" fill="rgb(0,102,255)">
              </rect>
              <rect id="s7" x="540.0" y="105.0" width="160.0" height="15.0" fill="rgb(51,0,255)">
              </rect>
              <rect id="s8" x="530.0" y="90.0" width="180.0" height="15.0" fill="rgb(204,0,255)">
              </rect>
              <rect id="s9" x="520.0" y="75.0" width="200.0" height="15.0" fill="rgb(255,0,153)">
              </rect>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Five</h3>
          <svg width="1000" height="1000">
              <ellipse id="myoval" cx="500.0" cy="400.0" rx="60.0" ry="30.0" fill="rgb(0,255,1)">
              </ellipse>
              <rect id="s0" x="600.0" y="195.0" width="20.0" height="15.0" fill="rgb(0,255,0)">
              </rect>
              <rect id="s1" x="590.0" y="180.0" width="40.0" height="15.0" fill="rgb(255,0,0)">
              </rect>
              <rect id="s2" x="580.0" y="165.0" width="60.0" height="15.0" fill="rgb(0,0,255)">
              </rect>
              <rect id="s3" x="20.0" y="20.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="20.0" y="80.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <rect id="s6" x="550.0" y="120.0" width="140.0" height="15.0" fill="rgb(0,102,255)">
              </rect>
              <rect id="s7" x="540.0" y="105.0" width="160.0" height="15.0" fill="rgb(51,0,255)">
              </rect>
              <rect id="s8" x="530.0" y="90.0" width="180.0" height="15.0" fill="rgb(204,0,255)">
              </rect>
              <rect id="s9" x="520.0" y="75.0" width="200.0" height="15.0" fill="rgb(255,0,153)">
              </rect>
              <ellipse id="so1" cx="40.0" cy="35.0" rx="40.0" ry="40.0" fill="rgb(0,0,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Six</h3>
          <svg width="1000" height="1000">
              <ellipse id="myoval" cx="500.0" cy="400.0" rx="60.0" ry="30.0" fill="rgb(0,255,1)">
              </ellipse>
              <rect id="s3" x="20.0" y="20.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="20.0" y="80.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <ellipse id="so1" cx="150.0" cy="35.0" rx="40.0" ry="40.0" fill="rgb(0,0,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Seven</h3>
          <svg width="1000" height="1000">
              <ellipse id="myoval" cx="500.0" cy="400.0" rx="60.0" ry="30.0" fill="rgb(0,255,1)">
              </ellipse>
              <rect id="s3" x="20.0" y="20.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="20.0" y="80.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <ellipse id="so1" cx="40.0" cy="35.0" rx="40.0" ry="40.0" fill="rgb(0,0,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Done!</h3>
          <svg width="1000" height="1000">
              <ellipse id="myoval" cx="500.0" cy="400.0" rx="60.0" ry="30.0" fill="rgb(0,255,1)">
              </ellipse>
              <rect id="s3" x="20.0" y="20.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="20.0" y="80.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <ellipse id="so1" cx="150.0" cy="35.0" rx="40.0" ry="40.0" fill="rgb(0,0,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      </body>
      </html>"""),
  hoops("""
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
      <div class="snapshot">
          <h2></h2>
          <h3>shot released!</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="20.0" cy="550.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>it's in the air!</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="150.0" cy="450.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>the arch looks good!</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="350.0" cy="400.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>everyone's holding their breath!</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="530.0" cy="380.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>for the win!</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="780.0" cy="450.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Jordan wins it!</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="860.0" cy="520.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      </body>
      </html>"""),
  playground("""
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
      <div class="snapshot">
          <h2></h2>
          <h3>One</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="860.0" cy="520.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <rect id="s0" x="100.0" y="75.0" width="20.0" height="15.0" fill="rgb(255,0,255)">
              </rect>
              <rect id="s1" x="90.0" y="90.0" width="40.0" height="15.0" fill="rgb(255,153,100)">
              </rect>
              <rect id="s2" x="80.0" y="105.0" width="60.0" height="15.0" fill="rgb(142,178,0)">
              </rect>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Two</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="860.0" cy="520.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <rect id="s0" x="100.0" y="75.0" width="20.0" height="15.0" fill="rgb(255,0,255)">
              </rect>
              <rect id="s1" x="90.0" y="90.0" width="40.0" height="15.0" fill="rgb(255,153,100)">
              </rect>
              <rect id="s2" x="80.0" y="105.0" width="60.0" height="15.0" fill="rgb(142,178,0)">
              </rect>
              <rect id="s3" x="70.0" y="120.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="50.0" y="135.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <rect id="s6" x="40.0" y="150.0" width="140.0" height="15.0" fill="rgb(0,102,255)">
              </rect>
              <rect id="s7" x="30.0" y="165.0" width="160.0" height="15.0" fill="rgb(51,0,255)">
              </rect>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Three</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="860.0" cy="520.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <rect id="s0" x="100.0" y="75.0" width="20.0" height="15.0" fill="rgb(255,0,255)">
              </rect>
              <rect id="s1" x="90.0" y="90.0" width="40.0" height="15.0" fill="rgb(255,153,100)">
              </rect>
              <rect id="s2" x="80.0" y="105.0" width="60.0" height="15.0" fill="rgb(142,178,0)">
              </rect>
              <rect id="s3" x="70.0" y="120.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="50.0" y="135.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <rect id="s6" x="40.0" y="150.0" width="140.0" height="15.0" fill="rgb(0,102,255)">
              </rect>
              <rect id="s7" x="30.0" y="165.0" width="160.0" height="15.0" fill="rgb(51,0,255)">
              </rect>
              <rect id="s8" x="20.0" y="180.0" width="180.0" height="15.0" fill="rgb(204,0,255)">
              </rect>
              <rect id="s9" x="10.0" y="195.0" width="200.0" height="15.0" fill="rgb(255,0,153)">
              </rect>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Four</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="860.0" cy="520.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <rect id="s0" x="600.0" y="195.0" width="20.0" height="15.0" fill="rgb(255,0,255)">
              </rect>
              <rect id="s1" x="590.0" y="180.0" width="40.0" height="15.0" fill="rgb(255,153,100)">
              </rect>
              <rect id="s2" x="580.0" y="165.0" width="60.0" height="15.0" fill="rgb(142,178,0)">
              </rect>
              <rect id="s3" x="570.0" y="150.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="560.0" y="135.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <rect id="s6" x="550.0" y="120.0" width="140.0" height="15.0" fill="rgb(0,102,255)">
              </rect>
              <rect id="s7" x="540.0" y="105.0" width="160.0" height="15.0" fill="rgb(51,0,255)">
              </rect>
              <rect id="s8" x="530.0" y="90.0" width="180.0" height="15.0" fill="rgb(204,0,255)">
              </rect>
              <rect id="s9" x="520.0" y="75.0" width="200.0" height="15.0" fill="rgb(255,0,153)">
              </rect>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Five</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="860.0" cy="520.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <rect id="s0" x="600.0" y="195.0" width="20.0" height="15.0" fill="rgb(0,255,0)">
              </rect>
              <rect id="s1" x="590.0" y="180.0" width="40.0" height="15.0" fill="rgb(255,0,0)">
              </rect>
              <rect id="s2" x="580.0" y="165.0" width="60.0" height="15.0" fill="rgb(0,0,255)">
              </rect>
              <rect id="s3" x="20.0" y="20.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="20.0" y="180.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <rect id="s6" x="550.0" y="120.0" width="140.0" height="15.0" fill="rgb(0,102,255)">
              </rect>
              <rect id="s7" x="540.0" y="105.0" width="160.0" height="15.0" fill="rgb(51,0,255)">
              </rect>
              <rect id="s8" x="530.0" y="90.0" width="180.0" height="15.0" fill="rgb(204,0,255)">
              </rect>
              <rect id="s9" x="520.0" y="75.0" width="200.0" height="15.0" fill="rgb(255,0,153)">
              </rect>
              <ellipse id="so1" cx="40.0" cy="70.0" rx="30.0" ry="30.0" fill="rgb(0,0,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Six</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="860.0" cy="520.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <rect id="s3" x="20.0" y="20.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="20.0" y="180.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <ellipse id="so1" cx="150.0" cy="70.0" rx="30.0" ry="30.0" fill="rgb(0,0,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Seven</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="860.0" cy="520.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <rect id="s3" x="20.0" y="20.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="20.0" y="180.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <ellipse id="so1" cx="40.0" cy="70.0" rx="30.0" ry="30.0" fill="rgb(0,0,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      <div class="snapshot">
          <h2></h2>
          <h3>Done!</h3>
          <svg width="1000" height="1000">
              <rect id="sky" x="0.0" y="0.0" width="1000.0" height="500.0" fill="rgb(0,191,255)">
              </rect>
              <rect id="ground" x="0.0" y="500.0" width="1000.0" height="100.0" fill="rgb(124,252,0)">
              </rect>
              <rect id="court" x="0.0" y="600.0" width="1000.0" height="150.0" fill="rgb(152,23,23)">
              </rect>
              <rect id="hoop1" x="950.0" y="560.0" width="20.0" height="100.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop2" x="930.0" y="540.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="hoop3" x="910.0" y="520.0" width="20.0" height="20.0" fill="rgb(187,187,187)">
              </rect>
              <rect id="backboard" x="895.0" y="470.0" width="15.0" height="80.0" fill="rgb(246,254,255)">
              </rect>
              <ellipse id="ball" cx="860.0" cy="520.0" rx="30.0" ry="30.0" fill="rgb(238,103,48)">
              </ellipse>
              <ellipse id="rim" cx="860.0" cy="525.0" rx="35.0" ry="5.0" fill="rgb(250,131,32)">
              </ellipse>
              <ellipse id="net1" cx="860.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net2" cx="868.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net3" cx="876.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net4" cx="884.0" cy="530.0" rx="5.0" ry="35.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net5" cx="860.0" cy="535.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net6" cx="860.0" cy="545.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <ellipse id="net7" cx="860.0" cy="555.0" rx="30.0" ry="3.0" fill="rgb(246,254,255)">
              </ellipse>
              <rect id="s3" x="20.0" y="20.0" width="80.0" height="15.0" fill="rgb(51,255,0)">
              </rect>
              <rect id="s5" x="20.0" y="180.0" width="120.0" height="15.0" fill="rgb(0,178,178)">
              </rect>
              <ellipse id="so1" cx="150.0" cy="70.0" rx="30.0" ry="30.0" fill="rgb(0,0,255)">
              </ellipse>
          </svg>
      </div>
      <p></p>
      </body>
      </html>""");
  private String value;
  HtmlResponses(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
