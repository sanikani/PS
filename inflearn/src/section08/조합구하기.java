package section08;

import java.util.Scanner;

public class 조합구하기 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        조합구하기 T = new 조합구하기();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[m];
        T.DFS(0, 1);
    }

    private void DFS(int l,int k) {
        if (l == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = k; i <= n; i++) {
                arr[l] = i;
                DFS(l + 1,i+1);
            }
        }
    }
}
