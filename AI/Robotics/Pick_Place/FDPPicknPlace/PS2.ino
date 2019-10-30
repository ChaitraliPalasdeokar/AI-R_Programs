void ps2Setup()
{
  ps2error = Ps2x.config_gamepad(clock_, command, attention, data, false, false);  
}

void gamePadRead()
{
  Ps2x.read_gamepad(false, false);
  while(Ps2x.Button(PSB_L1))
  {
    moveMotor(1);
    Ps2x.read_gamepad(false, false);
  }
  while(Ps2x.Button(PSB_R1))
  {
    moveMotor(-1);
    Ps2x.read_gamepad(false, false);
  }
  while(Ps2x.Button(PSB_L2))
  {
    gripperMotor(1);
    Ps2x.read_gamepad(false, false);
  }
  while(Ps2x.Button(PSB_R2))
  {
    gripperMotor(-1);
    Ps2x.read_gamepad(false, false);
  }
  
  moveMotor(0);
  gripperMotor(0);
}

bool isConnected()
{
  gamePadRead();
  if(Ps2x.Analog(PSS_LX) == 255 && Ps2x.Analog(PSS_LY) == 255 && Ps2x.Analog(PSS_RY) == 255 && Ps2x.Analog(PSS_RX) == 255)
    return false;
  else
    return true;
}

void calculateJoystick()
{
  gamePadRead();
  joyLX = Ps2x.Analog(PSS_LX);
  joyRX = Ps2x.Analog(PSS_RX);
  joyRY = Ps2x.Analog(PSS_RY);
  joyLY = Ps2x.Analog(PSS_LY);
}

void calculateVectors()
{
  joyLY -= 128;
  joyRX -= 128;
  joyLY = ignoreZeroError(joyLY);
  joyRX = ignoreZeroError(joyRX);
  left = 0;
  right = 0;
  if(joyLY < 0)
  {
    left++;
    right++;
  }
  else if(joyLY > 0)
  {
    left--;
    right--;
  }
  else
  {
    left = 0;
    right = 0;
  }
  if(joyLY != 0 && joyRX < 0)
  {
    right++;
  }
  else if(joyLY != 0 && joyRX > 0)
  {
    left++;
  }
  else if( joyRX < 0)
  {
    right--;
    left++;
  }
  else if( joyRX > 0)
  {
    left--;
    right++;
  }
}

int ignoreZeroError(int val)
{
  if(abs(val)<debounceFactor)
    return 0;
  else
    return val;
}

