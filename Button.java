////////////////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION ///////////////////////////////
//
// Title: Jungle Park 2000 Program
// Files: Animal.java, Button.java, AddAnimalButton.java, JunglePark.java, ParkGUI.java
//        Tiger.java, ClearButton.java, JungleParkTests.java, Deer.java, background.png, tiger.png, 
//        deer.png, and processing.jar
// Course: CS 300 Fall term 2018
// Author: Vedaant Tambi
// Email: tambi@wisc.edu
// Lecturer's Name: MOUNA AYARI BEN HADJ KACEM
//
////////////////////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////////////
//                                                 NONE
/////////////////////////////////////////// 100 COLUMNS WIDE //////////////////////////////////////


/**
 * This is a super class for any Button that can be added to a PApplet application This class
 * implements the ParkGUI interface
 * 
 * @author Mouna Kacem, Vedaant Tambi
 * @version 2.0
 * @since 1.0
 */
public class Button implements ParkGUI {
  private static final int WIDTH = 85; // Width of the Button in pixels
  private static final int HEIGHT = 32; // Height of the Button in pixels
  protected JunglePark processing; // PApplet object where the button will be displayed
  private float[] position; // array storing x and y positions of the Button with respect to
                            // the display window
  protected String label; // text/label that represents the button

  /**
   * Creates a new button positioned at a given position in the display window. In this program, the
   * new buttons are created at the top of the jungle park application
   * 
   * @param x x-coordinate of the button in the display window
   * @param y y-coordinate of the button in the display window
   * @param processing PApplet object that represents the display window
   */
  public Button(float x, float y, JunglePark processing) {
    // Set button drawing parameters
    this.processing = processing;
    this.position = new float[2];
    this.position[0] = x;
    this.position[1] = y;
    this.label = "Button";
  }

  /**
   * Callback method called in an infinite loop. It draws the Jungle Park's buttons. It overrides
   * the draw() method of the ParkGUI interface
   */
  @Override
  public void draw() {
    this.processing.stroke(0);// set line value to black
    if (isMouseOver()) // the label will change color if mouse is over the button
      processing.fill(100); // set the fill color to dark gray if the mouse is over the button
    else
      processing.fill(200); // set the fill color to light gray otherwise

    // draw the button (rectangle with a centered text)
    processing.rect(position[0] - WIDTH / 2.0f, position[1] - HEIGHT / 2.0f,
        position[0] + WIDTH / 2.0f, position[1] + HEIGHT / 2.0f);
    processing.fill(0); // set the fill color to black
    processing.text(label, position[0], position[1]); // display the text of the current button
  }

  /**
   * Called when the mouse is pressed. Overrides the mousePressed() method defined in the ParkGUI
   * interface. Overridden by method defined in its subclasses.
   */
  @Override
  public void mousePressed() {
    if (isMouseOver())
      System.out.println("A button was pressed.");
  }

  /**
   * Called when the mouse is released. Overrides the mouseReleased() method defined in the ParkGUI
   * interface. Overridden by method defined in its subclasses.
   */
  @Override
  public void mouseReleased() {

  }

  /**
   * Checks if the mouse is over the given button object
   * 
   * @return true if the mouse is over the given button object, false otherwise
   */
  @Override
  public boolean isMouseOver() {
    if (this.processing.mouseX > this.position[0] - WIDTH / 2
        && this.processing.mouseX < this.position[0] + WIDTH / 2
        && this.processing.mouseY > this.position[1] - HEIGHT / 2
        && this.processing.mouseY < this.position[1] + HEIGHT / 2)
      return true;
    return false;
  }
}
