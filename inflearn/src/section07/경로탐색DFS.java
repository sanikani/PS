package section07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로탐색DFS {
    static int[] ch;
    static int[][] arr;
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        경로탐색DFS T = new 경로탐색DFS();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        arr = new int[n + 1][n + 1];
        ch = new int[n+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
    public void DFS(int k) {
        if (k == n) {
            answer++;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[k][i] == 1 && ch[i] == 0) {
                ch[i] = 1;
                DFS(i);
                ch[i]=0;
            }
        }
    }
}
