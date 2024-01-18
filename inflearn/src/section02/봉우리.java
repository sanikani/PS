package section02;

import java.util.Scanner;

public class 봉우리 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n+2][n+2];

        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j < n+2; j++) {
                if (j == 0 || j == n + 1 || i == 0 || i == n + 1) {
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(n,arr));

    }
    public static int solution(int n, int[][] arr) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(arr[i][j]>arr[i-1][j]&&arr[i][j]>arr[i+1][j]&&arr[i][j]>arr[i][j-1]&&arr[i][j]>arr[i][j+1]) answer++;
            }
        }
        return answer;
    }
}
