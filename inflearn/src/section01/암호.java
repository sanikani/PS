package section01;

import java.util.Scanner;

public class 암호 {
    public static String solution(int n, String str) {
        str = str.replace("#", "1").replace("*", "0");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n * 7; i += 7) {
            int value = Integer.parseInt(str.substring(i, i + 7), 2);
            char x = (char) value;
            sb.append(x);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        System.out.println(solution(n,str));
    }
}
