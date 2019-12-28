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
//                                                  NONE
/////////////////////////////////////////// 100 COLUMNS WIDE //////////////////////////////////////


/**
 * This class represents the Add Animal Buttons in the jungle park application This class extends
 * the Button class
 * 
 * @author Mouna Kacem, Vedaant Tambi
 * @version 1.0
 * @since 1.0
 */
public class AddAnimalButton extends Button {

  private String type; // type of the animal to add

  /**
   * Creates a new AddAnimalButton object positioned at a given position of the display window
   * 
   * @param type
   * @param x x-coordinate of the AddAnimal button in the display window
   * @param y y-coordinate of the AddAnimal button in the display window
   * @param park PApplet object that represents the Jungle Park display window
   */
  public AddAnimalButton(String type, float x, float y, JunglePark park) {
    super(x, y, park);
    this.type = type.toLowerCase(); // because the type is 'checked for' in lower case only
    this.label = "Add " + type; // label is the text to be written on the button
  }

  /**
   * Creates a new Animal object and adds it to the graphics ArrayList when the mouse clicks the Add
   * Animal button. Overrides the class Button's mousePressed method
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      switch (type) {
        case "tiger":
          // tiger is added when the tiger button is clicked
          this.processing.listGUI.add(new Tiger(this.processing));
          break;
        case "deer":
          // deer is added when the deer button is clicked
          this.processing.listGUI.add(new Deer(this.processing));
          break;
      }
    }
  }
}
