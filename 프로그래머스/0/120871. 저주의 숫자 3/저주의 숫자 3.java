import java.util.*;
class Solution {
    public int solution(int n) {
        int cnt = 1;
        int i = 1;
        while(cnt<=n){
            if(i%3!=0&&!String.valueOf(i).contains("3")){
                cnt++;
            }
            i++;
        }
        return i-1;
    }
}