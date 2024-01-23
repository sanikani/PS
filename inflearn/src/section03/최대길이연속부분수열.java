package section03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대길이연속부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(m,arr));
    }

    public static int solution(int m, int[] arr) {
        int lt = 0, rt = 0, cnt = 0, max = 0;
        while (rt < arr.length) {
            if (arr[rt] == 0) {
                cnt++;
                rt++;
            } else if (arr[rt] == 1) {
                rt++;
            }
            if (cnt > m) {
                while (arr[lt] != 0) {
                    lt++;
                }
                lt = lt + 1;
                cnt--;
            }
            if (max < rt - lt) {
                max = rt - lt;
            }
        }
        return max;
    }

}
