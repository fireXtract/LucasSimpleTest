/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package simplucas.misc;


import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class RobotTemplate extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    //Doubles are like integers but with decimals like 24.23
    public double LSpeed;
    public double RSpeed;
    //Booleans are either true or false
    public boolean runHopper;
    public boolean runArm;
    public boolean backArm;
    public boolean runShooter;
    
    public void robotInit(){
        RobotParts.getInstance();
    }
    protected void disabled(){
        stop();
        getWatchdog().setEnabled(false);
    }
    public void stop(){
        //Sets all of the motors off before the robot stops
        LSpeed = 0;
        RSpeed = 0;
        runHopper = false;
        runArm = false;
        backArm = false;
        runShooter = false;
    }
    public void autonomous() {

    }
    /**
     * This function is called once each time the robot enters operator control.
     */
    
    public void operatorControl() {
    while (isOperatorControl() && isEnabled()){ //
        Joystick joy1 = new Joystick(1);
        Joystick joy2 = new Joystick(2);

            //Sets RSpeed as the forward and backward axis of joystick one
            RSpeed = joy1.getAxis(Joystick.AxisType.kY);
            LSpeed = joy2.getAxis(Joystick.AxisType.kY);
            
            //Sets runHopper to the value of the button
            runHopper = joy1.getRawButton(2);
            //Sets runShooter to the value of the trigger also known as Button(1)
            runShooter = joy1.getTrigger();
            
            //Sets runArm to the value of the button
            runArm = joy1.getRawButton(4);
            backArm = joy1.getRawButton(5);
            
        RobotParts robotParts = RobotParts.getInstance();
        robotParts.textOutput.println(DriverStationLCD.Line.kUser2, 1, "be printed i hope");
        robotParts.textOutput.println(DriverStationLCD.Line.kUser1, 1, "Lots of words should");
        robotParts.textOutput.updateLCD();
        
        //Sets the drive values to the speed values from the joystick
        robotParts.LDrive.set(LSpeed*-1);
        robotParts.RDrive.set(RSpeed);
        //Sets the hopper to either on at 0.5 else 0
        /*
         *This part calls from robotParts and sets the Hopper jag to the next value
         *robotParts.Hopper.set(
         * ? checks runHopper for true if so then it sets Hopper to 0.5
         * : is a compact else statement
         * runHopper? .5 : 0);
         * congrats now you understand a compacted if else statement
         */      
  
        robotParts.Hopper.set(runHopper? .5 : 0);
        robotParts.Arm.set(runArm? 0.90 : 0);
        robotParts.Arm.set(backArm? -0.90 : 0);
        robotParts.Shooter.set(runShooter? .72 : 0);
        
        Timer.delay(0.005);
        }
    }
}