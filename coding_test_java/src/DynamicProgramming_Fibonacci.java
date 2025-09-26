public class DynamicProgramming_Fibonacci {

    private static int mySolution(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n ; i++) {
            if (i <= 2) {
                dp[i] = 1;
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int result = mySolution(5);
        System.out.println("result = " + result);
    }
}
