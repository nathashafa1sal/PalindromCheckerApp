//version 4.0
//author Nathasha
//useCase 4: CharacterArray

import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindromeUsingCharArray(String input) {
        // Convert string to character array
        char[] characters = input.toCharArray();

        int start = 0;
        int end = characters.length - 1;

        // Two-pointer comparison
        while (start < end) {
            if (characters[start] != characters[end]) {
                return false; // Mismatch found
            }
            start++;
            end--;
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = isPalindromeUsingCharArray(input);

        if (result) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        scanner.close();
    }
}