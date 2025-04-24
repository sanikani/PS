import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<progresses.length;i++){
            int remain = 100 - progresses[i];
            int time = remain/speeds[i];
            if(remain%speeds[i]>0){
                time++;
            }
            queue.offer(time);
        }
        
        int i = queue.poll();
        int count = 1;
        while(true){
            if(queue.isEmpty()){
                answer.add(count);
                break;
            }
            if(queue.peek()>i){
                answer.add(count);
                count = 1;
                i = queue.poll();
            }else{
                queue.poll();
                count++;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}