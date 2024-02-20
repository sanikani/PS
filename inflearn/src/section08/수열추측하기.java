package section08;

import java.util.Scanner;

public class 수열추측하기 {
    static int n, f;
    static int[] ch;
    static boolean flag = false;
    public static void main(String[] args) {
        수열추측하기 T = new 수열추측하기();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        f = in.nextInt();
        ch = new int[n];
        int[] arr = new int[n];
        T.DFS(0,arr);
    }

    private void DFS(int l,int[] arr) {
        if (flag) {
            return;
        }
        if (l == n) {
            if (check(arr)) {
                flag=true;
                for (int i : arr) {
                    System.out.print(i+" ");
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    arr[l] = i + 1;
                    DFS(l + 1,arr);
                    ch[i] = 0;
                }
            }
        }
    }

    private boolean check(int[] arr) {
        int[] a = new int[n];
        int len = arr.length - 1;
        for (int i = 0; i < len; i++) {
            a[i] = arr[i] + arr[i + 1];
        }
        len--;
        while (len>=1) {
            for (int i = 0; i < len; i++) {
                a[i] = a[i] + a[i + 1];
            }
            len--;
        }
        if (a[0] == f) {
            return true;
        }
        return false;
    }

}
