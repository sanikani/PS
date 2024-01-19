package section02;

import java.util.Scanner;

public class 임시반장정하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(solution2(n,arr));
    }

    private static int solution(int n, int[][] arr) {
        int answer = 0;
        int maxSame = 0;
        for (int i = 0; i < n; i++) {
            boolean[] isSame = new boolean[n];
            int cnt=0;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < n; k++) {
                    if(arr[i][j]==arr[k][j]) isSame[k] = true;
                }
            }
            for (int y = 0; y < n; y++) {
                if(isSame[y]) cnt++;
                if(maxSame<cnt) {
                    maxSame = cnt;
                    answer = i+1;
                }

            }
        }

        return answer;
    }

    private static int solution2(int n, int[][] arr) {
        int answer = 0;
        int maxSame = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (maxSame < cnt) {
                maxSame = cnt;
                answer = i+1;
            }
        }
        return answer;
    }
}
