import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i=N; i<=M; i++){
            if(isPrime(i)) sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }
    
    public static boolean isPrime(int n){
        if(n<2) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        
        for(int i=3; i*i<=n; i+=2){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
