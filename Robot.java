package frc.robot;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.TimedRobot;
public class Robot extends TimedRobot {
  private Movement rob = new Movement();
  private PS4Controller p4 = new PS4Controller(1);
  private double y1 = 0;    
  private double x1 = 0; 
  private double deadzone1=.1;
  private double deadzone2=.1;
  private double aceleration=.25;
  @Override
  public void robotInit() {
    y1=0;
    x1=0;
    System.out.println(x1);
  }
  @Override
  public void teleopInit()
  {
    x1=0;
    y1=0;
  }
  @Override
  public void teleopPeriodic() {
    x1=0;
    y1=0;
    y1= p4.getLeftY();  
    x1= p4.getRightX(); 
    if(Math.abs(y1)<deadzone1)
    {
     y1=0;
    }
    if(Math.abs(x1)<deadzone2)
    {
     x1=0;
    }
    if(Math.abs(y1)>Math.abs(x1))
    {
    rob.rightForward(y1);
    rob.leftForward(y1);
    System.out.println("YVelocity: "+y1);
    }
    if(x1==0&&y1==0)
    {
      rob.leftForward(0);
      rob.rightForward(0);
    }
    if(Math.abs(x1)>Math.abs(y1))
    {
    rob.rightForward(x1);
    System.out.println("XVelocity: "+x1);
    x1=x1*-1;
    rob.leftForward(x1);
    }
    y1=0;
    x1=0;
   if(p4.getR2ButtonPressed()==true)
   {
    aceleration=rob.decrease();
   }
   if(p4.getL2ButtonPressed()==true)
   {
    aceleration=rob.increase();
   }
   if(p4.getL1ButtonPressed()==true)
   {
    rob.estop();
   }

   System.out.println("Aceleration: "+aceleration);

  }

  @Override
  public void disabledInit() {
    rob.rightForward(0);
    rob.leftForward(0);
  }

}
