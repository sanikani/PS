import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long value = Long.parseLong(p);
        for(int i=0;i<t.length()-p.length()+1;i++){
            String s = "";
            if(i==t.length()-p.length()){
                s = t.substring(i);
            }else s = t.substring(i,i+p.length());
            if(Long.parseLong(s)<=value) answer++;
        }
        return answer;
    }
}