import java.util.HashMap;
import java.util.HashSet;

public class Simulation_topping {

    private static int mySolution(int[] topping) {
        int cnt = 0;

        for (int i = 0; i < topping.length; i++) {
            HashSet<Integer> OB = new HashSet<>();
            HashSet<Integer> YB = new HashSet<>();

            for (int j = 0; j <= i; j++) {
                OB.add(topping[j]);
            }
            for (int k = topping.length - 1; k > i ; k--) {
                YB.add(topping[k]);
            }

            if (OB.size() == YB.size()) {
                cnt++;
            }

        }

        return cnt;
    }

    private static int solutionByMap(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> toppingMap = new HashMap<>();
        for (int t : topping) {
            toppingMap.put(t, toppingMap.getOrDefault(t, 0) + 1);
        }

        HashSet<Integer> toppingSet = new HashSet<>();

        for (int t : topping) {
            toppingSet.add(t);
            toppingMap.put(t, toppingMap.get(t) - 1);

            if (toppingMap.get(t) == 0) {
                toppingMap.remove(t);
            }

            if (toppingSet.size() == toppingMap.size()) {
                answer++;
            }
        }

        return answer;
    }

    private static int solutionByArr(int[] topping) {
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();
        int[] OBArr = new int[topping.length];
        int[] YBArr = new int[topping.length];

        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            OBArr[i] = set.size();
        }

        set.clear();

        for (int i = topping.length - 1; i >= 0 ; i--) {
            set.add(topping[i]);
            YBArr[i] = set.size();
        }

        for (int i = 0; i < topping.length - 1; i++) {
            if (OBArr[i] == YBArr[i + 1]) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
//        int[] topping = {1, 2, 3, 1, 4};
        int result = solutionByArr(topping);
        System.out.println("result = " + result);
    }
}
