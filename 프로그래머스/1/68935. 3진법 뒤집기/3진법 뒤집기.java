import java.util.*;
class Solution {
    public int solution(int n) {
        int x = 1;
        while(n>=x){
            x *= 3;
        }
        x/=3;
        StringBuilder sb = new StringBuilder();
        while(x!=0){
            sb.append(n/x);
            n%=x;
            x/=3;
        }
        int y = 1;
        int answer = 0;
        for(String k : sb.toString().split("")){
            answer += y*Integer.parseInt(k);
            y *= 3;
        }
        return answer;
    }
}