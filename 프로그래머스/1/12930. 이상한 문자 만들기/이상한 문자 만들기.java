import java.util.*;
class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        int check = 0;
        StringBuilder sb = new StringBuilder();
        for(char a : arr){
            if(a==' '){
                sb.append(a);
                check = 0;
            } else{
                if(check%2==0) sb.append(Character.toUpperCase(a));
                else sb.append(Character.toLowerCase(a));
                check++;
            }
        }
        return sb.toString();
    }
}