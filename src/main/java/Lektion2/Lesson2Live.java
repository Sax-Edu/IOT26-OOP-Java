package Lektion2;

import java.util.Scanner;

public class Lesson2Live {

    public static void main(String[] args) {

        String testest = "  Hej hej teST testTeSt   ";

        System.out.println(testest);

        testest = testest.trim().toUpperCase();

        System.out.println(testest);

        for (int row = 1; row <= 10; row++) {
            for (int col = 1; col <= 10; col++) {
                System.out.print(row * col + "\t"); //escapesekvensen \t = tab
            }
            System.out.println();
        }


        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running){
            System.out.println("Inne i menyn");
            System.out.println("1. Hej");
            System.out.println("2. Appgrej");
            System.out.println("skriv quit för att avsluta");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("quit")){
                running = false;
            }
        }

        System.out.println("Ute ur loopen");


        int counter = 0;

        while (counter < 3) {
            counter++;
            System.out.println("Detta är varv " + counter);
        }

        int input;
        do {
            System.out.print("Skriv ett positivt tal: ");
            input = scanner.nextInt();
        } while (input <= 0);

        for (int i = 0; i < 5; i++) {
            System.out.println("Varv: " + i);
        }


        scanner.close();


        String test = "abc123";

        String modString = " aBfG 12 HEJ lkjfd  ";

        String modStringClean = modString.trim();

        String hej = modStringClean.substring(8, 11);

        String modified = modStringClean.replace(" ", "-");
        String modified2 = modStringClean.replace("lkjfd", "MARTIN");


        System.out.println(modString + ", längd: " +modString.length());
        System.out.println(modStringClean + ", längd: " +modStringClean.length());
        System.out.println(hej +"!");
        System.out.println(modified);
        System.out.println(modified2);





        System.out.println(test.length());

        System.out.println(test.charAt(2));

        if(test.contains("123")){
            System.out.println("Funkar!");
        }
        if(test.equalsIgnoreCase("AbC123")){
            System.out.println("Japp, det är samma!");
        }

        if(test.length() < 6 ){
            System.out.println("Lösenord måste vara minst 6 tecken");
        }
    }

}
