package section05;

import java.util.Scanner;
import java.util.Stack;

public class 후위식연산 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
    }

    private static int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c-'0');
            } else {
                int y = stack.pop();
                int x = stack.pop();
                int result;
                if (c == '+') {
                    result = x + y;
                    stack.push(result);
                }else if (c == '-') {
                    result = x - y;
                    stack.push(result);
                }else if (c == '*') {
                    result = x * y;
                    stack.push(result);
                }else if (c == '/') {
                    result = x / y;
                    stack.push(result);
                }

            }
        }


        return stack.pop();
    }
}
