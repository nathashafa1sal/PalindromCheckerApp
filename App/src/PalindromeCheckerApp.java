//version 10.0
//author Nathasha
//useCase 10:Casesensitive
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Normalize string
        String normalized = input
                .toLowerCase()
                .replaceAll("\\s+", "");  // remove spaces

        // Optional advanced cleaning:
        // .replaceAll("[^a-z0-9]", "");

        if (isPalindrome(normalized)) {
            System.out.println("The string is a Palindrome (ignoring case & spaces).");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        sc.close();
    }
}