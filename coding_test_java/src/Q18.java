import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Q18 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9};
        int target = 10;
        boolean result = solution(arr, target);
        System.out.println("result = " + result);
    }

    private static boolean solution(int[] arr, int target) {
        HashSet<Integer> hashSet = new HashSet<>();
        
        for (int i : arr) {
            if (hashSet.contains(target - i)) {
                return true;
            } else {
                hashSet.add(i);
            }
        }
        return false;
    }
}
