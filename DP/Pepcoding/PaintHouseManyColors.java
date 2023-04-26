import java.io.*;
import java.util.*;

public class PaintHouseManyColors {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[][] arr = new int[n][k];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    int[][] dp = new int[n][k];

    // int ans = PHTabNotOptimized(arr, dp);
    // System.out.println(ans);
    PWTabOptimized(arr,dp);
  }
  public static int PHTabNotOptimized(int[][] arr, int[][] dp) {
    int n = arr.length;
    int k = arr[0].length;
    for (int i = 0; i < k; i++) {
      dp[0][i] = arr[0][i];
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < k; j++) {
        int currMin = Integer.MAX_VALUE;
        for (int tc = 0; tc < k; tc++) {
          if (tc != j) {
            currMin = Math.min(currMin, dp[i - 1][tc]);
          }
        }
        dp[i][j] = currMin + arr[i][j];
      }
    }
    int gMin = Integer.MAX_VALUE;
    for (int i = 0; i < k; i++) {
      gMin = Math.min(gMin, dp[n - 1][i]);
    }
    return gMin;
}
  public static void PWTabOptimized(int[][] cost,int[][] dp) {
    int n = cost.length;
    int colors = cost[0].length;
    for (int c = 0; c < colors; c++)
      dp[0][c] = cost[0][c];

    for (int house = 1; house < n; house++)
    {
      int MinAns = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
      for (int c = 0; c < colors; c++)
      {
        if (dp[house - 1][c] <= MinAns) {
          secondMin = MinAns;
          MinAns = dp[house - 1][c];
        }
        else if (dp[house - 1][c] <= secondMin) {
          secondMin = dp[house - 1][c];
        }
      }

      // Curr house: which color to paint
      for (int color = 0; color < colors; color++)
      {

        if (dp[house - 1][color] == MinAns)
          dp[house][color] = secondMin + cost[house][color];
        else
          dp[house][color] = MinAns + cost[house][color];
      }
    }

    int minAns = Integer.MAX_VALUE;
    for (int c = 0; c < colors; c++)
      minAns = Math.min(minAns, dp[n - 1][c]);
    System.out.println(minAns);
  }

}