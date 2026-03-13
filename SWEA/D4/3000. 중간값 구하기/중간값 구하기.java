import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static final int MOD = 20171109;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			
			maxHeap.offer(A);
			long result = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				maxHeap.offer(a);
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(b);
				minHeap.offer(maxHeap.poll());

				while(maxHeap.size() < minHeap.size() + 1){
				    maxHeap.offer(minHeap.poll());
				}
				
				result = (result + maxHeap.peek()) % MOD;
			}
			
			sb.append('#').append(tc).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
}
