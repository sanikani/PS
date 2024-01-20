package section02;

import java.util.Scanner;

public class 점수계산 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(n,arr));
    }

    public static int solution(int n, int[] arr) {
        int score = 0, bonus = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                bonus++;
                score += bonus;
            } else {
                bonus = 0;
            }
        }
        return score;
    }
}
