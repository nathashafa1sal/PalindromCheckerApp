//version 13.0
//author Nathasha
//useCase 13:performancecompare
import java.util.*;

public class PalindromeCheckerApp {

    // 1️⃣ Stack Method
    public static boolean stackCheck(String input) {
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

    // 2️⃣ Deque Method
    public static boolean dequeCheck(String input) {
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

    // 3️⃣ Recursive Method
    public static boolean recursiveCheck(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursiveCheck(str, start + 1, end - 1);
    }

    public static boolean recursionWrapper(String input) {
        String str = input.toLowerCase().replaceAll("\\s+", "");
        return recursiveCheck(str, 0, str.length() - 1);
    }

    // 4️⃣ Two Pointer Method
    public static boolean twoPointerCheck(String input) {
        String str = input.toLowerCase().replaceAll("\\s+", "");
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

        long startTime, endTime;

        // Stack
        startTime = System.nanoTime();
        stackCheck(input);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        // Deque
        startTime = System.nanoTime();
        dequeCheck(input);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        // Recursion
        startTime = System.nanoTime();
        recursionWrapper(input);
        endTime = System.nanoTime();
        long recursionTime = endTime - startTime;

        // Two Pointer
        startTime = System.nanoTime();
        twoPointerCheck(input);
        endTime = System.nanoTime();
        long twoPointerTime = endTime - startTime;

        // Display Results
        System.out.println("\n--- Performance Comparison (in nanoseconds) ---");
        System.out.println("Stack Method      : " + stackTime);
        System.out.println("Deque Method      : " + dequeTime);
        System.out.println("Recursive Method  : " + recursionTime);
        System.out.println("Two Pointer Method: " + twoPointerTime);

        sc.close();
    }
}