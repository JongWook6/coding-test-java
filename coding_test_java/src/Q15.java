import java.util.ArrayDeque;
import java.util.ArrayList;

public class Q15 {

    public static void main(String[] args) {
        int result = solution(5, 2);
        System.out.println("result = " + result);
    }

    private static int solution(int N, int k){

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                Integer pass = queue.pollFirst();
                queue.addLast(pass);
            }
            queue.pollFirst();
        }

        return queue.pollFirst();
    }
}
