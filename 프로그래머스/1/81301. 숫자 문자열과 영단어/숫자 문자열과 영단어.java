import java.util.*;
class Solution {
    public int solution(String s) {
        
        Map<String,String> map = Map.of(
                "zero","0",
                "one", "1",
                "two", "2",
                "three", "3",
                "four", "4",
                "five","5",
                "six","6",
                "seven","7",
                "eight","8",
                "nine","9");
        
        char arr[] = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder(); 
        
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(arr[i])){
                sb.append(arr[i]);
                if(map.containsKey(sb.toString())){
                    answer.append(map.get(sb.toString()));
                    sb.setLength(0);
                }
            }else{
                answer.append(arr[i]);
            }
        }
        
        return Integer.valueOf(answer.toString());
    }
}