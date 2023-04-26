import java.io.*;
import java.util.*;

public class UnboundedKnapsack {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] val = new int[n];
    for (int i = 0; i < n; i++) {
      val[i] = sc.nextInt();
    }
    int[] wei = new int[n];
    for (int i = 0; i < n; i++) {
      wei[i] = sc.nextInt();
    }
    int cap = sc.nextInt();
    System.out.println(UKTab(val, wei, cap));
  }

  public static int UKTab(int[] val, int[] wei, int tar) {
    int n = val.length;
    int[] dp = new int[tar + 1];
    dp[0] = 0;
    for (int i = 1; i <= tar; i++) {
      int ithMax = 0;
      for (int j = 0; j < n; j++) {
        int idx = i - wei[j];
        if (idx >= 0) {
          int currMax = val[j] + dp[idx];
          dp[i] = Math.max(dp[i], currMax);
        }
      }
    }
    return dp[tar];
  }

  public static int ubkRec(int cap, int[] profits, int[] weights) {
    if (cap == 0)
      return 0;

    int ans = 0;
    for (int i = 0; i < weights.length; i++) {
      if (cap >= weights[i])
        ans = Math.max(ans, profits[i] + ubkRec(cap - weights[i], profits, weights));
    }
    return ans;
  }
}