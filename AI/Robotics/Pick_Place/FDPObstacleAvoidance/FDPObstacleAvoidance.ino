#include <NewPing.h>
#include "PinDef.h"

NewPing sonar(triggerPin, echoPin, maxDistance);


int right, left;

void setup() {
  // put your setup code here, to run once:
  motorSetup();
}

void loop() {
  // put your main code here, to run repeatedly:
  if(sonar.ping_cm() == 0 || sonar.ping_cm() > 30)
  {
    drive(-1, -1);
  }
  else
  {
    delay(1500);
    drive(0, -1);
  }
}
