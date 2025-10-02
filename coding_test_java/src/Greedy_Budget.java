import java.util.Arrays;

public class Greedy_Budget {

    private static int mySol(int[] demand, int budget) {

        Arrays.sort(demand);
        int answer = 0;
        int remainingBudget = budget;

        for (int d : demand) {
            if (d <= remainingBudget) {
                answer++;
                remainingBudget -= d;
            }
        }

        return answer;
    }

    private static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;

        for (int amount : d) {
            if (budget < amount) {
                break;
            }

            budget -= amount;
            count++;
        }

        return budget >= 0 ? count : count - 1;
    }

    public static void main(String[] args) {
//        int[] demand = {1, 3, 2, 5, 4};
//        int budget = 9;
        int[] demand = {2, 2, 3, 3};
        int budget = 10;
        int result = mySol(demand, budget);
        System.out.println("result = " + result);
    }
}
