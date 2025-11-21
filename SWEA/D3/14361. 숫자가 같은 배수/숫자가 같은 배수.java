import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static String N;
	static int value;
	static String result;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = br.readLine();
			value = Integer.parseInt(N);
			result = "impossible";
			visited = new boolean[N.length()];
			sb = new StringBuilder();
			dfs(0);
			
			
			System.out.println("#"+test_case+" "+result);
		}
	}
	
	private static void dfs(int l) {
		if (l==N.length()) {
			int target = Integer.parseInt(sb.toString());
			if (target>value && target%value==0) {
				result = "possible";
                return;
			}
		}else {
			for(int j = 0; j<N.length(); j++) {
				if (!visited[j]) {
					visited[j] = true;
					sb.append(N.charAt(j));
					dfs(l+1);
					visited[j] = false;
					sb.delete(l, l+1);
				}
			}
		}
	}
}
