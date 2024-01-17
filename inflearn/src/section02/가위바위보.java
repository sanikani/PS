package section02;

import java.util.Scanner;

public class 가위바위보 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = in.nextInt();
        }
        solution(n,arrA,arrB);
    }

    public static void solution(int n, int[] arrA, int[] arrB) {
        for (int i = 0; i < n; i++) {
            if(arrA[i]==arrB[i]) System.out.println("D");
            else if (Math.abs(arrA[i] - arrB[i]) == 2) {
                if (arrA[i] == 3) System.out.println("B");
                else System.out.println("A");
            }
            else if(arrA[i]>arrB[i]) System.out.println("A");
            else System.out.println("B");
        }
    }
}
