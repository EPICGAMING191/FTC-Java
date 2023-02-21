package org.firstinspires.ftc.teamcode.Testing.Other_and_Telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp
public class Timer extends OpMode {
    ElapsedTime Timer = new ElapsedTime();
    @Override
    public void init() {
        Timer.reset();
    }

    @Override
    public void loop() {
    telemetry.addData("Time:",Timer.seconds());
    }
}
