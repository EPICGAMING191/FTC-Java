import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name="Basic Autonomous", group="Autonomous")
public class BasicAutonomous extends LinearOpMode {

    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() {
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        // Drive forward for 1 second
        leftMotor.setPower(1.0);
        rightMotor.setPower(1.0);
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 1.0) {
            telemetry.addData("Status", "Driving forward");
            telemetry.update();
        }

        // Turn left for 90 degrees
        leftMotor.setPower(-1.0);
        rightMotor.setPower(1.0);
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 0.5) {
            telemetry.addData("Status", "Turning left");
            telemetry.update();
        }

        // Drive forward for 2 seconds
        leftMotor.setPower(1.0);
        rightMotor.setPower(1.0);
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 2.0) {
            telemetry.addData("Status", "Driving forward");
            telemetry.update();
        }

        // Stop driving
        leftMotor.setPower(0.0);
        rightMotor.setPower(0.0);
        telemetry.addData("Status", "Finished");
        telemetry.update();
    }
}
