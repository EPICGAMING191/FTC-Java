import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
@TeleOp
public class ColorSensorIdea extends OpMode {
    private double red;
    private double green;
    private double blue;
    private ColorSensor color;
    @Override
    public void init() {
       color=hardwareMap.get(ColorSensor.class,"color");
    }

    @Override
    public void loop() {
        getColorRGB();
        telemetry.addData("Red:",red);
        telemetry.addData("Green:",green);
        telemetry.addData("Blue:",blue);

    }
    public void getColorRGB(){
        red=color.red();
        green=color.green();
        blue=color.blue();
    }
}
