import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			List<List<Integer>> list = new ArrayList<>();
			int[] degree = new int[v+1];
			for(int i = 0; i <= v; i++) {
				list.add(new ArrayList<>());
			}
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int pre = Integer.parseInt(st.nextToken());
				int work = Integer.parseInt(st.nextToken());
				list.get(pre).add(work);
				++degree[work];
			}
			sb.append('#').append(tc).append(' ').append(solution(v, e, list, degree)).append('\n');
		}
		
		System.out.println(sb);
	}

	private static String solution(int v, int e, List<List<Integer>> list, int[] degree) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= v; i++) if(degree[i] == 0) q.offer(i);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(' ');
			for(int work : list.get(cur)) {
				--degree[work];
				if(degree[work] == 0) q.offer(work);
			}
		}
		return sb.toString();
	}
}
