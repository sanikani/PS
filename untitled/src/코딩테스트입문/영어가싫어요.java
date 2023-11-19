package 코딩테스트입문;

import java.util.*;
public class 영어가싫어요 {
    public long solution(String numbers) {
        String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] num = {"0","1","2","3","4","5","6","7","8","9"};
        for(int i=0; i<10;i++){
            numbers = numbers.replaceAll(eng[i],num[i]);
        }
        long answer = Long.parseLong(numbers);
        return answer;
    }

}
