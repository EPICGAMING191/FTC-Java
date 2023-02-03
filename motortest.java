private DCMotor motor;
public class motortest extends OpMode{
public void init(){
motor=hardwareMap.get(DcMotor.class,"motor");
}
public void loop(){
telemetry.addData("Motor Power:",motor.getPower);
}
}
