import java.util.Scanner;

public class TestSmallInt {
  public static void main( String args[] ) {
    System.out.println("Select a number between 0 and " + SmallInt.MAXVALUE);
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();

    SmallInt smallInt  = new SmallInt(number);
    System.out.println("The number represented as a decimal: " + smallInt.getDec());
    System.out.println("The number represented as binary: " + smallInt.getBin());
    System.out.println("The number represented as hex: " + smallInt.getHex());
  }
}
