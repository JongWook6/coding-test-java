import java.util.ArrayList;

public class Backtracking_sum {

    private static ArrayList<ArrayList<Integer>> result;
    private static int N;

    private static void backtracking(int sum, ArrayList<Integer> selectedNums, int start) {
        if (sum == 10) {
            result.add(selectedNums);
            return;
        }

        for (int i = start; i <= N; i++) {
            if (sum + i <= 10) {
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);
                backtracking(sum + i, list, i + 1);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> solution(int n) {
        result = new ArrayList<>();
        N = n;

        backtracking(0, new ArrayList<>(), 1);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = solution(2);
        for (ArrayList<Integer> integers : result) {
            System.out.println(integers);
        }
    }
}
