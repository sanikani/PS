import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 1;
        if(s.charAt(0)=='-'){
            s = s.substring(1);
            answer *= -1;
        }
        int a = Integer.parseInt(s);
        return answer*a;
    }
}