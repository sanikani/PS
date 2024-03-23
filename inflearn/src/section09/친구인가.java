package section09;

import java.util.*;

public class 친구인가 {
    static int[] ch;
    public static void main(String[] args) {
        친구인가 T = new 친구인가();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        ch = new int[n+1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            list.get(s).add(e);
            list.get(e).add(s);
        }
        System.out.println(T.BFS(in.nextInt(), in.nextInt(),list));
    }

    private String BFS(int s, int e, List<List<Integer>> list) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        while (!Q.isEmpty()) {
            int c = Q.poll();
            if (c==e) {
                return "YES";
            } else {
                if (ch[c] == 0) {
                    ch[c] = 1;
                    for (int x : list.get(c)) {
                        Q.offer(x);
                    }
                }
            }
        }
        return "NO";
    }

}
