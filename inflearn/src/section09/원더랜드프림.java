package section09;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 원더랜드프림 {
    static int[] ch;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        ch = new int[v + 1];
        List<List<Edge>> list = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            list.get(a).add(new Edge(b, c));
            list.get(b).add(new Edge(a, c));
        }
        System.out.println(solution(list));
    }

    private static int solution(List<List<Edge>> list) {
        int total = 0;
        PriorityQueue<Edge> Q = new PriorityQueue<>();
        Q.offer(new Edge(1, 0));
        ch[1] = 1;
        Q.addAll(list.get(1));
        while (!Q.isEmpty()) {
            Edge tmp = Q.poll();
            if(ch[tmp.v]==0) {
                total+=tmp.c;
                ch[tmp.v] = 1;
            }
            for (Edge e : list.get(tmp.v)) {
                if (ch[e.v] == 0) {
                    Q.add(e);
                }
            }
        }
        return total;
    }

    public static class Edge implements Comparable<Edge>{
        int v;
        int c;

        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }

    }
}
