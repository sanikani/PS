class Solution {
    public int solution(int num) {
        int cnt = 0;
        long number = num;
        while(number!=1){
            if(cnt==500) return -1;
            if(number%2==0) number = number/2;
            else number = number*3+1;
            cnt++;
        }
        return cnt;
    }
}