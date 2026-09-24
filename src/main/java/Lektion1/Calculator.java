package Lektion1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Tal #1: ");

        int a = scan.nextInt();

        System.out.print("Tal #2: ");

        int b = scan.nextInt();

        double kvot = (double)a /b;

        System.out.println("Summa: " + (a + b));
        System.out.println("Differens: " + (a - b));
        System.out.println("Produkt: " + (a * b));
        System.out.printf("Kvot: %.2f %n", kvot);
        System.out.println("Rest: " + (a % b));

    }

}
