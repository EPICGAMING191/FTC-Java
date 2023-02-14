package org.firstinspires.ftc.teamcode.Testing.Servos;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class GripperTest extends OpMode {
    private Servo servo1;
    private double positionvar;
    ElapsedTime servoTimer = new ElapsedTime();

    public void init() {
        servo1 = hardwareMap.get(Servo.class, "servo");
        servo1.setDirection(Servo.Direction.FORWARD);
    }

    public void start() {
        servo1.setPosition(0.35);
        servoTimer.reset();

    }

    public void loop() {
        telemetry.addData("Loop", "Running");
        if (servoTimer.seconds() > 3){
            changeServoPosition();
            switchpos();
            servoTimer.reset();
        }
        telemetry.addData("Servo Position", servo1.getPosition());
        telemetry.addData("Time:",servoTimer.seconds());
        telemetry.addData("Updated code","True");
    }
    public void changeServoPosition() {
        if (positionvar == 0.75) {
            servo1.setPosition(0.75);
        }
        if (positionvar == 0.35) {
            servo1.setPosition(0.35);

        }
    }
        public void switchpos() {
            if (positionvar == 0.35) {
                positionvar = 0.75;
            }


            if (positionvar == 0.75) {
                positionvar = 0.35;
            }
}
}


