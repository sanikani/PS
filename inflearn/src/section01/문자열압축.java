package section01;

import java.util.Scanner;

public class 문자열압축 {
    public static String solution(String str) {
        String answer = "";
        char x=' ';

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != x) {
                x=str.charAt(i);
                answer += x;
                int count = 0;

                for (int j = i; j < str.length(); j++) {
                    if(str.charAt(j)==x) count++;
                    else break;
                }

                if(count>1) answer += count;
            }
        }

        return answer;
    }

    public static String solution2(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(ch);

            int count = 1;
            while (i + 1 < str.length() && str.charAt(i + 1) == ch) {
                count++;
                i++;
            }

            if (count > 1) {
                sb.append(count);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
    }
}
