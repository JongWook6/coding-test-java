import java.util.Arrays;
import java.util.HashSet;

public class Q58 {

    private static boolean solution(String[] phone_book) {

        HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String s : phone_book) {
            for (int i = 1; i < s.length(); i++) {
                if (set.contains(s.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] numbers = {"119", "97674223", "1195524421"};
        boolean result = solution(numbers);
        System.out.println("result = " + result);
    }
}
