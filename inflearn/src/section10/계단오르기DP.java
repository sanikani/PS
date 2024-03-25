package section10;

import java.util.Scanner;

public class 계단오르기DP {
    static int[] dy;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dy = new int[n + 1];
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        dy[1]=1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 1] + dy[i -2];
        }
        return dy[n];
    }
}
