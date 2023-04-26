import java.io.*;
import java.util.*;

public class CountABCSubsequences {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        int x=0,y=0,z=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='a'){
                x=2*x+1;
            }else if(ch=='b'){
                y=x+2*y;
            }else if(ch=='c'){
                z=y+2*z;
            }
        }
        System.out.println(z);
    }
}