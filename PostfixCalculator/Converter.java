import java.util.*;

public class Converter {
  private String expression;
  private String output = "";
  Stack<String> stack = new Stack<String>();
  private HashMap<String, Integer> operatorMap;
  final String[] operators = { "^", "*", "/", "+", "-" };

  Converter() {
    setOperators();
  }

  public String toPostFix(String expression) {
    String topOfStack;
    String topOfStackOperator;

    String[] expressionArray = expression.trim().split("");
    for(int i=0; i < expressionArray.length; i++) {
      String element = expressionArray[i];

      if(isOperator(element)) {
        while(!stack.empty() && hasHigherPrecedence(stack.peek(), element)) {
          output += stack.pop();
        }
          stack.push(element);
      }
      else if(element.equals("(")) {
        stack.push(element);
      }
      else if(element.equals(")")) {
        while(!stack.empty() && !stack.peek().equals("(")) {
          output += stack.pop();
        }
        if(!stack.empty()) {
          stack.pop();
        }
      }
      else {
        output += element;
      }
    }

    return output.replaceAll("[()]","");
  }

  private boolean hasHigherPrecedence(String topOfStackElement, String element)  {
    if(topOfStackElement.equals("(") || topOfStackElement.equals(")") || element.equals("(") || topOfStackElement.equals(")")) {
      return true;
    }
    else {
      return operatorMap.get(topOfStackElement) > operatorMap.get(element);
    }
  }

  private boolean isOperator(String element) {
    return Arrays.asList(operators).contains(element);
  }

  private void setOperators() {
    operatorMap = new HashMap<String, Integer>();
    operatorMap.put("^", 1);
    operatorMap.put("*", 2);
    operatorMap.put("/", 2);
    operatorMap.put("+", 3);
    operatorMap.put("-", 3);
    this.operatorMap = operatorMap;
  }

  // public String pop() throws StackUnderflowException {
    // if(this.stack.empty()) {
      // throw new StackUnderflowException("There are no items in the Stack");
    // }
    // super();
  // }

  // public void push(String parameter) throws StackOverflowException {
    // if(this.stack.empty()) {
      // throw new StackOverflowException("The Stack is full and can no longer accept any more items");
    // }
    // super();
  // }
}
