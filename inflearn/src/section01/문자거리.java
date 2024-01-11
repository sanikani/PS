package section01;

import java.util.Scanner;

public class 문자거리 {
    public static int[] solution(String str, String s) {
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int findIndex = str.indexOf(s);
            arr[i] = Math.abs(findIndex - i);
            while (findIndex >= 0) {
                arr[i] = Math.min(arr[i], Math.abs(findIndex - i));
                findIndex = str.indexOf(s, findIndex + 1);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String s = in.next();
        for (int i : solution(str, s)) {
            System.out.print(i+" ");
        }
    }
}
