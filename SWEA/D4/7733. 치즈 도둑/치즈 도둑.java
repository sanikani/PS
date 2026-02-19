import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static boolean[][] visited;
    static boolean[][] eat;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int cnt;
    static int N;
    static int maxTaste;

    static ArrayList<int[]>[] posByTaste;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            maxTaste = 0;

            posByTaste = new ArrayList[101];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int v = Integer.parseInt(st.nextToken());
                    map[i][j] = v;
                    maxTaste = Math.max(maxTaste, v);

                    if (posByTaste[v] == null) posByTaste[v] = new ArrayList<>();
                    posByTaste[v].add(new int[]{i, j});
                }
            }

            sb.append('#').append(tc).append(' ').append(solution(map)).append('\n');
        }

        System.out.println(sb);
    }

    private static int solution(int[][] map) {
        int max = 1;
        eat = new boolean[N][N];

        for (int d = 1; d <= maxTaste; d++) {

            if (posByTaste[d] != null) {
                for (int[] p : posByTaste[d]) {
                    eat[p[0]][p[1]] = true;
                }
            } else {
                continue;
            }

            cnt = 0;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!eat[i][j] && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            if (cnt > max) max = cnt;
        }
        return max;
    }

    private static void bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (eat[nr][nc]) continue;
                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}