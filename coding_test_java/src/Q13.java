import java.util.Stack;

public class Q13 {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3,}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int result = solution(board, moves);
        System.out.println("result = " + result);
    }

    private static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int i : moves){
            int j = 0;
            while (j < board.length && board[j][i - 1] == 0){
                j++;
            }

            if (j >= board.length) continue;
            int value = board[j][i - 1];
            board[j][i - 1] = 0;

            if (!stack.isEmpty() && stack.peek() == value){
                stack.pop();
                answer += 2;
            } else {
                stack.push(value);
            }
        }

        return answer;
    }


}
