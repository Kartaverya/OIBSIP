import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        boolean playAgain = true;

        while(playAgain){
            int number = rand.nextInt(100)+1;
            int attempts=0;
            int maxAttempts=7;
            boolean guessed = false;

            System.out.println("Guess the number between 1 and 100");
            System.out.println("You have " +maxAttempts+" attempts");

            while(attempts<maxAttempts){
                System.out.println("Enter your guess:");
                int guess=sc.nextInt();
                attempts++;

                if(guess==number){
                    System.out.println("Correct! you guessed it in "+attempts+" attempts");
                    guessed=true;
                    break;
                }
                else if(guess<number){
                    System.out.println("Too Low!");
                }
                else{
                    System.out.println("Too High!!");
                }
            }
            if(!guessed){
                System.out.println("Out of Attempts the number was:"+number);
            }

            int score = guessed?(maxAttempts-attempts+1)*10:0;
            System.out.println("Your score is:"+score);

            System.out.println("Want to play again? Enter yes/no:");
            String choice = sc.next().toLowerCase();
            playAgain=choice.equals("yes");
        }
    }
}