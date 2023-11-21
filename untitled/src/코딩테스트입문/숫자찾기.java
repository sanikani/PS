package 코딩테스트입문;

import java.util.stream.Stream;

public class 숫자찾기 {
    public int solution(int num, int k) {
        int answer = 0;
        int[] arr = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        for(int i=1;i<=arr.length;i++){
            if(arr[i-1]==k){
                return i;
            }
        }

        return -1;
    }
    public int solution2(int num, int k) {
        String number = String.valueOf(num);
        int answer = number.indexOf(String.valueOf(k));
        if(answer>=0){
            return answer+1;
        }else{
            return answer;
        }
    }
}
