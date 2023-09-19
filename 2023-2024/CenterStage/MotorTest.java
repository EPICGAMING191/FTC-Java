package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="MotorTestNPC")
public class MotorTest extends OpMode{
    private DcMotor motor;
        public void init(){
            motor=hardwareMap.get(DcMotor.class,"motor");
        }
        public void loop(){
            motor.setPower(1);
    }
}
