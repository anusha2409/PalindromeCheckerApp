public class PalindromeCheckerApp {

        interface PalindromeStrategy {
            boolean check(String input);
        }

        static class StackStrategy implements PalindromeStrategy {
            @Override
            public boolean check(String input) {
                java.util.Stack<Character> stack = new java.util.Stack<>();
                for (char c : input.toCharArray()) {
                    stack.push(c);
                }
                for (char c : input.toCharArray()) {
                    if (stack.pop() != c) {
                        return false;
                    }
                }
                return true;
            }
        }

        static class DequeStrategy implements PalindromeStrategy {
            @Override
            public boolean check(String input) {
                java.util.Deque<Character> deque = new java.util.ArrayDeque<>();
                for (char c : input.toCharArray()) {
                    deque.addLast(c);
                }
                while (deque.size() > 1) {
                    if (!deque.removeFirst().equals(deque.removeLast())) {
                        return false;
                    }
                }
                return true;
            }
        }

        public static void main(String[] args) {

            String input = "level";

            PalindromeStrategy stackStrategy = new StackStrategy();
            long startStack = System.nanoTime();
            boolean stackResult = stackStrategy.check(input);
            long endStack = System.nanoTime();
            long stackTime = endStack - startStack;

            PalindromeStrategy dequeStrategy = new DequeStrategy();
            long startDeque = System.nanoTime();
            boolean dequeResult = dequeStrategy.check(input);
            long endDeque = System.nanoTime();
            long dequeTime = endDeque - startDeque;

            System.out.println("Input : " + input);
            System.out.println("Stack -> Is Palindrome? : " + stackResult);
            System.out.println("Stack Execution Time : " + stackTime + " ns");
            System.out.println("Deque -> Is Palindrome? : " + dequeResult);
            System.out.println("Deque Execution Time : " + dequeTime + " ns");
        }
    }