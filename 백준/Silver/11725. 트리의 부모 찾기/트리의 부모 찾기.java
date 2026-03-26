import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }
        boolean[] vis = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        vis[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int k : graph.get(cur)) {
                if(vis[k]) continue;
                vis[k] = true;
                parent[k] = cur;
                q.offer(k);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 2; k <= n; k++) {
            sb.append(parent[k]).append('\n');
        }
        System.out.println(sb);

    }
}
