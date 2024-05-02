class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] sieve = new boolean[n+1];
     
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!sieve[i]) {
                for (int j = i * i; j <= n; j += i) {
                    sieve[j] = true;
                }
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (!sieve[i]) answer++;
        }
        
        return answer;
    }
}