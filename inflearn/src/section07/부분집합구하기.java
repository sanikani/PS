package section07;

import java.util.Scanner;

public class 부분집합구하기 {
    static int n;
    static int[] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n+1];
        DFS(1);
    }

    public static void DFS(int l) {
        if (l == n + 1) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i]==1)
                    System.out.print(i+" ");
            }
            System.out.println();
        }else {
            arr[l] = 1;
            DFS(l + 1);
            arr[l] = 0;
            DFS(l + 1);
        }
    }
}
