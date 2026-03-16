import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static List<List<Integer>> graph;
	static int start;
	static int end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(p).add(c);
			graph.get(c).add(p);
		}
		System.out.println(solution());
	}
	
	static int solution(){
		boolean[] vis = new boolean[n+1];
		vis[start] = true;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int len = q.size();
			cnt++;
			for(int i = 0; i < len; i++) {
				int now = q.poll();
				for (int k : graph.get(now)) {
					if(vis[k]) continue;
					if(k == end) return cnt;
					q.offer(k);
					vis[k] = true;
				}
			}
		}
		return -1;
	}
}
