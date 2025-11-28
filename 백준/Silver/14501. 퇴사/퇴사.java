import java.util.*;
import java.io.*;

public class Main{
    static int[][] reservation;
    static int max;
    static int N;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = 0;
        reservation = new int[N+1][2];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            reservation[i][0] = Integer.parseInt(st.nextToken());
            reservation[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(1,0);
        System.out.println(max);
    }
    
    private static void dfs(int day, int total){
        if(day==N+1){
            max = Math.max(max, total);
        }else{
            if(day+reservation[day][0]<=N+1){
                dfs(day + reservation[day][0], total + reservation[day][1]);
            }
            dfs(day + 1, total);
        }
    }
}