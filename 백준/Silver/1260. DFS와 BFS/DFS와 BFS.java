import java.util.*;
import java.io.*;
public class Main{
    static int[][] arr;
    static int n;
    static int[] ch;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        ch = new int[n+1];
        arr =new int[n+1][n+1];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        ch[v] = 1;
        System.out.print(v + " ");
        DFS(v);
        System.out.println();
        Arrays.fill(ch, 0);
        BFS(v);
        }

    public static void DFS(int v){
        for (int i = 1; i <= n; i++) {
            if (arr[v][i] == 1 && ch[i] == 0) {
                ch[i] = 1;
                System.out.print(i+" ");
                DFS(i);
            }
        }
    }

    public static void BFS(int v){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int c = Q.poll();
                if (ch[c] == 0) {
                    ch[c] = 1;
                    System.out.print(c+" ");
                    for (int j = 1; j <= n; j++) {
                        if (ch[j] == 0 && arr[c][j] == 1) {
                            Q.offer(j);
                        }
                    }
                }
            }
        }
    }
}
