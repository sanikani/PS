import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        int min = 100;
        
        for(int i = 0; i < wires.length; i++){
            min = Math.min(min, bfs(graph, wires, i, n));
        }
        
        return min;
    }
    
    public int bfs(List<List<Integer>> graph, int[][] wires, int i, int n){
        int deletedStart = wires[i][0];
        int deletedEnd = wires[i][1];
        
        boolean[] vis = new boolean[n + 1];
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(deletedStart);
        vis[deletedStart] = true;
        
        int cnt = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph.get(cur)){
                if((cur == deletedStart && next == deletedEnd) 
                   || (cur == deletedEnd && next == deletedStart)) continue;
                if(vis[next]) continue;
                vis[next] = true;
                cnt++;
                q.offer(next);
            }
        }
        
        return Math.abs(n - 2 * cnt);
    }
}