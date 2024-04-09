import java.util.*;
import java.io.*;
public class Main{
    static int[][] arr;
    static int[] ch;
    static int n,m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        ch = new int[n+1];
        arr = new int[n+1][n+1];
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        System.out.print(BFS(1));
    }
    
    public static int BFS(int s){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        ch[s] = 1;
        int cnt = 0;
        int len = Q.size();
        while(!Q.isEmpty()){
            for(int i=0;i<len;i++){
                int c = Q.poll();
                for(int j=1;j<=n;j++){
                    if(arr[c][j]==1 && ch[j]==0){
                        ch[j] = 1;
                        Q.offer(j);
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}