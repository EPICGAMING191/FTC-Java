package org.firstinspires.ftc.teamcode.Testing.Other_and_Telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class GamepadRumbleTest extends OpMode {
    @Override
    public void init() {
        telemetry.addData("Gamepad 1 ID",gamepad1.getGamepadId());
        gamepad1.rumble(5000);
        telemetry.addData("Gamepad 2 ID",gamepad2.getGamepadId());
        gamepad2.rumble(5000);

    }

    @Override
    public void loop() {
        check();
        gamepad1.rumble(5000);
        check();
        gamepad2.rumble(5000);
        check();
    }
    public void check(){
        if (gamepad1.isRumbling()){
            telemetry.addData("Gamepad 1","Rumbling");
            telemetry.addData("Gamepad 1 ID",gamepad1.getGamepadId());
        }
        if (gamepad2.isRumbling()){
            telemetry.addData("Gamepad 2","Rumbling");
            telemetry.addData("Gamepad 2 ID",gamepad2.getGamepadId());
        }
    }
}
