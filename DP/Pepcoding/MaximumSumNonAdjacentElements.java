import java.io.*;
import java.util.*;

public class MaximumSumNonAdjacentElements {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        // int[] dp=new int[n];
        // Arrays.fill(dp,-1);
        // System.out.println(MSNAEMemo(arr,0,dp));
        System.out.println(MSNAETab(arr));
    }
    public static int MSNAEMemo(int[]arr,int idx,int[] dp){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int x=MSNAEMemo(arr,idx+2,dp);
        x+=arr[idx];
        int y=MSNAEMemo(arr,idx+1,dp);
        int max=Math.max(x,y);
        dp[idx]=max;
        return max;
    }
    public static int MSNAETab(int[] arr){
        int n=arr.length;
        int[] dp=new int [n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int x=dp[i+1];
            int y=arr[i];
            if(i+2<=n){
                y+=dp[i+2];
            }
            dp[i]=Math.max(x,y);
        }
        return dp[0];
    }
    public static int MSNAETabTwoPointer(int[] arr){
        int n=arr.length;
        int x=0;
        for(int i=n-1;i<=0;i--){
            int a=x;
            int b=arr[i];
            if(i+2<=n){
                b+=x;
            }
        }
        return 0;
     
    }
}