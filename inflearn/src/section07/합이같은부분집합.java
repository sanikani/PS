package section07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합이같은부분집합 {
    static int n,sum,total=0;
    static int[] arr;
    static String answer = "NO";
    boolean flag = false;
    public static void main(String[] args) throws IOException {
        합이같은부분집합 T = new 합이같은부분집합();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        T.DFS(1);
        System.out.println(answer);
    }

    private void DFS(int i) {
        if(flag) return;
        if (i == n + 1) {
            if (sum == total - sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            sum += arr[i];
            DFS(i + 1);
            sum -= arr[i];
            DFS(i + 1);
        }
    }
}
