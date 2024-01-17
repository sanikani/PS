package section02;

import java.util.Scanner;

public class 큰수출력하기 {
    public static void solution(int n, int[] arr) {
        System.out.print(arr[0]+" ");
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                System.out.print(arr[i]+" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        solution(n,arr);
    }
}
