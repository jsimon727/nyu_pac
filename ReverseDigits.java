import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ReverseDigits {
  public static void main( String args[] ) {
    // System.out.println(reverseDigits("4321"));
    System.out.println("Enter your number: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    // int input = scanner.nextInt();
    System.out.println("The number reversed is " + reverseDigits(input));
  }

  public static String reverseDigits(String inputString) {
    int lengthOfNumber = inputString.length();
    int inputNum = Integer.parseInt(inputString);

    if(lengthOfNumber == 1) {
      return inputString;
    } else {
      int leadingNum = inputNum / (int) Math.pow(10, lengthOfNumber - 1);
      int trailingNums = inputNum % (int) Math.pow(10, lengthOfNumber - 1);

      return reverseDigits(Integer.toString(trailingNums)) + Integer.toString(leadingNum);
    }
  }
}

// 1234

// 1 * 1000
// 2 * 100
// 3 * 10
// 4 * 1

// firstDigit = 4
// secondDigit = 3
// thirdDigit = 2
// fourthDigit = 1

// 4 * 1000
// 3 * 100
// 2 * 10
// 1 * 1
