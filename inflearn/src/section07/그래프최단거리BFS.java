package section07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그래프최단거리BFS {
    public static int[] dis;
    public static int[][] arr;
    public static int[] ch;
    public static int N, M;
    public static Queue<Integer> Q;
    public static void main(String[] args) throws IOException {
        그래프최단거리BFS T = new 그래프최단거리BFS();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dis = new int[N + 1];
        ch = new int[N + 1];
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        Q = new LinkedList<>();
        Q.offer(1);
        ch[1]=1;
        T.BFS();
        for (int i = 1; i < dis.length; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }

    public void BFS() {
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int j = 1; j <= N; j++) {
                    if (arr[x][j] == 1 && ch[j] == 0) {
                        Q.offer(j);
                        ch[j] = 1;
                        dis[j]=L+1;
                    }
                }
            }
            L++;
        }

    }
}
