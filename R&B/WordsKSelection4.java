import java.io.*;
import java.util.*;

public class WordsKSelection4 {


  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int k = scn.nextInt();

    HashMap<Character,Integer> unique = new HashMap<>();
    ArrayList<Character> chs=new ArrayList<>();
    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        if(!unique.containsKey(ch)){
            chs.add(ch);
            unique.put(ch,1);
        }
        else{
            unique.put(ch,unique.get(ch)+1);
        }
    }

    combination(unique,0, chs, 0, k, "");
  }


  public static void combination(HashMap<Character,Integer> unique, int idx, ArrayList<Character> chs, int lastIdx, int k, String asf ) {
    if(asf.length()==k){
        System.out.println(asf);
        return;
    }
    if(idx>=k){
        return ;
    }
    for(int i=lastIdx;i<chs.size();i++){
        char ch=chs.get(i);
        int val=unique.get(ch);    
        if(val>0){
            unique.put(ch,val-1);
            combination(unique,idx+1,chs,i,k,asf+ch);
            unique.put(ch,val);
        }
    }
  }

}