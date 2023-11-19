package 코딩테스트입문;

import java.util.Arrays;

public class 한번만등장한문자 {
    public String solution(String s) {
        String answer = "";
        String duplicate = "";
        for(String x: s.split("")){
            if(answer.contains(x)){
                answer = answer.replaceAll(x,"");
                duplicate += x;
            }else if(duplicate.contains(x)){

            }
            else{
                answer += x;
            }
        }
        char[] arr =answer.toCharArray();
        Arrays.sort(arr);
        answer = String.valueOf(arr);

        return answer;
    }
}
