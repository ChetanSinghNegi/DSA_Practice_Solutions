import java.io.*;
import java.util.*;

public class TargetSumSubsetsDp {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int tar=sc.nextInt();
        // boolean b=TSS(0,arr,0,tar);
        boolean b=TSSTab(arr,tar);
        System.out.println(b);
    }
    public static boolean TSS(int idx,int[] arr,int currSum,int tar){
        if(idx==arr.length || currSum>tar){
            return false;
        }
        if(currSum==tar){
            return true;
        }
        boolean b1=TSS(idx+1,arr,currSum,tar);
        if(b1){
            return true;
        }
        boolean b2=TSS(idx+1,arr,currSum+arr[idx],tar);
        if(b2){
            return true;
        }
        return false;
    }
    public static boolean TSSTab(int[] arr,int tar){
        int n=arr.length;
        boolean [][] dp=new boolean[n+1][tar+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=tar;j++){
                boolean elementNotIncluded=(dp[i-1][j]==true);
                boolean elementIncluded=(j-arr[i-1]>=0 && (dp[i-1][j-arr[i-1]]==true));
                dp[i][j]=elementNotIncluded || elementIncluded;
            }
        }
        return dp[n][tar];
    }

    public boolean solve(int[] arr, int target) {
      int n = arr.length;
      boolean[] dpPrev = new boolean[target + 1];
      for(int i=1; i<=n; i++)
      {
          boolean[] dpCurr = new boolean[target + 1]; 
          dpPrev[0] = dpCurr[0] = true;
          for(int j=1; j<=target; j++)
          {
              boolean no = dpPrev[j];
              boolean yes = (j - arr[i-1] < 0) ? false : dpPrev[j - arr[i - 1]];

              dpCurr[j] = no || yes;
          }
          for(int j=0; j<=target; j++)
              dpPrev[j] = dpCurr[j];
      }
      return dpPrev[target];
  }
}