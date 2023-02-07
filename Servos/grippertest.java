import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.hardwareMap;
public class grippertest extends OpMode{
    private Servo servo1;
    public void init() {
    servo1=hardwareMap.Get(Servo.class,"servo");
    servo.setDirection(Servo.Direction.FORWARD);
    }
    public void loop() {
        servo.setPosition(0);
    if (servo.getposition()==0){
        servo1.setPosition(1);
    }
    else if(servo.getposition()==1){
        servo1.setPosition(0);
    }
    else if(servo.getposition()==0.5){
        servo.setPosition(1);
}
telemetry.addData("Servo Position", servo.getposition());
}
}
