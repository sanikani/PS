package section08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바둑이승차 {
    static int c,n=0;
    static int[] arr;
    static int sum, max = 0;

    static public void DFS(int i) {
        if (i == n) {
            if (sum <= c && sum > max) {
                max = sum;
            }
        } else {
            sum += arr[i];
            DFS(i + 1);
            sum -= arr[i];
            DFS(i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        DFS(0);
        System.out.println(max);
    }
}
