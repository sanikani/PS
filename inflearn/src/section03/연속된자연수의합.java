package section03;

import java.io.IOException;
import java.util.Scanner;

public class 연속된자연수의합 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solution(n));

    }

    private static int solution(int n) {
        int lt = 1, rt = 2, answer = 0;
        while (rt < n) {
            int sum=0;
            for (int i = lt; i <= rt; i++) {
                sum += i;
            }
            if (sum == n) {
                answer++;
                lt++;
                rt++;
            } else if (sum < n) {
                rt++;
            } else {
                lt++;
            }
        }
        return answer;
    }
}
