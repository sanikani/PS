package section05;

import java.util.Scanner;
import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        if (!stack.empty()) {
            return "NO";
        }
        return answer;
    }
}
