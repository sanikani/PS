import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<keymap.length;i++){
            int button = 1;
            for(String s : keymap[i].split("")){
                map.put(s,Math.min(map.getOrDefault(s,button),button));
                button++;
            }
        }
        for(int i=0;i<targets.length;i++){
            int cnt = 0;
            for(String s : targets[i].split("")){
                int c = map.getOrDefault(s,0);
                if(c == 0){
                    cnt = 0;
                    break;
                }
                cnt += c;
            }
            if(cnt == 0) answer[i] = -1;
            else answer[i] = cnt;
        }
        return answer;
    }
}