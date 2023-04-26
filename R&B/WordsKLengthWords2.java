import java.io.*;
import java.util.*;

public class WordsKLengthWords2 {

 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    helper(0,unique,ustr,"",k);

   
  }
  public static void helper(int currentBox,HashSet<Character> unique ,String ref,String curr,int k){
      if(curr.length()==k){
          System.out.println(curr);
          return;
      }
      // if(currentBox>=k){
      //     return;
      // }
      for(int i=0;i<ref.length();i++){
          char ch=ref.charAt(i);
          if(unique.contains(ch)){
              unique.remove(ch);
             helper(currentBox+1,unique,ref,curr+ch,k); 
              unique.add(ch);
          }
      }
  }

}