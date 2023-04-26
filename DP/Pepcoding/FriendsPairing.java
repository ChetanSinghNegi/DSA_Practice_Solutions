import java.io.*;
import java.util.*;

public class FriendsPairing {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        // System.out.println(FPLongMemo(n,dp));
        System.out.println(FPTab(n));
        
    }
    public static int FPLongMemo(int n,int[] dp){
        if(n==1||n==0){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int a=FPLongMemo(n-1,dp);
        for(int i=0;i<n-1;i++){
            a+=FPLongMemo(n-2,dp);
        }
        dp[n]=a;
        return a;
    }
    public static int FPSmartMemo(int n,int[] dp){
        if(n==1||n==0){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int a=FPSmartMemo(n-1,dp);
        int b=FPSmartMemo(n-2,dp);
        int currCount=a+(n-1)*b;
        dp[n]=currCount;
        return currCount;
    }
    public static int FPTab(int n){
        int [] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            dp[i]=dp[i-1];
            if(i-2>=0){
                dp[i]+=(i-1)*dp[i-2];
            }
        }
        return dp[n];
    }

}