import java.io.*;
import java.util.*;

public class BuySellStocksFeeInfiniteTransactions {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int fee=sc.nextInt();
        BASSIT(arr,fee);
    }
    public static void BASSIT(int [] arr,int fee){
        int n=arr.length;
        int[][] dp=new int[n][2];
        dp[0][0]=-arr[0];
        dp[0][1]=0;
        for(int i=1;i<n;i++){
            //Extra Buy
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-arr[i]); 
            
            //No Extra Buy 
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+arr[i]-fee);
        }
        System.out.println(dp[n-1][1]);
    }

}