package Lektion2;

public class TextAnalys {
    public static void main(String[] args) {
        String rawText = "   jAvA prOgrAmmErIng Är kUL!   ";
        String putsadText = rawText.trim();

        System.out.println(putsadText);

        String putsadTextlower = putsadText.toLowerCase();

        System.out.println(putsadTextlower);
        System.out.println(putsadTextlower +"<- har " +putsadTextlower.length() +" bokstäver.");

        System.out.println(putsadTextlower.contains("java"));

        String powerfulText = putsadTextlower.replace("kul", "kraftfullt");

        System.out.println(powerfulText);

    }
}
