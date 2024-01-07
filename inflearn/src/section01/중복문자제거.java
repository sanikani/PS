package section01;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 중복문자제거 {
    public static String solution(String str) {
        String answer="";
        answer = Stream.of(str.split("")).distinct().collect(Collectors.joining());
        return answer;
    }

    public static String solution2(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
    }
}
