import java.io.*;
import java.util.*;

public class CoinChangePermutations {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        // System.out.println(CCPTab(arr,target));
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        System.out.println(CCPMemo(arr, 0, target, dp));
    }

    public static int CCPTab(int[] arr, int tar) {
        int[] dp = new int[tar + 1];
        dp[0] = 1;
        for (int i = 1; i <= tar; i++) {
            for (int j = 0; j < arr.length; j++) {
                int prevIdx = i - arr[j];
                if (prevIdx >= 0) {
                    dp[i] += dp[prevIdx];
                }
            }
        }
        return dp[tar];
    }

    public static int CCPMemo(int[] arr, int currVal, int tar, int[] dp) {
        if (currVal > tar) {
            return 0;
        } else if (tar == currVal) {
            return 1;
        }
        if (dp[currVal] != -1) {
            return dp[currVal];
        }
        int totalCount = 0;
        for (int i = 0; i < arr.length; i++) {
            totalCount += CCPMemo(arr, currVal + arr[i], tar, dp);
        }
        dp[currVal] = totalCount;
        return totalCount;
    }
}