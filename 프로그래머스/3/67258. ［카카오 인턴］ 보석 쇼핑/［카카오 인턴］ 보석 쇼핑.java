import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int total = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        
        int[] result = new int[2];

        for(int right = 0; right < gems.length; right++){
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            
            while(map.size() == total){
                if(right - left < minLen){
                    minLen = right - left;
                    result[0] = left + 1;
                    result[1] = right + 1;
                }
                
                map.put(gems[left], map.get(gems[left]) - 1);
                if(map.get(gems[left]) == 0){
                    map.remove(gems[left]);
                }
                left++;
                
            }
        }
        return result;
    }
}