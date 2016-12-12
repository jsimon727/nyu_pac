import java.util.*;

public class PostfixCalculator {
  public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Type your infix expression: ");
    String expression = scanner.next();

    Converter converter = new Converter();
    String postFixExpression = converter.toPostFix(expression);

    System.out.println("Converted to postfix: " + postFixExpression.replaceAll("", " "));
    System.out.println("Answer is: " + calculate(postFixExpression));
  }

  private static Double calculate(String postFixExpression) {
    Double result = 0.0;
    Double operand1;
    Double operand2;
    Stack<String> stack = new Stack<String>();

    for (int i = 0; i < postFixExpression.length(); i++) {
      String[] elements = postFixExpression.split("");
      String element = elements[i];
      String[] operators = { "^", "*", "/", "+", "-" };

      if(!(Arrays.asList(operators).contains(element))) {
        stack.push(element);
      } else {
        operand1 = Double.valueOf("" + stack.pop());
        operand2 = Double.valueOf("" + stack.pop());

        switch (element) {
          case "+":
            stack.push(Double.toString(operand1 + operand2));
            break;
          case "-":
            stack.push(Double.toString(operand1 - operand2));
            break;
          case "*":
            stack.push(Double.toString(operand1 * operand2));
            break;
          case "/":
            stack.push(Double.toString(operand1 / operand2));
            break;
          case "^":
            stack.push(Double.toString(Math.pow(operand1, operand2)));
            break;

          default:
            System.out.println("Invalid operator!");
        }
      }

      result = Double.valueOf("" + stack.pop());

      return result;
    }
    return result;
  }
}
