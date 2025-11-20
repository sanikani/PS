import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> nodes;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		nodes = new ArrayList<List<Integer>>();
		visited = new boolean[n+1];
		result = 0;
		for(int i=0; i<=n; i++) {
			nodes.add(new ArrayList<>());
		}
		for(int i=0; i<k; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stringTokenizer.nextToken());
			int y = Integer.parseInt(stringTokenizer.nextToken());
			nodes.get(x).add(y);
			nodes.get(y).add(x);
		}
		visited[1] = true;
		dfs(1);
		
		System.out.println(result);
	}

	private static void dfs(int node) {
		if (nodes.get(node).size()==0) {
			return;
		}else {
			for(int n : nodes.get(node)) {
				if (visited[n]) {
					continue;
				}
				visited[n] = true;
				result++;
				dfs(n);
			}
		}
		
	}
}