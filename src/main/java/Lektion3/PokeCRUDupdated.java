package Lektion3;

import java.util.ArrayList;
import java.util.Scanner;

public class PokeCRUDupdated {
    public static void main(String[] args) {
        ArrayList<String> pokedex = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- POKÉMON DATABASE ---");
            System.out.println("1. Skapa ny Pokemon");
            System.out.println("2. Uppdatera en Pokemon");
            System.out.println("3. Ta bort en Pokemon");
            System.out.println("4. Lista alla Pokemon");
            System.out.println("5. Avsluta");

            System.out.print("Vad vill göra (välj 1-5): ");
            String input = scanner.nextLine();

            if (input.equals("5")) {
                System.out.println("Avslutar Pokemon-databasen...");
                running = false;
            } else if (input.equals("1")) {
                createPokemon(scanner, pokedex);
            } else if (input.equals("2")) {
                updatePokemon(scanner, pokedex);
            } else if (input.equals("3")) {
               deletePokemon(scanner, pokedex);
            } else if (input.equals("4")) {
                viewPokedex(pokedex);
            } else {
                System.out.println("Ogiltigt val, välj 1-5.");
            }
        }
        scanner.close();
    }

    public static void createPokemon(Scanner scanner, ArrayList<String> pokedex) {
        System.out.println("****************");
        System.out.println("SKAPA NY POKEMON");
        System.out.println("****************");
        System.out.print("Vad heter den nya pokemonen: ");
        String newPokemon = scanner.nextLine();
        pokedex.add(newPokemon);
        System.out.println(newPokemon + " har lagts till!");
    }

    public static void updatePokemon(Scanner scanner, ArrayList<String> pokedex) {
        System.out.println("****************");
        System.out.println("UPPDATERA POKEMON");
        System.out.println("****************");

        if (pokedex.size() == 0) {
            System.out.println("Det finns inga Pokemon att uppdatera.");
        } else {
            printNumberedList(pokedex);
            System.out.print("Ange nummer att uppdatera: ");
            try {
                int indexToUpdate = Integer.parseInt(scanner.nextLine()) - 1;
                if (indexToUpdate >= 0 && indexToUpdate < pokedex.size()) {
                    System.out.print("Ändra " + pokedex.get(indexToUpdate) + " till: ");
                    String newName = scanner.nextLine();
                    pokedex.set(indexToUpdate, newName);
                    System.out.println("Uppdaterat!");
                } else {
                    System.out.println("Ogiltigt nummer.");
                }
            }catch (NumberFormatException e){
                System.out.println("Det där var inget nummer.");
            }
        }
    }

    public static void deletePokemon(Scanner scanner, ArrayList<String> pokedex){
        System.out.println("****************");
        System.out.println("TA BORT POKEMON");
        System.out.println("****************");

        if (pokedex.size() == 0) {
            System.out.println("Det finns ingen Pokemon att ta bort.");
        } else {
            printNumberedList(pokedex);
            System.out.print("Ange nummer att ta bort: ");
            int indexToDelete = Integer.parseInt(scanner.nextLine()) - 1;
            if (indexToDelete >= 0 && indexToDelete < pokedex.size()) {

                String deletedPokemon = pokedex.remove(indexToDelete);

                System.out.println(deletedPokemon + " togs bort från databasen.");
            } else {
                System.out.println("Ogiltigt nummer.");
            }
        }
    }

    public static void viewPokedex(ArrayList<String> pokedex){
        System.out.println("*******************");
        System.out.println("LISTAR ALLA POKEMON");
        System.out.println("*******************");
        if (pokedex.size() == 0) {
            System.out.println("Databasen är tom.");
        } else {
            printNumberedList(pokedex);
        }

    }

    public static void printNumberedList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }


}
