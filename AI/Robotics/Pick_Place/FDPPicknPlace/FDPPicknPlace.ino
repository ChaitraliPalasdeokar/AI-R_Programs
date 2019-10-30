#include <PS2X_lib.h>
#include "PinDef.h"

PS2X Ps2x;

int ps2error, joyLX, joyLY, joyRX, joyRY, debounceFactor = 20;
int right, left;

void setup() {
  // put your setup code here, to run once:
  ps2Setup();
  motorSetup();
}

void loop() {
  // put your main code here, to run repeatedly:
  if(isConnected())
  {
    calculateJoystick();
    calculateVectors();
    drive(left, right); 
  }
  else
    disableEverything();
}
