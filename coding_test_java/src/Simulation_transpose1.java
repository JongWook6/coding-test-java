import java.util.Arrays;

public class Simulation_transpose1 {

    public static void main(String[] args) {
        int[][] arr = {{4, 5, 1}, {3, 6, 2}, {2, 5, 4}};
        int[][] result = solution(arr);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[][] solution(int[][] arr){
        int[][] transposed = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                transposed[i][j] = arr[j][i];
            }
        }

        return transposed;
    }


}
