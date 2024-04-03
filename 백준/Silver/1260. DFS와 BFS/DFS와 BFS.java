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
        ch[v] = 1;
        System.out.print(v+" ");
        while (!Q.isEmpty()) {
            int c = Q.poll();
                for (int i = 1; i <= n; i++) {
                    if (ch[i] == 0 && arr[c][i] == 1) {
                        ch[i] = 1;
                        System.out.print(i+" ");
                        Q.offer(i);
                    }
                }
        }
    }
}
