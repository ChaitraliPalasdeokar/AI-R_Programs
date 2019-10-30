void motorSetup()
{
  pinMode(leftPin1, OUTPUT);
  pinMode(leftPin2, OUTPUT);
  pinMode(rightPin1, OUTPUT);
  pinMode(rightPin2, OUTPUT);
  pinMode(gripperPin1, OUTPUT);
  pinMode(gripperPin2, OUTPUT);
  pinMode(movePin1, OUTPUT);
  pinMode(movePin2, OUTPUT);
}

void drive(int left, int right)
{
  leftMotor(left);
  rightMotor(right);
}

void leftMotor(int val)
{
  if(val == 1)
  {
    digitalWrite(leftPin1, HIGH);
    digitalWrite(leftPin2, LOW);
  }
  else if (val == -1)
  {
    digitalWrite(leftPin1, LOW);
    digitalWrite(leftPin2, HIGH);
  }
  else
  {
    digitalWrite(leftPin1, LOW);
    digitalWrite(leftPin2, LOW);
  }
}

void rightMotor(int val)
{
  if(val == 1)
  {
    digitalWrite(rightPin1, HIGH);
    digitalWrite(rightPin2, LOW);
  }
  else if (val == -1)
  {
    digitalWrite(rightPin1, LOW);
    digitalWrite(rightPin2, HIGH);
  }
  else
  {
    digitalWrite(rightPin1, LOW);
    digitalWrite(rightPin2, LOW);
  }
}

void moveMotor(int val)
{
  if(val == 1)
  {
    digitalWrite(movePin1, HIGH);
    digitalWrite(movePin2, LOW);
  }
  else if (val == -1)
  {
    digitalWrite(movePin1, LOW);
    digitalWrite(movePin2, HIGH);
  }
  else
  {
    digitalWrite(movePin1, LOW);
    digitalWrite(movePin2, LOW);
  }
}

void gripperMotor(int val)
{
  if(val == 1)
  {
    digitalWrite(gripperPin1, HIGH);
    digitalWrite(gripperPin2, LOW);
  }
  else if (val == -1)
  {
    digitalWrite(gripperPin1, LOW);
    digitalWrite(gripperPin2, HIGH);
  }
  else
  {
    digitalWrite(gripperPin1, LOW);
    digitalWrite(gripperPin2, LOW);
  }
}

void disableEverything()
{
  digitalWrite(leftPin1, LOW);
  digitalWrite(leftPin2, LOW);
  digitalWrite(rightPin1, LOW);
  digitalWrite(rightPin2, LOW);
  digitalWrite(gripperPin1, LOW);
  digitalWrite(gripperPin2, LOW);
  digitalWrite(movePin1, LOW);
  digitalWrite(movePin2, LOW);
}

