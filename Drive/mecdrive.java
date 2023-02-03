//Work IN PROGRESS DO NOT USE IT WILL GIVE ERRORS
package org.firstinspires.ftc.teamcode;
public class MecDrive extends OpMode{
  public void init(){
  }
  public void loop(){
    double y = -gamepad1.left_stick_y; // Remember, this is reversed!
    double x = -gamepad1.left_stick_x; // Counteract imperfect strafing
    double rx = -gamepad1.right_stick_x; //This is reversed for our turning

  }
}
