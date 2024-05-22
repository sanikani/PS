import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        for(int i=0;i<=9;i++){
            xMap.put(i,0);
            yMap.put(i,0);
        }
        for(int i=0;i<X.length();i++){
            int k = X.charAt(i)-'0';
            xMap.put(k,xMap.get(k)+1);
        }
        for(int i=0;i<Y.length();i++){
            int k = Y.charAt(i)-'0';
            yMap.put(k,yMap.get(k)+1);
        }
        for(int i=9;i>=0;i--){
            int x = xMap.get(i);
            int y = yMap.get(i);
            int k = 0;
            while(k<x && k<y){
                sb.append(Integer.valueOf(i));
                k++;
            }
        }
        String answer = sb.toString();
        if(answer.equals("")) return "-1";
        else if(answer.charAt(0)=='0') return "0";
        return answer;
    }
}
