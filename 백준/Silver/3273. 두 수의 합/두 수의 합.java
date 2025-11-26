import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());
        System.out.println(solution(N, arr, X));
    }
    
    private static int solution(int N, int[] arr, int X){
        Arrays.sort(arr);
        int sum = 0;
        int lt = 0;
        int rt = N-1;
        while(lt<rt){
            if(arr[lt]+arr[rt]>X){
                rt--;
            }else if(arr[lt]+arr[rt]<X){
                lt++;
            }else{
                sum++;
                rt--;
                lt++;
            }
        }
        return sum;
    }
}