import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];
        s = s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            arr[(int)(s.charAt(i)-'a')]++;
        }
        int max = 0;
        int alphabet = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
                alphabet = i;
            }
        }
        Arrays.sort(arr);
        if(arr[25]==arr[24]){
            System.out.println("?");
        }else{
            System.out.println((char)(alphabet+'A'));
        }
    }
}