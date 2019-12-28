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
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
////////////////////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////////////
//                                                 NONE
/////////////////////////////////////////// 100 COLUMNS WIDE //////////////////////////////////////

/**
 * This class represents a Deer in the JunglePark application
 * 
 * @author Mouna Kacem, Vedaant Tambi
 * @version 2.0
 * @since 1.0
 */
public class Deer extends Animal {
  private static final int SCAN_RANGE = 175; // scan range area to check for a threat in the
                                             // neighborhood
  private static final String IMAGE_FILE_NAME = "images/deer.png";
  private static int nextID = 1; // class variable that represents the identifier of the next deer
                                 // to be created

  private static final String TYPE = "DR"; // A String that represents the deer type
  private final int id; // Deer's id: positive number that represents the order of the deer


  /**
   * Constructor that creates a Deer object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Deer(JunglePark processing) {
    // Set Deer drawing parameters
    super(processing, IMAGE_FILE_NAME);
    // Set Deer identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
  }

  /**
   * Checks if there is a threat (a Tiger for instance) at the neighborhood
   * 
   * @param scanRange is an integer that represents the range of the area to be scanned around the
   *        animal
   * @return true if a tiger is located within the range of the deer, false otherwise
   */
  public boolean scanForThreat(int scanRange) {
    // 'processing' is the display window object that was passed to the Animal constructor
    for (int i = 0; i < this.processing.listGUI.size(); i++) {
      // checks if the graphic object is a Tiger object because only a tiger is a threat to a deer
      if (this.processing.listGUI.get(i) instanceof Tiger) {
        // checks if the tiger object is actually in the deer's range
        if (isClose((Animal) this.processing.listGUI.get(i), scanRange))
          return true;
      }
    }
    return false;
  }

  /**
   * Defines the behavior of a Deer object in the Jungle park (i.e. Getting a warning message if a
   * tiger is nearby). Overrides the action method in the Animal class.
   */
  @Override
  public void action() {
    if (scanForThreat(SCAN_RANGE)) {
      this.processing.fill(0); // specify font color: black
      this.processing.text("THREAT!", this.getPositionX(), // displays the word 'THREAT' on the top
          this.getPositionY() - this.image.height / 2 - 4);// of the deer object
    }
  }
}
