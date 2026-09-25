package Lektion2;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random rand = new Random();

        int secret = rand.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        do{
            System.out.print("Gissa ett nummer: ");
            guess = scanner.nextInt();
            attempts++;
            if(guess < secret){
                System.out.println("För lågt!");
            } else if (guess > secret) {
                System.out.println("För högt!");
            }
        } while(guess != secret);

        System.out.println("Rätt! På " +attempts +" gissningar.");

    }
}
