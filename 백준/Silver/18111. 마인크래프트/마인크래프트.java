import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int min = Integer.MAX_VALUE;
        int height = 0;
        
        for(int i=0; i<=256; i++){
            int result = flatten(N,M,B,map,i);
            if(result < min){
                min = result;
                height = i;
            }else if(result == min){
                if(i > height){
                    min = result;
                    height = i;
                }
            }
        }
        
        System.out.print(min + " " + height);
    }
    
    static int flatten(int N, int M, int B, int[][] map, int height){
        int time = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]>height){
                    int x = map[i][j] - height;
                    time += 2*x;
                    B += x;
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]<height){
                    int x = height - map[i][j];
                    time += x;
                    B -= x;
                    if(B<0){
                        return Integer.MAX_VALUE;
                    }
                }
            }
        }
        return time;
    }
}