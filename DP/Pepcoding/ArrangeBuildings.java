import java.util.*;

public class ArrangeBuildings{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    ABTwoPointer(n);
    ABTab(n);
 }
 public static void ABTwoPointer(int n){
     long prev1Count=1;
     long prev0Count=1;
     for(int i=2;i<=n;i++){
         long curr0Count=prev1Count;
         long curr1Count=prev0Count+prev1Count;
         prev0Count=curr0Count;
         prev1Count=curr1Count;
     }
     long totalCount=prev0Count+prev1Count;
     totalCount*=totalCount;
     System.out.println(totalCount);
 }
 public static void ABTab(int n){
    int[][] dp=new int[2][n];
    dp[0][0]=1;
    dp[1][0]=1;
    for(int i=1;i<n;i++){
        dp[0][i]=dp[0][i-1]+dp[1][i-1];
        dp[1][i]=dp[0][i-1];
    }
    System.out.println((int)Math.pow(dp[0][n-1]+dp[1][n-1],2));
}

}