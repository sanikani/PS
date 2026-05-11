import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][m];
        vis[0][0] = true;
        q.offer(new int[]{0, 0, 1});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d = 0; d < 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if(maps[nr][nc] == 0) continue;
                if(vis[nr][nc]) continue;
                if(nr == n - 1 && nc == m - 1) return cur[2] + 1;
                vis[nr][nc] = true;
                q.offer(new int[]{nr, nc, cur[2] + 1});
            }
        }
        return -1;
    }
}