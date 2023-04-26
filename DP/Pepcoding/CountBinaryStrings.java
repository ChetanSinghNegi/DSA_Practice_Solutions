import java.util.*;

public class CountBinaryStrings {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        CBSTwoPointer(n);
        CBSTab(n);
        scn.close();
    }

    public static void CBSTab(int n) {
        int[][] dp = new int[2][n];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 1; i < n; i++) {
            int temp = dp[0][i - 1];
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = dp[1][i - 1] + temp;
        }
        System.out.println(dp[0][n - 1] + dp[1][n - 1]);
    }

    public static void CBSTwoPointer(int n) {
        int prev1Count = 1;
        int prev0Count = 1;
        for (int i = 2; i <= n; i++) {
            int curr0Count = prev1Count;
            int curr1Count = prev0Count + prev1Count;
            prev0Count = curr0Count;
            prev1Count = curr1Count;
        }
        System.out.println(prev0Count + prev1Count);
    }

}