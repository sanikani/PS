import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        List<Integer> idx = new ArrayList<>();
        
        for(int i=0;i<skip.length();i++){
            idx.add(skip.charAt(i)-'a');
        }
        // Collections.sort(idx);
        
        for(int i=0;i<s.length();i++){
            int k = s.charAt(i)-'a';
            int a = index;
            for(int j=0;j<a;j++){
                k++;
                if(k>25) k = 0;
                if(idx.contains(k)) a++;
            }
            answer += (char)(k+'a');
        }
        return answer;
    }
}