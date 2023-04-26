import java.io.*;
import java.util.*;

public class ClimbStairs {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] dp=new int[n+1];
        int sol=climbStairsDMemo(n,dp);
        System.out.println(sol);
        System.out.println(climbStairsTab(n));
        dp=new int[n];
        int solU=climbStairsUMemo(0,n, dp);
        System.out.println(solU);
        sc.close();
    }
    
    public static int climbStairsRec(int src,int dest ){
        if(src==dest){
            return 1;
        }
        if(src>dest){
            return 0;
        }
        
        int x=climbStairsRec(src+1, dest);
        int y=climbStairsRec(src+2, dest);
        int z=climbStairsRec(src+3, dest);
        return x+y+z;
    }
    public static int climbStairsUMemo(int src,int dest,int[] dp){
        if(src==dest){
            return 1;
        }
        if(src>dest){
            return 0;
        }
        if(dp[src]!=0){
            return dp[src];
        }
        int x=climbStairsUMemo(src+1, dest, dp);
        int y=climbStairsUMemo(src+2, dest, dp);
        int z=climbStairsUMemo(src+3, dest, dp);
        dp[src]=x+y+z;
        return x+y+z;
    }
    public static int climbStairsDMemo(int n,int[] dp){
        if(n==0||n==1){
            return 1;
        }
        else if(n<0){
            return 0;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]+=climbStairsDMemo(n-1,dp);
        
        dp[n]+=climbStairsDMemo(n-2,dp);
        
        dp[n]+=climbStairsDMemo(n-3,dp);
        
        return dp[n];
    }
    public static int climbStairsTab(int n){
        int[] dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){

            if(i+1<=n){
                dp[i]+=dp[i+1];
            }
            if(i+2<=n){
                dp[i]+=dp[i+2];
            }
            if(i+3<=n){
                dp[i]+=dp[i+3];
            }
        }
        return dp[0];
    }


}