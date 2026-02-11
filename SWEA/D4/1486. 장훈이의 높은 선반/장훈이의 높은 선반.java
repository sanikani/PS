import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int B;
	static int N;
	static int[] heights;
	static int result;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			result = Integer.MAX_VALUE;
			heights = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			sb.append('#').append(test_case).append(' ').append(result - B).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int l, int sum) {
        if(result == B) {
			return;
		}
		if(sum >= B) {
			result = Math.min(result, sum);
			return;
		}
		
		if(l == N) {
			return;
		}
		
		//선택하거나
		dfs(l + 1, sum + heights[l]);
		//선택하지 않거나
		dfs(l + 1, sum);
	}
}