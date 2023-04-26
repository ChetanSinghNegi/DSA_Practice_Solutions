import java.io.*;
import java.util.*;

public class QueensPermutations2dAs2dBoxChooses {

    public static void queensPermutations(int cellNo,int qpsf,boolean[] queens,String asf) {
        // write your code here
        if(cellNo==queens.length*queens.length){
            if(qpsf==queens.length){
                System.out.println(asf);
                System.out.println();
            }
            return;
        }
        
        for(int i=0;i<queens.length;i++){
            if(queens[i]==false){
                queens[i]=true;
                if(cellNo%queens.length==queens.length-1){
                    queensPermutations(cellNo+1,qpsf+1,queens,asf+"q"+(i+1)+"\t\n");
                }
                else{
                queensPermutations(cellNo+1,qpsf+1,queens,asf+"q"+(i+1)+"\t");         
                }
                queens[i]=false;
            }
        }
        if(cellNo%queens.length==queens.length-1){
            queensPermutations(cellNo+1,qpsf,queens,asf+"-\t\n");
        }else{
            queensPermutations(cellNo+1,qpsf,queens,asf+"-\t");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];
        String str=new String();
        

        queensPermutations(0,0,queens,"");
    }
}