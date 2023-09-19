package org.firstinspires.ftc.teamcode.Testing;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class NewMotors extends OpMode{
    private DcMotor motor;
    public void init(){
        motor=hardwareMap.get(DcMotor.class,"motor");
        gamepad1.rumbleBlips(3);
        telemetry.addData("Gamepad ID:",gamepad1.getGamepadId());
    }
    public void loop(){
        telemetry.addData("Gamepad ID:",gamepad1.getGamepadId());
        telemetry.addData("Motor Power:",motor.getPower());
        motor.setPower(gamepad1.left_stick_y);
    }
}