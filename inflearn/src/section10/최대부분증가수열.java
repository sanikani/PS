package section10;

import java.util.Scanner;

public class 최대부분증가수열 {
    static int[] dy;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dy = new int[n + 1];
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr, n));
    }

    public static int solution(int[] arr, int n) {
        dy[1] = 1;
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dy[i] = Math.max(dy[i], dy[j] + 1);
                }
                answer = Math.max(answer, dy[i]);
            }
        }
        return answer;
    }
}
