import java.io.*;
import java.util.*;

public class WordsKSelection1 {


  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int k = scn.nextInt();

    HashSet<Character> unique = new HashSet<>();
    ArrayList<Character> chs=new ArrayList<>();
    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        if(!unique.contains(ch)){
            chs.add(ch);
        }
        unique.add(ch);
    }

    combination(0, chs, -1, k, "");
  }


  public static void combination(int idx, ArrayList<Character> chs, int lastIdx, int k, String asf ) {
    if(asf.length()==k){
        System.out.println(asf);
        return;
    }
    for(int i=lastIdx+1;i<chs.size();i++){
        combination(idx+1,chs,i,k,asf+chs.get(i));
    }
  }

}