/////////////////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION ///////////////////////////////
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
//                                                 NONE
/////////////////////////////////////////// 100 COLUMNS WIDE //////////////////////////////////////

/**
 * This interface sets the defining characteristics of the Jungle Park Graphic objects: Classes that
 * implement this interface are able to work in harmony with the various functions of the mouse
 * 
 * @author Mouna Kacem, Vedaant Tambi
 * @version 2.0
 * @since 1.0
 */
public interface ParkGUI {
  public void draw(); // draws a ParkGUI object (either an animal or a button) to the display window

  public void mousePressed(); // called each time the mouse is Pressed

  public void mouseReleased(); // called each time the mouse is Pressed

  public boolean isMouseOver(); // checks whether the mouse is over a ParkGUI object

}
