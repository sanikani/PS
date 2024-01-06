package section01;

import java.util.Scanner;

public class 문장속단어 {
    public static String solution(String str) {
        String answer = "";
        String[] strArr = str.split(" ");
        for (String s : strArr) {
            if (s.length() > answer.length()) {
                answer = s;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
    }
}
