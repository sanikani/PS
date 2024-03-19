package section09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 다익스트라2 {
    static int n,m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public static void main(String[] args) {
        다익스트라2 T = new 다익스트라2();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        T.solution(1);
        for (int i = 2; i <= n; i++) {
            if(dis[i]==Integer.MAX_VALUE) System.out.println(i + " : impossible");
            else System.out.println(i + " : " + dis[i]);
        }
    }

    private void solution(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int now = tmp.v;
            int nowCost = tmp.cost;
            if(dis[now]<nowCost) continue;
            for (Edge ob : graph.get(now)) {
                if (dis[ob.v] > nowCost + ob.cost) {
                    dis[ob.v] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.v, nowCost + ob.cost));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {

        public int v;
        public int cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;

        }
    }
}
