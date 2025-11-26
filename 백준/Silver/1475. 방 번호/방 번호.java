import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
    }
    
    private static int solution(int n){
        int[] arr = new int[10];
        String s = String.valueOf(n);
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'0']++;
        }
        arr[6] = (arr[9]+arr[6]+1)/2;
        arr[9] = 0;
        return Arrays.stream(arr).max().getAsInt();
    }
}