package org.firstinspires.ftc.teamcode.Testing.Motors;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
public class SlideKitTest extends OpMode {
    private DcMotor slidekit;
    private Servo servo1;
    private double gripperstate;

    @Override
    public void init() {
        slidekit = hardwareMap.get(DcMotor.class, "slide");
        slidekit.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slidekit.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        servo1 = hardwareMap.get(Servo.class, "servo");
        servo1.setDirection(Servo.Direction.FORWARD);
        slidekit.setTargetPosition(100);
    }

    @Override
    public void loop() {
        //Grippers
        //  if (gamepad1.x){
        // servo1.setPosition(0.45);
        // gripperstate=0;

        //  if (gamepad1.b){
        // servo1.setPosition(0.97);
        //gripperstate=1;

        //Slide Kit
        if (gamepad1.a) {
            slidekit.setPower(-0.1);
            telemetry.addData("Slide Kit", "Backward");
        } else if (gamepad1.y) {
            slidekit.setPower(0.1);
            telemetry.addData("Slide Kit", "Forward");
        } else {
            slidekit.setPower(0);
            telemetry.addData("Slide Kit", "Off");
        }
        if (slidekit.getCurrentPosition() == slidekit.getTargetPosition()){
            slidekit.setPower(0);
            telemetry.addData("Target Position","Reached");
        }
        //Gripper State
        if (gripperstate == 1) {
            telemetry.addData("Position", "Open");
        } else {
            telemetry.addData("Position", "Closed");
        }
        telemetry.addData("Motor Position",slidekit.getCurrentPosition());

    }
}
