import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        StringBuilder answer = new StringBuilder();
        answer.append(0);
        answer.append(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Deque<P> stack = new ArrayDeque<>();
        stack.push(new P(arr[0],0));
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty()) {
                P now = stack.pop();
                if(now.value>arr[i]){
                    answer.append(now.index+1);
                    answer.append(" ");
                    stack.push(now);
                    break;
                } else if (stack.isEmpty()) {
                    answer.append(0);
                    answer.append(" ");
                }

            }
            stack.push(new P(arr[i], i));
        }
        System.out.println(answer);
    }
    static class P{
        int value;
        int index;

        public P(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
