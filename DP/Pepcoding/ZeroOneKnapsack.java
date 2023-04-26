import java.io.*;
import java.util.*;

public class ZeroOneKnapsack {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] brr=new int[n];
        for(int i=0;i<n;i++){
            brr[i]=sc.nextInt();
        }
        int cap=sc.nextInt();
        int maxi=ZOK(arr,brr,0,0,0,cap);
        System.out.println(maxi);
        int[][] dp = new int[n + 1][cap + 1];
        for(int i=0; i<=n; i++)
            Arrays.fill(dp[i], -1);
            
        // Zero One Knapsack Memoization
        System.out.println(zokMemo(0, cap, arr, brr, dp));
    }
    public static int ZOK(int[] arr,int[] brr,int idx,int val,int wei,int cap){
        if(idx>arr.length || wei>cap){
            // System.out.println("hello");
            return Integer.MIN_VALUE;
        }
        if(idx==arr.length){
            return val;
        }
        int x=ZOK(arr,brr,idx+1,val+arr[idx],wei+brr[idx],cap);
        int y=ZOK(arr,brr,idx+1,val,wei,cap);
        int currMax=Math.max(x,y);
        return currMax;
    }

    public static int zokMemo(int idx, int cap, int[] profits, int[] weights, int[][] dp){
        if(idx == profits.length){
            return 0;
        }
        
        if(dp[idx][cap] != -1){
            return dp[idx][cap];
        }
        
        int yes = 0;
        if(cap - weights[idx] >= 0)
            yes = profits[idx] + zokMemo(idx + 1, cap - weights[idx], profits, weights, dp);
            
        int no = zokMemo(idx + 1, cap, profits, weights, dp);
        
        dp[idx][cap] = Math.max(yes, no);
        return dp[idx][cap];
    }
    public int ZOKTab(int[] profit, int[] weight, int cap) {
        int n = profit.length;
        int[][] dp = new int[n + 1][cap + 1];

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=cap; j++)
            {
                int no = dp[i - 1][j];
                int yes = (j - weight[i - 1] < 0) ? 0 
                           : dp[i - 1][j - weight[i - 1]] + profit[i - 1];
                dp[i][j] = Math.max(yes, no);
            }
        }

        return dp[n][cap];
    }

    

}