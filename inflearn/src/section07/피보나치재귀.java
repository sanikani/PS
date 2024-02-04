package section07;

import java.util.Scanner;

public class 피보나치재귀 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n+1];
        solution(n);
        for (int i = 1; i < n + 1; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static int solution(int n) {
        if (n <= 2) {
            return arr[n] = 1;
        } else {
            if (arr[n] != 0) {
                return arr[n];
            }
            return arr[n] = solution(n - 1) + solution(n - 2);
        }
    }
}
