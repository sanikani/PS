import java.util.*;
class Solution {
    public int[] solution(String s) {
        int loop = 0;
        int zeroCnt = 0;
        while(s.length()!=1){
            int cnt = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1') cnt++;
            }
            zeroCnt += s.length()-cnt;
            s = Integer.toBinaryString(cnt);
            loop++;
        }
        return new int[]{loop,zeroCnt};
    }
}