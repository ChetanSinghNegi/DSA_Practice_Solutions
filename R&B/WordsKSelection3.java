import java.io.*;
import java.util.*;

public class WordsKSelection3 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }
    helper(0, ustr, unique, "", k);
  }

  public static void helper(int idx, String ref, HashMap<Character, Integer> unique, String curr, int k) {
    if (curr.length() == k) {
      System.out.println(curr);
      return;
    }

    if (idx >= ref.length()) {
      return;
    }
    char ch = ref.charAt(idx);
    int val = unique.get(ch);
    for (int i = val; i >= 0; i--) {
      if (curr.length() + i > k) {
        continue;
      }
      String appending = "";
      for (int j = 0; j < i; j++) {
        appending += ch;
      }
      helper(idx + 1, ref, unique, curr + appending, k);
    }
  }

}