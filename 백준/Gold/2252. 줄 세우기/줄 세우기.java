import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] edgeCnt = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edgeCnt[b]++;
            graph.get(a).add(b);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (edgeCnt[i] == 0) {
                q.offer(i);
                vis[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(' ');

            for (int next : graph.get(cur)) {
                if(vis[next]) continue;
                edgeCnt[next]--;
                if (edgeCnt[next] == 0) {
                    q.offer(next);
                    vis[next] = true;
                }
            }
        }
        System.out.println(sb);
    }
}
