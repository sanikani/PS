package section10;

import java.util.Scanner;

public class 계단오르기 {
    static int end;
    static int cnt;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        end = in.nextInt();
        DFS(0);
        System.out.println(cnt);
    }

    private static void DFS(int l) {
        if (l == end) {
            cnt++;
        } else if (l < end) {
            DFS(l + 1);
            DFS(l + 2);
        }
    }
}
