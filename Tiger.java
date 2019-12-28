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
// NONE
/////////////////////////////////////////// 100 COLUMNS WIDE //////////////////////////////////////

/**
 * This class represents a Tiger in the JunglePark application
 * 
 * @author Mouna Kacem, Vedaant Tambi
 * @version 2.0
 * @since 1.0
 */
public class Tiger extends Animal {
  private static final int SCAN_RANGE = 100; // range dimension for scanning the neighborhood for
                                             // food
  private static final String IMAGE_FILE_NAME = "images/tiger.png";
  private static int nextID = 1; // class variable that represents the identifier of the next tiger
                                 // to be created
  // Tiger's identification fields
  private static final String TYPE = "TGR"; // A String that represents the tiger type
  private final int id; // Tiger's id: positive number that represents the order of the tiger
  private int deerEatenCount; // Number of Deers that the current tiger has eaten so far


  /**
   * Creates a new Tiger object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Tiger(JunglePark processing) {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
  }

  /**
   * @return the number of deer eaten by the tiger
   */
  public int getDeerEatenCount() {
    return deerEatenCount;
  }

  /**
   * This method moves the tiger to the position of the food (i.e deer) and deletes the food from
   * the listGUI ArrayList. In other words, the tiger hops on the deer and eats it
   * 
   * @param food refers to the deer which is within the tiger's range
   */
  public void hop(Deer food) {
    // to obtain index of food in ArrayList of graphic objects from display window object
    int indexOfFood = this.processing.listGUI.indexOf(food);
    this.setPositionX(food.getPositionX()); // move tiger to food's x coordinate
    this.setPositionY(food.getPositionY()); // move tiger to food's y coordinate
    this.processing.listGUI.remove(indexOfFood); // remove the food object from the park
    deerEatenCount++; // update the no. of deer eaten by the tiger object
  }

  /**
   * Displays the number of deer eaten by the tiger on top of the tiger's image
   */
  public void displayDeerEatenCount() {
    this.processing.fill(0); // specify font color: black
    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(),
        this.getPositionY() - this.image.height / 2 - 4);
  }

  /**
   * Tiger's behavior in the Jungle Park Scans for food at the neighborhood of the current tiger. If
   * the Tiger finds any deer at its proximity, it hops on it, and eats it
   */
  @Override
  public void action() {
    // 'processing' is the display window object that was passed to the Animal constructor
    for (int i = 0; i < this.processing.listGUI.size(); i++) {
      // checks if the graphic object is a Deer object because only deer is food for the tiger
      if (this.processing.listGUI.get(i) instanceof Deer) {
        // checks if the deer object is actually in the tiger object's range
        if (isClose((Animal) this.processing.listGUI.get(i), SCAN_RANGE))
          hop((Deer) this.processing.listGUI.get(i)); // the tiger hops on the deer
      }
    }
    if (deerEatenCount > 0) // no. of deer eaten displayed only when tiger has eaten atleast 1 deer
      displayDeerEatenCount(); // display deerEatenCount
  }


}
