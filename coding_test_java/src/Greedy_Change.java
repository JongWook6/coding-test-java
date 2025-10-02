import java.util.ArrayList;
import java.util.Arrays;

public class Greedy_Change {

    private static int[] mySol(int amount) {

        ArrayList<Integer> list = new ArrayList<>();
        while (amount != 0) {
            if (amount >= 100) {
                amount -= 100;
                list.add(100);
            } else if (amount >= 50) {
                amount -= 50;
                list.add(50);
            } else if (amount >= 10) {
                amount -= 10;
                list.add(10);
            } else {
                amount -= 1;
                list.add(1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] solution(int amount) {

        int[] denominations = {100, 50, 10, 1};

        ArrayList<Integer> change = new ArrayList<>();
        for (int coin : denominations) {
            while (amount >= coin) {
                change.add(coin);
                amount -= coin;
            }
        }

        return change.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] result = solution(350);
        System.out.println(Arrays.toString(result));
    }
}
