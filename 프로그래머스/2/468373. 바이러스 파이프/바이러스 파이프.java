import java.util.*;
class Solution {
    static List<Integer>[][] graph;
    static int K;
    static int max;
    static int N;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        int answer = 0;
        K = k;
        N = n;
        graph = new ArrayList[n + 1][3];
        max = 0;
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 3; j++){
                graph[i][j] = new ArrayList<>();
            }
        }
        
        for(int i = 0; i < n - 1; i++){
            int start = edges[i][0];
            int to = edges[i][1];
            int type = edges[i][2];
            
            graph[start][type - 1].add(to);
            graph[to][type - 1].add(start);
        }
        
        dfs(0, Set.of(infection));
        return max;
    }
    
    public void dfs(int level, Set<Integer> infections){
        if(level == K){
            max = Math.max(max, infections.size());
            return;
        }
        
        //infections 복사 후 감염시키고, 다음으로 진행
        for(int type = 0; type < 3; type++){
            Set<Integer> next = applyInfection(infections, type);
            next.addAll(infections);
            dfs(level + 1, next);
        }
    }
    
    public Set<Integer> applyInfection(Set<Integer> infections, int type){
        Set<Integer> result = new HashSet<>();
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int infection : infections){
            q.offer(infection);
        }
        
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph[cur][type]){
                if(result.contains(next)) continue;
                q.offer(next);
                result.add(next);
            }
        }
        
        return result;
    }
}