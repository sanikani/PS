class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(b>=a){
            int tmp = a;
            a = b;
            b = tmp;
        }
        for(int i=b;i<=a;i++) answer += i;
        return answer;
    }
}