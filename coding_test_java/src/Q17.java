import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class Q17 {

    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        String result = solution(cards1, cards2, goal);
        System.out.println("result = " + result);
    }

    private static String solution(String[] cards1, String[] cards2, String[] goal) {

        // 시작
        ArrayDeque<String> gQueue = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> c1Queue = new ArrayDeque<>(Arrays.stream(cards1).toList());
        ArrayDeque<String> c2Queue = new ArrayDeque<>(Arrays.stream(cards2).toList());

        for(int i = 0; i < goal.length; i++){
            if(!gQueue.isEmpty() && gQueue.peek().equals(c1Queue.peek())){
                gQueue.poll();
                c1Queue.poll();
            }
            if(!gQueue.isEmpty() && gQueue.peek().equals(c2Queue.peek())){
                gQueue.poll();
                c2Queue.poll();
            }
        }
        return (gQueue.isEmpty()) ? "Yes" : "No";
    }

}
