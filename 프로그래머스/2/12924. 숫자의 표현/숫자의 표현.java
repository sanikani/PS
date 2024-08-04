class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 1;
        int sum = 0;
        int minNum = 1;
        while(cnt<=n){
            if(sum == n){
                answer++;
                sum+=cnt++;
            }
            else if(sum<n) sum+=cnt++;
            else{
                sum -= minNum++;
            }
        }
        return answer+1;
    }
}