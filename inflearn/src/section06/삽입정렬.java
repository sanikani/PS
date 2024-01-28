package section06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삽입정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i : solution(n, arr)) {
            System.out.print(i+" ");
        }
    }

    private static int[] solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int j;
            int tmp = arr[i];

            for (j = i-1; j >= 0; j--) {
                if (arr[j] < tmp) {
                    break;
                }else if (arr[j]>=tmp) {
                    arr[j+1] = arr[j];
                }
            }
            arr[j + 1] = tmp;

        }
        return arr;
    }
}
