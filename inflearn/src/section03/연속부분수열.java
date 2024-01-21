package section03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int[] arr = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        int lt=0, rt=0, answer=0;
        while (rt < n) {
            int sum = 0;
            for (int i = lt; i <= rt; i++) {
                sum += arr[i];
            }
            if (sum == m) {
                answer++;
                lt++;
                rt++;
            } else if (sum > m) {
                lt++;
            } else {
                rt++;
            }
        }
        return answer;
    }
}
