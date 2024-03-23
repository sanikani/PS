package section09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 원더랜드크루스칼 {
    static int[] unf;

    public static int Find(int a) {
        if (unf[a] == a) {
            return a;
        } else return Find(unf[a]);
    }

    public static void Union(int a, int b) {
        if(Find(a)!=Find(b)) unf[Find(a)] = Find(b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        unf = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            list.add(new Node(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        System.out.println(solution(list));

    }

    public static int solution(List<Node> list) {
        int total = 0;
        Collections.sort(list);
        for (Node node : list) {
            if (Find(node.s) != Find(node.e)) {
                Union(node.s,node.e);
                total += node.p;
            }
        }
        return total;
    }

    public static class Node implements Comparable<Node>{
        int s;
        int e;
        int p;

        public Node(int s, int e, int p) {
            this.s = s;
            this.e = e;
            this.p = p;
        }

        @Override
        public int compareTo(Node o) {
            return this.p - o.p;
        }
    }
}
