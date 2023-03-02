import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class FlyWheelsTest extends OpMode {
    private DcMotor leftflywheel;
    private DcMotor rightflywheel;
    @Override
    public void init() {
        leftflywheel=hardwareMap.get(DcMotor.class,"leftfly");
        leftflywheel.setDirection(DcMotorSimple.Direction.FORWARD);
        leftflywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftflywheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightflywheel=hardwareMap.get(DcMotor.class,"rightfly");
        rightflywheel.setDirection(DcMotorSimple.Direction.FORWARD);
        rightflywheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {
    leftflywheel.setPower(-1);
    rightflywheel.setPower(1);
    }
