import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] su1 = {1,2,3,4,5};
        int[] su2 = {2,1,2,3,2,4,2,5};
        int[] su3 = {3,3,1,1,2,2,4,4,5,5};
        int[] cnt = new int[4];
        for(int i=0;i<answers.length;i++){
            int answer = answers[i];
            if(su1[i%5]==answer) cnt[1]++;
            if(su2[i%8]==answer) cnt[2]++;
            if(su3[i%10]==answer) cnt[3]++;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=2;i<4;i++){
            if(cnt[list.get(list.size()-1)]<cnt[i]){
                list.clear();
                list.add(i);
            }else if(cnt[list.get(list.size()-1)]==cnt[i]){
                list.add(i);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}