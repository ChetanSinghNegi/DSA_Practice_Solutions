import java.io.*;
import java.util.*;

public class TilingWithMByNTiles {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        // int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // System.out.println(TWMemo(n,m,dp));
        System.out.println(TWTab(n,m));

    }
    public static int TWMemo(int n,int m,int[] dp){
        if(n==0||n==1){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int x=TWMemo(n-1,m,dp);
        int y=TWMemo(n-m,m,dp);
        dp[n]=x+y;
        return x+y;
    }
    public static int TWTab(int n,int m){
        int [] dp=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]+=dp[i-1];
            if(i-m>=0){
                dp[i]+=dp[i-m];
            }
        }
        return dp[n];
    }
}