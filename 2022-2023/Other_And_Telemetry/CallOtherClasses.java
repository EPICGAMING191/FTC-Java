package org.firstinspires.ftc.teamcode.Testing.Other_and_Telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Testing.Motors.EncoderTargetPositionTest;


@TeleOp
public class CallOtherClasses extends OpMode {
    @Override
    public void init() {
    EncoderTargetPositionTest enco;
    enco=new EncoderTargetPositionTest();
    enco.Spin();
    }

    @Override
    public void loop() {
        EncoderTargetPositionTest enco;
        enco=new EncoderTargetPositionTest();
        enco.Spin();
    }
}
