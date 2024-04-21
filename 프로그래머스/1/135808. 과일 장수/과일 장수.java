import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        score = Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).mapToInt(i->i).toArray();
        int answer = 0;
        for(int i=1;i<=score.length/m;i++){
            answer += score[m*i-1]*m;
        }
        return answer;
    }
}