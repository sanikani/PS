package section02;

import java.util.Scanner;

public class 보이는학생 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(n,arr));
    }

    private static int solution(int n, int[] arr) {
        int answer = 0;
        int max = 0;
        for (int x : arr) {
            if (x > max) {
                max = x;
                answer++;
            }
        }

        return answer;
    }
}
