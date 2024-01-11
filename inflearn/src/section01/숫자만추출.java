package section01;

import java.util.Scanner;

public class 숫자만추출 {
    public static int solution(String str) {
        str = str.replaceAll("[^0-9]", "");
        return Integer.valueOf(str);
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) != 0) {
//                return Integer.valueOf(str);
//            }
//            str = str.substring(i + 1);
//        }
//        return Integer.valueOf(str);

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
    }
}
