import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] answer = new int[N];
        int total = stages.length;
        Arrays.sort(stages);
        List<Rate> list = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            list.add(new Rate(i+1,0));
        }
        
        for(int i=0;i<stages.length-1;i++){
            if(stages[i]==N+1) break;
            int length = stages.length - i;
            int cnt = 1;
            
            for(int j=i;j<stages.length-1;j++){
                if(stages[j]!=stages[j+1]) break;
                cnt++;
            }
            
            float fail = (float)cnt/length;
            list.get(stages[i]-1).fail = fail;
            i = i + cnt-1;
        }
        
        Collections.sort(list);
        int idx = 0;
        
        for(Rate r : list){
            answer[idx++] = r.stage;
        }
        
        return answer;
    }
    
    public static class Rate implements Comparable<Rate>{
        
        int stage;
        float fail;
        
        public Rate(int s, float f){
            stage = s;
            fail = f;
        }
        
        @Override
        public int compareTo(Rate rate){            
            if(this.fail>rate.fail) return -1;
            if(this.fail<rate.fail) return 1;
            return 0;
        }
    }
}