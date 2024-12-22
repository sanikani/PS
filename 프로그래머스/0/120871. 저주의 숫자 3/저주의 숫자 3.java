import java.util.*;
class Solution {
    public int solution(int n) {
        int cnt = 1;
        int i = 1;
        while(cnt<=n){
            String s = String.valueOf(i);
            if(i%3!=0&&!isContainThree(s)){
                cnt++;
            }
            i++;
        }
        return i-1;
    }
    
    public boolean isContainThree(String s){
        for(String st : s.split("")){
            if(st.equals("3")){
                return true;
            }
        }
        return false;
    }
}