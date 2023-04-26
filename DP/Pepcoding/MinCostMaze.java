import java.io.*;
import java.util.*;

public class MinCostMaze {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int r=scn.nextInt();
        int c=scn.nextInt();
        int[] [] arr=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        int[][] dp=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dp[i][j]=-1;
            }
        }
        memo(0,0,arr,dp);
        // for(int i=0;i<r;i++){
        //     for(int j=0;j<c;j++){
        //         System.out.println(dp[i][j]);
        //     }
        // }
        // System.out.println(dp[0][0]);
        System.out.println(tab(arr));
    }
    public static int memo(int sr,int sc,int[][] arr,int[][] dp){
        if(sr==arr.length-1&&sc==arr[0].length-1){
            return arr[sr][sc];
        }
        if(sr>=arr.length||sc>=arr[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[sr][sc]!=-1){
            return dp[sr][sc];
        }
        int x=memo(sr,sc+1,arr,dp);
        int y=memo(sr+1,sc,arr,dp);
        int minRec=Math.min(x,y);
        minRec=minRec+arr[sr][sc];
        dp[sr][sc]=minRec;
        return minRec;
    }
    public static int tab(int[][] arr){
        int r=arr.length;
        int c=arr[0].length;
        int[][] dp=new int[r][c];
        for(int i=r-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){
                if(i==r-1&&j==c-1){
                    dp[i][j]=arr[i][j];
                    continue;
                }
                int x=Integer.MAX_VALUE;
                int y=Integer.MAX_VALUE;
                if(i+1<r){
                    x=dp[i+1][j];
                }
                if(j+1<c){
                    y=dp[i][j+1];
                }
                int minCall=Math.min(x,y);
                dp[i][j]=arr[i][j]+minCall;
            }
        }
        return dp[0][0];
    }
}
