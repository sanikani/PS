package 코딩테스트입문;

import java.util.Arrays;

public class 가까운수 {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        int answer = 0;
        int min=100;
        for(int i=0; i<array.length;i++){
            if(Math.abs(array[i]-n)<min){
                min=Math.abs(array[i]-n);
                answer=array[i];
            }
        }
        return answer;
    }
}
