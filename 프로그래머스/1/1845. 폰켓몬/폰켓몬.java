import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int size = nums.length/2;
        if(map.size()>size) return size;
        else return map.size();
    }
}