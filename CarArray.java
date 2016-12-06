import java.util.Scanner;

public class CarArray {
  public static void main( String args[] ) {
    boolean[] ignitions = new boolean[10];
    int[] xCoordinates = new int[10];
    int[] yCoordinates = new int[10];
    char[] colorChars = new char[10];

    randomizePositions(xCoordinates);
    randomizePositions(yCoordinates);
    assignColors(colorChars);

    String userInput = "";

    while(!userInput.equals("Q")) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Which car would you like to use? (Choose from 1-10)");
      int carNumber = scanner.nextInt();
      int carIndex = carNumber - 1;

      System.out.println("What would you like to do?\n" +
          "1: turn the ignition on/off\n" +
          "2: change the position of car\n" +
          "Q: quit this program"
          );

      userInput = scanner.next();
      System.out.println("Input: " + userInput);

      switch(userInput) {
        case("1"):
          ignitions[carIndex] = ignitionSwitch(ignitions[carIndex]);
          reportState(xCoordinates, yCoordinates, colorChars, ignitions, carNumber);
          break;
        case("2"):
          System.out.println("In which direction do you want to move the car" +
          "\nH: Horizontal" +
          "\nV: Vertical");

          String directionInput = scanner.next();

          if(directionInput.equals("H") || directionInput.equals("V")) {
            System.out.println("Direction: " + directionInput);
            System.out.println("Enter a movement distance: ");
            int positionInput = scanner.nextInt();

              switch(directionInput) {
                case("H"):
                  int xCoordinate = xCoordinates[carIndex];
                  xCoordinates[carIndex] = moveHorizontally(positionInput, xCoordinate, ignitions[carIndex]);
                  break;
                case("V"):
                  int yCoordinate = yCoordinates[carIndex];
                  yCoordinates[carIndex] = moveVertically(positionInput, yCoordinate, ignitions[carIndex]);
                  break;
              }
              reportState(xCoordinates, yCoordinates, colorChars, ignitions, carNumber);
              break;
          } else {
            //Not sure where I am supposed to take the user after
            //the invalid input explanation, so bringing them to the main menu.
            System.out.println("This is not valid input");
            break;
          }
        case("Q"):
          reportState(xCoordinates, yCoordinates, colorChars, ignitions, carNumber);
          System.exit(0);
          break;
        default:
          //Not sure where I am supposed to take the user after
          //the invalid input explanation, so bringing them to the main menu.
          System.out.println("This is not valid input");
          break;
      }
    }
  }

  public static void randomizePositions(int coordinates[]) {
    for(int i=0; i < coordinates.length; i++) {
      coordinates[i] = (int) (Math.random() * 20) + 1;
    }
  }

  public static void assignColors(char colorChars[]) {
    char colors[ ] = { 'R', 'G', 'B','W', 'S' };

    for(int i=0; i < colorChars.length; i++) {
      int randomColorIndex = (int) (Math.random() * colors.length - 1) + 1;
      colorChars[i] = colors[randomColorIndex];
    }
  }

  public static boolean ignitionSwitch(boolean ignitionSwitch) {
    return !ignitionSwitch;
  }

  public static int moveHorizontally(int positionInput, int xCoordinate, boolean ignition) {
    if(ignition) {
      if(((xCoordinate + positionInput) > 20) || ((xCoordinate + positionInput) < 1)) {
        System.out.println("This movement is out of bounds");
        return xCoordinate;
      } else {
        return (xCoordinate + positionInput);
      }
    } else {
      System.out.println("The ignitition is off. Turn on before moving.");
      return xCoordinate;
    }
  }

  public static int moveVertically(int positionInput, int yCoordinate, boolean ignition) {
    if(ignition) {
      if(((yCoordinate + positionInput) > 20) || ((yCoordinate + positionInput) < 1)) {
        System.out.println("This movement is out of bounds");
        return yCoordinate;
      } else {
        return (yCoordinate + positionInput);
      }
    } else {
      System.out.println("The ignitition is off. Turn on before moving.");
      return yCoordinate;
    }
  }

  public static void reportState(int xCoordinates[], int yCoordinates[], char colorChars[], boolean ignitions[], int carNumber) {
    int carIndex = carNumber - 1;

    String color = "";
    switch(Character.toString(colorChars[carIndex])) {
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

    System.out.println("Car Information" +
        "\nCar #: " +  carNumber +
        "\nColor: " + color +
        "\nIgnition: " + (ignitions[carIndex] ? "On" : "Off") +
        "\nLocation: (" + xCoordinates[carIndex] + ", " + yCoordinates[carIndex] + ")");

    for(int y=1; y<=20; y++){
      for(int x=1; x<=20; x++){
        if(xCoordinates[carIndex] == x && yCoordinates[carIndex] == y) {
          System.out.print(colorChars[carIndex]);
        } else {
          System.out.print("-");
        }
      }
      System.out.println();
    }
  }
}
