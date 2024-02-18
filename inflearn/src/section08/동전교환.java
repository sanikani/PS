package section08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전교환 {
    static int n, m = 0;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        동전교환 T = new 동전교환();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        m = Integer.parseInt(br.readLine());
        T.DFS(0,0);
        System.out.println(min);
    }

    private void DFS(int l,int sum) {
        if (l >= min) {
            return;
        }

        if (sum > m) {
            return;
        }

        if (sum == m) {
            if (l < min) {
                min = l;
            }
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                DFS(l + 1,sum+arr[i]);
            }
        }
    }
}
