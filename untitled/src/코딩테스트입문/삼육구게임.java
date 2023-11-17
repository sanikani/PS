package 코딩테스트입문;
import java.util.*;
import java.util.stream.Stream;

public class 삼육구게임 {
    public int solution(int order) {
        int[] arr = Stream.of(String.valueOf(order).split("")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]%3==0&&arr[i]!=0){
                answer++;
            }
        }

        return answer;
    }

}
