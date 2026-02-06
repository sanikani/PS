import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static boolean[][] combi;
	static int N;
	static int M;
	static int result;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = 0;
			combi = new boolean[N][N];
			isSelected = new boolean[N];
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				combi[a][b] = true;
				combi[b][a] = true;
			}
			dfs(0);
			sb.append('#').append(tc).append(' ').append(result).append('\n');
		}

		System.out.println(sb);
	}
	
	static void dfs(int cnt) {
		if(cnt == N) {
			result++;
			return;
		}
		boolean flag = false;
		for(int i = 0; i <= cnt - 1; i++) {
			if(isSelected[i]) {
				if(combi[i][cnt]) {
					flag = true;
					break;
				}
			}
		}
		if (!flag) {
			isSelected[cnt] = true;
			dfs(cnt+1);
		}
		isSelected[cnt] = false;
		dfs(cnt+1);
	}
}
