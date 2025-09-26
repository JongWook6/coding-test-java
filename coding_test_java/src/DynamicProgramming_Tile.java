public class DynamicProgramming_Tile {

    private static int mySol(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n ; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int result = mySol(4);
        System.out.println("result = " + result);
    }
}
