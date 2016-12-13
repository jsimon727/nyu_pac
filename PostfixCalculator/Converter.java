import java.util.*;

public class Converter {
  private String expression;
  private String output = "";
  boolean operatorElement = true;
  ArrayStack<String> stack = new ArrayStack<String>();
  private HashMap<String, Integer> operatorMap;
  final String[] operators = { "^", "*", "/", "+", "-" };

  Converter() {
    setOperators();
  }

  public String toPostFix(char[] expression) {
    List<String> expressionList = ParserHelper.parse(expression);
    for(int i=0; i < expressionList.size(); i++) {
      String element = expressionList.get(i);

      if(isOperator(element)) {
        if(operatorElement) {
          try {
            stack.push(element);
          } catch(StackOverflowException e){
            System.err.println(e);
          }
        }
        else {
          while(!stack.isEmpty() && !stack.top().equals("(") && hasPrecedence(stack.top(), element)) {
            String op = stack.top();
            stack.pop();
            output += " " + op;
          }
          try {
            stack.push(element);
          } catch(StackOverflowException e){
            System.err.println(e);
          }
        }
        operatorElement = true;
      }
      else if(element.equals("(")) {
        try {
          stack.push(element);
        } catch(StackOverflowException e){
          System.err.println(e);
        }
      }
      else if(element.equals(")")) {
        String op;
        while(!(op = stack.top()).equals("(")) {
          output += " " + op;
          stack.pop();
        }
      }
      else {
        output += " " + element;
        operatorElement = false;
      }
    }

    while(!stack.isEmpty()) {
      String op = stack.top();
      output += " " + op;
      stack.pop();
    }
    return output.replaceAll("[()]","");
  }

  private boolean hasPrecedence(String topOfStackElement, String element)  {
    return operatorMap.get(topOfStackElement) >= operatorMap.get(element);
  }

  private boolean isOperator(String element) {
    return Arrays.asList(operators).contains(element);
  }

  private void setOperators() {
    operatorMap = new HashMap<String, Integer>();
    operatorMap.put("^", 3);
    operatorMap.put("*", 2);
    operatorMap.put("/", 2);
    operatorMap.put("+", 1);
    operatorMap.put("-", 1);
    this.operatorMap = operatorMap;
  }
}
