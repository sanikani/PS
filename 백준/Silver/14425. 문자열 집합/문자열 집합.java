import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final char OFFSET = 'a';
    static class Node{
        boolean isEnd;
        Node[] childs = new Node['z' - OFFSET + 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node start = new Node();
        //
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Node cur = start;
            int idx = 0;
            while (idx < s.length()) {
                Node child = cur.childs[s.charAt(idx) - OFFSET];
                if (child == null) {
                    cur.childs[s.charAt(idx) - OFFSET] = new Node();
                    child = cur.childs[s.charAt(idx) - OFFSET];
                }
                cur = child;
                idx++;
            }
            cur.isEnd = true;
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if(isContains(s, start)) cnt++;
        }

        System.out.println(cnt);
    }

    static boolean isContains(String s, Node start) {
        int idx = 0;
        Node cur = start;
        while (idx < s.length()) {
            Node child = cur.childs[s.charAt(idx) - OFFSET];
            if (child == null) {
                return false;
            }
            cur = child;
            idx++;
        }
        return cur.isEnd;
    }
}
