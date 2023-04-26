import java.io.*;
import java.util.*;

public class NQueenPermutation {

    public static boolean IsQueenSafe(int[][] chess, int sr, int sc) {
        // write your code here
         for(int r=0;r<sr;r++){
            if(chess[r][sc]!=0){
                return false;
            }
        }
        for(int c=0;c<sc;c++){
            if(chess[sr][c]!=0){
                return false;
            }
        }

        int i=sr;
        int j=sc;
        while(i>=0 && j>=0){
            if(chess[i][j]!=0){
                return false;
            }
            i--;
            j--;
        }
        i=sr;
        j=sc;
        while(i>=0 && j<chess.length){
            if(chess[i][j]!=0){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void nqueens(int sr,int sc,int qpsf,boolean[] usedQueen, int[][] chess) {
        // write your code here
        
        if(sr==chess.length){
            if(qpsf==chess.length){
            int q=1;
            for(int i=0;i<chess.length;i++){
                for(int j=0;j<chess.length;j++){
                    if(chess[i][j]==0){
                        System.out.print("-\t");
                    }else{
                        System.out.print("q"+chess[i][j]+"\t");
                        q++;
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
            return;
        }
        
        for(int i=0;i<usedQueen.length;i++){
            if(usedQueen[i]==false && IsQueenSafe(chess,sr,sc)){
                usedQueen[i]=true;
                chess[sr][sc]=(i+1);
                if(sc==chess.length-1){
                    nqueens(sr+1,0,qpsf+1,usedQueen,chess);
                }else{
                    nqueens(sr,sc+1,qpsf+1,usedQueen,chess);
                }
                chess[sr][sc]=0;
                usedQueen[i]=false;
            }
        }
        if(sc==chess.length-1){
            nqueens(sr+1,0,qpsf,usedQueen,chess);
        }else{
            nqueens(sr,sc+1,qpsf,usedQueen,chess);
        }
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        boolean[] usedQueen=new boolean[n];

        nqueens(0,0,0, usedQueen,chess);
    }
}