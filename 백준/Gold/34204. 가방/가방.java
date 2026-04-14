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
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int sum = 0;
        int idx = 0;
        int thief = 0;
        int thiefIdx = K - 1;
        for (int i = 0; i < K; i++) {
            thief += arr[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int c = 1; c <= C; c++) {
            if (N - idx > K) {
                while (idx < N){
                    if(sum + arr[idx] <= c){
                        sum += arr[idx];
                        thief -= arr[idx++];
                        if(thiefIdx < N - 1){
                            thief += arr[++thiefIdx];
                        }
                    }else {
                        break;
                    }
                }
            }

            sb.append(thief).append('\n');
        }
        System.out.println(sb);
    }
}
