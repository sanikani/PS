package section06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 뮤직비디오 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n,m,arr));
    }

    public static int solution(int n, int m, int[] arr) {
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int answer = 0;
        while (lt<=rt) {
            int mid = (lt + rt) / 2;
            int sum = 0, cnt = 1;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum > mid) {
                    sum=arr[i];
                    cnt++;
                    if (cnt > m) {
                        lt = mid+1;
                        break;
                    }
                }
            }
            if (cnt <= m) {
                answer = mid;
                rt = mid - 1;
            }
        }
        return answer;
    }
}
