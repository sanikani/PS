package section05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정설계 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(solution(a,b));
    }

    private static String solution(String a, String b) {
        int cnt = 0;
        for (char x : b.toCharArray()) {
            if (a.charAt(cnt) == x) {
                cnt++;
            }
            if (cnt == a.length()) {
                return "YES";
            }
        }
        return "NO";

    }

    public static String solution2(String a, String b) {
        Queue<Character> queue = new LinkedList<>();
        for (char x : a.toCharArray()) {
            queue.offer(x);
        }
        for (char x : b.toCharArray()) {
            if (queue.contains(x)) {
                if (queue.poll() != x) {
                    return "NO";
                }
            }
        }
        if (!queue.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}
