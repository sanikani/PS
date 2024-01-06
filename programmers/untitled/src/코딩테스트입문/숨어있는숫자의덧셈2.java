package 코딩테스트입문;

public class 숨어있는숫자의덧셈2 {
    public int solution(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("[^0-9]"," ");
        for(String s : my_string.split(" ")){
            if(!s.equals("")) answer += Integer.valueOf(s);
        }
        return answer;
    }
}
