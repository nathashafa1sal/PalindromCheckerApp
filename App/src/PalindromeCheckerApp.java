//version 4.0
//author Nathasha
//useCase 6:Stackqueue
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();


        String processedInput = input.toLowerCase();


        for (int i = 0; i < processedInput.length(); i++) {
            char ch = processedInput.charAt(i);
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.remove()) {
                isPalindrome = false;
                break;
            }
        }


        if (isPalindrome) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        sc.close();
    }
}