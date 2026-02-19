// version 2.0
//author Nathasha
//Usecase2: Hardcorepalindrome
public class PalindromeChecker {

    public static void main(String[] args) {

        // Hardcoded string
        String word = "madam";


        String reversed = "";


        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        // Check if palindrome using if-else
        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }
    }
}
