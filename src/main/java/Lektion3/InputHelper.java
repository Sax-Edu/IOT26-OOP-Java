package Lektion3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {

    public static int readInt(Scanner scanner, String prompt){
        while (true){
            System.out.println(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;

            } catch (InputMismatchException e){
                System.out.println("Ogiltig input. Skriv ett heltal.");
                scanner.nextLine();
            }
        }
    }

    public static int readIntBetween(Scanner scanner, String prompt, int min, int max){
     while(true){
         int value = readInt(scanner, prompt);
         if(value >= min && value <= max){
             return value;
         }
         System.out.println("Värdet måste vara mellan " +min +" och " +max +".");
     }
    }


}
