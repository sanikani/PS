import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] trees = new int[N];
			int max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < trees.length; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, trees[i]);
			}
			
			
			sb.append('#').append(test_case).append(' ').append(solution(trees, N, max)).append('\n');
		}
		
		System.out.println(sb);
	}

	private static int solution(int[] trees, int n, int max) {
		calRemainDays(trees, max);
		int even = 0;
		int odd = 0;
		
		for (int i = 0; i < trees.length; i++) {
			even += trees[i] / 2;
			odd += trees[i] % 2;
		}
		
		//짝수일 = 홀수일 2개 -> 짝수일이 2개 더 많으면 3일 or 4일 필요함 1개 더 많으면 1일 or 2일 필요
		//따라서 짝수일이 1개 더 많을때까지 짝수일을 줄여야함
		while(even > odd + 1) {
			even--;
			odd += 2;
		}
		
		//짝수일이 홀수일보다 많거나 같은 경우 -> 짝수일로 끝난것
		if(even >= odd) {
			return even * 2;
		}
		
		//홀수일이 많은 경우
		return odd * 2 - 1;
	}

	private static void calRemainDays(int[] trees, int max) {
		for (int i = 0; i < trees.length; i++) {
			trees[i] = max - trees[i];
		}		
	}
}
