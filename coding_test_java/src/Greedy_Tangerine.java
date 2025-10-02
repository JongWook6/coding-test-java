import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Greedy_Tangerine {

    private static int mySol(int k, int[] tangerine) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(((o1, o2) -> Integer.compare(o2, o1)));

        int type = 0;
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            if (total >= k) {
                break;
            }
            total += list.get(i);
            type += 1;
        }

        return type;
    }

    private static int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> sortedCounts = new ArrayList<>(map.values());
        sortedCounts.sort(Collections.reverseOrder());

        int numTypes = 0;
        int countSum = 0;
        for (Integer count : sortedCounts) {
            countSum += count;
            numTypes++;
            if (countSum >= k) {
                break;
            }
        }

        return numTypes;
    }

    public static void main(String[] args) {
//        int k = 4;
//        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int k = 2;
        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
        int result = solution(k, tangerine);
        System.out.println("result = " + result);
    }
}
