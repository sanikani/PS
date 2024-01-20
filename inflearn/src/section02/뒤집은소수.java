package section02;

import java.util.Scanner;

public class 뒤집은소수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.next();
        }
        solution(n, arr);
    }

    public static void solution(int n, String[] arr) {
        int num;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(arr[i]);
            num = Integer.parseInt(sb.reverse().toString());
            if(isPrime(num)) System.out.print(num+" ");
        }
    }

    public static boolean isPrime(int x) {
        if(x==1) return false;
        for (int i = 2; i < x; i++) {
            if(x%i==0) return false;
        }
        return true;
    }
}
