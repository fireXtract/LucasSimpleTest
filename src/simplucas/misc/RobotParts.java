/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplucas.misc;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.camera.AxisCamera;

/**
 *
 * @author Teacher
 */
public class RobotParts {
    //Sets the drive PWM from the sidecar as # 
    private final static int LDriveP = 5;
    private final static int RDriveP = 4;
    private final static int HopperP = 3;
    private final static int ShooterP = 8;
    private final static int ArmP = 2;
   // private final static int camera = 1;
    //Declares the Individual Jaguars for later us
    public Jaguar LDrive;
    public Jaguar RDrive;
    public Jaguar Hopper;
    public Jaguar Arm;
    public Jaguar Shooter;
    //public AxisCamera camera;
    public DriverStationLCD textOutput;
    
    private double time;
    private static RobotParts partInst;
    public Joystick joy1;
    public Joystick joy2;
    
    public RobotParts(){
        //Creates the jaguar from the last two sections
        LDrive = new Jaguar(LDriveP);
        RDrive = new Jaguar(RDriveP);
        Hopper = new Jaguar(HopperP);
        Shooter = new Jaguar(ShooterP);
        Arm = new Jaguar(ArmP);
        textOutput = DriverStationLCD.getInstance();
        joy1 = new Joystick(1);
        joy2 = new Joystick(2);
        // camera = new AxisCamera("192.168.0.90");
    }
       
    public void runHopper(double x){
        time = x;
        textOutput.println(DriverStationLCD.Line.kUser1, 1, "Speed 1 "+ joy1.getAxis(Joystick.AxisType.kY));
        textOutput.println(DriverStationLCD.Line.kUser2, 1, "Speed 2 "+ joy2.getAxis(Joystick.AxisType.kY));
        textOutput.updateLCD();
    }
       
    public static RobotParts getInstance(){
        if(partInst == null) //if partInst doesnt exist make it!!
            partInst = new RobotParts();
        return partInst;
    }
}
