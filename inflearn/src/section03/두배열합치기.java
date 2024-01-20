package section03;

import java.util.Arrays;
import java.util.Scanner;

public class 두배열합치기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arrA = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] arrB = new int[m];
        for (int i = 0; i < m; i++) {
            arrB[i] = in.nextInt();
        }

        for (int i : solution(n,m,arrA,arrB)) {
            System.out.print(i+" ");
        }
    }

    private static int[] solution(int n, int m, int[] arrA, int[] arrB) {
        int[] answer = new int[n + m];
        int idxA = 0;
        int idxB = 0;

        for (int i = 0; i < n + m; i++) {

            if (idxA == n) {
                answer[i] = arrB[idxB++];
                continue;
            }
            if (idxB == m) {
                answer[i] = arrA[idxA++];
                continue;
            }

            if (arrA[idxA] < arrB[idxB]) {
                answer[i] = arrA[idxA++];
            } else if (arrA[idxA] > arrB[idxB]) {
                answer[i] = arrB[idxB++];
            } else if (arrA[idxA] == arrB[idxB]) {
                answer[i] = arrB[idxB++];
            }
        }

        return answer;
    }

    public static int[] solution2(int n, int m, int[] arrA, int[] arrB) {
        int[] answer = new int[n + m];
        int idxA = 0;
        int idxB = 0;
        for (int i = 0; i < n + m; i++) {
            if (idxA < n) {
                answer[i] = arrA[idxA++];
            } else {
                answer[i] = arrB[idxB++];
            }
        }
        Arrays.sort(answer);
        return answer;
    }

}
