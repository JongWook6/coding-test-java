import java.util.Arrays;

public class Simulation_snail {

    public static void main(String[] args) {
        int[][] result = solution(4);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[][] solution(int n) {
        int[][] arr = new int[n][n];
        int num = 1;

        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                arr[startRow][i] = num++;
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) {
                arr[i][endCol] = num++;
            }
            endCol--;

            for (int i = endCol; i >= startCol ; i--) {
                arr[endRow][i] = num++;
            }
            endRow--;

            for (int i = endRow; i >= startRow ; i--) {
                arr[i][startCol] = num++;
            }
            startCol++;

        }
        return arr;
    }
}
