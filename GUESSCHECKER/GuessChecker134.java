import java.util.Scanner;

public class GuessChecker134 {
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
    } 
      else if (g1 == r2) {
      nearHitCount++;
    } else if (g1 == r3) {
      nearHitCount++;
    } else if (g1 == r4) {
      nearHitCount++;
    }

    if (g2 == r2) {
      hitCount++;
    } 
      else if (g2 == r1) {
      nearHitCount++;
    } else if (g2 == r3) {
      nearHitCount++;
    } else if (g2 == r4) {
      nearHitCount++;
    }

    if (g3 == r3) {
      hitCount++;
    } 
      else if (g3 == r1) {
      nearHitCount++;
    } else if (g3 == r2) {
      nearHitCount++;
    } else if (g3 == r4) {
      nearHitCount++;
    }

    if (g4 == r4) {
      hitCount++;
    } 
      else if (g4 == r1) {
      nearHitCount++;
    } else if (g4 == r2) {
      nearHitCount++;
    } else if (g4 == r3) {
      nearHitCount++;
    }

    System.out.println("Hits: " + hitCount);
    System.out.println("Near Hits: " + nearHitCount);

    sc.close();
  }

  public static boolean hasDupes(int num) {
    boolean d0, d1, d2, d3, d4, d5, d6, d7, d8, d9;
    d0 = d1 = d2 = d3 = d4 = d5 = d6 = d7 = d8 = d9 = false;

    while (num > 0) {
      int digit = num % 10;

      if (digit == 0) {
        if (d0) return true;
        d0 = true;
      } else if (digit == 1) { 
        if (d1) return true;
        d1 = true;
      } else if (digit == 2) {
        if (d2) return true;
        d2 = true;
      } else if (digit == 3) {
        if (d3) return true;
        d3 = true;
      } else if (digit == 4) {
        if (d4) return true;
        d4 = true;
      } else if (digit == 5) {
        if (d5) return true;
        d5 = true;
      } else if (digit == 6) {
        if (d6) return true;
        d6 = true;
      } else if (digit == 7) {
        if (d7) return true;
        d7 = true;
      } else if (digit == 8) {
        if (d8) return true;
        d8 = true;
      } else if (digit == 9) {
        if (d9) return true;
        d9 = true;
      }
      num /= 10;
    }
    return false;
  }

  public static int getRandomNumber() {
    int target = 0;
    do {
        target = (int) (Math.random() * 9000 + 1000);
    } while (hasDupes(target));
    
    return target;
  }

  public static int getGuess() {
    int userGuess = 0;
    boolean validGuess = false;

    while (!validGuess) {
      System.out.print("Guess a 4-digit number from 1000 to 9999 with no duplicate digits: ");
      if (sc.hasNextInt()) {
        userGuess = sc.nextInt();
        sc.nextLine();

        if (!hasDupes(userGuess) && (userGuess >= 1000 && userGuess <= 9999)) {
          validGuess = true;
        } else {
          if (userGuess < 1000 || userGuess > 9999) {
            System.out.println("Invalid input: Must be a 4-digit number (1000-9999).");
          } else if (hasDupes(userGuess)) {
            System.out.println("Invalid input: The number contains duplicate digits.");
          }
        }
      } else {
          System.out.println("Invalid input: Please enter a whole number.");
          sc.next();
      }
    }
    return userGuess;
  }
}