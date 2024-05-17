import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> pMap = new HashMap<>();
        Map<String, Integer> cMap = new HashMap<>();
        
        for(int i=0;i<participant.length-1;i++){
            cMap.put(completion[i],cMap.getOrDefault(completion[i],0)+1);
            
        }
        for(int i=0;i<participant.length;i++){
            // pMap.put(participant[i],pMap.getOrDefault(participant[i],0)+1);
            if(cMap.get(participant[i])==null) return participant[i];
            else{
                cMap.put(participant[i],cMap.get(participant[i])-1);
                if(cMap.get(participant[i])<0) return participant[i];
            }
        }
        return "answer";
    }
}

