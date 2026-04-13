import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = 0;
        int min = Integer.MAX_VALUE;
        int sum = arr[lt];
        while (rt >= lt) {
            if (sum < S) {
                if(rt + 1 >= N) break;
                sum += arr[++rt];
            }else{
                min = Math.min(min, rt - lt + 1);
                sum -= arr[lt++];
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(min);
    }
}
