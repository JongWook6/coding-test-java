public class DynamicProgramming_Square {

    private static int mySol(int[][] board) {
        int answer = 0;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(board[i][j - 1], Math.min(board[i - 1][j - 1], board[i - 1][j])) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }

        return answer * answer;
    }

    public static void main(String[] args) {
//        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        int[][] board = {{0, 0, 1, 1}, {1, 1, 1, 1}};

        int result = mySol(board);
        System.out.println("result = " + result);
    }
}
