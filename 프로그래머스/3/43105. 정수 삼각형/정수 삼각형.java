import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int h = triangle.length;
        int[][] dp = new int[h + 1][h + 1];
        
        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= i; j++){
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i - 1][j - 1];
            }
        }
        
        return Arrays.stream(dp[h]).max().getAsInt();
    }
}