import java.util.Arrays;
import java.util.Stack;

public class Q14 {

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(solution(n, k, cmd));
    }

    private static String solution(int n, int k, String[] cmd) {

        // 삭제행 기록용 배열
        Stack<Integer> stack = new Stack<>();

        // 인덱스 기록용 배열
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        k++;

        for(int i = 0; i < n + 2; i++){
            up[i] = i - 1; // [-1, 0, 1, 2, 3, 3, 5, 6]
            down[i] = i + 1; // [1, 2, 3, 5, 5, 6, 7, 8]
        }

        for(String s : cmd){
            if(s.equals("C")){
                stack.push(k);
                down[up[k]] = down[k];
                up[down[k]] = up[k];
                k = (n < down[k]) ? up[k] : down[k];
            } else if (s.equals("Z")){
                int restore = stack.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            } else {
                String[] arr = s.split(" ");
                int amount = Integer.parseInt(arr[1]);

                for(int i = 0; i < amount; i++){
                    k = (arr[0].equals("U")) ? up[k] : down[k];
                }

            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for(int i : stack){
            answer[i - 1] = 'X';
        }

        return new String(answer);
    }
}
