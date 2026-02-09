import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static List<List<Integer>> tallList;
	static List<List<Integer>> smallList;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			tallList = new ArrayList<>();
			smallList = new ArrayList<>();
			for(int i = 0; i <= N; i ++) {
				tallList.add(new ArrayList<>());
				smallList.add(new ArrayList<>());
			}
			
			for(int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tallList.get(a).add(b);
				smallList.get(b).add(a);
			}
			int result = 0;
			for(int i = 1; i <= N; i++) {
				if(bfs(i)) result++;
			}
			sb.append('#').append(test_case).append(' ').append(result).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static boolean bfs(int idx) {
	    int cnt = 0;
	    boolean[] visited = new boolean[N + 1];

	    Queue<Integer> q = new ArrayDeque<>();
	    visited[idx] = true;
	    q.add(idx);

	    while (!q.isEmpty()) {
	        int cur = q.poll();
	        for (int next : tallList.get(cur)) {
	            if (visited[next]) continue;
	            visited[next] = true;
	            cnt++;
	            q.add(next);
	        }
	    }

	    visited = new boolean[N + 1];
	    visited[idx] = true;
	    q.add(idx);

	    while (!q.isEmpty()) {
	        int cur = q.poll();
	        for (int next : smallList.get(cur)) {
	            if (visited[next]) continue;
	            visited[next] = true;
	            cnt++;
	            q.add(next);
	        }
	    }
	    return cnt == N - 1;
	}
}
