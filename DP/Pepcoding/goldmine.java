import java.io.*;
import java.util.*;

public class goldmine {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] gm = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                gm[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[r][c];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = Integer.MIN_VALUE;
        System.out.println(tab(gm));
    }

    public static int memo(int[][] gm, int sr, int sc, int[][] dp) {
        if (sr >= gm.length || sr < 0) {
            return 0;
        }

        if (sc == gm[0].length - 1) {
            return gm[sr][sc];
        }
        if (dp[sr][sc] != -1) {
            return dp[sr][sc];
        }

        int x = memo(gm, sr - 1, sc + 1, dp);
        int y = memo(gm, sr, sc + 1, dp);
        int z = memo(gm, sr + 1, sc + 1, dp);
        int maxPath = Math.max(x, Math.max(y, z));
        maxPath += gm[sr][sc];
        dp[sr][sc] = maxPath;

        return dp[sr][sc];
    }

    public static int tab(int[][] gm) {
        int[][] dp = new int[gm.length][gm[0].length];
        for (int c = gm[0].length - 1; c >= 0; c--) {
            for (int r = 0; r < gm.length; r++) {
                if (c == gm[0].length - 1) {
                    dp[r][c] = gm[r][c];
                    continue;
                }
                int x = r - 1 >= 0 ? dp[r - 1][c + 1] : 0;
                int y = dp[r][c + 1];
                int z = r + 1 < gm.length ? dp[r + 1][c + 1] : 0;
                int maxPath = Math.max(x, Math.max(z, y));
                maxPath += gm[r][c];
                dp[r][c] = maxPath;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < gm.length; i++) {
            if (max < dp[i][0]) {
                max = dp[i][0];
            }
        }

        return max;
    }
}
