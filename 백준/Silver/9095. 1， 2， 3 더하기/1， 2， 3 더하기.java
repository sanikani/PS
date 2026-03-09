import java.io.*;

public class Main {
    static int cnt;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            cnt = 0;
            dfs(0);
            sb.append(cnt);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int sum) {
        if(sum > n) return;

        if(sum == n) {
            cnt++;
            return;
        }

        for (int k = 1; k <= 3; k++) {
            dfs(sum + k);
        }
    }
}
