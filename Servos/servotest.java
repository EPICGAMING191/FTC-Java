import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
private Servo servo;
Public class servotest extends OpMode(){
  public void init(){
servo = hardwareMap.get(Servo.class, "servo");
servo.setDirection(Servo.Direction.REVERSE);
servo.scaleRange(0.5, 1.0); 
  }
  public void loop(){
    If (servo.getPosition = 0){
    servo.setPosition(1);
    }
     If (servo.getPosition = 1){
    servo.setPosition(0);
    }
  }
}

