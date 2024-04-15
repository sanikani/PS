import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        for(int i=0;i<score.length;i++){
            if(i<k){
                Q.offer(score[i]);
                System.out.println(score[i]+"삽입");
                answer[i] = Q.peek();
            } 
            else {
                if(Q.peek()<score[i]){
                    System.out.println(score[i]+"삽입");
                    Q.poll();
                    Q.offer(score[i]);
                    answer[i] = Q.peek();
                }else{
                    answer[i] = Q.peek();
                }
            }
        }
        return answer;
    }
}