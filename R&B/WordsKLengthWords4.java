import java.io.*;
import java.util.*;

public class WordsKLengthWords4 {

 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character,Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch,1);
        ustr += ch;
      }else{
          unique.put(ch,unique.get(ch)+1);
      }
    }
    helper(0,unique,ustr,"",k);

   
  }
  public static void helper(int currentBox,HashMap<Character,Integer> unique ,String ref,String curr,int k){
      if(curr.length()==k){
          System.out.println(curr);
          return;
      }
      // if(currentBox>=k){
      //     return;
      // }
      for(int i=0;i<ref.length();i++){
          char ch=ref.charAt(i);
          int val=unique.get(ch);
          if(val>0){
              unique.put(ch,val-1);
             helper(currentBox+1,unique,ref,curr+ch,k); 
              unique.put(ch,val);
          }
      }
  }

}