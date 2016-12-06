public class Car {
  private char color;
  private int xCoordinate;
  private int yCoordinate;
  private boolean ignitionSwitch;

  Car() {
    setColor(assignColor());
    setX(randomizePosition());
    setY(randomizePosition());
    setIgnition(false);
  }

  private int randomizePosition() {
    return (int) (Math.random() * 20) + 1;
  }

  public String getColor() {
    String color = "";
    switch(Character.toString(this.color)) {
      case("R"):
        color = "Red";
        break;
      case("G"):
        color = "Green";
        break;
      case("B"):
        color = "Black";
        break;
      case("W"):
        color = "White";
        break;
      case("S"):
        color = "Silver";
        break;
    }
    return color;
  }

  public boolean getIgnition() {
    return this.ignitionSwitch;
  }

  public int getX() {
    return this.xCoordinate;
  }

  public int getY() {
    return this.yCoordinate;
  }

  private void setX(int xCoordinate) {
    this.xCoordinate = xCoordinate;
  }

  private void setY(int yCoordinate) {
    this.yCoordinate = yCoordinate;
  }

  private void setIgnition(boolean ignition) {
    this.ignitionSwitch = ignition;
  }

  private void setColor(char color) {
    this.color = color;
  }

  public void printState() {
    System.out.println("Car Information" +
        "\nColor: " + this.getColor() +
        "\nIgnition: " + (this.getIgnition() ? "On" : "Off") +
        "\nLocation: (" + this.getX() + ", " + this.getY() + ")");

    for(int y=1; y<=20; y++){
      for(int x=1; x<=20; x++){
        if(this.getX() == x && this.getY() == y) {
          System.out.print(this.color);
        } else {
          System.out.print("-");
        }
      }
      System.out.println();
    }
  }

  private char assignColor() {
    char colors[ ] = { 'R', 'G', 'B','W', 'S' };
    int randomColorIndex = (int) (Math.random() * colors.length - 1) + 1;
    return colors[randomColorIndex];
  }

  public void moveHorizontally(int positionInput) {
    if(this.ignitionSwitch) {
      if(((this.xCoordinate + positionInput) > 20) || ((this.xCoordinate + positionInput) < 1)) {
        System.out.println("This movement is out of bounds");
      } else {
        setX(this.xCoordinate + positionInput);
      }
    } else {
      System.out.println("The ignitition is off. Turn on before moving.");
    }
  }

  public void moveVertically(int positionInput) {
    if(this.ignitionSwitch) {
      if(((this.yCoordinate + positionInput) > 20) || ((this.yCoordinate + positionInput) < 1)) {
        System.out.println("This movement is out of bounds");
      } else {
        setY(this.yCoordinate + positionInput);
      }
    } else {
      System.out.println("The ignitition is off. Turn on before moving.");
    }
  }

  public void ignitionSwitch() {
    setIgnition(!ignitionSwitch);
  }
}
