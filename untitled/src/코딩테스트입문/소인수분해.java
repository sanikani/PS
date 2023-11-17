package 코딩테스트입문;

import java.util.ArrayList;
import java.util.List;

public class 소인수분해 {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(n%i==0){
                while(n%i==0){
                    n/=i;
                }
                answer.add(i);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue).toArray();

    }
}
