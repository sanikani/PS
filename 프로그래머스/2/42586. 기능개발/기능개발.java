import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0;i<progresses.length;i++){
            double time = (100 - progresses[i])/(double)speeds[i];
            queue.offer((int)Math.ceil(time));
        }
        
        int i = queue.poll();
        int count = 1;
        while(!queue.isEmpty()){
            if(queue.peek()>i){
                answer.add(count);
                count = 1;
                i = queue.poll();
            }else{
                queue.poll();
                count++;
            }
        }
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}