package 코딩테스트입문;

import java.util.Arrays;

public class 문자열정렬하기2 {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        char[] arr = my_string.toCharArray();
        Arrays.sort(arr);
        my_string = String.valueOf(arr);
        return my_string;
    }
}
