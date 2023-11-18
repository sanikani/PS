package 코딩테스트입문;

import java.util.Arrays;

public class 배열원소의길이 {
    public int[] solution(String[] strlist) {
        int[] answer = Arrays.stream(strlist).mapToInt(String::length).toArray();
        return answer;
    }
}
