package section01;

import java.util.Scanner;

public class 특정문자뒤집기 {
    public static String solution(String str) {
        char[] charArray = str.toCharArray();
        int lt=0, rt = str.length()-1;
        while (lt < rt) {
            if (!Character.isAlphabetic(charArray[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(charArray[rt])) {
                rt--;
            }else{
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }

        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
        return;
    }
}
