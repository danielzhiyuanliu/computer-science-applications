import java.util.Scanner;

public class GuessChecker135 {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int hitCount = 0;
    int nearHitCount = 0;

    int targetNumber = getRandomNumber();

    int r1 = targetNumber / 1000;
    int r2 = targetNumber / 100 % 10;
    int r3 = targetNumber / 10 % 10;
    int r4 = targetNumber % 10;

    int guess = getGuess();

    int g1 = guess / 1000;
    int g2 = guess / 100 % 10;
    int g3 = guess / 10 % 10;
    int g4 = guess % 10;

    if (g1 == r1) {
      hitCount++;
    } else if (g1 == r2 || g1 == r3 || g1 == r4) {
      nearHitCount++;
    }

    if (g2 == r2) {
      hitCount++;
    } else if (g2 == r1 || g2 == r3 || g2 == r4) {
      nearHitCount++;
    }

    if (g3 == r3) {
      hitCount++;
    } else if (g3 == r1 || g3 == r2 || g3 == r4) {
      nearHitCount++;
    }

    if (g4 == r4) {
      hitCount++;
    } else if (g4 == r1 || g4 == r2 || g4 == r3) {
      nearHitCount++;
    }

    System.out.println("\nHits: " + hitCount);
    System.out.println("Near Hits: " + nearHitCount);

    sc.close();
  }
  
  public static boolean hasDupes(int num) {
    boolean[] seen = new boolean[10];
    while (num > 0) {
      int digit = num % 10;
      if (seen[digit]) return true;
      seen[digit] = true;
      num /= 10;
    }
    return false;
  }

  public static int getRandomNumber() {
    int target = (int) (Math.random() * 9000 + 1000);
    while (hasDupes(target))
      target = (int) (Math.random() * 9000 + 1000);
    return target;
  }

  public static int getGuess() {
    int userGuess = 0;
    boolean validGuess = false;

    while (!validGuess) {
      System.out.print("Guess a 4-digit number from 1000 to 9999 with no duplicate digits: ");
      if (sc.hasNextInt()) {
        userGuess = sc.nextInt();
        if (userGuess >= 1000 && userGuess <= 9999 && !hasDupes(userGuess)) {
          validGuess = true;
        } else {
          System.out.println("Invalid guess. Must be a 4-digit number (1000-9999) with unique digits.");
        }
      } else {
        System.out.println("Invalid input. Please enter a number.");
        sc.next();
      }
    }
    return userGuess;
  }
}