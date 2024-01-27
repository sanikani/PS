package section05;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution2(str));
    }

    public static int solution(String str) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        int answer = 0;
        for (char x : str.toCharArray()) {
            if (x == '(') {
                cnt++;
                stack.push(x);
            } else {
                if (stack.peek() == '(') {
                    cnt--;
                    stack.push(x);
                    answer += cnt;
                } else {
                    cnt--;
                    stack.push(x);
                    answer++;
                }
            }
        }
        return answer;
    }

    public static int solution2(String str) {
        int cnt = 0;
        int answer = 0;
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else {
                if (str.charAt(i - 1) == '(') {
                    cnt--;
                    answer += cnt;
                } else {
                    cnt--;
                    answer++;
                }
            }
        }
        return answer;
    }
}
