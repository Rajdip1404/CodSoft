import java.util.*;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        int maxAttempts = 10;
        int totalScore = 0;
        boolean again;

        System.out.println("Welcome to the Number Guessing Game!");
        do{
            int target = rn.nextInt(100)+1;
            int attempts = 0;
            boolean isGuessed = false;
            System.out.println("Try to guess the number between 1 to 100");
            while(attempts < maxAttempts && !isGuessed){
                System.out.println("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if(userGuess==target){
                    System.out.println("Congratulations! You've guessed the correct number.");
                    isGuessed = true;
                    totalScore += (maxAttempts - attempts + 1);
                } else if (userGuess < target){
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if (!isGuessed) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + target);
            }

            System.out.println("Your current score: " + totalScore);
            System.out.print("Do you want to play another round? (yes/no): ");
            again = sc.next().equalsIgnoreCase("yes");
        } while (again);

        System.out.println("Thank you for playing!!");
        sc.close();
    }
}
