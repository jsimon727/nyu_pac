import java.util.Scanner;
public class MilitaryTime {
  public static final int SECONDS_IN_A_MINUTE = 60;
  public static final int SECONDS_IN_AN_HOUR = 3600;

  public static void main( String args[] ) {
    System.out.println("Enter first time: ");
    Scanner scanner = new Scanner(System.in);
    int firstNumber = scanner.nextInt();

    System.out.println("Enter second time: ");
    int secondNumber = scanner.nextInt();

    System.out.println("These times subtracted: " + convertDifferenceToMilitaryTime(subtractTimes(firstNumber, secondNumber)));
  }

  public static int subtractTimes(int firstNumber, int secondNumber) {
    int firstNumberInSeconds = convertTimeToSeconds(firstNumber);
    int secondNumberInSeconds = convertTimeToSeconds(secondNumber);

    return (firstNumberInSeconds - secondNumberInSeconds);
  }

  public static int convertDifferenceToMilitaryTime(int numberToConvert) {
    int hours = numberToConvert / SECONDS_IN_AN_HOUR;
    int minutes = (numberToConvert - (hours * SECONDS_IN_AN_HOUR))/ SECONDS_IN_A_MINUTE;
    int seconds = (numberToConvert - (hours * SECONDS_IN_AN_HOUR)) - (minutes * SECONDS_IN_A_MINUTE);
    return ((hours * 10000) + (minutes * 100) + (seconds));
  }

  public static int convertTimeToSeconds(int numberToConvert) {
    int lengthOfNumber = Integer.toString(numberToConvert).length();
    int hours = numberToConvert/ 10000;
    int trailingNumbers = numberToConvert % 10000;
    int minutes = trailingNumbers / 100;
    int seconds = trailingNumbers % 100;

    int hoursInSeconds = hours * SECONDS_IN_AN_HOUR;
    int minutesInSeconds = minutes * SECONDS_IN_A_MINUTE;
    return (hoursInSeconds + minutesInSeconds + seconds);
  }
}
