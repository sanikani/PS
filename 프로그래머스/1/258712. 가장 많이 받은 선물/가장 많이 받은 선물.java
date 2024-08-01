import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> giftValue = new HashMap<>();
        Map<String, Map<String, Integer>> giftMap = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();
        int answer = Integer.MIN_VALUE;
        
        for(String friend : friends){
            giftValue.put(friend, 0);
            giftMap.put(friend, new HashMap<>());
            answerMap.put(friend,0);
        }
        
        for(String gift : gifts){
            String[] tmp = gift.split(" ");
            Map<String, Integer> map = giftMap.get(tmp[0]);
            map.put(tmp[1],map.getOrDefault(tmp[1],0)+1);
            giftValue.put(tmp[0],giftValue.get(tmp[0])+1);
            giftValue.put(tmp[1],giftValue.get(tmp[1])-1);
        }
        
        for(int i=0;i<friends.length-1;i++){
            for(int j=i+1;j<friends.length;j++){
                if(giftMap.get(friends[i]).getOrDefault(friends[j],0)>giftMap.get(friends[j]).getOrDefault(friends[i],0)){
                    answerMap.put(friends[i],answerMap.get(friends[i])+1);
                }else if(giftMap.get(friends[j]).getOrDefault(friends[i],0)>giftMap.get(friends[i]).getOrDefault(friends[j],0)){
                    answerMap.put(friends[j],answerMap.get(friends[j])+1);
                }else{
                    if(giftValue.get(friends[i])>giftValue.get(friends[j])){
                        answerMap.put(friends[i],answerMap.get(friends[i])+1);
                    }else if(giftValue.get(friends[j])>giftValue.get(friends[i])){
                        answerMap.put(friends[j],answerMap.get(friends[j])+1);
                    }   
                }
            }
            answer = Math.max(answer,answerMap.get(friends[i]));
        }
        
        return answer;
    }
}