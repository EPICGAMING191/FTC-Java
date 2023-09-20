package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecDrive extends OpMode {
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;


    @Override
    public void init() {
        gamepad1.rumbleBlips(3);
        telemetry.addData("Gamepad ID:",gamepad1.getGamepadId());
        frontLeftMotor = hardwareMap.get(DcMotor.class, "FL");
        frontRightMotor = hardwareMap.get(DcMotor.class, "FR");
        backLeftMotor = hardwareMap.get(DcMotor.class, "BL");
        backRightMotor = hardwareMap.get(DcMotor.class, "BR");

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void loop(){
        double y = -gamepad1.left_stick_y; // Remember, this is reversed!
        double x = -gamepad1.left_stick_x; // Counteract imperfect strafing
        double rx = -gamepad1.right_stick_x; //This is reversed for our turning
        drive(y,x,rx);
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
