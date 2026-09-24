package Lektion1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Skriv en veckodag 1-7: ");

        int day = scan.nextInt();

        String dayName = switch (day) {
            case 1 -> "måndag";
            case 2 -> "tisdag";
            case 3 -> "onsdag";
            case 4 -> "torsdag";
            case 5 -> "fredag";
            case 6 -> "lördag";
            case 7 -> "söndag";
            default -> "okänd";
        };

        String dayType = switch (day){
            case 1,2,3,4,5 -> "vardag";
            case 6,7 -> "helgdag";
            default -> "okänd";
        };

        if(!dayName.equals("okänd")) {
            System.out.println("Du valde " + dayName +", vilket är en " +dayType +".");
        }
        else {
            System.out.println(dayName);
        }

        scan.close();


        /*
        System.out.print("Hur gammal är du? Ålder: ");

        int age = scan.nextInt();

        String test = "Hej";

        if(age == 40 && test.equals("Hej")){
            System.out.println("Trevligt!");
        } else {
            System.out.println("HA!");
        }



        Scanner scan= new Scanner(System.in);

        System.out.println("namn?");
        String name = scan.nextLine();

        System.out.println(name);
        //scan.close();

        Scanner scanInt = new Scanner(System.in);

        System.out.println("skriv ett heltal");
        int number = scanInt.nextInt();

        System.out.println(number);
        scanInt.close();

        Scanner scan = new Scanner(System.in);

        System.out.print("Hej! Vad heter du? Skriv namn:");
        String userInput = scan.nextLine();
        System.out.println("Hej " +userInput +"!");

        scan.close();


        int price = 199;
        int    discountPercent = 20;
        double discount = price * discountPercent / 100.0;
        double finalPrice = price - discount;
        System.out.println("Du betalar: " + finalPrice + " kr");
        */
    }
}

