//Not tested yet
package org.firstinspires.ftc.teamcode;
public class MecDrive {
 private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    public void init(HardwareMap hwMap) {
      gamepad1.rumbleBlips(3);
      telemtry.AddData("Gamepad ID:",gamepad1.getID)
        frontLeftMotor = hwMap.get(DcMotor.class, "FL");
        frontRightMotor = hwMap.get(DcMotor.class, "FR");
        backLeftMotor = hwMap.get(DcMotor.class, "BL");
        backRightMotor = hwMap.get(DcMotor.class, "BR");

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
  public void loop(){
    double y = -gamepad1.left_stick_y; // Remember, this is reversed!
    double x = -gamepad1.left_stick_x; // Counteract imperfect strafing
    double rx = -gamepad1.right_stick_x; //This is reversed for our turning
    drive{x,y,rx};
 }
    public void drive(double y, double x, double rx){
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (-y + x + rx) / denominator;
        double backLeftPower = (-y - x + rx) / denominator;
        double frontRightPower = (y + x + rx) / denominator;
        double backRightPower = (y - x + rx) / denominator;

        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }
}

