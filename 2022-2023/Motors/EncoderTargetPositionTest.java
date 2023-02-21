package org.firstinspires.ftc.teamcode.Testing.Motors;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class EncoderTargetPositionTest extends OpMode {
    private DcMotor motor;
    @Override
    public void init() {
        motor=hardwareMap.get(DcMotor.class,"motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop() {
    Spin();
    }
    public void Spin(){
        motor.setTargetPosition(200);
        if (motor.getCurrentPosition() >= motor.getTargetPosition()){
            motor.setPower(0);
            telemetry.addData("Target Position","Reached");
        }
        else {
           motor.setPower(0.1);
           telemetry.addData("Position:",motor.getCurrentPosition());
           telemetry.addData("Power:",motor.getPower());
        }
    }
}

