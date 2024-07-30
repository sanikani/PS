import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, List<String>> reportMap = new HashMap<>();
        int[] answer = new int[id_list.length];
        
        for(String s : id_list){
            reportCount.put(s,0);
            reportMap.put(s,new ArrayList<>());
        }
        
        for(String s : report){
            String[] tmp = s.split(" ");
            if(reportMap.get(tmp[0]).contains(tmp[1])) continue;
            reportMap.get(tmp[0]).add(tmp[1]);
            reportCount.put(tmp[1],reportCount.get(tmp[1])+1);
        }
        
        for(int i=0;i<id_list.length;i++){
            List<String> l = reportMap.get(id_list[i]);
            for(String s : l){
                if(reportCount.get(s)>=k) answer[i]++;
            }
        }
        
        return answer;
    }
}