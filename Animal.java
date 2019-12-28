////////////////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION ///////////////////////////////
//
// Title: Jungle Park 2000 Program
// Files: Animal.java, Button.java, AddAnimalButton.java, JunglePark.java, ParkGUI.java
//        Tiger.java, ClearButton.java, JungleParkTests.java, Deer.java, background.png,
//        tiger.png , deer.png, and processing.jar
// Course: CS 300 Fall term 2018
// Author: Vedaant Tambi
// Email: tambi@wisc.edu
// Lecturer's Name: MOUNA AYARI BEN HADJ KACEM
//
////////////////////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////////////
//                                                 NONE
/////////////////////////////////////////// 100 COLUMNS WIDE //////////////////////////////////////

import java.util.Random;

/**
 * This class represents an animal in the Jungle Park application It implements the interface
 * ParkGUI
 * 
 * @author Mouna Kacem, Vedaant Tambi
 * @version 2.0
 * @since 1.0
 */
public class Animal implements ParkGUI {

  private static Random randGen = new Random(); // Generator of random numbers
  protected String label; // represents the animal's identifier
  // Fields defined to draw the animal in the application display window
  protected JunglePark processing; // PApplet object that represents the display window
  protected PImage image; // animal's image

  private float[] position; // animal's position in the display window
                            // Usage: position[0: x-coordinate, or 1: y-coordinate]
  private boolean isDragging; // indicates whether the animal is being dragged or not


  /**
   * Creates a new Animal object positioned at a given position of the display window
   * 
   * @param processing PApplet object that represents the display window
   * @param positionX x-coordinate of the animal's image in the display window
   * @param positionY y-coordinate of the animal's image in the display window
   * @param imageFileName filename of the animal image
   */
  public Animal(JunglePark processing, float positionX, float positionY, String imageFileName) {

    // Set Animal drawing parameters
    this.processing = processing; // set the PApplet Object where the animal will be drawn
    this.position = new float[] {positionX, positionY}; // sets the position of the animal object
    this.image = processing.loadImage(imageFileName); // loads the image after taking the file name
    isDragging = false; // initially the animal is not dragging
  }

  /**
   * Creates a new Animal object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   * @param imageFileName filename of the animal image
   */
  public Animal(JunglePark processing, String imageFileName) {
    /*
     * the random integers produced are type-casted to float so that the parameterized constructor
     * matches the relevant function prototype. The random generators are passed the dimensions of
     * the display window, so that animal is positioned within the display window.
     */
    this(processing, (float) randGen.nextInt(processing.width),
        // the max() method makes sure that the y-coordinate is > 100 but < display window height
        Math.max((float) randGen.nextInt(processing.height), 100), imageFileName);
  }

  /**
   * Draws the animal to the display window. It also sets its position to the mouse position if the
   * tiger is being dragged (i.e. if its isDragging field is set to true).
   */
  @Override
  public void draw() {
    // if the tiger is dragging, set its position to the mouse position with respect to the display
    // window (processing) dimension
    if (this.isDragging) {
      if (this.processing.mouseX < 0) // mouse outside the screen
        this.position[0] = 0; // animal positioned at the left edge of the screen
      else if (this.processing.mouseX > this.processing.width) // mouse outside the screen
        this.position[0] = this.processing.width; // animal drawn at the right edge of the screen
      else
        // x coordinate of animal is equated with mouse's x coordinate if mouse is inside screen
        this.position[0] = this.processing.mouseX;

      if (this.processing.mouseY < 0) // mouse outside the screen
        this.position[1] = 0; // animal positioned at the bottom edge of the screen
      else if (this.processing.mouseY > this.processing.height) // mouse outside the screen
        this.position[1] = this.processing.height; // animal drawn at the top edge of the screen
      else
        // y coordinate of animal is equated with mouse's y coordinate if mouse is inside screen
        this.position[1] = this.processing.mouseY;
    }

    // draw the tiger at its current position
    this.processing.image(this.image, this.position[0], position[1]);
    /*
     * since draw method is called continuously, the action method is executed so that the animal
     * (deer/tiger) performs its relevant action
     */
    this.action();
    // display label for the animal
    displayLabel();

  }


  /**
   * Displays the Tiger object label on the application window screen
   */
  private void displayLabel() {
    this.processing.fill(0); // specify font color: black
    // display label
    this.processing.text(label, this.position[0], this.position[1] + this.image.height / 2 + 4); // text
  }

  /**
   * Checks if the mouse is over the given animal object
   * 
   * @return true if the mouse is over the given animal object, false otherwise
   */
  @Override
  public boolean isMouseOver() {
    int animalWidth = image.width; // image width
    int animalHeight = image.height; // image height

    // checks if the mouse is over the animal
    if (processing.mouseX > position[0] - animalWidth / 2 // tigerWidth/2 is x coordinate of center
        && processing.mouseX < position[0] + animalWidth / 2
        && processing.mouseY > position[1] - animalHeight / 2 // tigerHeight/2 is ordinate of center
        && processing.mouseY < position[1] + animalHeight / 2) {
      return true;
    }
    return false;
  }

  /**
   * Lets the animal be dragged when the mouse is clicked on an animal (i.e. isDragging field is set
   * to true). Overrides the mousePressed() method defined in the ParkGUI interface
   */
  @Override
  public void mousePressed() {
    if (isMouseOver())
      // the mouse will start dragging the animal only if it's clicked and over the animal image
      isDragging = true;
  }

  /**
   * Stops dragging the animal when the mouse is released. Overrides the mouseReleased() method
   * defined in the ParkGUI interface
   */
  @Override
  public void mouseReleased() {
    isDragging = false; // the mouse will stop dragging the animal when the mouse is released
  }

  /**
   * @return the label that represents the animal's identifier
   */
  public String getLabel() {
    return label;
  }


  /**
   * @return the image of type PImage of the animal object
   */
  public PImage getImage() {
    return image;
  }


  /**
   * @return the X coordinate of the animal position
   */
  public float getPositionX() {
    return position[0];
  }

  /**
   * @return the Y coordinate of the animal position
   */
  public float getPositionY() {
    return position[1];
  }


  /**
   * @param position the XPosition to set
   */
  public void setPositionX(float position) {
    this.position[0] = position;
  }

  /**
   * @param position the YPosition to set
   */
  public void setPositionY(float position) {
    this.position[1] = position;
  }

  /**
   * @return true if the animal is being dragged, false otherwise
   */
  public boolean isDragging() {
    return isDragging;
  }

  /**
   * Computes the euclidean distance between the current animal and another one. Euclidean distance
   * = sqrt((x2-x1)^2 + (y2-y1)^2)
   * 
   * @param otherAnimal reference to another animal
   * @return distance between the current animal and otherAnimal
   */
  public double distance(Animal otherAnimal) {
    return Math.sqrt(Math.pow(this.getPositionX() - otherAnimal.getPositionX(), 2)
        + Math.pow(this.getPositionY() - otherAnimal.getPositionY(), 2));
  }

  /**
   * Defines the behavior of the current animal in the jungle park
   */
  public void action() {
    // This method should be overridden by a subclass
  }

  /**
   * Checks whether the other animal is close to the (i.e within the range of) current animal
   * 
   * @param otherAnimal reference to the other animal
   * @param range maximum distance within which the animal can perform its action
   * @return true if the otherAnimal is in range of animal, false otherwise
   */
  public boolean isClose(Animal otherAnimal, int range) {
    // if the other animal's distance is less than or equal to the range
    if (distance(otherAnimal) <= range) // otherAnimal is close to this animal with respect to range
      return true;
    else
      return false;
  }


}
