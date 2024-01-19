package section02;

import java.util.Scanner;

public class 멘토링 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[][] arr) {
        int answer = 0;
        int[][] cnt = new int[n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    cnt[arr[i][j]-1][arr[i][k]-1]++;
                }
            }
        }
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (cnt[x][y] == m) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
