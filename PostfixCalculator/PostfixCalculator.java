import java.util.*;

public class PostfixCalculator {
  ArrayStack<Double> stack = new ArrayStack<Double>();

  public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Type your infix expression: ");
    String expression = scanner.next();
    Converter converter = new Converter();
    String postFixExpression = converter.toPostFix(expression.toCharArray());

    PostfixCalculator calc = new PostfixCalculator();
    System.out.println("Converted to postfix: " + postFixExpression);
    System.out.println("Answer is: " + calc.calculate(postFixExpression));
  }

  private double calculate(String postFixExpression) {
    double result = 0.0;
    double operand1;
    double operand2;

    String[] elements = postFixExpression.split(" ");
    List<String> list = new ArrayList<String>(Arrays.asList(elements));
    list.removeAll(Arrays.asList("", null));

    for (int i = 0; i < list.size(); i++) {
      String element = list.get(i);
      String[] operators = { "^", "*", "/", "+", "-" };

      if(!(Arrays.asList(operators).contains(element))) {
        try {
          this.stack.push(Double.parseDouble(element));
        } catch(StackOverflowException e){
          System.err.println(e);
        }
      } else {
        operand2 = this.stack.top();
        stack.pop();
        operand1 = this.stack.top();
        stack.pop();

        switch (element) {
          case "+":
            result = operand1 + operand2;
            break;
          case "-":
            result = operand1 - operand2;
            break;
          case "*":
            result = operand1 * operand2;
            break;
          case "/":
            result = operand1 / operand2;
            break;
          case "^":
            result = Math.pow(operand1, operand2);
            break;

          default:
            System.out.println("Invalid operator!");
        }
        try {
          this.stack.push(result);
        } catch(StackOverflowException e){
          System.err.println(e);
        }
      }
    }
    this.stack.pop();
    return result;
  }
}
