/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package simplucas.misc;


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

    public double LSpeed;
    public double RSpeed;
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
    while (isOperatorControl() && isEnabled()){ // loop until change 
        Joystick joy1 = new Joystick(1);
        Joystick joy2 = new Joystick(2);

            //driving
            RSpeed = joy1.getAxis(Joystick.AxisType.kY);
            LSpeed = joy2.getAxis(Joystick.AxisType.kY);
            
            //hopper
            runHopper = joy1.getRawButton(2);
            
            //shooter
            runShooter = joy1.getTrigger();
            
            //arm
            runArm = joy1.getRawButton(4);
            backArm = joy1.getRawButton(5);
            
        RobotParts robotParts = RobotParts.getInstance();
        
        //driving
        robotParts.LDrive.set(LSpeed*-1);
        robotParts.RDrive.set(RSpeed);
        //hopper
        robotParts.Hopper.set(runHopper? .5 : 0);
        robotParts.Arm.set(runArm? 0.90 : 0);
        robotParts.Arm.set(backArm? -0.90 : 0);
        robotParts.Shooter.set(runShooter? .72 : 0);
        
        Timer.delay(0.005);
        }
    }
}