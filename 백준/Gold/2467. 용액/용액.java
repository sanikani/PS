import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lt = 0;
        int rt = N - 1;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                left = arr[lt];
                right = arr[rt];
            }
            if (sum > 0) {
                rt--;
            }
            if (sum < 0) {
                lt++;
            }
            if (sum == 0) {
                System.out.println(arr[lt] + " " + arr[rt]);
                return;
            }

        }
        System.out.println(left + " " + right);
    }
}
