import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static int MAX = 100000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] dist = new int[MAX + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(n);
		dist[n] = 0;
		
		while(!dq.isEmpty()) {
			int cur = dq.poll();
			
			if(cur == k) break;
			
			int next = cur * 2;
			if(next <= MAX && dist[cur] < dist[next]) {
				dq.offerFirst(next);
				dist[next] = dist[cur];
			}
			
			next = cur - 1;
			if(next >= 0 && dist[cur] + 1 < dist[next]) {
				dq.offerLast(next);
				dist[next] = dist[cur] + 1;
			}
			next = cur + 1;
			if(next < dist.length && dist[cur] + 1 < dist[next]) {
				dq.offerLast(next);
				dist[next] = dist[cur] + 1;
			}
		}
		System.out.println(dist[k]);
	}
}
