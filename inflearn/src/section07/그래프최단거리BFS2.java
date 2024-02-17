package section07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그래프최단거리BFS2 {
    static int n,m= 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public void BFS(int x) {
        Queue<Integer> Q = new LinkedList<>();
        ch[x] = 1;
        dis[x] = 0;
        Q.offer(x);
        while (!Q.isEmpty()) {
            int val = Q.poll();
            for (int k : graph.get(val)) {
                if (ch[k] == 0) {
                    Q.offer(k);
                    ch[k] = 1;
                    dis[k] = dis[val] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        그래프최단거리BFS2 T = new 그래프최단거리BFS2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dis = new int[n + 1];
        ch = new int[n + 1];
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        T.BFS(1);
        for (int i = 0; i < dis.length; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
