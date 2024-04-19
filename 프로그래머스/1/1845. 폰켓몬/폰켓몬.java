import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }
        return Math.min(set.size(),nums.length/2);
    }
}