package Lektion5;

import Lektion4.Pokemon;
import Lektion4.Type;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// Pokemon Database uppdaterad med enkelt Swing GUI men bevarad logik
public class PokedexGoldGUI {
    public static void main(String[] args) {
        ArrayList<Pokemon> pokedex = new ArrayList<>();
        boolean running = true;

        while (running) {
            String menu = """
                    --- POKÉMON DATABASE ---
                    1. Skapa ny Pokemon
                    2. Uppdatera en Pokemon
                    3. Ta bort en Pokemon
                    4. Lista alla Pokemon
                    5. Avsluta
                    
                    Vad vill du göra (välj 1-5):""";

            // Visar menyn i en inmatningsruta
            String input = JOptionPane.showInputDialog(null, menu, "Pokedex Gold", JOptionPane.QUESTION_MESSAGE);

            // Om användaren klickar på "Cancel" eller stänger fönstret
            if (input == null) {
                input = "5";
            }

            switch (input.trim()) {
                case "5" -> {
                    JOptionPane.showMessageDialog(null, "Avslutar Pokemon-databasen...");
                    running = false;
                }
                case "1" -> createPokemon(pokedex);
                case "2" -> updatePokemon(pokedex);
                case "3" -> deletePokemon(pokedex);
                case "4" -> viewPokedex(pokedex);
                default -> JOptionPane.showMessageDialog(null, "Ogiltigt val, välj 1-5.");
            }
        }
    }

    public static void createPokemon(ArrayList<Pokemon> pokedex) {
        String newPokemonName = JOptionPane.showInputDialog(null, "Vad heter den nya pokemonen:", "SKAPA NY POKEMON", JOptionPane.QUESTION_MESSAGE);
        if (newPokemonName == null) return;

        String typeString = JOptionPane.showInputDialog(null, "Vad har den för typ?", "SKAPA NY POKEMON", JOptionPane.QUESTION_MESSAGE);
        if (typeString == null) return;

        String hpString = JOptionPane.showInputDialog(null, "Vad har den för maxHP?", "SKAPA NY POKEMON", JOptionPane.QUESTION_MESSAGE);
        if (hpString == null) return;

        try {
            Type newType = Type.valueOf(typeString.trim().toUpperCase());
            int newHP = Integer.parseInt(hpString.trim());

            Pokemon newPokemon = new Pokemon(newPokemonName, newType, newHP);
            pokedex.add(newPokemon);

            JOptionPane.showMessageDialog(null, newPokemon.getName() + " har lagts till!");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Ogiltig typ eller felaktigt HP-format.", "Fel", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void updatePokemon(ArrayList<Pokemon> pokedex) {
        if (pokedex.size() == 0) {
            JOptionPane.showMessageDialog(null, "Det finns inga Pokemon att uppdatera.");
            return;
        }

        String listText = getNumberedListString(pokedex) + "\nAnge nummer att uppdatera:";
        String input = JOptionPane.showInputDialog(null, listText, "UPPDATERA POKEMON", JOptionPane.QUESTION_MESSAGE);
        if (input == null) return;

        try {
            int indexToUpdate = Integer.parseInt(input.trim()) - 1;
            if (indexToUpdate >= 0 && indexToUpdate < pokedex.size()) {
                Pokemon current = pokedex.get(indexToUpdate);

                String newName = JOptionPane.showInputDialog(null, "Ändra namnet " + current.getName() + " till:", current.getName());
                if (newName == null) return;

                String typeInput = JOptionPane.showInputDialog(null, "Ändra typen från " + current.getType() + " till:", current.getType().toString());
                if (typeInput == null) return;
                Type newType = Type.valueOf(typeInput.trim().toUpperCase());

                String hpInput = JOptionPane.showInputDialog(null, "Ändra maxHP från " + current.getMaxHP() + " till:", String.valueOf(current.getMaxHP()));
                if (hpInput == null) return;
                int newMaxHP = Integer.parseInt(hpInput.trim());

                Pokemon updatedPokemon = new Pokemon(newName, newType, newMaxHP);
                pokedex.set(indexToUpdate, updatedPokemon);

                JOptionPane.showMessageDialog(null, "Uppdaterat!");
            } else {
                JOptionPane.showMessageDialog(null, "Ogiltigt nummer.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Det där var inget giltigt nummer.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Ogiltig typ angiven.");
        }
    }

    public static void deletePokemon(ArrayList<Pokemon> pokedex) {
        if (pokedex.size() == 0) {
            JOptionPane.showMessageDialog(null, "Det finns ingen Pokemon att ta bort.");
            return;
        }

        String listText = getNumberedListString(pokedex) + "\nAnge nummer att ta bort:";
        String input = JOptionPane.showInputDialog(null, listText, "TA BORT POKEMON", JOptionPane.QUESTION_MESSAGE);
        if (input == null) return;

        try {
            int indexToDelete = Integer.parseInt(input.trim()) - 1;
            if (indexToDelete >= 0 && indexToDelete < pokedex.size()) {
                Pokemon deletedPokemon = pokedex.remove(indexToDelete);
                JOptionPane.showMessageDialog(null, deletedPokemon.getName() + " togs bort från databasen.");
            } else {
                JOptionPane.showMessageDialog(null, "Ogiltigt nummer.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Det där var inget nummer.");
        }
    }

    public static void viewPokedex(ArrayList<Pokemon> pokedex) {
        if (pokedex.size() == 0) {
            JOptionPane.showMessageDialog(null, "Databasen är tom.");
        } else {
            String listText = getNumberedListString(pokedex);

            // Använder JTextArea för snyggare presentation om listan är lång
            JTextArea textArea = new JTextArea(listText);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            JOptionPane.showMessageDialog(null, scrollPane, "LISTAR ALLA POKEMON", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Hjälpmetod för att bygga en String av listan istället för att skriva ut i konsolen
    public static String getNumberedListString(ArrayList<Pokemon> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(list.get(i).getName())
                    .append(" (")
                    .append(list.get(i).getType())
                    .append(")\n");
        }
        return sb.toString();
    }
}
