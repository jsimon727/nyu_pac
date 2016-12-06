class SmallInt {
  public static final int MAXVALUE = 1000;
  private int value;

  SmallInt(int value) {
    if(hasErrors(value)) {
      System.out.println("The input is not in range");
      setDec(0);
    } else {
      setDec(value);
    }
  }

  public String getDec() {
    String emptyString = "";
    return emptyString + value;
  }

  public void setDec(int value) {
    this.value = value;
  }

  //getBin() works by dividing the value by 2 until it is less than or equal to 0.
  //With each iteration it calculates the value modulo 2, which returns either 1 or 0.
  //These values are stored in an array, which is concatinated and returned at the end of the loop.
  //Example: getBin(45) -> 101101
  //45 % 2 = 1
  //45/2 = 22
  //22 % 2 = 0
  //22/2 = 11
  //11 % 2 = 1
  //etc.
  public String getBin() {
    if(value == 0) {
      return "0";
    } else {
      int binaryNums[] = new int[maxArraySize(2)];
      int counter = 0;
      String binaryString = "";
      int tempValue = value;

      while(tempValue > 0) {
        binaryNums[counter] = tempValue % 2;
        tempValue = tempValue / 2;
        counter++;
      }

      for(int i = counter - 1; i >= 0; i --) {
        binaryString = binaryString + Integer.toString(binaryNums[i]);
      }

      return binaryString;
    }
  }

  //getHex() works by dividing the value by 16 until it is less than or equal to 0.
  //With each iteration it calculates the value modulo 16, which returns a value ranging from 0 to 16.
  //These values are stored in an array. The method then checks if the values are included in three ranges:
  //0-9 => returns the value
  //10-15 => returns a letter A-F which corresponds with 10-15 in order
  //16 => returns 16
  //Example: getHex(45) -> 2D
  //45 % 16 = 13
  //45/16 = 2
  //2 % 16 = 2
  //2 is from the 0-9 range so 2 is returned
  //13 is from the 10-15 range so 13 corresponds with 'D' which is returned
  public String getHex() {
    if(value == 0) {
      return "0";
    } else {
      int hexNums[] = new int[maxArraySize(16)];
      int counter = 0;
      String hexString = "";
      int tempValue = value;

      while(tempValue > 0) {
        hexNums[counter] = tempValue % 16;
        tempValue = tempValue / 16;
        counter++;
      }

      for(int i = counter - 1; i >= 0; i--) {
        if(hexNums[i] == 16) {
          hexString = hexString + 16;
        } else if(hexNums[i] > 9) {
          hexString = hexString + (char) (hexNums[i] + 55);
        } else if(hexNums[i] < 10) {
          hexString = hexString + Integer.toString(hexNums[i]);
        }
        else {
          System.out.println("ERROR");
        }
      }

      return hexString;
    }
  }

  private int maxArraySize(int base) {
    int counter = 0;
    int value = MAXVALUE;

    while(value > 0) {
      value = value / base;
      counter++;
    }

    return counter;
  }

  private static boolean hasErrors(int value) {
    return (value < 0 || value > MAXVALUE);
  }
}
