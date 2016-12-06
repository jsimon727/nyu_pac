import java.util.Scanner;
import java.io.*;
public class GameOfLife {
  public static void main (String [] args) {
    final int M = 25;
    final int N = 75;
    Scanner consoleReader = new Scanner(System.in);
    System.out.println("Which file do you want to open?");
    String filename = consoleReader.next();
    File file = new File(filename);
    char [][] world = new char [M][N];
    Scanner fileReader = null;
    try
    {
      fileReader = new Scanner (file);
    }
    catch (Exception e)
    {
      System.out.print("file " + file + " does not exist");
      System.exit(0);
    }

    String userInput = "";
    int generationCount = 0;

    System.out.println("Generation: " + generationCount);
    for (int row =0; row < M; row++) {
      String words = fileReader.nextLine();
      System.out.print(words);

      for (int col =0; col < N; col++) {
        world[row] = words.toCharArray();
      }
      System.out.println();
    }

    Scanner scanner = new Scanner(System.in);

    while(!userInput.equals("q")) {
      System.out.println("Would you like to proceed? Press any key and enter to continue or 'q' to quit");
      userInput = scanner.next();

      if(worldEmpty(world)) {
        System.out.println("World is dead");
        System.exit(0);
      }
      else {
        char [][] nextGenerationWorld = new char [M][N];
        for(int i = 0; i < world.length; i++) {
          for(int j = 0; j < world[i].length; j++) {
            int numOfNeighbors = findNumberOfNeighbors(world, i, j);
            if(numOfNeighbors > 3 || numOfNeighbors < 2) {
              nextGenerationWorld[i][j] = '.';
            }
            else if(numOfNeighbors == 3) {
              nextGenerationWorld[i][j] = 'X';
            }
            else if(numOfNeighbors == 2) {
              nextGenerationWorld[i][j] = world[i][j];
            }
            else {
              nextGenerationWorld[i][j] = '.';
            }
          }
        }

        generationCount ++;
        System.out.println("Generation: " + generationCount);
        for (int a =0; a < M; a++) {
          for (int b =0; b < N;b++) {
            System.out.print(nextGenerationWorld[a][b]);
            world[a][b] = nextGenerationWorld[a][b];
          }
          System.out.println();
        }
      }
    }
  }


  private static boolean worldEmpty(char [][] world) {
    for(int i = 0; i < world.length; i++) {
      for(int j = 0; j < world[i].length; j++) {
        if(world[i][j] == 'X'){
          return false;
        }
      }
    }
    return true;
  }


  private static int findNumberOfNeighbors(char [][] world, int xCoord, int yCoord) {
    int neighbors = 0;

    try {
      if(world[xCoord - 1][yCoord + 1] == 'X') {
        neighbors++;
      }

      if(world[xCoord][yCoord + 1] == 'X') {
        neighbors++;
      }

      if(world[xCoord + 1][yCoord + 1] == 'X') {
        neighbors++;
      }

      if(world[xCoord - 1][yCoord] == 'X') {
        neighbors++;
      }

      if(world[xCoord + 1][yCoord] == 'X') {
        neighbors++;
      }

      if(world[xCoord - 1][yCoord - 1] == 'X') {
        neighbors++;
      }

      if(world[xCoord][yCoord - 1] == 'X') {
        neighbors++;
      }

      if(world[xCoord + 1][yCoord - 1] == 'X') {
        neighbors++;
      }
    }
    catch(ArrayIndexOutOfBoundsException exception) { }

    return neighbors;
  }
}
