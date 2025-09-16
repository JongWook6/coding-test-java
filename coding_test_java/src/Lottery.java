import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Lottery {

    private static int[] solution(){

        HashSet<Integer> lottoSet = new HashSet<>();
        Random random = new Random();

        while (lottoSet.size() < 6) {
            int randomNumber = random.nextInt(45) + 1;
            lottoSet.add(randomNumber);
        }

        ArrayList<Integer> list = new ArrayList<>(lottoSet);
        Collections.sort(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] result = solution();
        System.out.println(Arrays.toString(result));
    }
}
