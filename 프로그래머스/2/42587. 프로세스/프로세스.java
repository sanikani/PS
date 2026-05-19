import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Process> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.value, a.value));
        Queue<Process> q = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++){
            Process p = new Process(i, priorities[i]);
            pq.offer(p);
            q.offer(p);
        }
        
        int cnt = 0;
        while(!q.isEmpty()){
            Process cur = q.poll();
            if(cur.value != pq.peek().value){
                q.offer(cur);
                continue;
            }
            pq.poll();
            cnt++;
            if(cur.num == location){
                return cnt;
            }
        }
        return answer;
    }
    
    class Process{
        int num;
        int value;
        
        Process(int n, int v){
            num = n;
            value = v;
        }
    }
}