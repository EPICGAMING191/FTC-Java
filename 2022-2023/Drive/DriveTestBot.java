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
    //private double timer= new ElapsedTime();
    private DcMotor frontLeftMotor;
    private double gripperState;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    private double y;
    private double x;
    private double rx;
    private Servo grippers;
    ElapsedTime Timer = new ElapsedTime();
    ElapsedTime CycleTimer = new ElapsedTime();
    public void init() {
        gamepad1.rumbleBlips(3);
        telemetry.addData("Gamepad ID:",gamepad1.getGamepadId());
        Timer.reset();
        CycleTimer.reset();
        grippers = hardwareMap.get(Servo.class,"grippers");
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
        frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }


    public void loop(){
        double y = -gamepad1.left_stick_y; // Remember, this is reversed!
        double x = -gamepad1.left_stick_x; // Counteract imperfect strafing
        double rx = -gamepad1.right_stick_x; //This is reversed for our turning
        drive();
        WorkGrippers();
        GetTime();
    }


    public void drive(){
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
        if (gamepad1.a){
            if (gripperState == 0){
                gripperState=1;
                ChangeState();
            }
            else {
                gripperState=0;
                ChangeState();
            }
        }
    }
    public void ChangeState(){
        if (gripperState==0){
            grippers.setPosition(0.45);
            telemetry.addData("Position","Open");
        }
        if (gripperState==0){
            grippers.setPosition(0.97);
            telemetry.addData("Position","Closed");
        }
    }
    public void GetTime(){
        telemetry.addData("Time:",Timer.seconds());
        telemetry.addData("Time since last delivery:",CycleTimer.seconds());
    }
}

