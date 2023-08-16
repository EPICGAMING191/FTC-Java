import os
base="blank_class_"
index=0
index_2=0
ext=".java"
line01="package org.firstinspires.ftc.teamcode;"
line02="import com.qualcomm.robotcore.eventloop.opmode.Disabled;"
line03="import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;"
line04="import com.qualcomm.robotcore.eventloop.opmode.OpMode;"
line05="import com.qualcomm.robotcore.eventloop.opmode.TeleOp;"
line06="import com.qualcomm.robotcore.hardware.DcMotor;"
line07="import com.qualcomm.robotcore.hardware.DcMotorSimple;"
line08="import com.qualcomm.robotcore.util.ElapsedTime;"
line09="import java.text.SimpleDateFormat;"
line10="import java.util.Date;"
line11="public class BlankIterativeOpMode extends OpMode {"
line12="    @Override"
line13="    public void init() {"
line14="        telemetry.addData('Status', 'Initialized');"
line15="    }"
line16="    @Override"
line17="    public void init_loop() {"
line18="    }" 
line19="    @Override"
line20="    public void start() {"
line21="    }"
line22="    @Override"
line23="    public void loop() {"
line24="    }"
line25="   @Override"
line26="    public void stop() {"
line27="    }"
line28="  }"
lines=[line01,line02,line03,line04,line05,line06,line07,line08,line09,line10,line11,line12,line13,line14,line15,line16,line17,line18,line19,line20,line21,line22,line23,line24,line25,line26,line27,line28]
while os.path.exists((base+str(index)+ext)):
  index=int(index)+1
fname=base+str(index)+ext
with open(fname,"w+") as f:
  for x in range(len(lines)):
    f.write(lines[index_2])
    f.write("\n")
    index_2=index_2+1
  print(f"Generated program {fname}")
