import java.io.*;
import java.util.*;

public class CoinChangeCombination {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int target=scn.nextInt();
        // System.out.println(CCCTab(arr,target));
        int[] dp=new int[target+1];
        // Arrays.fill(dp,-1);
        System.out.println(CCCRec(arr,0,target,dp));
    }
    public static int CCCTab(int[] arr,int tar){
        int n=arr.length;
        int[] dp=new int[tar+1];
        dp[0]=1;
        for(int denomination=0;denomination<n;denomination++){
            for(int j=1;j<=tar;j++){
                int idx=j-arr[denomination];
                if(idx>=0){
                    dp[j]+=dp[idx];
                }
            }
        }
        return dp[tar];
    }

    public static int CCCRec(int[] arr,int idx,int target,int[] dp){
        if(target<0 || idx==arr.length){
            return 0;
        }else if(target==0){
            return 1;
        }   
        // if(dp[target]!=0){
        //     return dp[target];
        // }
        int x=CCCRec(arr,idx,target-arr[idx],dp);
        int y=CCCRec(arr,idx+1,target-arr[idx],dp);
        // dp[target]=dp[target]+x+y;
        return x+y;
    }    
}