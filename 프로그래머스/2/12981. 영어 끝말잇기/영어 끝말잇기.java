import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        int k = 0;
        
        for(int i=1;i<words.length;i++){
            String pre = list.get(i-1);
            if(pre.charAt(pre.length()-1)!=words[i].charAt(0) || list.contains(words[i])){
                k = i;
                System.out.println(words[i]);
                break;
            }
            list.add(words[i]);
        }
        
        if(k==0){
            return new int[]{0,0};
        }
        return new int[]{k%n+1,k/n+1};
    }
}