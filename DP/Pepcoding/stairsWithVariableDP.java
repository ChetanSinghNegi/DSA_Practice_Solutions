import java.io.*;
import java.util.*;

public class stairsWithVariableDP {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 1;

        // int sol=climbStairsVariableMemo(arr,0,dp);
        // System.out.println(sol);
        System.out.println(climbStairsVariableTab(arr));
    }

    public static int climbStairsVariableRec(int[] arr, int src) {// blunt recursion
        if (src == arr.length) {
            return 1;
        } else if (src > arr.length) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= arr[src]; i++) {
            count += climbStairsVariableRec(arr, src + i);
        }
        return count;
    }

    public static int climbStairsVariableMemo(int[] arr, int src, int[] dp) {// Memorization recursion
        if (src == arr.length) {
            return 1;
        } else if (src > arr.length) {
            return 0;
        }
        if (dp[src] != -1) {
            return dp[src];
        }
        int count = 0;
        for (int i = 1; i <= arr[src]; i++) {
            count += climbStairsVariableMemo(arr, src + i, dp);
        }
        dp[src] = count;
        return count;
    }

    public static int climbStairsVariableTab(int[] arr) {// tabulation
        int[] dp = new int[arr.length + 1];
        dp[arr.length] = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int count = 0;
            for (int j = 1; j <= arr[i]; j++) {
                if (i + j <= arr.length) {
                    count += dp[i + j];
                }
            }
            dp[i] = count;
        }
        return dp[0];
    }

}
