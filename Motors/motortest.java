package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.hardware.DcMotor;
private DCMotor motor;
@TeleOp
public class motortest extends OpMode{
public void init(){
motor=hardwareMap.get(DcMotor.class,"motor");
}
public void loop(){
motor.setPower(1)
telemetry.addData("Motor Power:",motor.getPower);
}
}
