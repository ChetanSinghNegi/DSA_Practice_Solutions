import java.io.*;
import java.util.*;

public class QueensCombinations2dAs2dBoxChooses {

    public static void queensPermutations(int cellNo, int count, int tq, int[][] chess) {
        // write your code here
        // int row=cellNo/M;
        // int col=cellNo%M;

        if (cellNo == tq * tq) {
            if (count == tq + 1) {
                for (int i = 0; i < tq; i++) {
                    for (int j = 0; j < tq; j++) {
                        if (chess[i][j] == 0) {
                            System.out.print("-");
                        } else {
                            System.out.print("q");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
                return;
            }
            return;
        }
        chess[cellNo / tq][cellNo % tq] = count;
        queensPermutations(cellNo + 1, count + 1, tq, chess);
        chess[cellNo / tq][cellNo % tq] = 0;
        queensPermutations(cellNo + 1, count, tq, chess);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        queensPermutations(0, 1, n, chess);
    }
}