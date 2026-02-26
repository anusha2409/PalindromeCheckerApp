public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal panama";

        boolean result = isPalindrome(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? " + result);
    }

    private static boolean isPalindrome(String input) {

        String normalized = input
                .replaceAll("\\s+", "")
                .toLowerCase();
        for (int i = 0; i < normalized.length() / 2; i++) {

            if (normalized.charAt(i) !=
                    normalized.charAt(normalized.length() - 1 - i)) {

                return false;
            }
        }

        return true;
    }
}