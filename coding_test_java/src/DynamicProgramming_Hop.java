import java.util.Arrays;

public class DynamicProgramming_Hop {

    private static int mySol(int[][] land) {
        int l = land.length;

        for (int i = 1; i < l; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (k != j) {
                        max = Math.max(max, land[i - 1][k]);
                    }
                }
                land[i][j] +=  max;
            }
        }

        return Arrays.stream(land[l - 1]).max().getAsInt();
    }

    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        int result = mySol(land);
        System.out.println("result = " + result);
    }
}
