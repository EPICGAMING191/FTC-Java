package org.firstinspires.ftc.teamcode.Testing.Servos;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
public class GarbageBotGripperTest extends OpMode {
    private Servo servo1;
    public void init() {
        servo1 = hardwareMap.get(Servo.class, "servo");
        servo1.setDirection(Servo.Direction.FORWARD);
    }

    @Override
    public void loop() {
        if (gamepad1.x){
        servo1.setPosition(0.45);
        telemetry.addData("Position","Open");
        }
        if (gamepad1.b){
            servo1.setPosition(0.97);
            telemetry.addData("Position","Closed");
        }
    }
}
