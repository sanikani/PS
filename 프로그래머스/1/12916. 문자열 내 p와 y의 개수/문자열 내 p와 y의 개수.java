import java.util.*;
class Solution {
    boolean solution(String s) {
        int a = 0;
        s = s.toLowerCase();
        for(String x : s.split("")){
            if(x.equals("p")) a++;
            else if(x.equals("y")) a--;
        }
        if(a==0) return true;
        return false;
    }
}