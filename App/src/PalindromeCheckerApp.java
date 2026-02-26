//version 12.0
//author Nathasha
//useCase 12:strategy

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {

    // 1️⃣ Strategy Interface
    interface PalindromeStrategy {
        boolean check(String input);
    }

    // 2️⃣ Stack Strategy
    static class StackStrategy implements PalindromeStrategy {

        public boolean check(String input) {

            String str = input.toLowerCase().replaceAll("\\s+", "");
            Stack<Character> stack = new Stack<>();

            for (char ch : str.toCharArray()) {
                stack.push(ch);
            }

            for (char ch : str.toCharArray()) {
                if (ch != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    // 3️⃣ Deque Strategy
    static class DequeStrategy implements PalindromeStrategy {

        public boolean check(String input) {

            String str = input.toLowerCase().replaceAll("\\s+", "");
            Deque<Character> deque = new ArrayDeque<>();

            for (char ch : str.toCharArray()) {
                deque.addLast(ch);
            }

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }

            return true;
        }
    }

    // 4️⃣ Context Class
    static class PalindromeContext {

        private PalindromeStrategy strategy;

        public PalindromeContext(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean execute(String input) {
            return strategy.check(input);
        }
    }

    // 5️⃣ Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeContext context = new PalindromeContext(strategy);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        boolean result = context.execute(input);

        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        sc.close();
    }
}