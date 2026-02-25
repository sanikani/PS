import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static int N;
	static int total;
	static List<List<Integer>> graph;
	static boolean[] isSelected;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		total = 0;
		min = Integer.MAX_VALUE;
		isSelected = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			total += nums[i];
		}
		
		graph = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while (st.hasMoreTokens()) {
				graph.get(i).add(Integer.parseInt(st.nextToken())-1);
			}
		}
		dfs(0,0);
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

	static void dfs(int l, int sum) {
		if(l == N) {
			if(isAllConnected()) {
				min = Math.min(min, Math.abs(total - sum*2));
			}
			return;
		}
		isSelected[l] = true;
		dfs(l+1, sum + nums[l]);
		isSelected[l] = false;
		dfs(l+1, sum);
	}
	
	static boolean isAllConnected() {
		List<Integer> area1 = new ArrayList<>();
		List<Integer> area2 = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) area1.add(i);
			else area2.add(i);
		}
		if(!isConnected(area1)) return false;
		if(!isConnected(area2)) return false;
		return true;
	}
	
	private static boolean isConnected(List<Integer> area) {
	    if (area.isEmpty()) return false;

	    boolean[] inArea = new boolean[N];
	    for (int v : area) inArea[v] = true;

	    boolean[] visited = new boolean[N];
	    Queue<Integer> q = new ArrayDeque<>();

	    int start = area.get(0);
	    q.offer(start);
	    visited[start] = true;

	    int cnt = 1;
	    while (!q.isEmpty()) {
	        int cur = q.poll();
	        for (int nxt : graph.get(cur)) {
	            if (!inArea[nxt] || visited[nxt]) continue;
	            visited[nxt] = true;
	            q.offer(nxt);
	            cnt++;
	        }
	    }

	    return cnt == area.size();
	}
}
