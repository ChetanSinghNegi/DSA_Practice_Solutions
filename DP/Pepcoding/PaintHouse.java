import java.io.*;
import java.util.*;

public class PaintHouse {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        int ans = PHTab(arr, dp);
        System.out.println(ans);
        // PWTabTwoPointer(arr,dp);
    }

    public static int PHTab(int[][] arr, int[][] dp) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

    public static void PWTabTwoPointer(int[][] arr) {
        int n = arr.length;
        int r = arr[0][0];
        int g = arr[0][1];
        int b = arr[0][2];
        for (int i = 1; i < n; i++) {
            int rNew = Math.min(g, b) + arr[i][0];
            int gNew = Math.min(r, b) + arr[i][1];
            int bNew = Math.min(r, g) + arr[i][2];
            r = rNew;
            g = gNew;
            b = bNew;
            // System.out.println(r+" "+g+" "+b+" ");
        }
        System.out.println(Math.min(r, Math.min(g, b)));
    }
}