package Lektion3;

public class FizzBuzzUpdated {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getFizzBuzz(i));
        }
    }

    public static String getFizzBuzz(int siffra){
        if (siffra % 15 == 0) {
            return "FizzBuzz";
        } else if (siffra % 5 == 0) {
            return "Buzz";
        } else if (siffra % 3 == 0) {
            return"Fizz";
        } else return String.valueOf(siffra);
    }

}
