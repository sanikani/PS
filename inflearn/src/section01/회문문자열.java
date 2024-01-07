package section01;

import java.util.Scanner;

public class 회문문자열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution2(str));
    }

    public static String solution2(String str) {
        str = str.toLowerCase();
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equals(tmp)) {
            return "YES";
        }
        return "NO";

    }

    private static String solution(String str) {
        str = str.toLowerCase();
        int lt=0, rt=str.length()-1;
        char[] arr = str.toCharArray();
        for (int i=0; i<str.length();i++) {
            if (arr[lt] == arr[rt]) {
                lt++;
                rt--;
            }else{
                return "NO";
            }
        }
        return "YES";
    }
}
