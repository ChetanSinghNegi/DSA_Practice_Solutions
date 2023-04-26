import java.io.*;
import java.util.*;

public class QueensCombinations2dAs2dQueenChooses {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int sr, int sc){
        // write your code here
        if(qpsf==tq){
            for(int i=0;i<tq;i++){
                for(int j=0;j<tq;j++){
                if(chess[i][j]==false){
                    System.out.print("-\t");
                }
                else{
                    System.out.print("q\t"); 
                }
            }
            System.out.println();
        }
        System.out.println();
        return;
        }
        for(int j=sc+1;j<tq;j++){
            chess[sr][j]=true;
            queensCombinations(qpsf+1, tq, chess, sr, j);
            chess[sr][j]=false;
        }
        for(int i=sr+1;i<tq;i++){
            for(int j=0;j<tq;j++){
            chess[i][j]=true;
            queensCombinations(qpsf+1, tq, chess, i, j);
            chess[i][j]=false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}