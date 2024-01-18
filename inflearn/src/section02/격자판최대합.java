package section02;

import java.util.Arrays;
import java.util.Scanner;

public class 격자판최대합 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }

    public static int solution(int n,int[][] arr) {
        int[] sum = new int[n * 2 + 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i] += arr[i][j];
                sum[i + n] += arr[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            sum[n*2] += arr[i][i];
            sum[n*2+1] += arr[i][n-1-i];
        }
        Arrays.sort(sum);
        return sum[sum.length-1];
    }
}
