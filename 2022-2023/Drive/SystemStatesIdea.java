//EDIT PACKAGE NAME BELOW NOTHING ELSE
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp
public class DriveTestBot extends OpMode {
    private DcMotor frontLeftMotor;
    private double gripperState;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    private double y;
    private double x;
    private double rx;
    private Servo grippers;
    private Servo wrist;
    private double state;
    ElapsedTime MainTimer = new ElapsedTime();
    ElapsedTime CycleTimer = new ElapsedTime();
    ElapsedTime sleepTimer = new ElapsedTime();
    ElapsedTime pauseBetweenStates = new ElapsedTime();
    public void init() {
        gamepad1.rumbleBlips(3);
        telemetry.addData("Gamepad ID:",gamepad1.getGamepadId());
        MainTimer.reset();
        CycleTimer.reset();
	sleepTimer.reset();
	pauseBetweenStates.reset();
        grippers = hardwareMap.get(Servo.class,"grippers");
        wrist = hardwareMap.get(Servo.class,"wrist");
        frontLeftMotor = hardwareMap.get(DcMotor.class, "FL");
        frontRightMotor = hardwareMap.get(DcMotor.class, "FR");
        backLeftMotor = hardwareMap.get(DcMotor.class, "BL");
        backRightMotor = hardwareMap.get(DcMotor.class, "BR");

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void start(){
	wrist.setPosition(0.5);
}
    public void loop(){
        drive();
        checkState();
    }


    public void drive(){
	double y = -gamepad1.left_stick_y; // Remember, this is reversed!
        double x = gamepad1.left_stick_x; // Counteract imperfect strafing
        double rx = gamepad1.right_stick_x; //This is reversed for our turning
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
    public void checkState(){
	if (gamepad1.a){
	  if (pauseBetweenStates.seconds()>2){
	   if (state==0){
	   grippers.setPosition(0.97);
	   sleepTimer.reset();
	      if (sleepTimer.seconds()>1.2){
	       wrist.setPosition(0.25);
	       state=1;
	       pauseBetweenStates.reset();
	     }
          }
            if (state==1){
	      wrist.setPosition(0.5);
	      sleepTimer.reset();
	        if (sleepTimer.seconds()>1.2){
	          grippers.setPosition(0.45);
	          state=0;
		  pauseBetweenStates.reset();
	     }
	}
       }
    }
}
