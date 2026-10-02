package Lektion4;

import java.util.ArrayList;
import java.util.Scanner;


// Pokemon Database från L3 uppdaterad till switch och till att hantera Pokemon-objekt
public class PokedexGold {
    public static void main(String[] args) {
        ArrayList<Pokemon> pokedex = new ArrayList<>();
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

            switch (input) {
                case "5" -> {
                    System.out.println("Avslutar Pokemon-databasen...");
                    running = false;
                }
                case "1" -> createPokemon(scanner, pokedex);
                case "2" -> updatePokemon(scanner, pokedex);
                case "3" -> deletePokemon(scanner, pokedex);
                case "4" -> viewPokedex(pokedex);
                default -> System.out.println("Ogiltigt val, välj 1-5.");
            }
        }
        scanner.close();
    }

    public static void createPokemon(Scanner scanner, ArrayList<Pokemon> pokedex) {
        System.out.println("****************");
        System.out.println("SKAPA NY POKEMON");
        System.out.println("****************");

        System.out.print("Vad heter den nya pokemonen: ");
        String newPokemonName = scanner.nextLine();

        System.out.print("Vad har den för typ?");
        String typeString = scanner.nextLine();

        System.out.print("Vad har den för maxHP?");
        String hpString = scanner.nextLine();

        Type newType =Type.valueOf(typeString.trim().toUpperCase());

        int newHP = Integer.parseInt(hpString);

        Pokemon newPokemon = new Pokemon(newPokemonName, newType, newHP);

        pokedex.add(newPokemon);

        System.out.println(newPokemon.getName() + " har lagts till!");
    }

    public static void updatePokemon(Scanner scanner, ArrayList<Pokemon> pokedex) {
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
                    System.out.print("Ändra namnet " + pokedex.get(indexToUpdate).getName() + " till: ");
                    String newName = scanner.nextLine();

                    System.out.print("Ändra typen från " + pokedex.get(indexToUpdate).getType() + " till: ");
                    Type newType = Type.valueOf(scanner.nextLine().trim().toUpperCase());

                    System.out.print("Ändra maxHP från " + pokedex.get(indexToUpdate).getMaxHP() + " till: ");
                    int newMaxHP = Integer.parseInt(scanner.nextLine());

                    Pokemon updatedPokemon = new Pokemon(newName, newType, newMaxHP);

                    pokedex.set(indexToUpdate, updatedPokemon);
                    System.out.println("Uppdaterat!");
                } else {
                    System.out.println("Ogiltigt nummer.");
                }
            }catch (NumberFormatException e){
                System.out.println("Det där var inget nummer.");
            }
        }
    }

    public static void deletePokemon(Scanner scanner, ArrayList<Pokemon> pokedex){
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

                Pokemon deletedPokemon = pokedex.remove(indexToDelete);

                System.out.println(deletedPokemon.getName() + " togs bort från databasen.");
            } else {
                System.out.println("Ogiltigt nummer.");
            }
        }
    }


    public static void viewPokedex(ArrayList<Pokemon> pokedex){
        System.out.println("*******************");
        System.out.println("LISTAR ALLA POKEMON");
        System.out.println("*******************");
        if (pokedex.size() == 0) {
            System.out.println("Databasen är tom.");
        } else {
            printNumberedList(pokedex);
        }

    }

    public static void printNumberedList(ArrayList<Pokemon> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).getName() +" ( " +list.get(i).getType() +" )");
        }
    }


}
