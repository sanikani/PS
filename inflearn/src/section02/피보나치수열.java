package section02;

import java.util.Scanner;

public class 피보나치수열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int x : solution(n)) {
            System.out.print(x + " ");
        }
    }

    public static int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }
        return answer;
    }
}
