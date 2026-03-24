import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final char OFFSET = 'a';
    static Node root;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int k = Integer.parseInt(br.readLine());
            s = br.readLine();
            root = new Node();

            for (int i = 0; i < s.length(); i++) {
                insert(i);
            }

            sb.append('#').append(tc).append(' ').append(findKth(k)).append('\n');
        }
        System.out.println(sb);
    }

    static class Node{
        int cnt;
        Node[] child;
        boolean isWord;

        public Node() {
            cnt = 0;
            child = new Node[26];
            isWord = false;
        }
    }

    static void insert(int start) {
        Node cur = root;

        for (int i = start; i < s.length(); i++) {
            int idx = s.charAt(i) - OFFSET;

            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
            }

            cur = cur.child[idx];

            if (!cur.isWord) {
                cur.isWord = true;
                increaseCount(start, i);
            }
        }
    }

    static void increaseCount(int start, int end) {
        Node cur = root;
        cur.cnt++;

        for (int i = start; i <= end; i++) {
            int idx = s.charAt(i) - OFFSET;
            cur = cur.child[idx];
            cur.cnt++;
        }
    }

    static String findKth(int k) {
        if (root.cnt < k) return "none";

        StringBuilder sb = new StringBuilder();
        Node cur = root;

        while (true) {
            for (int i = 0; i < 26; i++) {
                if (cur.child[i] == null) continue;

                Node next = cur.child[i];

                if (next.cnt < k) {
                    k -= next.cnt;
                } else {
                    sb.append((char) (i + OFFSET));
                    cur = next;

                    if (cur.isWord) {
                        k--;
                        if (k == 0) return sb.toString();
                    }
                    break;
                }
            }
        }
    }
}
