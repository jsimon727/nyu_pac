import java.util.Scanner;

public class TestCar {
  public static void main( String args[] ) {
    Car[] cars = new Car[10];

    for(int i = 0; i < cars.length; i++) {
      cars[i] = new Car();
    }

    String userInput = "";

    while(!userInput.equals("Q")) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter a number between 1­10 to select a car:");
      int carNumber = scanner.nextInt();
      int carIndex = carNumber - 1;

      if(carNumber > 10 || carNumber < 1) {
        System.out.println("Sorry, this is not a valid selection.");
        break;
      }

      System.out.println("What would you like to do?\n" +
          "1: turn the ignition on/off\n" +
          "2: change the position of car\n" +
          "Q: quit this program"
          );

      userInput = scanner.next();
      System.out.println("Input: " + userInput);

      switch(userInput) {
        case("1"):
          cars[carIndex].ignitionSwitch();
          cars[carIndex].printState();
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
                cars[carIndex].moveHorizontally(positionInput);
                break;
              case("V"):
                cars[carIndex].moveVertically(positionInput);
                break;
            }
            cars[carIndex].printState();
            break;
          } else {
            //Not sure where I am supposed to take the user after
            //the invalid input explanation, so bringing them to the main menu.
            System.out.println("This is not valid input");
            break;
          }
        case("Q"):
          cars[carIndex].printState();
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
  
}
