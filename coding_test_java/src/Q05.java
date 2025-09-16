import java.util.Arrays;

public class Q05 {

    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        int[][] result = mySol(arr1, arr2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }

    private static int[][] mySol(int[][] arr1, int[][] arr2) {

        // 계산 결과를 담을 2차원 행렬 (arr1 의 행 길이) * (arr2 의 열 길이)
        int row = arr1.length;
        int col = arr2[0].length;
        int[][] result = new int[row][col];

        // 계산 후 할당
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                for (int k = 0; k < col; k++) {
                    result[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }

        return result;
    }
}
