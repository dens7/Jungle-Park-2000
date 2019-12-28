////////////////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION ///////////////////////////////
//
// Title: Jungle Park 2000 Program
// Files: Animal.java, Button.java, AddAnimalButton.java, JunglePark.java, ParkGUI.java, Tiger.java, 
//        ClearButton.java, JungleParkTests.java, Deer.java, background.png, tiger.png , deer.png, 
//        and processing.jar
// Course: CS 300 Fall term 2018
// Author: Vedaant Tambi
// Email: tambi@wisc.edu
// Lecturer's Name: MOUNA AYARI BEN HADJ KACEM
//
////////////////////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////////////
//                                                  NONE
/////////////////////////////////////////// 100 COLUMNS WIDE //////////////////////////////////////

/**
 * This class represents the Clear Button in the display window. It extends the Button class.
 * 
 * @author Vedaant Tambi
 * @version 1.0
 * @since 1.0
 */
public class ClearButton extends Button {

  /**
   * Creates a new ClearButton object positioned at a given position of the display window
   * 
   * @param x x-coordinate of the Clear button in the display window
   * @param y y-coordinate of the Clear button in the display window
   * @param park PApplet object that represents the Jungle Park display window
   */
  public ClearButton(float x, float y, JunglePark park) {
    super(x, y, park); // set the button dimensions
    this.label = "Clear Park"; // set the button's text to read "Clear Park"
  }

  /**
   * Deletes all the Animal objects from the ListGUI ArrayList and clears the pard. Overrides the
   * class Button's mousePressed method
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) // if the clicked mouse is over the animal, it is removed from the park
      this.processing.clear();
  }
}
