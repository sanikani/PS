class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a){
            if(n%a==0){
                answer += (n/a)*b;
                n = (n/a)*b;
            }else{
                int x = n/a;
                answer += x*b;
                n = n - (n/a)*a + (n/a)*b;
            }
        }
        return answer;
    }
}