package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.OpMode.OpMode;
import com.qualcomm.robotcore.hardware.DCMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.OpMode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp
public class MecDrive extends OpMode{
 private double timer= new ElapsedTime;
 private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    private Servo grippers;
    public void init(HardwareMap hwMap) {
      gamepad1.rumbleBlips(3);
      telemetry.addData("Gamepad ID:",gamepad1.getID)
        grippers = hwMap.get(Servo.class,"grippers");
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
    drive{};
    WorkGrippers{};
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
   public void WorkGrippers(){
    
   }
}

