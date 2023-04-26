import java.io.*;
import java.util.*;

public class FibonacciDp{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] dp=new int[n+1];
    System.out.println(fibRec(n));
    int sol=fibMemo(n,dp);
    System.out.println(sol);
    dp=new int[n+1];
    Arrays.fill(dp,-1);
    System.out.println(fibTab(n));

    sc.close();
 }
 public static int fibRec(int n){ //blunt recursion
    if(n==0||n==1){
        return n; 
    }
    
   int x=fibRec(n-1);
   int  y=fibRec(n-2);
    return x+y;
}
 public static int fibMemo(int n,int[] dp){ //Memoization
     if(n==0||n==1){
         return n; 
     }
     if(dp[n]!=0){
        return dp[n];
     }
    int x=fibMemo(n-1,dp);
    int  y=fibMemo(n-2,dp);
     dp[n]=x+y;
     return x+y;
 }
 public static int fibTab(int n){ //Tabulation 
    int[] tDp=new int[n+1];
    tDp[0]=0;
    tDp[1]=1;
    for(int i=2;i<=n;i++){
        tDp[i]=tDp[i-1]+tDp[i-2];
    }
    return tDp[n];
 }

}