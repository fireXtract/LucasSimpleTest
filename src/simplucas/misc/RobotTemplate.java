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
    public void robotInit() {
        RobotParts.getInstance();
    }

    protected void disabled() {
        stop();
        getWatchdog().setEnabled(false);
    }

    public void stop() {
        //NOTHING
    }

    public void autonomous() {
    }

    public void runDrive(RobotParts q) {
        q.RDrive.set(q.joy1.getAxis(Joystick.AxisType.kY));
        q.LDrive.set(q.joy2.getAxis(Joystick.AxisType.kY) * -1);
    }

    public void runShooter(RobotParts q) {
        q.Shooter.set(q.joy1.getTrigger() ? 0.5 : 0);
    }

    public void runHopper(RobotParts q) {
        q.Hopper.set(q.joy1.getRawButton(2) ? 0.5 : 0);
    }

    public void runArm(RobotParts q) {
        q.Arm.set(q.joy1.getRawButton(4) ? 0.9 : 0);
        q.Arm.set(q.joy1.getRawButton(5) ? -0.9 : 0);
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while (isOperatorControl() && isEnabled()) {

            RobotParts setOfParts = RobotParts.getInstance();

            setOfParts.runHopper(5);

            runDrive(setOfParts);
            runHopper(setOfParts);
            runArm(setOfParts);
            runShooter(setOfParts);

            Timer.delay(0.05);
        }
    }
}