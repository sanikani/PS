package section08;

import java.util.Scanner;

public class 순열구하기 {
    static int n,m;
    static int[] arr;
    static int[] ch;
    static int[] answer;
    public static void main(String[] args) {
        순열구하기 T = new 순열구하기();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n];
        ch = new int[n];
        answer = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        T.DFS(0);

    }

    public void DFS(int l) {
        if (l == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(answer[i]+" ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    answer[l] = arr[i];
                    DFS(l + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
