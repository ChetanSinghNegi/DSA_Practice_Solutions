import java.io.*;
import java.util.*;

public class TilingWith2By1Tiles {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // System.out.println(TWMemo(n,dp));
        System.out.println(TWTab(n));

    }
    public static int TWMemo(int n,int[] dp){
        if(n==0||n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }

        int x=TWMemo(n-1,dp);
        int y=TWMemo(n-2,dp);
        dp[n]=x+y;
        return x+y;
    }
    public static int TWTab(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}