import java.io.*;
import java.util.*;

public class FriendsPairing2 {
  static int counter = 1;

  public static void solution(int n, boolean[] used, String asf) {
    // write your code here
    int i = 0;
    for (int j = 1; j <= n; j++) {
      if (used[j] == false) {
        i = j;
        break;
      }
    }
    if (i == 0) {
      System.out.println(counter + "." + asf);
      counter++;
      return;
    }
    used[i] = true;
    String currAns = asf + "(" + i + ") ";
    solution(n, used, currAns);

    for (int j = 1; j <= n; j++) {
      if (used[j] == false) {
        used[j] = true;
        String currPairAns = asf + "(" + i + "," + j + ") ";
        solution(n, used, currPairAns);
        used[j] = false;
      }
    }
    used[i] = false;
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    solution(n, used, "");
  }
}
