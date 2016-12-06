import java.util.Scanner;

public class Calculator {
  public static boolean quit = false;
  public static double buffer = 0.0;
  public static boolean divisionError = false;

  public static void main( String args[] ) {

    while (!quit) {
      System.out.println("First input: ");
      Scanner scanner = new Scanner(System.in);
      String firstInput = scanner.next();

      if(checkForQuit(firstInput)) {
        buffer = firstInput.equals("c") ? 0.0 : Double.parseDouble(firstInput);

        while (!quit) {
          System.out.println("op: ");
          String op = scanner.next();

          if(op.equals("c")) {
            System.out.println("Answer: 0.0");
            break;
          }

          if(checkForQuit(op)) {
            System.out.println("Second input: ");
            String secondInput = scanner.next();

            if(secondInput.equals("c")) {
              System.out.println("Answer: 0.0");
              break;
            }

            if(checkForQuit(secondInput)) {
              double firstAnswer = performOperation(buffer, op, secondInput);
              buffer = firstAnswer;

              if(!divisionError) {
                System.out.println("Answer: " + firstAnswer);
              }

              System.out.println("op: ");
              String secondOp = scanner.next();

              if(secondOp.equals("c")) {
                System.out.println("Answer: 0.0");
                break;
              }

              if(checkForQuit(secondOp)) {
                System.out.println("More input: ");
                String moreInput = scanner.next();

                if(moreInput.equals("c")) {
                  System.out.println("Answer: 0.0");
                  break;
                }

                if(checkForQuit(moreInput)) {
                  double secondAnswer = performOperation(buffer, secondOp, moreInput);
                  if(!divisionError) {
                    System.out.println("Answer: " + secondAnswer);
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public static boolean checkForQuit(String userInput) {
    if(userInput.equals("x")) {
      System.exit(0);
      return false;
    }
    else {
      return true;
    }
  }

  public static double performOperation(double buffer, String op, String secondInput) {
    divisionError = false;
    if(op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*")) {
      double input = Double.parseDouble(secondInput);
      switch(op) {
        case "+":
          buffer = buffer + input;
          break;
        case "-":
          buffer = buffer - input;
          break;
        case "*":
          buffer = buffer * input;
          break;
        case "/":
          if(input == 0) {
            divisionError = true;
            System.out.println("Error: division by zero");
            break;
          } else {
            buffer = buffer / input;
            break;
          }
      }
    }
    else {
      System.out.println("Error: Unknown operator " + op);
    }
    return buffer;
  }
}
