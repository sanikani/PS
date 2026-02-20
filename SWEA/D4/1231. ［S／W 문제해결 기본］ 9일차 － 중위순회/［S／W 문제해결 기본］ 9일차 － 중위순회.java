import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder result;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			result = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			Node[] nodes = new Node[N+1];
			for (int i = 1; i <= N; i++) nodes[i] = new Node('\0');
			for(int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				nodes[n].value = st.nextToken().charAt(0);
				if(st.hasMoreTokens()) {
					int left = Integer.parseInt(st.nextToken());
					nodes[n].left = nodes[left];
				}
				if(st.hasMoreTokens()) {
					int right = Integer.parseInt(st.nextToken());
					nodes[n].right = nodes[right];	
				}
			}
			solution(nodes[1]);
			sb.append('#').append(tc).append(' ').append(result).append('\n');
		}
		
		System.out.println(sb);
	}
	
	private static void solution(Node node) {
		if(result.length() == N) return;
		if(node.left != null) solution(node.left);
		result.append(node.value);
		if(node.right != null) solution(node.right);
	}

	static class Node{
		char value;
		Node left;
		Node right;
		
		public Node(char value) {
			this.value = value;
		}
		
	}
}
