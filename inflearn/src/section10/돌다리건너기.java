package section10;

import java.util.Scanner;

public class 돌다리건너기 {
    static int[] dy;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dy = new int[n + 2];
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n + 1; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }
        return dy[n + 1];
    }
}
