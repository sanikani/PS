package 코딩테스트입문;

public class 인덱스바꾸기 {
    public String solution(String my_string, int num1, int num2) {
        char[] arr = my_string.toCharArray();
        char tmp = my_string.charAt(num1);
        arr[num1]=arr[num2];
        arr[num2]=tmp;
        return String.valueOf(arr);
    }
}
