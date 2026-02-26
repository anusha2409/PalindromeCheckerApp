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

            PalindromeStrategy strategy;
            strategy = new StackStrategy();
            // strategy = new DequeStrategy();

            boolean result = strategy.check(input);

            System.out.println("Input: " + input);
            System.out.println("Is Palindrome? " + result);
        }
    }