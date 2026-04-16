import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(computers[i][j] == 0 || i == j) continue;
                graph.get(i).add(j);
            }
        }
        
        int cnt = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(vis[i]) continue;
            cnt++;
            bfs(i, vis, graph);
        }
        
        return cnt;
    }
    
    static void bfs(int start, boolean[] vis, List<List<Integer>> graph){
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        vis[start] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph.get(cur)){
                if(vis[next]) continue;
                vis[next] = true;
                q.offer(next);
            }
        }
    }
}