import java.io.*;
import java.util.*;

public class PaintFence {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[n][2];
        System.out.println(PFTab(dp, k));
        System.out.println(PFTwoPointer(n, k));

        // for(int i=0;i<n;i++){
        // System.out.println(dp[i][0]+" "+dp[i][1]);
        // }
    }

    public static int PFTab(int[][] dp, int colors) {
        int n = dp.length;
        dp[0][0] = 0;
        dp[0][1] = colors;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = (colors - 1) * (dp[i - 1][0] + dp[i - 1][1]);
        }
        return dp[n - 1][0] + dp[n - 1][1];
    }

    public static int PFTwoPointer(int n, int colors) {
        int x = 0;
        int y = colors;
        for (int i = 1; i < n; i++) {
            int temp = x;
            x = y;
            y = (colors - 1) * (temp + y);
        }
        return x + y;
    }
}