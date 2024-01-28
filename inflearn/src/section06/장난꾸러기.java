package section06;

import java.util.Arrays;
import java.util.Scanner;

public class 장난꾸러기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[] answer = solution(n, arr);
        System.out.print(answer[0]+" "+answer[1]);
    }

    public static int[] solution(int n, int[] arr) {
        int[] answer = new int[2];
        int[] tmp = arr.clone();
        int cnt = 0;
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) {
                answer[cnt]=i+1;
                cnt++;
            }
        }
        return answer;
    }
}
