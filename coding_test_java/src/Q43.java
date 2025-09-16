import java.util.ArrayList;

public class Q43 {

    private static ArrayList<ArrayList<Integer>> result;
    private static int n;

    private static void backTracking(int sum, ArrayList<Integer> selectedNums, int start) {
        if (sum == 10) {
            result.add(selectedNums);
            return;
        }

        for (int i = start; i <= n; i++) {
            if (sum + i <= 10) {
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);
                backTracking(sum + i, list, i + 1);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> solution(int N) {
        result = new ArrayList<>();
        n = N;

        backTracking(0, new ArrayList<>(), 1);
        return result;
    }

}
