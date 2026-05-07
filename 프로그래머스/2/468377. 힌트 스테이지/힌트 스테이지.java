import java.util.*;

class Solution {
    static int min;
    
    public int solution(int[][] cost, int[][] hint) {
        min = Integer.MAX_VALUE;
        dfs(0, 0, cost, hint, new int[cost.length + 1]);
        return min;
    }
    
    public void dfs(int c, int l, int[][] cost, int[][] hint, int[] h){
        if(l == cost.length){
            min = Math.min(min, c);
            return;
        }

        //문제 해결 비용 구하기
        int cc = cost[l][cost.length - 1];
        if(h[l + 1] < cost.length){
           cc = cost[l][h[l + 1]];
        }

        //힌트 번들 구매
        if(l != cost.length - 1){
            for(int i = 1; i < hint[0].length; i++){
                h[hint[l][i]]++;
            }
            
            dfs(c + cc + hint[l][0], l + 1, cost, hint, h);
            
            for(int i = 1; i < hint[0].length; i++){
                h[hint[l][i]]--;
            }
        }

        //힌트 번들 구매 X
        dfs(c + cc, l + 1, cost, hint, h);
    }
}