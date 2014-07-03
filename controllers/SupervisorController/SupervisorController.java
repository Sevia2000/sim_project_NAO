// File:          SupervisorController.java
// Date:          
// Description:   
// Author:        
// Modifications: 

// You may need to add other webots classes such as
//  import com.cyberbotics.webots.controller.DistanceSensor;
//  import com.cyberbotics.webots.controller.LED;
// or more simply:
//  import com.cyberbotics.webots.controller.*;
import com.cyberbotics.webots.controller.Robot;
import com.cyberbotics.webots.controller.Supervisor;
import com.cyberbotics.webots.controller.Node;
import com.cyberbotics.webots.controller.Field;
import java.lang.Math;


// Here is the main class of your controller.
// This class defines how to initialize and how to run your controller.
// Note that this class derives Robot and so inherits all its functions
public class SupervisorController extends Supervisor {
  
  // You may need to define your own functions or variables, like
  //  private LED led;
  
  // SupervisorController constructor
  public SupervisorController() {
      
    // call the Robot constructor
    super();
    
    // You should insert a getDevice-like function in order to get the
    // instance of a device of the robot. Something like:
    //  led = getLED("ledName");
    
  }
    
  // User defined function for initializing and running
  // the SupervisorController class
  public void run() {
    
    // Main loop:
    // Perform simulation steps of 64 milliseconds
    // and leave the loop when the simulation is over
    
    Node robot_node = this.getFromDef("NAO_BOT");
    Field trans_field = robot_node.getField("translation");
    Field rot_field = robot_node.getField("rotation");
    
    
    while (step(128) != -1) {
      
      // Read the sensors:l
      // Enter here functions to read sensor data, like:
      //  double val = distanceSensor.getValue();
      double[] trans = trans_field.getSFVec3f();
      //double[] rotation = rot_field.getSFRotation();
      // Process sensor data here
      //System.out.println("My robot is at position " + trans[0] + ", " + trans[1] + ", " 
      //+ trans[2]);
      double[] rotation = robot_node.getOrientation();
      double angle = Math.atan2(rotation[1], rotation[7]);
      // rounding (double)Math.round(value * 100000) / 100000
    
      
      //angle = (angle > 0 ? angle : (2*3.14159 + angle)) * 360 / (2*3.14159);
      
      //(x > 0 ? x : (2*PI + x)) * 360 / (2*PI)
      
      angle = (double)Math.round(angle * 1000) / 1000;
     
      System.out.println("The robot's rotation: " + angle);
      
      // Enter here functions to send actuator commands, like:
      //  led.set(1);
    };
    
    // Enter here exit cleanup code
  }

  // This is the main program of your controller.
  // It creates an instance of your Robot subclass, launches its
  // function(s) and destroys it at the end of the execution.
  // Note that only one instance of Robot should be created in
  // a controller program.
  // The arguments of the main function can be specified by the
  // "controllerArgs" field of the Robot node
  public static void main(String[] args) {
    SupervisorController controller = new SupervisorController();
    controller.run();
  }
}
