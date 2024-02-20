package section08;

import java.util.Scanner;

public class 조합의경우수 {
    static int n,r;
    static int answer = 0;

    public static void main(String[] args) {
        조합의경우수 T = new 조합의경우수();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        r = in.nextInt();
        T.DFS(n, r);
        System.out.println(answer);
    }

    private void DFS(int n, int r) {
        if (n == r) {
            answer += 1;
        } else if (r == 1) {
            answer += n;
        } else if (n - r == 1) {
            answer += n;
        } else {
            DFS(n - 1, r - 1);
            DFS(n - 1, r);
        }
    }
}
