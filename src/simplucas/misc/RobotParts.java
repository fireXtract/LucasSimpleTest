/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplucas.misc;

import edu.wpi.first.wpilibj.Jaguar;
//import edu.wpi.first.wpilibj.camera.AxisCamera;

/**
 *
 * @author Teacher
 */
public class RobotParts {
    //pwm number
    private final static int LDriveP = 5;
    private final static int RDriveP = 4;
    private final static int HopperP = 3;
    private final static int ShooterP = 8;
    private final static int ArmP = 2;
   // private final static int camera = 1;
    //jags
    public Jaguar LDrive;
    public Jaguar RDrive;
    public Jaguar Hopper;
    public Jaguar Arm;
    public Jaguar Shooter;
    //public AxisCamera camera;

    private static RobotParts partInst;
    
    private RobotParts(){
        LDrive = new Jaguar(LDriveP);
        RDrive = new Jaguar(RDriveP);
        Hopper = new Jaguar(HopperP);
        Shooter = new Jaguar(ShooterP);
        Arm = new Jaguar(ArmP);
       // camera = new AxisCamera("192.168.0.90");
    }
    public static RobotParts getInstance(){
        if(partInst == null)
            partInst = new RobotParts();
        return partInst;
    }
}
