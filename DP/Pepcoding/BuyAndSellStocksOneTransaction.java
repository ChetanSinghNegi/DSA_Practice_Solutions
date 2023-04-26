import java.io.*;
import java.util.*;

public class BuyAndSellStocksOneTransaction{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(BASS(arr));
    }
    public static int BASS(int[] arr){
        int s=arr[0];
        int max=0;
        for(int i=1;i<arr.length;i++){
            max=Math.max(max,arr[i]-s);
            if(arr[i]<s){
                s=arr[i];
            }
        }
        return max;
    }

}