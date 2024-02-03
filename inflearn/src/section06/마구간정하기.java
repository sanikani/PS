package section06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 마구간정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int c = Integer.parseInt(tmp[1]);
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, c, arr));
    }

    private static int solution(int n, int c, int[] arr) {
        Arrays.sort(arr);
        int answer = 0;
        int lt = 1;
        int rt = arr[n - 1];
        while (lt <= rt) {
            int mid = (rt + lt) / 2;
            if (count(arr, mid) >= c) {
                lt = mid + 1;
                answer = mid;
            } else {
                rt = mid - 1;
            }
        }
        return answer;

    }

    private static int count(int[] arr, int mid) {
        int cnt = 1;
        int ep = arr[0];
        for (int j : arr) {
            if (j - ep >= mid) {
                ep = j;
                cnt++;
            }
        }
        return cnt;

    }
}
