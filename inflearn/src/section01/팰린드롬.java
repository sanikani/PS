package section01;

import java.util.Scanner;

public class 팰린드롬 {
    public static String solution(String str) {
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        String reverseStr = new StringBuilder(str).reverse().toString();
        if (str.equals(reverseStr)) return "YES";
        return "NO";
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
    }
}
