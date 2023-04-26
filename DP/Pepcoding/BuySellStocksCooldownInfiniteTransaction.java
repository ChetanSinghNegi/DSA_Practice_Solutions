import java.io.*;
import java.util.*;

public class BuySellStocksCooldownInfiniteTransaction {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        BASSIT(arr);
    }
    public static void BASSIT(int [] arr){
        int n=arr.length;
        int[][] dp=new int[n][3];
        dp[0][0]=-arr[0];
        dp[0][1]=0;
        dp[0][2]=0;
        for(int i=1;i<n;i++){
            //Extra Buy
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]-arr[i]); 
            
            //No Extra Buy 
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+arr[i]);


            dp[i][2]=Math.max(dp[i-1][1],dp[i-1][2]);
        }
        System.out.println(Math.max(dp[n-1][1],dp[n-1][2]));
    }

}