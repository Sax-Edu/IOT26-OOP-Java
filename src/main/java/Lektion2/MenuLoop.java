package Lektion2;

import java.util.Random;
import java.util.Scanner;

public class MenuLoop {

    public static void main(String[] args) {
        boolean running = true;
        Scanner scan = new Scanner(System.in);
        while(running){
            System.out.println("1. HÄLSA");
            System.out.println("2. FIZZBUZZ");
            System.out.println("3. GISSA NUMMER");
            System.out.println("4. AVSLUTA");
            System.out.print("Välj 1-4: ");
            String choice = scan.nextLine();
            switch (choice){

                case "1" ->{
                    System.out.println("Vad heter du?");
                    String name = scan.nextLine();
                    System.out.println("Hej " +name +"!");
                }
                case "2" ->{
                    for (int i = 1; i <= 100; i++) {
                        if (i % 15 == 0) {
                            System.out.println("FizzBuzz");
                        } else if (i % 5 == 0) {
                            System.out.println("Buzz");
                        } else if (i % 3 == 0) {
                            System.out.println("Fizz");
                        } else System.out.println(i);
                    }
                }
                case "3" ->{
                    Random rand = new Random();

                    int secret = rand.nextInt(100) + 1;
                    int guess;
                    int attempts = 0;

                    do{
                        System.out.print("Gissa ett nummer: ");
                        guess = scan.nextInt();
                        attempts++;
                        if(guess < secret){
                            System.out.println("För lågt!");
                        } else if (guess > secret) {
                            System.out.println("För högt!");
                        }
                    } while(guess != secret);

                    scan.nextLine();
                    System.out.println("Rätt! På " +attempts +" gissningar.");
                }
                case "4" -> running = false;
                default -> System.out.println("ogiltigt val");
            }
        }



    }
}
