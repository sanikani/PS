package section05;

import java.util.*;

public class 괄호문자제거 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution2(str));
    }

    private static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            } else {
                if (stack.empty()) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    private static String solution2(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(') ;
            } else {
                stack.push(c);
            }
        }
        //스택을 처음부터 꺼내는 방법
        for(int i=0; i<stack.size(); i++) answer+=stack.get(i);
        return answer;
    }
}
