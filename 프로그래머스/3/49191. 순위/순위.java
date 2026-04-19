import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<Integer>[] winGraph = new ArrayList[n + 1];
        List<Integer>[] loseGraph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            winGraph[i] = new ArrayList<>();
            loseGraph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < results.length; i++){
            int win = results[i][0];
            int lose = results[i][1];
            
            winGraph[win].add(lose);
            loseGraph[lose].add(win);
        }
        
        for(int i = 1; i<= n; i++){
            if(checkRank(winGraph, i) + checkRank(loseGraph, i) == n - 1) answer++;
        }
        
        return answer;
    }
    
    public int checkRank(List<Integer>[] graph, int num){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[graph.length];
        int cnt = 0;
        for(int next: graph[num]){
            q.offer(next);
            cnt++;
            vis[next] = true;
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next: graph[cur]){
                if(vis[next]) continue;
                q.offer(next);
                ++cnt;
                vis[next] = true;
            }
        }
        
        return cnt;
    }
}