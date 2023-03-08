import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class UltimateGoalBotDrive extends OpMode {
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    private DCMotor leftfly;
    private DCMotor rightfly;

    @Override
    public void init() {
        gamepad1.rumbleBlips(1);
        frontLeftMotor = hardwareMap.get(DcMotor.class, "FL");
        frontRightMotor = hardwareMap.get(DcMotor.class, "FR");
        backLeftMotor = hardwareMap.get(DcMotor.class, "BL");
        backRightMotor = hardwareMap.get(DcMotor.class, "BR");
        rightfly = hardwareMap.get(DCMotor.class, "rightfly");
        leftfly = hardwareMap.get(DCMotor.class, "leftfly");

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftfly.setDirection(DcMotorSimple.Direction.FORWARD);
        rightfly.setDirection(DcMotorSimple.Direction.FORWARD);
    }
    public void start(){
        gamepad1.rumbleBlips(2);
  }
    

   @Override

  public void loop() {
  drive();
  runFlyWheels()
  }

  public void drive(){
      double y = -gamepad1.left_stick_y; // Remember, this is reversed!
      double x = gamepad1.left_stick_x; // Counteract imperfect strafing
      double rx = -gamepad1.right_stick_x; //This is reversed for our turning
      double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

      double frontLeftPower = (-y + x + rx) / denominator;
        double backLeftPower = (-y - x + rx) / denominator;
        double frontRightPower = (y + x + rx) / denominator;
        double backRightPower = (y - x + rx) / denominator;

        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }
    public void runFlyWheels(){
        leftfly.setPower(-1)
        rightfly.setPower(-1)
    }
}

