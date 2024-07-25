import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> map = new HashMap<>();
        String[] keySet = {"R","T","C","F","J","M","A","N"};
        for(String key : keySet) map.put(key,0);

        for(int i=0;i<survey.length;i++){
            String[] tmp = survey[i].split("");
            if(choices[i]==1||choices[i]==2||choices[i]==3){
                map.put(tmp[0],map.get(tmp[0])+Math.abs(choices[i]-4));
            }else if(choices[i]==4) continue;
            else{
                map.put(tmp[1],map.get(tmp[1])+choices[i]-4);
            }
        }
        System.out.println(map);
        for(int i=0;i<8;i+=2){
            if(map.get(keySet[i])>map.get(keySet[i+1])) sb.append(keySet[i]);
            else if(map.get(keySet[i])<map.get(keySet[i+1])) sb.append(keySet[i+1]);
            else{
                if(keySet[i].compareTo(keySet[i+1])>0) sb.append(keySet[i+1]);
                else sb.append(keySet[i]);
            }
        }
        return sb.toString();
    }
}