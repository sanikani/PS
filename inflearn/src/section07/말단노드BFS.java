package section07;

import java.util.LinkedList;
import java.util.Queue;

public class 말단노드BFS {
    Node root;
    Queue<Node> Q = new LinkedList<>();
    public int BFS(int L, Node root) {
        Q.offer(root);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node poll = Q.poll();
                if (poll.lt == null && poll.rt == null) {
                    return L;
                }
                if(poll.lt!=null) Q.offer(poll.lt);
                if(poll.rt!=null) Q.offer(poll.rt);
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {
        말단노드BFS tree = new 말단노드BFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(0, tree.root));
    }
}

