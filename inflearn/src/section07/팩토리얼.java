package section07;

import java.util.Scanner;

public class 팩토리얼 {
    public static void main(String[] args) {
        팩토리얼 T = new 팩토리얼();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(T.DFS(n));
    }

    private int DFS(int n) {
        if (n == 1) {
            return 1;
        }
        return n * DFS(n - 1);
    }
}
