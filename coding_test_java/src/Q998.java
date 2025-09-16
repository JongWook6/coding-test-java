import java.util.Arrays;

public class Q998 {

    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        int[] result = solution(wallpaper);
        System.out.println("result = " + Arrays.toString(result));
    }

    private static int[] solution(String[] wallpaper) {
        char[][] board = new char[wallpaper.length][wallpaper[0].length()];
        for(int i = 0; i < wallpaper.length; i++){
            board[i] = wallpaper[i].toCharArray();
        }

        int left = getLeft(board); // [0, i]
        int right = getRight(board); // [0, i]
        int top = 0;
        int bottom = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                top = i;
                break;
            }
        }
        for (int i = wallpaper.length - 1; i >= 0; i--) {
            if (wallpaper[i].contains("#")) {
                bottom = i;
                break;
            }
        }

        int[] answer = new int[4];
        answer[0] = top;
        answer[1] = left;
        answer[2] = bottom + 1;
        answer[3] = right + 1;
        return answer;
    }

    private static int getLeft(char[][] board){
        int answer = 0;
        A:for(int i = 0; i < board[0].length; i++){ // 열 = i
            for(int j = 0; j < board.length; j++){ // 행 = j
                if(board[j][i] == '#'){
                    answer = i;
                    break A;
                }
            }
        }
        return answer;
    }

    private static int getRight(char[][] board){
        int answer = 0;
        A: for(int i = board[0].length - 1; i >= 0; i--){ // 열 = i
            for(int j = board.length - 1; j >= 0; j--){ // 행 = j
                if(board[j][i] == '#'){
                    answer = i;
                    break A;
                }
            }
        }
        return answer;
    }

}
