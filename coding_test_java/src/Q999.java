import java.util.ArrayDeque;
import java.util.Arrays;

public class Q999 {

    public static void main(String[] args) {
        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        int result = solution(k, m, score);
        System.out.println("result = " + result);
    }

    public static int solution(int k, int m, int[] score) {

        // 배열 오름차순 정렬
        int answer = 0;
        Arrays.sort(score);

        // 큰 값부터 큐에 입력
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = score.length - 1; i >= 0; i--){
            queue.offer(score[i]);
        }

        System.out.println(queue);
        System.out.println(queue.size());

        // m 개씩 추출
        while(!queue.isEmpty()){
            int price = 0;
            for(int i = 1; i <= m; i++){
                if (queue.isEmpty()) {
                    break;
                }
                if(i == m) {
                    price = queue.poll();
                } else {
                    queue.poll();
                }
            }
            answer += price * m;
        }

        return answer;
    }
}
