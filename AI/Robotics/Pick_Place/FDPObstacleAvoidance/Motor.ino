void motorSetup()
{
  pinMode(leftPin1, OUTPUT);
  pinMode(leftPin2, OUTPUT);
  pinMode(rightPin1, OUTPUT);
  pinMode(rightPin2, OUTPUT);
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

void disableEverything()
{
  digitalWrite(leftPin1, LOW);
  digitalWrite(leftPin2, LOW);
  digitalWrite(rightPin1, LOW);
  digitalWrite(rightPin2, LOW);
}

