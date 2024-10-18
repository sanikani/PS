import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int size : tangerine){
            map.put(size,map.getOrDefault(size,0)+1);
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        int total = 0;

        for(int key : keySet){
            total += map.get(key);
            answer++;
            if(total>=k){
                return answer;
            }
        }
        return answer;
    }
}