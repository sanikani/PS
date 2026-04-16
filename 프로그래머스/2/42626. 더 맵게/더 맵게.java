import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        int answer = 0;
        while(pq.peek() < K){
            if(pq.size() <= 1) return -1;
            pq.offer(pq.poll() + pq.poll()*2);
            answer++;
        }
        
        return answer;
    }
}