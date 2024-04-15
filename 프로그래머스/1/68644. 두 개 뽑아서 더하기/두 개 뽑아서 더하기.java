import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Arrays.sort(numbers);
        int len = numbers.length;
        int[] ch = new int[numbers[len-1]+numbers[len-2]+1];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<numbers.length;j++){
                if(i==j) continue;
                if(ch[numbers[i]+numbers[j]]==0){
                    list.add(numbers[i]+numbers[j]);
                    ch[numbers[i]+numbers[j]] = 1;
                }
            }
        }
        int[] answer = list.stream().sorted().mapToInt(i->i).toArray();
        return answer;
    }
}