package section01;

import java.util.Scanner;

public class 대소문자변환 {
    public static String solution(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isUpperCase(x)) {
                answer += Character.toLowerCase(x);
            } else {
                answer += Character.toUpperCase(x);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
        return ;
    }
}