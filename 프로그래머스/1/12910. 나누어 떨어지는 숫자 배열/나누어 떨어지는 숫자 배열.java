import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int x : arr){
            if(x%divisor==0) list.add(x);
        }
        if(list.size()==0){
            int[] a = {-1};
            return a;
        }
        Collections.sort(list);
        return list.stream().mapToInt(i->i).toArray();
    }
}