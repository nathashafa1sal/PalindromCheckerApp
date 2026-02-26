//version 11.0
//author Nathasha
//useCase 11:Objectoriented

public class PalindromeCheckerApp {

    // Public method exposed to outside
    public boolean checkPalindrome(String input) {

        if (input == null)
            return false;

        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}