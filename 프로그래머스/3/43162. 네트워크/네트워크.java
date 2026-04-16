import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int cnt = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(vis[i]) continue;
            cnt++;
            bfs(i, vis, computers, n);
        }
        
        return cnt;
    }
    
    static void bfs(int start, boolean[] vis, int[][] computers, int n){
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        vis[start] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i = 0; i < n; i++){
                if(vis[i] || computers[cur][i] == 0) continue;
                vis[i] = true;
                q.offer(i);
            }
        }
    }
}