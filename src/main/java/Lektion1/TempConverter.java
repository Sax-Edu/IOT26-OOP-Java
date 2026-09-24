package Lektion1;

import java.util.Scanner;

public class TempConverter {
    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Fråga efter skala
        System.out.print("Vilken skala matar du in? (C/F/K): ");
        String skala = scanner.nextLine().trim().toUpperCase(); //"trim()" tar bort blanksteg från inmatningen. "toUpperCase()" gör allt till versaler.

        //Fråga efter temperatur
        System.out.print("Ange temperatur: ");
        double temp = scanner.nextDouble();
        scanner.nextLine(); // Rensar bufferten

        //Variabler för de tre skalorna
        double celsius = 0;
        double fahrenheit = 0;
        double kelvin = 0;

        //Omvandla baserat på vald skala
        if (skala.equals("C")) {
            celsius = temp;
            fahrenheit = celsius * 9.0 / 5.0 + 32;
            kelvin = celsius + 273.15;

            System.out.printf("%.1f°C motsvarar %.1f°F och %.1fK%n", celsius, fahrenheit, kelvin);

        } else if (skala.equals("F")) {
            fahrenheit = temp;
            celsius = (fahrenheit - 32) * 5.0 / 9.0;
            kelvin = celsius + 273.15;

            System.out.printf("%.1f°F motsvarar %.1f°C och %.1fK%n", fahrenheit, celsius, kelvin);

        } else if (skala.equals("K")) {
            kelvin = temp;
            celsius = kelvin - 273.15;
            fahrenheit = celsius * 9.0 / 5.0 + 32;

            System.out.printf("%.1fK motsvarar %.1f°C och %.1f°F%n", kelvin, celsius, fahrenheit);

        } else {
            System.out.println("Ogiltig skala! Du måste välja C, F eller K.");
        }

        scanner.close();
    }
}
*/

   // LÖSNING MED SWITCH

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Fråga efter skala
        System.out.print("Vilken skala matar du in? (C/F/K): ");
        String skala = scanner.nextLine().trim().toUpperCase();

        // 2. Fråga efter temperatur
        System.out.print("Ange temperatur: ");
        double temp = scanner.nextDouble();
        scanner.nextLine(); // Rensar bufferten

        // Variabler för resultat
        double celsius = 0;
        double fahrenheit = 0;
        double kelvin = 0;

        // 3. Omvandla baserat på skala med switch
        switch (skala) {
            case "C" -> {
                celsius = temp;
                fahrenheit = celsius * 9.0 / 5.0 + 32;
                kelvin = celsius + 273.15;
                System.out.printf("%.1f°C motsvarar %.1f°F och %.1fK%n", celsius, fahrenheit, kelvin);
            }
            case "F" -> {
                fahrenheit = temp;
                celsius = (fahrenheit - 32) * 5.0 / 9.0;
                kelvin = celsius + 273.15;
                System.out.printf("%.1f°F motsvarar %.1f°C och %.1fK%n", fahrenheit, celsius, kelvin);
            }
            case "K" -> {
                kelvin = temp;
                celsius = kelvin - 273.15;
                fahrenheit = celsius * 9.0 / 5.0 + 32;
                System.out.printf("%.1fK motsvarar %.1f°C och %.1f°F%n", kelvin, celsius, fahrenheit);
            }
            default -> System.out.println("Ogiltig skala! Du måste välja C, F eller K.");
        }

        scanner.close();
    }
}

