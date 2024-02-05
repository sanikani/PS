package section07;

import java.util.LinkedList;
import java.util.Queue;

public class 이진트리레벨탐색 {
    Node root;

    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            System.out.print(L+" : ");
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null)
                    Q.offer(cur.lt);
                if (cur.rt != null)
                    Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }

    }

    public static void main(String[] args) {
        이진트리레벨탐색 T = new 이진트리레벨탐색();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        T.root.rt.lt = new Node(6);
        T.root.rt.rt = new Node(7);
        T.BFS(T.root);
    }
}