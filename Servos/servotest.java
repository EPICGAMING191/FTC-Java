Public class servotest extends OpMode(){
servo = hardwareMap.get(Servo.class, "servo");
servo.setDirection(Servo.Direction.REVERSE);
servo.scaleRange(0.5, 1.0); 
}
