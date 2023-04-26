import java.io.*;
import java.util.*;

public class QueensCombinations2dAs1dQueenChooses {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int cellNo) {
        // write your code here
        if (qpsf == tq) {
            for (int i = 0; i < tq; i++) {
                for (int j = 0; j < tq; j++) {
                    if (chess[i][j] == false) {
                        System.out.print("-\t");
                    } else {
                        System.out.print("q\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int j = cellNo + 1; j < tq * tq; j++) {
            chess[j / tq][j % tq] = true;
            queensCombinations(qpsf + 1, tq, chess, j);
            chess[j / tq][j % tq] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}